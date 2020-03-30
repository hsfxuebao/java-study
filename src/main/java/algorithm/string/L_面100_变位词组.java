package algorithm.string;

import java.util.*;

/**
 * @author haoshaofei
 * @date 2020/03/29
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
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/group-anagrams-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L_面100_变位词组 {

	/**
	 * 循环传入的数组，将数组中的每个元素进行字符串排序
	 * 将排序后的字符串作为map的key，原始字符串放入list作为map的value
	 * 每次排序后判断该字符串是否在map中存在，如果存在将map的list取出来添加str，如果不存在，新建一个list添加str后放入map
	 *
	 */
	public List<List<String>> groupAnagrams(String[] strs) {

		if (strs == null || strs.length == 0) {
			return null;
		}

		Map<String, List<String>> map = new HashMap<>();

		for (String str : strs) {
			String sortStr = this.sort(str);
			if (map.containsKey(sortStr)) {
				map.get(sortStr).add(str);
				continue;
			}

			ArrayList<String> list = new ArrayList<>();
			list.add(str);
			map.put(sortStr, list);
		}

		List<List<String>> list = new ArrayList<>();
		map.forEach((key, value) -> {
			list.add(value);
		});
		return list;
	}

	// 字符串排序
	private String sort(String str) {
		if (str == null && str.length()==0) {
			return "";
		}

		char[] chars = str.toCharArray();
		Arrays.sort(chars);

		StringBuffer sb = new StringBuffer();
		for (char aChar : chars) {
			sb.append(aChar);
		}
		return sb.toString();

	}



}
