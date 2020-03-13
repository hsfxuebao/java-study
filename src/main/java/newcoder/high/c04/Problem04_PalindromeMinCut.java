package newcoder.high.c04;

/**
 *
 *
 * 给定一个字符串str，返回把str全部切成回文子串的最小分割数。 【举例】
 * str="ABA"。
 * 不需要切割，str本身就是回文串，所以返回0。
 * str="ACDCDCDAD"。 最少需要切2次变成3个回文子串，比如"A"、"CDCDC"和"DAD"，所以返回2。
 */
public class Problem04_PalindromeMinCut {

	public static int minCut(String str) {
		if (str == null || str.equals("")) {
			return 0;
		}
		char[] chas = str.toCharArray();
		int len = chas.length;
		int[] dp = new int[len + 1];
		dp[len] = -1;
		boolean[][] p = new boolean[len][len];
		for (int i = len - 1; i >= 0; i--) {
			dp[i] = Integer.MAX_VALUE;
			for (int j = i; j < len; j++) {
				if (chas[i] == chas[j] && (j - i < 2 || p[i + 1][j - 1])) {
					p[i][j] = true;
					dp[i] = Math.min(dp[i], dp[j + 1] + 1);
				}
			}
		}
		return dp[0];
	}

	// for test
	public static String getRandomStringOnlyAToD(int len) {
		int range = 'D' - 'A' + 1;
		char[] charArr = new char[(int) (Math.random() * (len + 1))];
		for (int i = 0; i != charArr.length; i++) {
			charArr[i] = (char) ((int) (Math.random() * range) + 'A');
		}
		return String.valueOf(charArr);
	}

	public static void main(String[] args) {
		int maxLen = 10;
		int testTimes = 5;
		String str = null;
		for (int i = 0; i != testTimes; i++) {
			str = getRandomStringOnlyAToD(maxLen);
			System.out.print("\"" + str + "\"" + " : ");
			System.out.println(minCut(str));
		}

	}
}
