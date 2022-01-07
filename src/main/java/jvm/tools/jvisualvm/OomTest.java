package jvm.tools.jvisualvm;

import java.util.ArrayList;
import java.util.Random;

/**
 * @author hsfxuebao
 * Created on 2021-02-23
 *
 * -Xms500m -Xmx500m -XX:SurvivorRatio=8
 */
public class OomTest {
    public static void main(String[] args) {
        ArrayList<Picture> list = new ArrayList();

        while(true){
            try{
                Thread.sleep(5);
            } catch(InterruptedException e){
                e.printStackTrace();
            }

            list.add(new Picture(new Random().nextInt(100 * 50)));
        }
    }

    static class Picture{
        private byte[] pixels;

        public Picture(int length){
            this.pixels = new byte[length];
        }
    }
}
