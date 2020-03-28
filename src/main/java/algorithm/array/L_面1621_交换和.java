package algorithm.array;

import algorithm.util.PrintUtils;
import com.google.common.collect.Sets;
import sun.jvm.hotspot.ui.action.FindAction;

import java.util.Set;

/**
 * @author haoshaofei
 * @date 2020/03/28
 *
 * 给定两个整数数组，请交换一对数值（每个数组中取一个数值），使得两个数组所有元素的和相等。
 *
 * 返回一个数组，第一个元素是第一个数组中要交换的元素，第二个元素是第二个数组中要交换的元素。若有多个答案，返回任意一个均可。若无满足条件的数值，返回空数组。
 *
 * 示例:
 *
 * 输入: array1 = [4, 1, 2, 1, 1, 2], array2 = [3, 6, 3, 3]
 * 输出: [1, 3]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sum-swap-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L_面1621_交换和 {

	public static int[] findSwapValues(int[] array1, int[] array2) {


		int length1 = array1.length;
		int lenth2 = array2.length;
		Set<Integer> array1Set = Sets.newHashSet();
		Set<Integer> array2Set = Sets.newHashSet();

		int sum1 = 0;
		int sum2 = 0;
		for (int i = 0; i < length1; i++) {
			sum1 += array1[i];
			array1Set.add(array1[i]);
		}
		for (int i = 0; i < lenth2; i++) {
			sum2 += array2[i];
			array2Set.add(array2[i]);
		}

		int maxDiff = sum1 - sum2;
		if (maxDiff % 2 != 0) {
			return new int[0];
		}
		int diff = maxDiff / 2;

		if (diff > 0) {
			for (int i = 0; i < length1; i++) {
				if (array2Set.contains(array1[i] - diff)) {
					return new int[]{array1[i], array1[i] - diff};
				}
			}
		} else {
			for (int i = 0; i < lenth2; i++) {
				if (array1Set.contains(array2[i] + diff)) {
					return new int[]{array2[i] + diff, array2[i]};
				}
			}
		}
		return new int[0];
	}

	public static void main(String[] args) {
		int[] num1 = {4, 1, 2, 1, 1, 2};
		int[] num2 = {3, 6, 3, 3};
		PrintUtils.printArray(findSwapValues(num1, num2));

	}
}
