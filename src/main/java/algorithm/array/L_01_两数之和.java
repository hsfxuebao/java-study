package algorithm.array;

import algorithm.util.PrintUtils;
import com.google.common.collect.Maps;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author haoshaofei
 * @date 2020/05/09
 *
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
 *
 *  
 *
 * 示例:
 *
 * 给定 nums = [2, 7, 11, 15], target = 9
 *
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L_01_两数之和 {


	public static int[] twoSum(int[] nums, int target) {

		if (Objects.isNull(nums)) {
			return null;
		}

		int numsLength = nums.length;
		Map<Integer, Integer> numIndexMap = Maps.newHashMapWithExpectedSize(numsLength);

		for (int i = 0; i < numsLength; i++) {
			int diff = target - nums[i];
			if (numIndexMap.containsKey(diff)) {
				return new int[]{numIndexMap.get(diff), i};
			}
			numIndexMap.put(nums[i], i);
		}
		return null;
	}

	public static void main(String[] args) {
		int[] nums = {2,7,11,15};
		int target = 9;
		PrintUtils.printArray(twoSum(nums, target));

	}

}
