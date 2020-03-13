package newcoder.high.c04;

/**
 *
 * 给定一个字符串str，如果可以在str的任意位置添加字符，请返回在添加字符最少 的情况下，让str整体都是回文字符串的一种结果。
 * 【举例】
 * str="ABA"。str本身就是回文串，不需要添加字符，所以返回"ABA"。 str="AB"。可以在'A'之前添加'B'，使str整体都是回文串，故可以返回"BAB"。也 可以在'B'之后添加'A'，使str整体都是回文串，故也可以返回"ABA"。总之，只要 添加的字符数最少，返回其中一种结果即可。
 *
 */
public class Problem03_PalindromeMinAdd {

	public static String getPalindrome1(String str) {
		if (str == null || str.length() < 2) {
			return str;
		}
		char[] chas = str.toCharArray();
		int[][] dp = getDP(chas);
		char[] res = new char[chas.length + dp[0][chas.length - 1]];
		int i = 0;
		int j = chas.length - 1;
		int resl = 0;
		int resr = res.length - 1;
		while (i <= j) {
			if (chas[i] == chas[j]) {
				res[resl++] = chas[i++];
				res[resr--] = chas[j--];
			} else if (dp[i][j - 1] < dp[i + 1][j]) {
				res[resl++] = chas[j];
				res[resr--] = chas[j--];
			} else {
				res[resl++] = chas[i];
				res[resr--] = chas[i++];
			}
		}
		return String.valueOf(res);
	}

	public static int[][] getDP(char[] str) {
		int[][] dp = new int[str.length][str.length];
		for (int j = 1; j < str.length; j++) {
			dp[j - 1][j] = str[j - 1] == str[j] ? 0 : 1;
			for (int i = j - 2; i > -1; i--) {
				if (str[i] == str[j]) {
					dp[i][j] = dp[i + 1][j - 1];
				} else {
					dp[i][j] = Math.min(dp[i + 1][j], dp[i][j - 1]) + 1;
				}
			}
		}
		return dp;
	}

	public static void main(String[] args) {
		String str = "AB1CD2EFG3H43IJK2L1MN";
		System.out.println(getPalindrome1(str));
	}

}
