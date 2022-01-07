package algorithm.array;

import java.util.Objects;

/**
 * @author hsfxuebao
 * @date 2020/03/29
 *
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。  
 *
 * 示例 1：
 *
 * 输入：[3,4,5,1,2]
 * 输出：1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L_面11_旋转数组中的最小值 {

	public static int minArray(int[] numbers) {

		if (Objects.isNull(numbers)) {
			return -1;
		}

		int length = numbers.length;
		if (length == 1) {
			return numbers[0];
		}

		int left = 0;
		int right = length - 1;
		int mid = 0;

		while (left <= right) {
			mid = left + ((right - left) >> 1);
			if (numbers[mid] < numbers[right]) {
				right = mid;
			} else if (numbers[mid] > numbers[right]) {
				left = mid + 1;
			} else {
				right--;
			}
		}

		return numbers[left];
	}

	public static void main(String[] args) {
		int[] numbers = {3,4,5,1,2};
		System.out.println(minArray(numbers));
	}

}
