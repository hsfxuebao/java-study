package algorithm.string;

import java.util.Objects;

/**
 * @author haoshaofei
 * @date 2020/03/29
 *
 * 字符串轮转。给定两个字符串s1和s2，请编写代码检查s2是否为s1旋转而成（比如，waterbottle是erbottlewat旋转后的字符串）。
 *
 * 示例1:
 *
 *  输入：s1 = "waterbottle", s2 = "erbottlewat"
 *  输出：True
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/string-rotation-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L_面0109_字符串轮转 {


	public static boolean isFlipedString(String str1, String str2) {

		if (str1.length() != str2.length()) {
			return false;
		}
		if (Objects.equals(str1, str2)) {
			return true;
		}

		str1 += str1;
		return str1.contains(str2);

	}

	public static void main(String[] args) {
		String str1 = "abcd";
		String str2 = "dabc";
		System.out.println(isFlipedString(str1, str2));
	}



}
