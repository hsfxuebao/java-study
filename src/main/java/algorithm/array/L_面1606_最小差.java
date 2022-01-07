package algorithm.array;

import java.util.Arrays;

/**
 * @author hsfxuebao
 * @date 2020/03/28
 *
 * 给定两个整数数组a和b，计算具有最小差绝对值的一对数值（每个数组中取一个值），并返回该对数值的差
 *
 * 示例：
 *
 * 输入：{1, 3, 15, 11, 2}, {23, 127, 235, 19, 8}
 * 输出： 3，即数值对(11, 8)
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/smallest-difference-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L_面1606_最小差 {

	public static Integer getMinDiff(int[] a, int[] b) {

		Arrays.sort(a);
		Arrays.sort(b);
		int i = 0;
		int j = 0;
		int min = Integer.MAX_VALUE;
		while (i < a.length && j < b.length) {
			min = Math.min((Math.abs(a[i] - b[j])), min);
			if (a[i] <= b[j]) {
				i++;
			} else {
				j++;
			}
		}
		return min;
	}

	public static void main(String[] args) {
		int[] num = {1, 3, 15, 11, 2};
		int[] num2 = {23, 127, 235, 19, 8};
		System.out.println(getMinDiff(num, num2));
	}
}
