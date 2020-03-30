package algorithm.array;

/**
 * @author haoshaofei
 * @date 2020/03/29
 * 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），每段绳子的长度记为 k[0],k[1]...k[m] 。请问 k[0]*k[1]*...*k[m] 可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 *
 * 示例 1：
 *
 * 输入: 2
 * 输出: 1
 * 解释: 2 = 1 + 1, 1 × 1 = 1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/jian-sheng-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L_面14_剪绳子 {

	/**
	 * 当 n \leq 3n≤3 时，按照贪心规则应直接保留原数字，但由于题目要求必须剪成 m>1m>1 段，因此必须剪出一段长度为 11 的绳子，即返回 n - 1n−1 。
	 * 当 n>3n>3 时，求 nn 除以 33 的 整数部分 aa 和 余数部分 bb （即 n = 3a + bn=3a+b ），并分为以下三种情况：
	 * 当 b = 0b=0 时，直接返回 3^a3
	 * a
	 *  ；
	 * 当 b = 1b=1 时，要将一个 1 + 31+3 转换为 2+22+2，因此返回 3^{a-1} \times 43
	 * a−1
	 *  ×4；
	 * 当 b = 2b=2 时，返回 3^a \times 23
	 * a
	 *  ×2。

	 * @param n
	 * @return
	 */
	//贪心策略
	public int cuttingRope(int n) {
		if(n <= 3){
			return n - 1;
		}

		int a = n / 3, b = n % 3;
		if (b == 0) {
			return (int) Math.pow(3, a);
		}
		if (b == 1) {

			return (int) Math.pow(3, a - 1) * 4;
		}
		return (int)Math.pow(3, a) * 2;
	}



}
