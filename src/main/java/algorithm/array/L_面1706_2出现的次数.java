package algorithm.array;

/**
 * @author haoshaofei
 * @date 2020/03/29
 *
 * 编写一个方法，计算从 0 到 n (含 n) 中数字 2 出现的次数。
 *
 * 示例:
 *
 * 输入: 25
 * 输出: 9
 * 解释: (2, 12, 20, 21, 22, 23, 24, 25)(注意 22 应该算作两次)
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-2s-in-range-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L_面1706_2出现的次数 {


	public  static int countDigitOne(int n, int x) {

		if (n <= 0 || x < 1 || x > 9) {
			return 0;
		}
		int high = n;
		int low = 0;
		int cur = 0;
		int temp = 0;
		int index = 1;
		int total = 0;

		while (high != 0) {
			high = n / (int) Math.pow(10, index);
			temp = n % (int) Math.pow(10, index);
			cur = temp / (int) Math.pow(10, (index - 1));
			low = temp % (int) Math.pow(10, (index - 1));

			if (cur > x) {
				total += (high + 1) * Math.pow(10, (index - 1));
			} else if (cur == x) {
				total += high * Math.pow(10, (index - 1)) + (low + 1);
			} else {
				total += high * Math.pow(10, (index - 1));
			}
			index++;
		}
		return total;
	}

	public static void main(String[] args) {
		System.out.println(countDigitOne(25, 2));

	}

}
