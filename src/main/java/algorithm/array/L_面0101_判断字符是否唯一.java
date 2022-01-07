package algorithm.array;

import org.apache.commons.lang3.StringUtils;

/**
 * @author hsfxuebao
 * @date 2020/03/27
 * 实现一个算法，确定一个字符串 s 的所有字符是否全都不同。
 *
 * 示例 1：
 *
 * 输入: s = "leetcode"
 * 输出: false
 */
public class L_面0101_判断字符是否唯一 {


	/**
	 * 思路1，数组实现
	 * 思路2：当最后一次索引的位置不是当前的索引i时表示有重复
	 *
	 * @return
	 */
	public static boolean isUnique(String str) {

		if (StringUtils.isBlank(str)) {
			return true;
		}

		char[] chars = str.toCharArray();
		for (int i = 0; i < chars.length; i++) {
			if (str.lastIndexOf(chars[i]) != i) {
				return false;
			}
		}
		return true;
	}


	public static void main(String[] args) {
		String str = "leetcode";
		System.out.println(isUnique(str));
	}

}
