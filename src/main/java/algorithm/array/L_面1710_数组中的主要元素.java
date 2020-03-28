package algorithm.array;

import com.google.common.collect.Maps;

import java.util.Map;

/**
 * @author haoshaofei
 * @date 2020/03/28
 *
 * 如果数组中多一半的数都是同一个，则称之为主要元素。给定一个整数数组，找到它的主要元素。若没有，返回-1。
 *
 * 示例 1：
 *
 * 输入：[1,2,5,9,5,9,5,5,5]
 * 输出：5
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-majority-element-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L_面1710_数组中的主要元素 {

	public static Integer getMaxNumber(int[] num) {

		int length = num.length;
		int mid = length / 2 + 1;
		Map<Integer, Integer> numberSize = Maps.newHashMap();
		for (int i = 0; i < length; i++) {
			if (numberSize.containsKey(num[i])) {
				Integer size = numberSize.get(num[i]) + 1;
				if (size >= mid) {
					return num[i];
				}
				numberSize.put(num[i], size);
			} else {
				numberSize.put(num[i],1);
			}

		}
		return -1;
	}

	public static void main(String[] args) {
		int[] num = {1,2,5,9,5,9,5,5,5};
		System.out.println(getMaxNumber(num));
	}
}

