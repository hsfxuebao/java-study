package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author haoshaofei
 * @date 2020/03/13
 *
 * 类型题：两数之和（1），三数之和（15），四数之和（18）
 *
 * 给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。
 * 注意：
 * 答案中不可以包含重复的四元组。
 *
 * 示例：
 * 给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。
 *
 * 满足要求的四元组集合为：
 * [
 *   [-1,  0, 0, 1],
 *   [-2, -1, 1, 2],
 *   [-2,  0, 0, 2]
 * ]
 *
 **/
public class X_018_四数之和 {

    /**
     * 和三数之和思想类似，只是增加了一次循环，
     */
    public List<List<Integer>> fourSum(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }

        Arrays.asList(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0;i < nums.length;i++) {
            for (int j = i+1;j < nums.length;j++) {
                if (j < nums.length-1 && nums[j] == nums[j+1]) {
                    continue;
                }

                int left = j+1;
                int right = nums.length-1;

                while (left < right) {
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum == target) {
                        res.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        while (left < right && nums[left] == nums[left+1]) {
                            left++;
                        }
                        while (left < right && nums[right] == nums[right-1]) {
                            right--;
                        }
                        left++;
                        right--;
                    } else if (sum < target) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }

        return res;
    }
}