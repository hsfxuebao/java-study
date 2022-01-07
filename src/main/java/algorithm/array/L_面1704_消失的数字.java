package algorithm.array;

/**
 * @author hsfxuebao
 * @date 2020/03/28
 *
 * 数组nums包含从0到n的所有整数，但其中缺了一个。请编写代码找出那个缺失的整数。你有办法在O(n)时间内完成吗？
 *
 * 注意：本题相对书上原题稍作改动
 *
 * 示例 1：
 *
 * 输入：[3,0,1]
 * 输出：2
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/missing-number-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L_面1704_消失的数字 {

	//不缺元素的总和减去缺元素的总和
	public static Integer getNumber(int[] num) {

		int length = num.length;
		//不缺元素的总和
		int sum = 0;
		//实际的总和
		int res = 0;
		for (int i = 0; i < length; i++) {
			res += num[i];
			sum += i;
		}
		sum += length;
		sum -= res;
		return sum;
	}

	public static void main(String[] args) {
		int[] num = {3,0,1};
		System.out.println(getNumber(num));
	}
}
