package leetcode;

/**
 * @author haoshaofei
 * @date 2020/03/13
 *
 * 报数序列是一个整数序列，按照其中的整数的顺序进行报数，得到下一个数。其前五项如下：
 *
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 * 1 被读作  "one 1"  ("一个一") , 即 11。
 * 11 被读作 "two 1s" ("两个一"）, 即 21。
 * 21 被读作 "one 2",  "one 1" （"一个二" ,  "一个一") , 即 1211。
 *
 * 给定一个正整数 n（1 ≤ n ≤ 30），输出报数序列的第 n 项。
 * 注意：整数顺序将表示为一个字符串。
 *
 *
 * 示例 1:
 * 输入: 1
 * 输出: "1"
 * 示例 2:
 * 输入: 4
 * 输出: "1211"
 *
 */
public class X_038_报数 {

    /**
     * 错误的
     */
    public String countAndSay(int n) {
        if (n == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder().append(1);

        int count = 0;
        for (int i = 0;i < sb.length();i++) {
            count++;

            if (sb.charAt(i) == '1') {
                if(sb.charAt(i+1) == '1') {
                    sb.delete(i,i+2);
                }
            }

            if (count == n) {
                break;
            }
        }

        return sb.toString();
    }

    public String countAndSay2(int n) {
        String str = "1";
        while (--n > 0) {
            int times = 1;
            StringBuilder sb = new StringBuilder();
            char[] chars = str.toCharArray();
            int len = chars.length;
            for (int j = 1; j < len; j++) {
                if (chars[j - 1] == chars[j]) {
                    times++;
                } else {
                    sb.append(times).append(chars[j - 1]);
                    times = 1;
                }
            }
            str = sb.append(times).append(chars[len - 1]).toString();
        }
        return str;
    }

    public static void main(String[] args) {
        X_038_报数 test = new X_038_报数();
        test.countAndSay(2);
    }
}