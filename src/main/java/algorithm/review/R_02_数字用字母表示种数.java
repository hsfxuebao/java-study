package algorithm.review;

import org.apache.commons.lang3.StringUtils;


/**
 * @author hsfxuebao
 * @date 2020/03/16
 * <p>
 * a = 1;b =2,c=3,....z=26;input ：String[0-9],输出，种数
 * <p>
 * 例如：111
 * 可以用 aaa,ak,ka三种方式表示
 */
public class R_02_数字用字母表示种数 {



	public static Integer getNumber(String str) {
		if (str == null) {
			return 0;
		}
		int length = str.length();
		Integer[] dp = new Integer[length];

		//设置初始值
		dp[0] = 1;
		dp[1] = 1;
		if (length == 1) {
			return dp[length - 1];
		}

		Integer number1 = Integer.valueOf(StringUtils.substring(str, 0, 2));
		if (number1 <= 26) {
			dp[1] = 2;
		}
		for (int i = 2; i < length; i++) {
			dp[i] = dp[i-2] + 1;
			Integer number = Integer.valueOf(StringUtils.substring(str, i - 1, i + 1));
			if (number <= 26 && number >= 10) {
				dp[i]++;
			}
		}
		return dp[length - 1];
	}




	public static void main(String[] args) {

		String str = "111";
		System.out.println(getNumber(str));
		System.out.println();
	}

}
