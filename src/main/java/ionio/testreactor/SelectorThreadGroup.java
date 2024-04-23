package ionio.testreactor;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.Channel;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.SelectionKey;
import java.nio.channels.ServerSocketChannel;
import java.util.concurrent.atomic.AtomicInteger;

public class SelectorThreadGroup {  //天生都是boss

    SelectorThread[] sts;
    ServerSocketChannel server=null;
    AtomicInteger xid = new AtomicInteger(0);

    SelectorThreadGroup  stg =  this;

    public void setWorker(SelectorThreadGroup  stg){
        this.stg =  stg;

    }

    SelectorThreadGroup(int num){
        //num  线程数
        sts = new SelectorThread[num];
        for (int i = 0; i < num; i++) {
            sts[i] = new SelectorThread(this);

            new Thread(sts[i]).start();
        }

    }



    public void bind(int port) {

        try {
            server =  ServerSocketChannel.open();
            server.configureBlocking(false);
            server.bind(new InetSocketAddress(port));

            //注册到那个selector上呢？
//            nextSelectorV2(server);
            nextSelectorV3(server);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void nextSelectorV3(Channel c) {

        try {
            if(c instanceof  ServerSocketChannel){
                SelectorThread st = next();  //listen 选择了 boss组中的一个线程后，要更新这个线程的work组
                st.lbq.put(c);
                st.setWorker(stg);
                st.selector.wakeup();
            }else {
                SelectorThread st = nextV3();  //在 main线程种，取到堆里的selectorThread对象

                //1,通过队列传递数据 消息
                st.lbq.add(c);
                //2,通过打断阻塞，让对应的线程去自己在打断后完成注册selector
                st.selector.wakeup();

            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }


    public void nextSelectorV2(Channel c) {

            try {
                if(c instanceof  ServerSocketChannel){
                sts[0].lbq.put(c);
                sts[0].selector.wakeup();
                }else {
                    SelectorThread st = nextV2();  //在 main线程种，取到堆里的selectorThread对象

                    //1,通过队列传递数据 消息
                    st.lbq.add(c);
                    //2,通过打断阻塞，让对应的线程去自己在打断后完成注册selector
                    st.selector.wakeup();

                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


    }
    public void nextSelector(Channel c) {
        SelectorThread st = next();  //在 main线程种，取到堆里的selectorThread对象

        //1,通过队列传递数据 消息
        st.lbq.add(c);
        //2,通过打断阻塞，让对应的线程去自己在打断后完成注册selector
        st.selector.wakeup();

//    public void nextSelector(Channel c) {
//        SelectorThread st = next();  //在 main线程种，取到堆里的selectorThread对象
//
//        //1,通过队列传递数据 消息
//        st.lbq.add(c);
//        //2,通过打断阻塞，让对应的线程去自己在打断后完成注册selector
//        st.selector.wakeup();


        //重点：  c有可能是 server  有可能是client
//        ServerSocketChannel s = (ServerSocketChannel) c;
        //呼应上， int nums = selector.select();  //阻塞  wakeup()
//        try {
//            s.register(st.selector, SelectionKey.OP_ACCEPT);  //会被阻塞的!!!!!
//            st.selector.wakeup();  //功能是让 selector的select（）方法，立刻返回，不阻塞！
//            System.out.println("aaaaa");
//        } catch (ClosedChannelException e) {
//            e.printStackTrace();
//        }

    }



    //无论 serversocket  socket  都复用这个方法
    private SelectorThread next() {
        int index = xid.incrementAndGet() % sts.length;  //轮询就会很尴尬，倾斜
        return sts[index];
    }
    private SelectorThread nextV2() {
        int index = xid.incrementAndGet() % (sts.length-1);  //轮询就会很尴尬，倾斜
        return sts[index+1];
    }

    private SelectorThread nextV3() {
        int index = xid.incrementAndGet() % stg.sts.length;  //动用worker的线程分配
        return stg.sts[index];
    }
}
