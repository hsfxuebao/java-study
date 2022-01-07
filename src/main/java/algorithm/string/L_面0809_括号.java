package algorithm.string;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hsfxuebao
 * @date 2020/03/29
 *
 * 括号。设计一种算法，打印n对括号的所有合法的（例如，开闭一一对应）组合。
 *
 * 说明：解集不能包含重复的子集。
 *
 * 例如，给出 n = 3，生成结果为：
 *
 * [
 *   "((()))",
 *   "(()())",
 *   "(())()",
 *   "()(())",
 *   "()()()"
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/bracket-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L_面0809_括号 {


	public static List<String> generateParenthesis(int n) {
		List<String> result = new ArrayList<>();
		if (n <= 0) {
			return result;
		}
		generate(n, result, "", 0, 0);
		return result;
	}

	private static  void generate(int n, List<String> result, String item, int left, int right) {

		if ((left + right) == 2 * n) {
			result.add(item);
		}

		if (left < n) {
			generate(n, result, item + "(", left + 1, right);
		}

		if ((right < n) && (right < left)) {
			generate(n, result, item + ")", left, right + 1);
		}
	}


	public static void main(String[] args) {
		System.out.println(generateParenthesis(3));
	}

}
