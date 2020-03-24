package kmp;

/**
 * https://blog.csdn.net/duoduo18up/article/details/80686284
 *
 * 给定一个字符串  如何加最短的字符（只能在原始串的后面进行添加）使其构成一个长的字符串且包含两个原始字符串~
 * 思路：其实就是最大前后缀长度数组~   e.g.  abcabc ---->abcabcabc  最少增加3个
 *
 * 多求一位nextArr     可以看出之前4个复用  所以再添一位就好~
 *
 * 总结： 在KMP中nextArr数组基础上 多求一位终止位  将不是的补上即可
 */
public class N_02_KMP_ShortestHaveTwice {

	public static String answer(String str) {
		if (str == null || str.length() == 0) {
			return "";
		}
		char[] chas = str.toCharArray();
		if (chas.length == 1) {
			return str + str;
		}
		if (chas.length == 2) {
			return chas[0] == chas[1] ? (str + chas[0]) : (str + str);
		}
		int endNext = endNextLength(chas);
		return str + str.substring(endNext);
	}

	public static int endNextLength(char[] chas) {
		int[] next = new int[chas.length + 1];
		next[0] = -1;
		next[1] = 0;
		int pos = 2;
		int cn = 0;
		while (pos < next.length) {
			if (chas[pos - 1] == chas[cn]) {
				next[pos++] = ++cn;
			} else if (cn > 0) {
				cn = next[cn];
			} else {
				next[pos++] = 0;
			}
		}
		return next[next.length - 1];
	}

	public static void main(String[] args) {
		String test1 = "a";
		System.out.println(answer(test1));

		String test2 = "aa";
		System.out.println(answer(test2));

		String test3 = "ab";
		System.out.println(answer(test3));

		String test4 = "abcdabcd";
		System.out.println(answer(test4));

		String test5 = "abracadabra";
		System.out.println(answer(test5));

	}

}
