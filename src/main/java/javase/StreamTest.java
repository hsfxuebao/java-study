package javase;

import java.util.ArrayList;
import java.util.List;

/**
 * @author haoshaofei <haoshaofei@kuaishou.com>
 * Created on 2021-03-10
 */
public class StreamTest {


    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <=10 ; i++) {
            list.add(i);
        }

        System.out.println("集合：" + list);
        list.stream().skip(5).limit(12).forEach(System.out::println);


    }

}
