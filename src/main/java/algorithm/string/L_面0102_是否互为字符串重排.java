package algorithm.string;

/**
 * @author hsfxuebao
 * @date 2020/03/29
 *
 * 给定两个字符串 s1 和 s2，请编写一个程序，确定其中一个字符串的字符重新排列后，能否变成另一个字符串。
 *
 * 示例 1：
 *
 * 输入: s1 = "abc", s2 = "bca"
 * 输出: true
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/check-permutation-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L_面0102_是否互为字符串重排 {

	//异或运算
	public static boolean checkPermutation(String s1, String s2) {
		if (s1 == null || s2 == null) {
			return false;
		}
		int length = s1.length();
		if (length != s2.length()) {
			return false;
		}
		int result = 0;
		char[] s1Char = s1.toCharArray();
		char[] s2Char = s2.toCharArray();
		for (int i = 0; i < s1Char.length; i++) {
			result = result ^ s1Char[i] ^ s2Char[i];
		}
		return result == 0;
	}

	public static void main(String[] args) {
		String str1 = "abc";
		String str2 = "bcd";
		System.out.println(checkPermutation(str1, str2));
	}

}
