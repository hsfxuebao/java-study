package algorithm.hash;

import org.apache.commons.lang3.StringUtils;

import java.util.HashSet;
import java.util.Set;

/**
 * @author haoshaofei
 * @date 2020/03/31
 *
 * 给定一个字符串，编写一个函数判定其是否为某个回文串的排列之一。
 *
 * 回文串是指正反两个方向都一样的单词或短语。排列是指字母的重新排列。
 *
 * 回文串不一定是字典当中的单词。
 *
 *  
 *
 * 示例1：
 *
 * 输入："tactcoa"
 * 输出：true（排列有"tacocat"、"atcocta"，等等）
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindrome-permutation-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L_面0104_回文排列 {

	public static boolean canPermutePalindrome(String str) {
		if (StringUtils.isBlank(str)) {
			return false;
		}

		Set<Character> set = new HashSet<>();
		char[] chars = str.toCharArray();
		for (char ch : chars) {
			if (!set.add(ch)) {
				set.remove(ch);
			}
		}
		return set.size() > 1 ? false : true;

	}

	public static void main(String[] args) {

		String str = "tactcoa";
		System.out.println(canPermutePalindrome(str));

	}
}
