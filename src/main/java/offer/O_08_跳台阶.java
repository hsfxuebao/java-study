package offer;

/**
 * @author haoshaofei
 * @date 2020/03/13
 *
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
 * f(n) = f(n-1) + f(n-2)
 *
 */
public class O_08_跳台阶 {

    public int JumpFloor(int target) {
        if (target <= 3) {
            return target;
        }

        int pre1 = 3;
        int pre2 = 2;
        int res = 3;

        for (int i = 4; i <= target;i++) {
            res = pre1 + pre2;
            pre2 = pre1;
            pre1 = res;
        }

        return res;
    }
}