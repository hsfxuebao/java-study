package ionio.iomultiplex;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Set;


/**
 * 单reactor单线程
 * 只有一个线程，即负责接收accept事件,也负责read/write事件
 */
public class IoMultiplexingSingleThreadv1 {


    private ServerSocketChannel server = null;
    //linux 多路复用器（select poll  epoll kqueue）
    private Selector selector = null;
    int port = 9090;

    public void initServer() {
        try {
            server = ServerSocketChannel.open();
            // 非阻塞
            server.configureBlocking(false);
            // 绑定
            server.bind(new InetSocketAddress(port));
            //如果在epoll模型下，open-->  epoll_create -> fd3
            selector = Selector.open();  //  select poll epoll  优先选择：epoll
            /**
             * server 约等于 listen状态的 fd4
             * register
             * 如果：
             * select，poll：jvm里开辟一个数组 fd4 放进去
             * epoll：  epoll_ctl(fd3,ADD,fd4,EPOLLIN)
             */
            server.register(selector, SelectionKey.OP_ACCEPT);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void start() {
        initServer();
        System.out.println("服务器启动了。。。。。");
        try {
            while (true) {  //死循环

                Set<SelectionKey> keys = selector.keys();
                System.out.println("keys size = " + keys.size());
                /**
                 *  1.调用多路复用器(select,poll or epoll(epoll_wait))
                 *  select()是啥意思：
                 *      ① select，poll  其实  内核的select（fd4）  poll(fd4)
                 *      ② epoll：  其实 内核的 epoll_wait()
                 *   参数可以带时间：有时间设置一个超时
                 *    没有时间，0： 阻塞，selector.wakeup()唤醒 结果返回0
                 *
                 *  懒加载：
                 *  其实再触碰到selector.select()调用的时候触发了epoll_ctl的调用
                 */
                while (selector.select() > 0) {
                    // 返回的有状态的fd集合
                    Set<SelectionKey> selectionKeys = selector.selectedKeys();
                    Iterator<SelectionKey> iter = selectionKeys.iterator();
                    // 多路复用器，只要给我状态，我一个一个的去处理他们的R/W。同步好辛苦！
                    //  NIO :自己对着每一个fd调用系统调用，浪费资源，那么你看，这里是不是调用了一次select方法，知道具体的那些可以R/W了
                    while (iter.hasNext()) {
                        SelectionKey key = iter.next();
                        //不移除会重复循环处理
                        iter.remove();
                        if (key.isAcceptable()) {
                            // 重点，如果要去接受一个新的连接
                            //语义上，accept接受连接且返回新连接的FD
                            //那新的FD怎么办？
                            //select，poll，因为他们内核没有空间，那么在jvm中保存和前边的fd4那个listen的一起
                            //epoll： 我们希望通过epoll_ctl把新的客户端fd注册到内核空间
                            acceptHandler(key);
                        } else if (key.isReadable()) {
                            readHandler(key);  //连read 还有 write都处理了
                            //在当前线程，这个方法可能会阻塞，如果阻塞了十年，其他的IO早就没了。。。
                            //所以，为什么提出了 IO THREADS
                            //redis  是不是用了epoll，redis是不是有个io threads的概念 ，redis是不是单线程的
                            //tomcat 8,9  异步的处理方式  IO和处理上  解耦
                        } else if(key.isWritable()) {
                            //要明白：你想什么时候写？不是依赖send-queue是不是有空间
                            //1，你准备好要写什么了，这是第一步
                            //2，第二步你才关心send-queue是否有空间
                            //3，so，读 read 一开始就要注册，但是write依赖以上关系，什么时候用什么时候注册
                            //4，如果一开始就注册了write的事件，进入死循环，一直调起！！！
                            writeHandler(key);
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void acceptHandler(SelectionKey key) {
        System.out.println("acceptHandler handler..");
        try {
            ServerSocketChannel ssc = (ServerSocketChannel) key.channel();
            //目的是调用accept接受客户端  fd7
            SocketChannel client = ssc.accept();
            // 非阻塞
            client.configureBlocking(false);
            ByteBuffer buffer = ByteBuffer.allocate(8192);
            //调用了register
            /*
            select，poll：jvm里开辟一个数组 fd7 放进去
            epoll：  epoll_ctl(fd3,ADD,fd7,EPOLLIN)
             */
            client.register(selector, SelectionKey.OP_READ, buffer);
            System.out.println("新客户端：" + client.getRemoteAddress());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readHandler(SelectionKey key) {
        System.out.println("read handler.....");
        SocketChannel client = (SocketChannel) key.channel();
        ByteBuffer buffer = (ByteBuffer) key.attachment();
        buffer.clear();
        int read = 0;
        try {
            while (true) {
                read = client.read(buffer);
                if (read > 0) {
                     /*在read方法中直接将数据发出去
                    buffer.flip();
                    while (buffer.hasRemaining()) {
                        client.write(buffer);
                    }
                    buffer.clear();*/
                    // 关心  OP_WRITE 其实就是关系send-queue是不是有空间
                    client.register(key.selector(),SelectionKey.OP_WRITE,buffer);
                } else if (read == 0) {
                    break;
                } else {
                    client.close();
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();

        }
    }

    private void writeHandler(SelectionKey key) {

        System.out.println("write handler...");
        SocketChannel client = (SocketChannel) key.channel();
        ByteBuffer buffer = (ByteBuffer) key.attachment();
        buffer.flip();
        while (buffer.hasRemaining()) {
            try {
                client.write(buffer);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        buffer.clear();
        // 取消write事件
        key.cancel();
        try {
            client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        IoMultiplexingSingleThreadv1 service = new IoMultiplexingSingleThreadv1();
        service.start();
    }
}
