package concurrent.juctools.flowcontrol.condition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.apache.log4j.Logger;

/**
 * 此demo用于测试 condition
 * Created by xujiankang on 2017/2/8.
 */
public class ConditionTest {

    private static final Logger logger = Logger.getLogger(ConditionTest.class);

    static final Lock lock = new ReentrantLock();
    static final Condition condition = lock.newCondition();

    public static void main(String[] args) throws Exception{

        final Thread thread1 = new Thread("Thread 1 "){
            @Override
            public void run() {
                lock.lock(); // 线程 1获取 lock
                logger.info(Thread.currentThread().getName() + " 正在运行 .....");

                try {
                    Thread.sleep(2 * 1000);
                    logger.info(Thread.currentThread().getName() + " 停止运行, 等待一个 signal ");
                    condition.await(); // 调用 condition.await 进行释放锁, 将当前节点封装成一个 Node 放入 Condition Queue 里面, 等待唤醒
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                logger.info(Thread.currentThread().getName() + " 获取一个 signal, 继续执行 ");
                lock.unlock(); // 释放锁
            }
        };

        thread1.start();  // 线程 1 线运行

        Thread.sleep(1 * 1000);

        Thread thread2 = new Thread("Thread 2 "){
            @Override
            public void run() {
                lock.lock();        // 线程 2获取lock
                logger.info(Thread.currentThread().getName() + " 正在运行.....");
                thread1.interrupt(); // 对线程1 进行中断 看看中断后会怎么样? 结果 线程 1还是获取lock, 并且最后还进行 lock.unlock()操作

                try {
                    Thread.sleep(2 * 1000);
                }catch (Exception e){

                }
                condition.signal(); // 发送唤醒信号 从 AQS 的 Condition Queue 里面转移 Node 到 Sync Queue
                logger.info(Thread.currentThread().getName() + " 发送一个 signal ");
                logger.info(Thread.currentThread().getName() + " 发送 signal 结束");
                lock.unlock(); // 线程 2 释放锁
            }
        };

        thread2.start();

    }


}