package algorithm.array;

/**
 * @author hsfxuebao
 * @date 2020/03/28
 *
 * 面试题 10.01. 合并排序的数组
 * 给定两个排序后的数组 A 和 B，其中 A 的末端有足够的缓冲空间容纳 B。 编写一个方法，将 B 合并入 A 并排序。
 *
 * 初始化 A 和 B 的元素数量分别为 m 和 n。
 *
 * 示例:
 *
 * 输入:
 * A = [1,2,3,0,0,0], m = 3
 * B = [2,5,6],       n = 3
 *
 * 输出: [1,2,2,3,5,6]
 */
public class L_面1001_合并排序的数组 {

	public static void mergeArr(int[] a, int[] b, int m, int n) {

		int length = m + n;
		int i = m - 1;
		int j = n - 1;
		while (i >= 0 && j >= 0) {
			if (a[i] >= b[j]) {
				a[--length] = a[i--];

			} else {
				a[--length] = b[j--];

			}
		}

		if (i > 0) {
			a[--length] = a[i--];
		}
		if (j > 0) {
			a[--length] = b[j--];
		}
	}

	public static void main(String[] args) {
		int[] a = {1,2,3,0,0,0};
		int[] b = {2,5,6};
		mergeArr(a, b, 3, 3);
		System.out.println(a);
	}
}
