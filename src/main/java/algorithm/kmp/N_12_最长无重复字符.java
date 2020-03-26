package algorithm.kmp;

/**
 * @author haoshaofei
 * @date 2020/03/26
 */

import java.util.HashMap;
import java.util.Map;

/**
 * 找到字符串的最长无重复字符子串
 * 【题目】 给定一个字符串str，返回str的最长无重复字符子串的长度。 【举例】
 * str="abcd"，返回4 str="aabcb"，最长无重复字符子串为"abc"，返回3。 【要求】 如果str的长度为N，请实现时间复杂度为O(N)的方法。
 *
 */
public class N_12_最长无重复字符 {

	/**
	 * 用数组实现
	 * @param str
	 * @return
	 */
	public static int maxUnique(String str) {
		if (str == null || str.equals("")) {
			return 0;
		}
		char[] chas = str.toCharArray();
		int[] map = new int[256];
		for (int i = 0; i < 256; i++) {
			map[i] = -1;
		}
		int len = 0;
		//不重复子串的开始位置
		int pre = -1;
		int cur = 0;
		for (int i = 0; i != chas.length; i++) {
			pre = Math.max(pre, map[chas[i]]);
			cur = i - pre;
			len = Math.max(len, cur);
			map[chas[i]] = i;
		}
		return len;
	}

	/**
	 * 定义一个 map 数据结构存储 (k, v)，其中 key 值为字符，value 值为字符位置 +1，加 1 表示从字符位置后一个才开始不重复
	 *    我们定义不重复子串的开始位置为 start，结束位置为 end
	 *    随着 end 不断遍历向后，会遇到与 [start, end] 区间内字符相同的情况，此时将字符作为 key 值，获取其 value 值，并更新 start，此时 [start, end] 区间内不存在重复字符
	 *    无论是否更新 start，都会更新其 map 数据结构和结果 ans。
	 */
	public int lengthOfLongestSubstring(String s) {
		int n=s.length(), ans = 0;
		Map<Character,Integer> map = new HashMap<>();
		for(int end=0,start=0;end<n;end++) {
			char alpha = s.charAt(end);
			if(map.containsKey(alpha)) {
				start = Math.max(map.get(alpha), start);  //滑动窗口--最新一次开始的坐标
			}
			ans = Math.max(ans, end-start+1); //最长不重复子串的长度
			map.put(s.charAt(end), end+1);	//map中存的是每个字母和对应的下标+1
		}
		return ans;
	}

	// for test
	public static String getRandomString(int len) {
		char[] str = new char[len];
		int base = 'a';
		int range = 'z' - 'a' + 1;
		for (int i = 0; i != len; i++) {
			str[i] = (char) ((int) (Math.random() * range) + base);
		}
		return String.valueOf(str);
	}

	// for test
	public static String maxUniqueString(String str) {
		if (str == null || str.equals("")) {
			return str;
		}
		char[] chas = str.toCharArray();
		int[] map = new int[256];
		for (int i = 0; i < 256; i++) {
			map[i] = -1;
		}
		int len = -1;
		int pre = -1;
		int cur = 0;
		int end = -1;
		for (int i = 0; i != chas.length; i++) {
			pre = Math.max(pre, map[chas[i]]);
			cur = i - pre;
			if (cur > len) {
				len = cur;
				end = i;
			}
			map[chas[i]] = i;
		}
		return str.substring(end - len + 1, end + 1);
	}

	public static void main(String[] args) {
		String str = getRandomString(20);
		System.out.println(str);
		System.out.println(maxUnique(str));
		System.out.println(maxUniqueString(str));
	}

}
