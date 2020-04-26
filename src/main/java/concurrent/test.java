package concurrent;

import org.openjdk.jol.info.ClassLayout;

import java.util.concurrent.TimeUnit;

public class test {

    public static void main(String[] args) throws InterruptedException {
        B b = new B();

         Thread thread=new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (b){
                    System.out.println("------------");
                    System.out.println(ClassLayout.parseInstance(b).toPrintable());
                }
            }
        });


        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (b){
                    System.out.println("==================");
                    System.out.println(ClassLayout.parseInstance(b).toPrintable());
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (b){
                    System.out.println("==================");
                    System.out.println(ClassLayout.parseInstance(b).toPrintable());
                }
            }
        });



        thread.start();
        TimeUnit.SECONDS.sleep(10);

        thread1.start();
        thread2.start();


    }
}

class B{
    private Integer a = 100;
}
