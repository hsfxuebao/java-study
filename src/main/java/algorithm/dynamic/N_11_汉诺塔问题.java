package algorithm.dynamic;

/**
 * @author haoshaofei
 * @date 2020/03/26
 */
/**
 *
 * 给定一个数n，表示n层汉诺塔问题，请打印最优步数的所有过 程
 * 进阶:给定一个汉诺塔的状况用数组arr表示(arr中只有1，2， 3三种数字)，请返回这是汉诺塔最优步数的第几步?
 * 举例:
 * arr = {3,2,1} arr长度为3，表示这是一个3层汉诺塔问题;
 * arr[0] == 3表示上面的汉诺塔在右边;
 * arr[1] == 2表示中间的汉诺塔在中间;
 * arr[2] == 1表示底下的汉诺塔在左间; 这种状况是3层汉诺塔最优步数的第2步，所以返回2。
 *
 */
public class N_11_汉诺塔问题 {

	public static void hanoi(int n) {
		if (n > 0) {
			func(n, "left", "mid", "right");
		}
	}

	public static void func(int n, String from, String mid, String to) {
		if (n == 1) {
			System.out.println("move from " + from + " to " + to);
		} else {
			func(n - 1, from, to, mid);
			func(1, from, mid, to);
			func(n - 1, mid, from, to);
		}
	}

	public static int step1(int[] arr) {
		if (arr == null || arr.length == 0) {
			return -1;
		}
		return process(arr, arr.length - 1, 1, 2, 3);
	}

	public static int process(int[] arr, int i, int from, int mid, int to) {
		if (i == -1) {
			return 0;
		}
		if (arr[i] != from && arr[i] != to) {
			return -1;
		}
		if (arr[i] == from) {
			return process(arr, i - 1, from, to, mid);
		} else {
			int rest = process(arr, i - 1, mid, from, to);
			if (rest == -1) {
				return -1;
			}
			return (1 << i) + rest;
		}
	}

	public static int step2(int[] arr) {
		if (arr == null || arr.length == 0) {
			return -1;
		}
		int from = 1;
		int mid = 2;
		int to = 3;
		int i = arr.length - 1;
		int res = 0;
		int tmp = 0;
		while (i >= 0) {
			if (arr[i] != from && arr[i] != to) {
				return -1;
			}
			if (arr[i] == to) {
				res += 1 << i;
				tmp = from;
				from = mid;
			} else {
				tmp = to;
				to = mid;
			}
			mid = tmp;
			i--;
		}
		return res;
	}

	public static void main(String[] args) {
		int n = 4;
		hanoi(n);

		int[] arr = { 3, 3, 2, 1 };
		System.out.println(step1(arr));
		System.out.println(step2(arr));

	}

}
