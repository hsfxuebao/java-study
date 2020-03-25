package algorithm.dynamic;

/**
 * @author haoshaofei
 * @date 2020/03/17
 *
 *  给定两个数组w和v，两个数组长度相等，w[i]表示第i件商品的 重量，v[i]表示第i件商品的价值。
 *  再给定一个整数bag，要求 你挑选商品的重量加起来一定不能超 过bag，
 *  返回满足这个条件 下，你能获得的最大价值
 *
 */
public class N_08_背包问题 {

	public static int maxValue1(int[] c, int[] p, int bag) {
		return process1(c, p, 0, 0, bag);
	}

	public static int process1(int[] weights, int[] values, int i, int alreadyweight, int bag) {
		if (alreadyweight > bag) {
			return 0;
		}
		if (i == weights.length) {
			return 0;
		}
		return Math.max(

				process1(weights, values, i + 1, alreadyweight, bag),

				values[i] + process1(weights, values, i + 1, alreadyweight + weights[i], bag));
	}

	public static int maxValue2(int[] c, int[] p, int bag) {
		int[][] dp = new int[c.length + 1][bag + 1];
		for (int i = c.length - 1; i >= 0; i--) {
			for (int j = bag; j >= 0; j--) {
				dp[i][j] = dp[i + 1][j];
				if (j + c[i] <= bag) {
					dp[i][j] = Math.max(dp[i][j], p[i] + dp[i + 1][j + c[i]]);
				}
			}
		}
		return dp[0][0];
	}

	public static void main(String[] args) {
		int[] c = { 3, 2, 4, 7 };
		int[] p = { 5, 6, 3, 19 };
		int bag = 11;
		System.out.println(maxValue1(c, p, bag));
		System.out.println(maxValue2(c, p, bag));
	}
}
