package leetcode;

/**
 * @author haoshaofei
 * @date 2020/03/13
 *
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 *
 * 示例 1:
 * 输入: 123
 * 输出: 321
 * 示例 2:
 * 输入: -123
 * 输出: -321
 * 示例 3:
 * 输入: 120
 * 输出: 21
 *
 */
public class X_007_整数反转 {

    /**
     * 字符串反转
     */
    public int reverse(int x) {
        String s = x >= 0 ? String.valueOf(x) : String.valueOf(x).substring(1);
        s = new StringBuilder(s).reverse().toString();

        try {
            return x >= 0 ? Integer.valueOf(s) : -Integer.valueOf(s);
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    /**
     * 此种情况无需考虑正负号问题
     */
    public int reverse1(int x) {
        long res = 0;

        while (x != 0) {
            res = res*10 + x%10;
            x /= 10;
        }

        return (Integer.MAX_VALUE <= res || Integer.MIN_VALUE >= res) ? 0 : (int) res;
    }
}