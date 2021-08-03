package designpattern.interpreter;

import java.util.HashMap;
import java.util.Stack;

public class Calculator {

	// 定义表达式
	private Expression expression;

	// 构造器  并解析
	public Calculator(String expStr) { // expStr = a+b
		// 安排运算先后顺序
		Stack<Expression> stack = new Stack<>();
		// 表达式拆分成字符数组
		char[] charArray = expStr.toCharArray();// [a, +, b]

		Expression left = null;
		Expression right = null;
		// 遍历我们的字符数组  [a, +, b]
		// 针对不同情况 处理
		for (int i = 0; i < charArray.length; i++) {
			switch (charArray[i]) {
			case '+': //
				left = stack.pop();// 从stack  取出left => "a"
				right = new VarExpression(String.valueOf(charArray[++i]));// 取出右边表达式 "b"
				stack.push(new AddExpression(left, right));// 然后根据得到left 和right 构建AddExpression 加入stack
				break;
			case '-': // 
				left = stack.pop();
				right = new VarExpression(String.valueOf(charArray[++i]));
				stack.push(new SubExpression(left, right));
				break;
			default: 
				// 如果是一个  var 就创建给VarExpression 对象  并push 到stack
				stack.push(new VarExpression(String.valueOf(charArray[i])));
				break;
			}
		}
		// 当遍历整个 charArray 数组后 stack 就得到最后 Expression
		this.expression = stack.pop();
	}

	public int run(HashMap<String, Integer> var) {
		// 最后将表达式 a+b 和 var = {a=10,b=20}
		// 然后传递给 expression的interpreter进行解释执行
		return this.expression.interpreter(var);
	}
}