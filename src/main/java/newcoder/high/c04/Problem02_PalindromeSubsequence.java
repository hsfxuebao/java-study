package newcoder.high.c04;

/**
 *
 * 给定一个字符串str，求最长的回文子序列。注意区分子序列和子串的不同。
 *
 */
public class Problem02_PalindromeSubsequence {

	public static int maxLen1(String str) {
		if (str == null || str.length() == 0) {
			return 0;
		}
		char[] str1 = str.toCharArray();
		char[] str2 = reverse(str1);
		return lcse(str1, str2);
	}

	public static char[] reverse(char[] str) {
		char[] reverse = new char[str.length];
		for (int i = 0; i < reverse.length; i++) {
			reverse[i] = str[str.length - 1 - i];
		}
		return reverse;
	}

	public static int lcse(char[] str1, char[] str2) {
		int[][] dp = new int[str1.length][str2.length];
		dp[0][0] = str1[0] == str2[0] ? 1 : 0;
		for (int i = 1; i < str1.length; i++) {
			dp[i][0] = Math.max(dp[i - 1][0], str1[i] == str2[0] ? 1 : 0);
		}
		for (int j = 1; j < str2.length; j++) {
			dp[0][j] = Math.max(dp[0][j - 1], str1[0] == str2[j] ? 1 : 0);
		}
		for (int i = 1; i < str1.length; i++) {
			for (int j = 1; j < str2.length; j++) {
				dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				if (str1[i] == str2[j]) {
					dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - 1] + 1);
				}
			}
		}
		return dp[str1.length - 1][str2.length - 1];
	}

	public static int maxLen2(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}
		char[] str = s.toCharArray();
		int[][] dp = new int[str.length][str.length];
		for (int i = 0; i < str.length; i++) {
			dp[i][i] = 1;
		}
		for (int i = 0; i < str.length - 1; i++) {
			dp[i][i + 1] = str[i] == str[i + 1] ? 2 : 1;
		}
		for (int i = str.length - 2; i >= 0; i--) {
			for (int j = i + 2; j < str.length; j++) {
				dp[i][j] = Math.max(dp[i][j - 1], dp[i + 1][j]);
				if (str[i] == str[j]) {
					dp[i][j] = Math.max(dp[i + 1][j - 1] + 2, dp[i][j]);
				}
			}
		}
		return dp[0][str.length - 1];
	}

	public static void main(String[] args) {
		String test = "A1BC2D33FG2H1I";
		System.out.println(maxLen1(test));
		System.out.println(maxLen2(test));
	}

}
