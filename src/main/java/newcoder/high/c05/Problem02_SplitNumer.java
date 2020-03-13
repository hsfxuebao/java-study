package newcoder.high.c05;

/**
 * 给定一个正数1，裂开的方法有一种，(1) 给定一个正数2，裂开的方法有两种，(1和1)、(2) 给定一个正数3，裂开的方法有三种，(1、1、1)、(1、2)、(3) 给定一个正数4，裂开的方法有五种，(1、1、1、1)、(1、1、2)、(1、3)、(2、2)、 (4)
 * 给定一个正数n，求裂开的方法数。 动态规划优化状态依赖的技巧
 *
 */
public class Problem02_SplitNumer {

	public static int ways1(int n) {
		if (n < 1) {
			return 0;
		}
		return process(1, n);
	}

	public static int process(int pre, int rest) {
		if (rest == 0) {
			return 1;
		}
		if (pre > rest) {
			return 0;
		}
		int ways = 0;
		for (int i = pre; i <= rest; i++) {
			ways += process(i, rest - i);
		}
		return ways;
	}

	public static int ways2(int n) {
		if (n < 1) {
			return 0;
		}
		int[][] dp = new int[n + 1][n + 1];
		for (int pre = 1; pre < dp.length; pre++) {
			dp[pre][0] = 1;
		}
		for (int pre = n; pre > 0; pre--) {
			for (int rest = pre; rest <= n; rest++) {
				for (int i = pre; i <= rest; i++) {
					dp[pre][rest] += dp[i][rest - i];
				}
			}
		}
		return dp[1][n];
	}

	public static int ways3(int n) {
		if (n < 1) {
			return 0;
		}
		int[][] dp = new int[n + 1][n + 1];
		for (int pre = 1; pre < dp.length; pre++) {
			dp[pre][0] = 1;
		}
		for (int pre = 1; pre < dp.length; pre++) {
			dp[pre][pre] = 1;
		}
		for (int pre = n - 1; pre > 0; pre--) {
			for (int rest = pre + 1; rest <= n; rest++) {
				dp[pre][rest] = dp[pre + 1][rest] + dp[pre][rest - pre];
			}
		}
		return dp[1][n];
	}

	public static void main(String[] args) {
		int n = 20;
		System.out.println(ways1(n));
		System.out.println(ways2(n));
		System.out.println(ways3(n));
	}

}
