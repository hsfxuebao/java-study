package concurrent;

public class SynExample1 {
    //1.创建共享变量
    private static boolean flag = true;

    public static void main(String[] args) throws Exception {
        //2.t1空循环，如果flag为true,不退出
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    //新增的打印语句
//                    System.out.println(flag);
                    if(!flag){
                        System.out.println("进入if");
                        break;
                    }
                }
            }
        });
        t1.start();

        Thread.sleep(2000L);
        //2.t2修改flag为false
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                flag = false;
                System.out.println("修改了");
            }
        });

        t2.start();
    }
}