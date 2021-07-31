package designpattern.decorator.application;


import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author haoshaofei
 * Created on 2021-07-31
 */
public class DecoratorTest {


    public static void main(String[] args) throws IOException {
        DataInputStream dis = new DataInputStream(new FileInputStream("d:\\abc.txt"));
        System.out.println(dis.read());
        dis.close();
    }

}
