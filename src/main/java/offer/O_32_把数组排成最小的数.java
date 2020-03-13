package offer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author haoshaofei
 * @date 2020/03/13
 *
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
 */
public class O_32_把数组排成最小的数 {

    public String PrintMinNumber(int [] numbers) {
        if (numbers.length == 0) {
            return "";
        }

        List<Integer> list = new ArrayList<>();
        for (int num : numbers) {
            list.add(num);
        }
        list.sort((o1, o2) -> {
            String s1 = o1 + "" + o2;
            String s2 = o2 + "" + o1;
            return s1.compareTo(s2);
        });

        StringBuilder sb = new StringBuilder();
        for (Integer i : list) {
            sb.append(i);
        }

        return sb.toString();
    }
}