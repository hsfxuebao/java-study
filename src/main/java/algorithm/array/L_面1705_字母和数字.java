package algorithm.array;

import algorithm.util.PrintUtils;
import com.google.common.collect.Maps;
import sun.security.util.Length;

import java.util.Map;

/**
 * @author hsfxuebao
 * @date 2020/03/29
 *
 * 给定一个放有字符和数字的数组，找到最长的子数组，且包含的字符和数字的个数相同。
 *
 * 返回该子数组，若存在多个最长子数组，返回左端点最小的。若不存在这样的数组，返回一个空数组。
 *
 * 示例 1:
 *
 * 输入: ["A","1","B","C","D","2","3","4","E","5","F","G","6","7","H","I","J","K","L","M"]
 *
 * 输出: ["A","1","B","C","D","2","3","4","E","5","F","G","6","7"]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-longest-subarray-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L_面1705_字母和数字 {

	/**
	 * 实质就是和为0的最长子数组，字母加1，数字减1
	 * @param array
	 * @return
	 */
	public static String[] findLongestSubarray(String[] array) {

		if (array == null || array.length == 0) {
			return new String[0];
		}
		int arrLength = array.length;
		//最大长度
		int len = Integer.MIN_VALUE;
		//最大长度对应的开始位置
		int start = 0;
		Map<Integer, Integer> map = Maps.newHashMap();
		int sum = 0;
		//重要
		map.put(0, -1);

		for (int i = 0; i < arrLength; i++) {
			char[] chars = array[i].toCharArray();
			for (char ch : chars) {
				if (ch >= '0' && ch <= '9') {
					sum++;
				} else {
					sum--;
				}
				if (!map.containsKey(sum)) {
					map.put(sum, i);
				} else {
					start = map.get(sum);
					len = Math.max(i - start, len);
				}
			}
		}
		String[] res = new String[len];
		for (int i = 1; i <= len; i++) {
			res[i - 1] = array[i + start];
		}
		return res;

	}

	public static void main(String[] args) {
		String[] res = {"A","1","B","C","D","2","3","4","E","5","F","G","6","7","H","I","J","K","L","M"};
		findLongestSubarray(res);
		System.out.println();
	}
}
