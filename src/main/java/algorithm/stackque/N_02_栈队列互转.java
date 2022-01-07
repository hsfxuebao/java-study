package algorithm.stackque;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author hsfxuebao
 * @date 2020/03/15
 */
public class N_02_栈队列互转 {


	/**
	 * stackPush负责所有数据入栈，
	 * stackPop负责数据出栈，如果我空，将stackPush中的所有数据倒入stackPop中
	 */
	public static class TwoStacks2Queue {

		private Stack<Integer> stackPush;
		private Stack<Integer> stackPop;

		public TwoStacks2Queue() {
			stackPop = new Stack<Integer>();
			stackPush = new Stack<Integer>();
		}

		public void push(int value) {
			stackPush.push(value);
		}

		public Integer poll() {

			if (stackPush.isEmpty() && stackPop.isEmpty()) {
				throw new RuntimeException("Queue is Empty");
			} else if (stackPop.isEmpty()) {
				while (!stackPush.isEmpty()) {
					stackPop.push(stackPush.pop());
				}
			}

			return stackPop.pop();
		}

		public Integer peek() {
			if (stackPush.isEmpty() && stackPop.isEmpty()) {
				throw new RuntimeException("Queue is Empty");
			} else if (stackPop.isEmpty()) {
				while (!stackPush.isEmpty()) {
					stackPop.push(stackPush.pop());
				}
			}

			return stackPop.peek();

		}

	}

	public static class TwoQueuesToStack {

		private Queue<Integer> queue;
		private Queue<Integer> help;

		public TwoQueuesToStack() {
			queue = new LinkedList<Integer>();
			help = new LinkedList<Integer>();
		}

		public void push(int value) {
			queue.add(value);
		}

		public Integer pop() {
			if (queue.isEmpty()) {
				throw new RuntimeException("stack 是 空的");
			}
			while (queue.size() != 1) {
				help.add(queue.poll());
			}
			swap();
			return queue.poll();
		}

		public Integer peek() {
			if (queue.isEmpty()) {
				throw new RuntimeException("stack 是 空的");
			}
			while (queue.size() != 1) {
				help.add(queue.poll());
			}
			Integer res = queue.poll();
			help.add(res);
			swap();
			return res;
		}

		private void swap() {
			Queue<Integer> temp = queue;
			queue = help;
			help = temp;
		}
	}

}
