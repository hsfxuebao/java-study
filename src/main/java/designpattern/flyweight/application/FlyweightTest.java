package designpattern.flyweight.application;

/**
 * @author haoshaofei
 * Created on 2021-08-01
 */
public class FlyweightTest {

    public static void main(String[] args) {

        //如果 Integer.valueOf(x) x 在  -128 --- 127 范围内就使用享元模式直接返回
        // 否则  使用new


        Integer x = Integer.valueOf(127); // 得到 x 实例 Integer
        Integer y = new Integer(127); // µÃµ½ y ÊµÀý£¬ÀàÐÍ Integer
        Integer z = Integer.valueOf(127);//..
        Integer w = new Integer(127);



        System.out.println(x.equals(y)); // 大小 true
        System.out.println(x == y ); //  false
        System.out.println(x == z ); // true
        System.out.println(w == x ); // false
        System.out.println(w == y ); // false


        Integer x1 = Integer.valueOf(200);
        Integer x2 = Integer.valueOf(200);
        System.out.println("x1==x2" + (x1 == x2)); // false
    }


}
