package jvm.agent.asm;

import java.lang.management.ManagementFactory;

/**
 * @author haoshaofei
 * Created on 2021-03-24
 */
public class Base {


    public static void process(){
        System.out.println("process");
    }


    public static void main(String[] args) {
        String name = ManagementFactory.getRuntimeMXBean().getName();
        String s = name.split("@")[0];
        //打印当前Pid
        System.out.println("pid:"+s);
        while (true) {
            try {
                Thread.sleep(5000L);
            } catch (Exception e) {
                break;
            }
            process();
        }
    }
}
