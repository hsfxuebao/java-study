package common.stackque;

/**
 * @author haoshaofei
 * @date 2020/03/15
 *
 * 数组实现固定大小的栈和队列
 */
public class N_01_数组实现栈和队列 {


	public static class ArrayStack {

		public Integer[] arr;
		public Integer size;

		public ArrayStack(int initSize) {
			if (initSize < 0) {
				throw new IllegalArgumentException("initSize不能小于0");
			}
			this.arr = new Integer[initSize];
			this.size = 0;
		}

		public Integer peek() {
			if (size == 0) {
				return null;
			}
			return arr[size - 1];
		}

		public void push(int value) {

			if (size == arr.length - 1) {
				throw new ArrayIndexOutOfBoundsException("超过数组长度");
			}
			arr[size++] = value;
		}

		public Integer pop() {
			if (size == 0) {
				throw new ArrayIndexOutOfBoundsException("数组中没有元素");
			}

			return arr[--size];
		}
	}

	public static class ArrayQueue {

		private Integer arr[];
		private Integer first;
		private Integer last;
		private Integer size;

		public ArrayQueue(int initSize) {
			if (initSize < 0) {
				throw new IllegalArgumentException("初始化不能小于0");
			}
			arr = new Integer[initSize];
			first = 0;
			last = 0;
			size = 0;
		}


		public Integer peek() {
			if (size == 0) {
				throw new ArrayIndexOutOfBoundsException("里面的元素为空");
			}
			return arr[first];
		}

		public void push(int value) {
			if (size == arr.length) {
				throw new ArrayIndexOutOfBoundsException("数组满了");
			}
			size++;
			arr[last] = value;
			last = last == arr.length - 1 ? 0 : last + 1;

		}

		public Integer pop() {
			if (size == 0) {
				throw new ArrayIndexOutOfBoundsException("数组是空的");
			}
			size--;
			int index = first;
			first = first == arr.length -1 ? 0 :first + 1;
			return arr[index];
		}

		public static void main(String[] args) {

		}
	}



}
