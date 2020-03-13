package offer;

import java.util.ArrayList;

/**
 * @author haoshaofei
 * @date 2020/03/13
 *
 * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。
 * 输出描述:
 * 对应每个测试案例，输出两个数，小的先输出。
 */
public class O_42_和为S的两个数字 {

    public ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {
        if (array.length <= 1) {
            return new ArrayList<>();
        }

        int left = 0;
        int right = array.length-1;
        ArrayList<Integer> res = new ArrayList<>();

        while (left < right) {
            int target = array[left] + array[right];
            if (target < sum) {
                left++;
            } else if (target > sum) {
                right--;
            } else {
                res.add(array[left]);
                res.add(array[right]);
                return res;
            }
        }

        return res;
    }
}