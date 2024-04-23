package algorithm.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TwoSumTest {


    public List<List<Integer>> threeSum(int[] nums) {

        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<>();

        // 固定一个数，求 两个之和的所有可能结果
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            // 计算从i+1位置开始，和为0-num
            List<List<Integer>> twoSumList = twoSumAll(nums, i + 1, -num);
            for (List<Integer> res : twoSumList) {
                res.add(num);
                result.add(res);
            }
            // 第一个数重复的情况
            while (i < nums.length && nums[i] == num) {
                i++;
            }

        }
        return result;

    }

    public static List<List<Integer>> twoSumAll(int[] nums, int index, int target) {

        List<List<Integer>> result = new ArrayList<>();

        int left = index, right = nums.length - 1;
        while (left < right) {

            int leftNum = nums[left];
            int rightNum = nums[right];
            int sum = leftNum + rightNum;
            if (sum < target) {
                while (left < right && nums[left] == leftNum) {
                    left++;
                }
            } else if (sum > target) {
                while (left < right && nums[right] == rightNum) {
                    right--;
                }
            } else if (sum == target) {
                List<Integer> res = new ArrayList<>();
                res.add(leftNum);
                res.add(rightNum);
                result.add(res);
                while (left < right && nums[left] == leftNum) {
                    left++;
                }
                while (left < right && nums[right] == rightNum) {
                    right--;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};
        System.out.println(twoSumAll(nums, 0, 0));

    }
}

