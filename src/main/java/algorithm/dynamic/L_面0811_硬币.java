package algorithm.dynamic;

/**
 * @author hsfxuebao
 * @date 2020/03/29
 *
 *硬币。给定数量不限的硬币，币值为25分、10分、5分和1分，编写代码计算n分有几种表示法。(结果可能会很大，你需要将结果模上1000000007)
 *
 * 示例1:
 *
 *  输入: n = 5
 *  输出：2
 *  解释: 有两种方式可以凑成总金额:
 * 5=5
 * 5=1+1+1+1+1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/coin-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L_面0811_硬币 {


	//动态规划2
	public static int waysToChangeBydp2(int n) {

		int[] arr = new int[]{1,5,10,25};
		int[][] dp = new int[arr.length][n + 1];

		//初始化第一列
		for (int i = 0; i < arr.length; i++) {
			dp[i][0] = 1;
		}
		//初始化第一行
		for (int j = 1; arr[0] * j <= n; j++) {
			dp[0][arr[0] * j] = 1;
		}

		for (int i = 1; i < arr.length; i++) {
			for (int j = 0; j <= n; j++) {
				dp[i][j] = dp[i-1][j];
				if (j - arr[i] >= 0) {
					dp[i][j] += dp[i][j - arr[i]];
				}
			}
		}
		return dp[arr.length - 1][n];
	}


	//动态规划1
	public static int waysToChangeBydp(int n) {

		int[] arr = new int[]{1,5,10,25};
		int[][] dp = new int[arr.length][n + 1];

		//初始化第一列
		for (int i = 0; i < arr.length; i++) {
			dp[i][0] = 1;
		}
		//初始化第一行
		for (int j = 1; arr[0] * j <= n; j++) {
			dp[0][arr[0] * j] = 1;
		}

		for (int i = 1; i < arr.length; i++) {
			for (int j = 0; j <= n; j++) {
				int res = 0;
				for (int k = 0; arr[i] * k <= j; k++) {
					res += dp[i-1][j - arr[i] * k];
				}
				dp[i][j] = res;
			}
		}
		return dp[arr.length - 1][n];
	}

	//递归
	public static int waysToChange(int n) {

		int[] arr = new int[]{1,5,10,25};
		return process(arr,0, n);

	}

	private static int process(int[] arr, int index, int sum) {
		int res = 0;
		if (index == arr.length) {
			res = sum == 0 ? 1 : 0;
		} else {

			for (int i = 0; arr[index] * i <= sum ; i++) {
				res += process(arr, index+1, sum-arr[index]*i);
			}
		}
		return res;

	}


	public static void main(String[] args) {

		System.out.println(waysToChange(5));
		System.out.println(waysToChangeBydp(5));
		System.out.println(waysToChangeBydp2(5));
	}

}
