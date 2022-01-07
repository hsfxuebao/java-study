package algorithm.dynamic;

/**
 * @author hsfxuebao
 * @date 2020/03/17
 *
 * 给你一个数组arr，和一个整数aim。如果可以任意选择arr中的 数字，能不能累加得到aim，返回true或者false
 *
 */
public class N_07_某几个元素和 {

	public static boolean money1(int[] arr, int aim) {
		return process1(arr, 0, 0, aim);
	}

	public static boolean process1(int[] arr, int i, int sum, int aim) {
		if (sum == aim) {
			return true;
		}
		// sum != aim
		if (i == arr.length) {
			return false;
		}
		return process1(arr, i + 1, sum, aim) || process1(arr, i + 1, sum + arr[i], aim);
	}

	public static boolean money2(int[] arr, int aim) {
		boolean[][] dp = new boolean[arr.length + 1][aim + 1];
		for (int i = 0; i < dp.length; i++) {
			dp[i][aim] = true;
		}
		for (int i = arr.length - 1; i >= 0; i--) {
			for (int j = aim - 1; j >= 0; j--) {
				dp[i][j] = dp[i + 1][j];
				if (j + arr[i] <= aim) {
					dp[i][j] = dp[i][j] || dp[i + 1][j + arr[i]];
				}
			}
		}
		return dp[0][0];
	}

	public static void main(String[] args) {
		int[] arr = { 1, 4, 8 };
		int aim = 12;
		System.out.println(money1(arr, aim));
		System.out.println(money2(arr, aim));
	}
}
