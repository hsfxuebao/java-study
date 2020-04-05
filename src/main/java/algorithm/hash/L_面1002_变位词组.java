package algorithm.hash;

import java.security.acl.Group;
import java.util.*;

/**
 * @author haoshaofei
 * @date 2020/03/31
 *
 * 编写一种方法，对字符串数组进行排序，将所有变位词组合在一起。变位词是指字母相同，但排列不同的字符串。
 *
 * 注意：本题相对原题稍作修改
 *
 * 示例:
 *
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * 输出:
 * [
 *   ["ate","eat","tea"],
 *   ["nat","tan"],
 *   ["bat"]
 * ]
 * 说明：
 *
 * 所有输入均为小写字母。
 * 不考虑答案输出的顺序。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/group-anagrams-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L_面1002_变位词组 {

	public static List<List<String>> groupAnagrams(String[] strs) {

		Map<String, List<String>> map = new HashMap<>();
		for (String str : strs) {
			String temp = sort(str);
			map.computeIfAbsent(temp, x -> new ArrayList<>()).add(str);
		}
		List<List<String>> resultList = new ArrayList<>();
		for (Map.Entry<String, List<String>> entry : map.entrySet()) {
			resultList.add(entry.getValue());
		}
		return resultList;
	}

	public static String sort(String str) {

		char[] chars = str.toCharArray();
		Arrays.sort(chars);

		StringBuilder builder = new StringBuilder();
		for (char ch : chars) {
			builder.append(ch);
		}
		return builder.toString();
	}

	public static void main(String[] args) {

		String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
		System.out.println(groupAnagrams(strs));

	}

}
