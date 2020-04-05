package algorithm.hash;

import java.util.HashMap;
import java.util.Map;

/**
 * @author haoshaofei
 * @date 2020/03/31
 *
 * 请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zui-chang-bu-han-zhong-fu-zi-fu-de-zi-zi-fu-chuan-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L_面48_最长不含重复字符的子串 {

	public static int lengthOfLongestSubstring(String s) {

		char[] chars = s.toCharArray();
		Map<Character, Integer> map = new HashMap<>();
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < chars.length; i++) {
			if (map.containsKey(chars[i])) {
				Integer index = map.get(chars[i]);
				max = Math.max(max, i - index);
				map.put(chars[i], i);

			} else {
				map.put(chars[i], i);
			}
		}

		return max;
	}

	public static void main(String[] args) {
		String str = "abcabcbb";
		System.out.println(lengthOfLongestSubstring(str));
		String str1 = "bbbbb";
		System.out.println(lengthOfLongestSubstring(str1));

	}
}
