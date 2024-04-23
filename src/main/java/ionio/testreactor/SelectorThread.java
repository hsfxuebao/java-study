package ionio.testreactor;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.LinkedBlockingQueue;


public class SelectorThread  extends  ThreadLocal<LinkedBlockingQueue<Channel>>  implements   Runnable{
    // 每线程对应一个selector，
    // 多线程情况下，该主机，该程序的并发客户端被分配到多个selector上
    //注意，每个客户端，只绑定到其中一个selector
    //其实不会有交互问题



    Selector  selector = null;
//    LinkedBlockingQueue<Channel> lbq = new LinkedBlockingQueue<>();
    LinkedBlockingQueue<Channel> lbq = get();  //lbq  在接口或者类中是固定使用方式逻辑写死了。你需要是lbq每个线程持有自己的独立对象

    SelectorThreadGroup stg;

    @Override
    protected LinkedBlockingQueue<Channel> initialValue() {
        return new LinkedBlockingQueue<>();//你要丰富的是这里！  pool。。。
    }

    SelectorThread(SelectorThreadGroup stg){
        try {


            this.stg = stg;
            selector = Selector.open();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void run() {

        //Loop
        while (true){
            try {
                //1,select()
//                System.out.println(Thread.currentThread().getName()+"   :  before select...."+ selector.keys().size());
                int nums = selector.select();  //阻塞  wakeup()
//                Thread.sleep(1000);  //这绝对不是解决方案，我只是给你演示
//                System.out.println(Thread.currentThread().getName()+"   :  after select...." + selector.keys().size());

                //2,处理selectkeys
                if(nums>0){
                    Set<SelectionKey> keys = selector.selectedKeys();
                    Iterator<SelectionKey> iter = keys.iterator();
                    while(iter.hasNext()){  //线程处理的过程
                        SelectionKey key = iter.next();
                        iter.remove();
                        if(key.isAcceptable()){  //复杂,接受客户端的过程（接收之后，要注册，多线程下，新的客户端，注册到那里呢？）
                            acceptHandler(key);
                        }else if(key.isReadable()){
                            readHander(key);
                        }else if(key.isWritable()){

                        }
                    }

                }
                //3,处理一些task :  listen  client
                if(!lbq.isEmpty()){   //队列是个啥东西啊？ 堆里的对象，线程的栈是独立，堆是共享的
                    //只有方法的逻辑，本地变量是线程隔离的
                    Channel c = lbq.take();
                    if(c instanceof ServerSocketChannel){
                        ServerSocketChannel server = (ServerSocketChannel) c;
                        server.register(selector,SelectionKey.OP_ACCEPT);
                        System.out.println(Thread.currentThread().getName()+" register server listen" + server.getLocalAddress());
                    }else if(c instanceof  SocketChannel){
                        SocketChannel client = (SocketChannel) c;
                        ByteBuffer buffer = ByteBuffer.allocateDirect(4096);
                        client.register(selector, SelectionKey.OP_READ, buffer);
                        System.out.println(Thread.currentThread().getName()+" register client: " + client.getRemoteAddress());

                    }
                }



            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
//            catch (InterruptedException e) {
//                e.printStackTrace();
//            }


        }

    }

    private void readHander(SelectionKey key) {
        System.out.println(Thread.currentThread().getName()+" read......");
        ByteBuffer buffer = (ByteBuffer)key.attachment();
        SocketChannel client = (SocketChannel)key.channel();
        buffer.clear();
        while(true){
            try {
                int num = client.read(buffer);
                if(num > 0){
                    buffer.flip();  //将读到的内容翻转，然后直接写出
                    while(buffer.hasRemaining()){
                        client.write(buffer);
                    }
                    buffer.clear();
                }else if(num == 0){
                    break;
                }else if(num < 0 ){
                    //客户端断开了
                    System.out.println("client: " + client.getRemoteAddress()+"closed......");
                    key.cancel();
                    break;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void acceptHandler(SelectionKey key) {
        System.out.println(Thread.currentThread().getName()+"   acceptHandler......");

        ServerSocketChannel server = (ServerSocketChannel)key.channel();
        try {
            SocketChannel client = server.accept();
            client.configureBlocking(false);

            //choose a selector  and  register!!

            stg.nextSelectorV3(client);
//            stg.nextSelectorV2(client);

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public void setWorker(SelectorThreadGroup stgWorker) {
        this.stg =  stgWorker;
    }


        public static void main(String[] args) {
            //ANDROID_f1eb34ce664c3e87,ANDROID_f1eb34ce664c3e88,ANDROID_f1eb34ce664c3e89,ANDROID_f1eb34ce664c3e90
            String did = "ANDROID_f1eb34ce664c3e87";
            System.out.println(Objects.hashCode(did));

            String[] arr = new String[]{"ANDROID_f1eb34ce664c3e87", "ANDROID_f1eb34ce664c3e88", "ANDROID_f1eb34ce664c3e89", "ANDROID_f1eb34ce664c3e90"};
            for (String str : arr) {
                System.out.println(Objects.hashCode(str));
            }
        }

}
