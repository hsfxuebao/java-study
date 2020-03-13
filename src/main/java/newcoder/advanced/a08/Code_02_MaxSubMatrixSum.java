package newcoder.advanced.a08;

/**
 *
 * 子数组的最大累加和问题
 * 【题目】
 * 给定一个数组arr，返回子数组的最大累加和。 例如，arr=[1,-2,3,5,-2,6,-1]，所有的子数组中，[3,5,-2,6] 可以累加出最大的和12，所以返回12。
 * 【要求】 如果arr长度为N，要求时间复杂度为O(N)，额外空间复杂度为 O(1)。
 */
public class Code_02_MaxSubMatrixSum {

	public static int maxSum(int[][] m) {
		if (m == null || m.length == 0 || m[0].length == 0) {
			return 0;
		}
		int max = Integer.MIN_VALUE;
		int cur = 0;
		int[] s = null;
		for (int i = 0; i != m.length; i++) {
			s = new int[m[0].length];
			for (int j = i; j != m.length; j++) {
				cur = 0;
				for (int k = 0; k != s.length; k++) {
					s[k] += m[j][k];
					cur += s[k];
					max = Math.max(max, cur);
					cur = cur < 0 ? 0 : cur;
				}
			}
		}
		return max;
	}

	public static void main(String[] args) {
		int[][] matrix = { { -90, 48, 78 }, { 64, -40, 64 }, { -81, -7, 66 } };
		System.out.println(maxSum(matrix));

	}
}
