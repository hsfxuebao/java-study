package algorithm.hash;

import java.util.HashMap;
import java.util.Map;

/**
 * @author haoshaofei
 * @date 2020/03/31
 *
 * 在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。
 *
 * 示例:
 *
 * s = "abaccdeff"
 * 返回 "b"
 *
 * s = ""
 * 返回 " "
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/di-yi-ge-zhi-chu-xian-yi-ci-de-zi-fu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L_面50_第一个只出现一次的字符 {

	public static char firstUniqChar(String s) {

		Map<Character, Integer> map = new HashMap<>();
		for (char ch : s.toCharArray()) {
			if (map.containsKey(ch)) {

				map.put(ch, map.get(ch) + 1);
			} else {
				map.put(ch, 1);
			}
		}

		for (char ch : s.toCharArray()) {
			if (map.get(ch) == 1) {
				return ch;
			}
		}
		return ' ';
	}

	public static void main(String[] args) {

		String str = "abaccdeff";
		System.out.println(firstUniqChar(str));
	}
}
