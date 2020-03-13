package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author haoshaofei
 * @date 2020/03/13
 * 类型题：两数之和（1），三数之和（15），四数之和（18）
 *
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
 * 注意：答案中不可以包含重复的三元组。
 *
 * 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 * 满足要求的三元组集合为：
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 *
 **/
public class X_015_三数之和 {

    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }

        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0;i < nums.length;i++) {
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }

            int left = i+1;
            int right = nums.length-1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    res.add(Arrays.asList(i, left, right));
                    while (left < nums.length - 1 && nums[left] == nums[left+1]) {
                        left++;
                    }
                    while (right > 0 && nums[right] == nums[right-1]) {
                        right--;
                    }
                    left++;
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return res;
    }
}