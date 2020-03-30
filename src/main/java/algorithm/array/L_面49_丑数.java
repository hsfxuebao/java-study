package algorithm.array;

/**
 * @author haoshaofei
 * @date 2020/03/29
 *
 * 我们把只包含因子 2、3 和 5 的数称作丑数（Ugly Number）。求按从小到大的顺序的第 n 个丑数。
 *
 *  
 *
 * 示例:
 *
 * 输入: n = 10
 * 输出: 12
 * 解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/chou-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L_面49_丑数 {

	public static int nthUglyNumber(int n) {

		if (n <= 0) {
			return 0;
		}

		int[] number = new int[n];
		number[0] = 1;
		int p2 = 0;
		int p3 = 0;
		int p5 = 0;
		int index = 1;
		for ( ; index < n; index++) {

			number[index] = Math.min(Math.min(number[p2]*2, number[p3] * 3), number[p5] * 5);
			if (number[index] == number[p2] * 2) {
				p2++;
			}
			if (number[index] == number[p3] * 3) {
				p3++;
			}
			if (number[index] == number[p5] * 5) {
				p5++;
			}

		}
		return number[n-1];
	}

	public static void main(String[] args) {

		int n = 10;
		System.out.println(nthUglyNumber(n));

	}
}
