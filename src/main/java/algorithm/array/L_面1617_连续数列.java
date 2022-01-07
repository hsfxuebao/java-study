package algorithm.array;

/**
 * @author hsfxuebao
 * @date 2020/03/28
 * 给定一个整数数组（有正数有负数），找出总和最大的连续数列，并返回总和。
 *
 * 示例：
 *
 * 输入： [-2,1,-3,4,-1,2,1,-5,4]
 * 输出： 6
 * 解释： 连续子数组 [4,-1,2,1] 的和最大，为 6。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/contiguous-sequence-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L_面1617_连续数列 {

	public static Integer maxSubArray(int[] nums) {
		int res=nums[0];
		for(int i=1;i<nums.length;i++){
			nums[i]=Math.max(nums[i-1]+nums[i],nums[i]);
			res=Math.max(res,nums[i]);
		}
		return res;
	}

	public static void main(String[] args) {
		int[] num = {-2,1,-3,4,-1,2,1,-5,4};
		System.out.println(maxSubArray(num));
	}

}
