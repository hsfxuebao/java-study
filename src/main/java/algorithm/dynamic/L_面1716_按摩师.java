package algorithm.dynamic;

/**
 * @author hsfxuebao
 * @date 2020/03/30
 *一个有名的按摩师会收到源源不断的预约请求，每个预约都可以选择接或不接。在每次预约服务之间要有休息时间，因此她不能接受相邻的预约。给定一个预约请求序列，替按摩师找到最优的预约集合（总预约时间最长），返回总的分钟数。
 *
 * 注意：本题相对原题稍作改动
 *
 *  
 *
 * 示例 1：
 *
 * 输入： [1,2,3,1]
 * 输出： 4
 * 解释： 选择 1 号预约和 3 号预约，总时长 = 1 + 3 = 4。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/the-masseuse-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class L_面1716_按摩师 {

	public static int massage(int[] nums) {

		if (nums == null || nums.length == 0) {
			return 0;
		}
		int len = nums.length;
		if (len == 1) {
			return nums[0];
		}
		if (len == 2) {
			return Math.max(nums[0], nums[1]);
		}

		int[] dp = new int[len];
		dp[0] = nums[0];
		dp[1] = Math.max(nums[0], nums[1]);
		for (int i = 2; i < len; i++) {
			dp[i] = Math.max(dp[i-2] + nums[i], dp[i-1]);
		}
		return dp[len-1];

	}

	public static void main(String[] args) {

		int[] nums = {1,2,3,1};
		System.out.println(massage(nums));
		int[] nums1 = {2,7,9,3,1};
		System.out.println(massage(nums1));
		int[] nums2 = {2,1,4,5,3,1,1,3};
		System.out.println(massage(nums2));

	}
}
