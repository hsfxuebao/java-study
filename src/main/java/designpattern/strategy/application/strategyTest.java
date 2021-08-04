package designpattern.strategy.application;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author haoshaofei
 * Created on 2021-08-04
 */
public class strategyTest {

    public static void main(String[] args) {

        // TODO Auto-generated method stub
        // 数组
        Integer[] data = { 9, 1, 2, 8, 4, 3 };
        // 时间降序排序  返回-1 放左边 1放右边 0 保持不变

        // 说明
        // 1. 实现了 Comparator 接口 策略接口,  匿名类 对象 new Comparator<Integer>(){..}
        // 2. 对象 new Comparator<Integer>(){..} 就是实现了 策略接口的对象
        // 3. public int compare(Integer o1, Integer o2){} 指定了具体的处理方式
        Comparator<Integer> comparator = new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2) {
                if (o1 > o2) {
                    return -1;
                } else {
                    return 1;
                }
            };
        };

        // 说明
		/*
		 * public static <T> void sort(T[] a, Comparator<? super T> c) {
		        if (c == null) {
		            sort(a); // 默认方法
		        } else {
		            if (LegacyMergeSort.userRequested)
		                legacyMergeSort(a, c); // 使用策略对象c
		            else
		            	// 使用策略对象c
		                TimSort.sort(a, 0, a.length, c, null, 0, 0);
		        }
		    }
		 */
        //
        Arrays.sort(data, comparator);

        System.out.println(Arrays.toString(data)); // 降序排序


        //方式2 同事lamda 表达式实现 策略模式
        Integer[] data2 = { 19, 11, 12, 18, 14, 13 };

        Arrays.sort(data2, (var1, var2) -> {
            if(var1.compareTo(var2) > 0) {
                return -1;
            } else {
                return 1;
            }
        });

        System.out.println("data2=" + Arrays.toString(data2));

    }



}
