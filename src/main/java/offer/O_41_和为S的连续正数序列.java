package offer;

import java.util.ArrayList;

/**
 * @author haoshaofei
 * @date 2020/03/13
 *
 * 小明很喜欢数学, 有一天他在做数学作业时, 要求计算出9~16的和,他马上就写出了正确答案是100。但是他并不满足于此,他在想究竟有多少种连续的正数序列的和为100(至少包括两个数)。没多久,他就得到另一组连续正数和为100的序列:18,19,20,21,22。现在把问题交给你,你能不能也很快的找出所有和为S的连续正数序列? Good Luck!
 *
 * 输出所有和为S的连续正数序列。序列内按照从小至大的顺序，序列间按照开始数字从小到大的顺序
 */
public class O_41_和为S的连续正数序列 {

    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        if (sum <= 1) {
            return new ArrayList<>();
        }
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();

        int left = 1;
        int right = 1;
        for (int i = 0; i <= sum; i++) {
            int tmpSum = getSum(left, right);
            if (tmpSum == sum) {
                addList(list, left, right);
                res.add(new ArrayList<>(list));
                list = new ArrayList<>();
                right++;
            } else if (tmpSum < sum) {
                right++;
            } else {
                left++;
            }
        }

        return res;
    }

    private void addList(ArrayList<Integer> list, int left, int right) {
        for (int i = left;i <= right;i++) {
            list.add(i);
        }
    }

    private int getSum(int left, int right) {
        int sum = 0;

        for (int i = left;i <= right;i++) {
            sum += i;
        }

        return sum;
    }
}