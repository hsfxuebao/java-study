package algorithm.array;

import algorithm.util.PrintUtils;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author haoshaofei
 * @date 2020/03/28
 *
 * 设计一个算法，找出数组中两数之和为指定值的所有整数对。一个数只能属于一个数对。
 *
 * 示例 1:
 *
 * 输入: nums = [5,6,5], target = 11
 * 输出: [[5,6]]
 * 示例 2:
 *
 * 输入: nums = [5,6,5,6], target = 11
 * 输出: [[5,6],[5,6]]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/pairs-with-sum-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L_面1624_数对和 {

	public static List<List<Integer>> pairSums(int[] nums, int target) {
		List<List<Integer>> ans = new LinkedList<>();
		Arrays.sort(nums);
		int start = 0;
		int end = nums.length - 1;
		while (start <= end){
			int sum = nums[start] + nums[end];
			if (sum < target) {
				start++;
			} else if (sum > target) {
				end--;
			} else {
				List<Integer> list = new LinkedList<>();
				list.add(nums[start]);
				list.add(nums[end]);
				ans.add(list);
				start++;
				end--;
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		int[] num = {5,6,5,6};

		System.out.println(pairSums(num, 11));
	}

}
