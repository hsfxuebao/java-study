package stackque;

/**
 * @author haoshaofei
 * @date 2020/03/15
 */

import com.google.common.base.Objects;

import java.util.Stack;

/**
 * 实现一个特殊的栈，在实现栈的基本功能的基础上，再实现返
 * 回栈中最小元素的操作。
 * 【要求】 1.pop、push、getMin操作的时间复杂度都是O(1)。 2.设计的栈类型可以使用现成的栈结构。
 */
public class N_03_栈中最小元素 {


	/**
	 * 最小栈和数据栈的数量是一样的
	 */
	public static class MinStack1 {

		private Stack<Integer> stackData;
		private Stack<Integer> stackMin;

		public MinStack1() {
			stackData = new Stack<Integer>();
			stackMin = new Stack<Integer>();
		}

		public void push(int value) {
			if (stackMin.isEmpty()) {
				stackMin.push(value);
			} else if (value < this.getMin()) {
				stackMin.push(value);
			} else {
				int number = stackMin.peek();
				stackMin.push(number);
			}

			stackData.push(value);
		}

		public Integer pop() {
			if (stackData.isEmpty()) {
				throw new RuntimeException("栈中元素是空的");
			}
			stackMin.pop();
			return stackData.pop();
		}

		public Integer getMin() {
			if (stackMin.isEmpty()) {
				throw new RuntimeException("栈中的元素是空的");
			}
			return stackMin.peek();
		}

	}


	public static class MinStack2 {

		private Stack<Integer> stackData;
		private Stack<Integer> stackMin;

		public MinStack2() {
			stackData = new Stack<Integer>();
			stackMin = new Stack<Integer>();
		}

		public void push(int value) {

			if (stackMin.isEmpty()) {
				stackMin.push(value);
			} else if (value <= getMin()) {
				stackMin.push(value);
			}
			stackData.push(value);
		}

		public Integer pop() {
			if (stackData.isEmpty()) {
				throw new RuntimeException("stack is empty");
			}

			Integer number = stackData.pop();
			if (Objects.equal(number, getMin())) {
				stackMin.pop();
			}

			return number;
		}

		public Integer getMin() {
			if (stackMin.isEmpty()) {
				throw new RuntimeException("stack is empty");
			}
			return stackMin.peek();
		}

	}

}
