package algorithm.array;

/**
 * @author hsfxuebao
 * @date 2020/03/27
 * 给定两个字符串 s1 和 s2，请编写一个程序，确定其中一个字符串的字符重新排列后，能否变成另一个字符串。
 *
 * 示例 1：
 *
 * 输入: s1 = "abc", s2 = "bca"
 * 输出: true
 *
 *
 */
public class L_面0102_互为字符重排 {

	public static boolean checkPermutation(String s1, String s2) {
		if (s1 == null || s2 == null) {
			return false;
		}
		int len1 = s1.length();
		int len2 = s2.length();

		if (len1 != len2) {
			return false;
		}

		int[] count = new int[26];
		for (int i = 0; i < len1; i++) {
			count[s1.charAt(i) - 'a']++;
		}

		for (int i = 0; i < len2; i++) {
			int index = s2.charAt(i) - 'a';
			count[index]--;
			if (count[index] < 0) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		String s1 = "abc";
		String s2 = "ace";
		System.out.println(checkPermutation(s1, s2));
	}

}
