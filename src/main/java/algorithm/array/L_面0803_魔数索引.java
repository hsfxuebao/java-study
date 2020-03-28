package algorithm.array;

import java.util.Objects;

/**
 * @author haoshaofei
 * @date 2020/03/28
 *
 * 魔术索引。 在数组A[0...n-1]中，有所谓的魔术索引，满足条件A[i] = i。给定一个有序整数数组，编写一种方法找出魔术索引，若有的话，在数组A中找出一个魔术索引，如果没有，则返回-1。若有多个魔术索引，返回索引值最小的一个。
 *
 * 示例1:
 *
 *  输入：nums = [0, 2, 3, 4, 5]
 *  输出：0
 *  说明: 0下标的元素为0
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/magic-index-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L_面0803_魔数索引 {


	public static Integer getIndex(int[] num) {

		if (Objects.isNull(num)) {
			return -1;
		}
		int length = num.length;
		int left = 0;
		int right = length;
		int mid = 0;
		int index = Integer.MAX_VALUE;

		while (left <= right) {

			mid = (left + right)/2;
			if (num[mid] != mid) {
				right = mid -1;

			} else {
				index = Math.min(index, mid);
				right = mid - 1;
			}

		}
		return index == Integer.MAX_VALUE ? -1 : index;
	}

	public static void main(String[] args) {
		int[] num = {0,1,1,4,5,6};
		System.out.println(getIndex(num));
	}
}
