package algorithm.string;

/**
 * @author haoshaofei
 * @date 2020/03/29
 * 字符串压缩。利用字符重复出现的次数，编写一种方法，实现基本的字符串压缩功能。比如，字符串aabcccccaaa会变为a2b1c5a3。若“压缩”后的字符串没有变短，则返回原先的字符串。你可以假设字符串中只包含大小写英文字母（a至z）。
 *
 * 示例1:
 *
 *  输入："aabcccccaaa"
 *  输出："a2b1c5a3"
 * 示例2:
 *
 *  输入："abbccd"
 *  输出："abbccd"
 *  解释："abbccd"压缩后为"a1b2c2d1"，比原字符串长度更长。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/compress-string-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L_面0106_字符串压缩 {

	public static String compressString(String str) {

		int length = str.length();
		int j = 0;
		int i = 0;
		StringBuilder stringBuilder = new StringBuilder();
		while (i < length) {

			j = i;
			while (j < length && str.charAt(i) == str.charAt(j)) {
				j++;
			}
			stringBuilder.append(str.charAt(i)).append(j - i);
			i = j;
		}

		if (length <= stringBuilder.length()) {
			return str;
		} else {
			return stringBuilder.toString();
		}
	}

	public static void main(String[] args) {

		String str = "aabcccccaaa";
		System.out.println(compressString(str));
	}
}
