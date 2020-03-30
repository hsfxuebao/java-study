package algorithm.dynamic;

/**
 * @author haoshaofei
 * @date 2020/03/29
 *
 * 三步问题。有个小孩正在上楼梯，楼梯有n阶台阶，小孩一次可以上1阶、2阶或3阶。实现一种方法，计算小孩有多少种上楼梯的方式。结果可能很大，你需要对结果模1000000007。
 *
 * 示例1:
 *
 *  输入：n = 3
 *  输出：4
 *  说明: 有四种走法
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/three-steps-problem-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L_面0801_三步问题 {

	public static int waysToStep(int n) {


		if (n <= 0) {
			return 0;
		}
		if (n == 1) {
			return 1;
		}
		if (n == 2) {
			return 2;
		}
		long[] count = new long[n+1];
		count[0] = 1;
		count[1] = 1;
		count[2] = 2;
		count[3] = 4;

		for (int i = 4; i <= n; i++) {
			count[i] = (long) ((count[i-1] + count[i - 2] + count[i - 3]) % 1000000007);

		}

		return (int) count[n];
	}

	public static void main(String[] args) {
		System.out.println(waysToStep(3));

	}

}
