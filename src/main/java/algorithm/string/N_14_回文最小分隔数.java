package algorithm.string;

/**
 * 未看
 * @author hsfxuebao
 * @date 2020/03/26
 *
 * 回文最小分割数
 *  * 【题目】 给定两个字符串str，请把str切割，保证每一部分都是回文串，求最小的分割 数。
 *  * 【举例】 str="AA12321BB"，切成"AA","12321","BB"，每一部分都是回文串，分出3个 部分，所以返回3
 *
 */
public class N_14_回文最小分隔数 {


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
