package leetcode;

import java.util.Stack;

/**
 * @author haoshaofei
 * @date 2020/03/13
 *
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 *
 * 示例 1:
 * 输入: "()"
 * 输出: true
 * 示例 2:
 * 输入: "()[]{}"
 * 输出: true
 * 示例 3:
 * 输入: "(]"
 * 输出: false
 * 示例 4:
 * 输入: "([)]"
 * 输出: false
 * 示例 5:
 * 输入: "{[]}"
 * 输出: true
 */
public class X_020_有效的括号 {


	public boolean isValid(String s) {
		if (s == null || s.length() == 0) {
			return true;
		}

		Stack<Character> stack = new Stack();

		for (int i = 0;i < s.length();i++) {
			if (isLeft(s.charAt(i))) {
				stack.push(s.charAt(i));
			} else {
				if (!isValid(s.charAt(i), stack)) {
					return false;
				}
				stack.pop();
			}
		}

		return stack.size() == 0;
	}

	private boolean isValid(char c, Stack<Character> stack) {
		if (stack.isEmpty()) {
			return false;
		}

		return  (stack.peek() == '(' && c == ')')
				|| (stack.peek() == '[' && c == ']')
				|| (stack.peek() == '{' && c == '}');
	}

	public boolean isLeft(Character c) {
		return c == '(' || c == '[' || c == '{';
	}

	public static void main(String[] args) {
		X_020_有效的括号 s = new X_020_有效的括号();
		s.isValid("()");
	}
}