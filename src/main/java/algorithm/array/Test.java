package algorithm.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {

    /**
     * n数之和,至少2数之和,nums必须是排序好
     */
    public static List<List<Integer>> nSumTarget(int[] nums, int n, int start, int target) {

        int size = nums.length;
        List<List<Integer>> result = new ArrayList<>();
        if (n < 2 || size < n) {
            return result;
        }

        if (n == 2) {
            int left = start, right = size - 1;
            while (left < right) {

                int leftNum = nums[left];
                int rightNum = nums[right];
                int sum = leftNum + rightNum;
                if (sum < target) {
                    while (left < right && nums[left] == leftNum) {
                        left++;
                    }
                } else if (sum > target) {
                    while (left < right && rightNum == nums[right]) {
                        right--;
                    }
                } else if (sum == target) {
                    result.add(new ArrayList<>(Arrays.asList(leftNum, rightNum)));
                    while (left < right && nums[left] == leftNum) {
                        left++;
                    }
                    while (left < right && rightNum == nums[right]) {
                        right--;
                    }
                }
            }
        } else {
            // n大于2 的情况
            for (int i = start; i < size; ) {
                int iNum = nums[i];
                List<List<Integer>> resList = nSumTarget(nums, n - 1, i + 1, target - nums[i]);
                for (List<Integer> res : resList) {
                    res.add(iNum);
                    result.add(res);
                }

                // 排除 重复的元素
                while (i < size && nums[i] == iNum) {
                    i++;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {-1, 0,1,2,-1,-4};
        Arrays.sort(nums);
        System.out.println(nSumTarget(nums, 3, 0, 0));

    }


}
