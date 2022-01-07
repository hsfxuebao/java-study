package algorithm.string;

/**
 * @author hsfxuebao
 * @date 2020/03/29
 *
 * 二进制数转字符串。给定一个介于0和1之间的实数（如0.72），类型为double，打印它的二进制表达式。如果该数字不在0和1之间，或者无法精确地用32位以内的二进制表示，则打印“ERROR”。
 *
 * 示例1:
 *
 *  输入：0.625
 *  输出："0.101"
 * 示例2:
 *
 *  输入：0.1
 *  输出："ERROR"
 *  提示：0.1无法被二进制准确表示
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/bianry-number-to-string-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L_面0502_二进制转字符串 {

	public String printBin(double num) {
		StringBuilder sb = new StringBuilder("0.");
		for (int i = 1; i < 31 && num > 0; i++) {
			if (num >= Math.pow(0.5, i)) {
				num -= Math.pow(0.5, i);
				sb.append(1);
			} else {

				sb.append(0);
			}
		}
		return num == 0 ? sb.toString() : "ERROR";
	}



}
