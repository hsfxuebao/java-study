package designpattern.iterator.application;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author haoshaofei
 * Created on 2021-08-04
 */
public class iteratorTest {


    public static void main(String[] args) {
        // TODO Auto-generated method stub
        List<String> a = new ArrayList<>();
        a.add("jack");// ..
        //
        Iterator Itr = a.iterator();
        while (Itr.hasNext()) {
            System.out.println(Itr.next());
        }
    }
}
