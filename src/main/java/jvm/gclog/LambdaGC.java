package jvm.gclog;

/**
 * @author hsfxuebao
 * Created on 2021-04-11
 */
public class LambdaGC {

    public static void main(String[] args) {
        for (; ; ) {
            I i = C::n;
        }

    }

    public static interface I {
        void m();
    }

    public static class C {
        static void n() {
            System.out.println("hello");
        }
    }

}
