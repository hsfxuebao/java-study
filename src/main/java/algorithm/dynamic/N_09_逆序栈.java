package algorithm.dynamic;

import java.util.Stack;

/**
 * @author hsfxuebao
 * @date 2020/03/17
 *
 * 给你一个栈，请你逆序这个栈，不能申请额外的数据结构，只能
 *  使用递归函数。如何实现?
 *
 */
public class N_09_逆序栈 {

	/**
	 * 1、首先，取出栈顶元素
	 * 2、然后求剩下元素的最后一个元素
	 * 3、最后将栈顶元素放回
	 * 其中第二步为递归调用，递归终止条件是栈中只有一个元素，此时直接返回栈顶即可得到最后一个元素
	 */
	public static int getAndRemoveLastElement(Stack<Integer> stack){
		int res = stack.pop();
		if(stack.isEmpty()){
			return res;
		}
		int last = getAndRemoveLastElement(stack);
		stack.add(res);
		return last;
	}
	/**
	 * 1、取出并删除栈低元素
	 * 2、翻转剩下的元素
	 * 3、再将之前的栈低元素压回栈顶
	 * 其中第二步为递归调用，递归终止条件是栈为空
	 */
	public static void reverse(Stack<Integer> stack){
		if(stack.isEmpty()){

			return;
		}
		int i = getAndRemoveLastElement(stack);
		reverse(stack);
		stack.add(i);
	}

	//测试代码
	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<Integer>();
		stack.add(3);
		stack.add(1);
		stack.add(2);
		reverse(stack);
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
	}

}
