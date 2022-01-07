package algorithm.array;

/**
 * @author hsfxuebao
 * @date 2020/03/30
 *
 * 输入一个整型数组，数组里有正数也有负数。数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
 *
 * 要求时间复杂度为O(n)。
 *
 *  
 *
 * 示例1:
 *
 * 输入: nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/lian-xu-zi-shu-zu-de-zui-da-he-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L_面42_连续子数组的最大和 {

	public static int maxSubArray(int[] nums) {

		if (nums == null || nums.length < 1) {
			return 0;
		}
		int max = Integer.MIN_VALUE;
		int current = 0;
		for (int i = 0; i < nums.length; i++) {
			current += nums[i];
			max = Math.max(current, max);
			current = current < 0 ? 0 : current;
		}
		return max;

	}

	public static void main(String[] args) {
		int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
		System.out.println(maxSubArray(nums));

	}
}
