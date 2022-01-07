package algorithm.array;

/**
 * @author hsfxuebao
 * @date 2020/03/29
 *
 * 有些数的素因子只有 3，5，7，请设计一个算法找出第 k 个数。注意，不是必须有这些素因子，
 * 而是必须不包含其他的素因子。例如，前几个数按顺序应该是 1，3，5，7，9，15，21。
 *
 * 示例 1:
 *
 * 输入: k = 5
 *
 * 输出: 9
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/get-kth-magic-number-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L_面1709_第K个数 {

	public static int getKthMagicNumber(int k) {

		if (k <= 0) {
			return 0;
		}
		int[] number = new int[k];
		number[0] = 1;

		int p3 = 0;
		int p5 = 0;
		int p7 = 0;
		for (int i = 1; i < k; i++){
			number[i] = Math.min(Math.min(number[p3]*3, number[p5]*5), number[p7]*7);

			if (number[i] == number[p3] * 3) {
				p3++;
			}
			if (number[i] == number[p5] * 5) {
				p5++;
			}
			if (number[i] == number[p7] * 7) {
				p7++;
			}
		}
		return number[k-1];
	}

	public static void main(String[] args) {
		int k = 6;
		System.out.println(getKthMagicNumber(k));
	}
}
