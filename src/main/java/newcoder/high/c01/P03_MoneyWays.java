package newcoder.high.c01;

/**
 * 现有n1+n2种面值的硬币，其中前n1种为普通币，可以取任意枚，后n2种为纪念币， 每种最多只能取一枚，每种硬币有一个面值，问能用多少种方法拼出m的面值
 */
public class P03_MoneyWays {

	public static int moneyWays(int[] arbitrary, int[] onlyone, int money) {
		if (money < 0) {
			return 0;
		}
		if ((arbitrary == null || arbitrary.length == 0)
				&& (onlyone == null || onlyone.length == 0)) {
			return money == 0 ? 1 : 0;
		}
		int[][] dparb = getDpArb(arbitrary, money);
		int[][] dpone = getDpOne(onlyone, money);
		if (dparb == null) {
			return dpone[dpone.length - 1][money];
		}
		if (dpone == null) {
			return dparb[dparb.length - 1][money];
		}
		int res = 0;
		for (int i = 0; i <= money; i++) {
			res += dparb[dparb.length - 1][i]
					* dpone[dpone.length - 1][money - i];
		}
		return res;
	}

	public static int[][] getDpArb(int[] arr, int money) {
		if (arr == null || arr.length == 0) {
			return null;
		}
		int[][] dp = new int[arr.length][money + 1];
		for (int i = 0; i < arr.length; i++) {
			dp[i][0] = 1;
		}
		for (int j = 1; arr[0] * j <= money; j++) {
			dp[0][arr[0] * j] = 1;
		}
		for (int i = 1; i < arr.length; i++) {
			for (int j = 1; j <= money; j++) {
				dp[i][j] = dp[i - 1][j];
				dp[i][j] += j - arr[i] >= 0 ? dp[i][j - arr[i]] : 0;
			}
		}
		return dp;
	}

	public static int[][] getDpOne(int[] arr, int money) {
		if (arr == null || arr.length == 0) {
			return null;
		}
		int[][] dp = new int[arr.length][money + 1];
		for (int i = 0; i < arr.length; i++) {
			dp[i][0] = 1;
		}
		if (arr[0] <= money) {
			dp[0][arr[0]] = 1;
		}
		for (int i = 1; i < arr.length; i++) {
			for (int j = 1; j <= money; j++) {
				dp[i][j] = dp[i - 1][j];
				dp[i][j] += j - arr[i] >= 0 ? dp[i - 1][j - arr[i]] : 0;
			}
		}
		return dp;
	}

}
