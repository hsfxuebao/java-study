package offer;

/**
 * @author haoshaofei
 * @date 2020/03/13
 *
 * 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0）。
 * 0 1 1 2 3
 * f(n) = f(-1) + f(n-2)
 * n<=39
 */
public class O_07_斐波那契数列 {

    public int Fibonacci(int n) {
        if (n <= 1) {
            return n;
        }

        int pre1 = 1;
        int pre2 = 0;
        int res = 1;

        for (int i = 2;i <= n;i++) {
            res = pre1 + pre2;
            pre2 = pre1;
            pre1 = res;
        }

        return res;
    }
}