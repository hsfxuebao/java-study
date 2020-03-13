package offer;

/**
 * @author haoshaofei
 * @date 2020/03/13
 *
 * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 */
public class O_10_矩形覆盖 {

    public int RectCover(int target) {
        if (target <= 2) {
            return target;
        }

        int res = 0;
        int pre1 = 2;
        int pre2 = 1;

        for (int i = 3;i <= target;i++) {
            res = pre1 + pre2;
            pre2 = pre1;
            pre1 = res;
        }

        return res;
    }
}