package newcoder.high.c06;

import java.util.HashSet;
import java.util.Stack;

/**
 *
 * 一个不含有负数的数组可以代表一圈环形山，每个位置的值代表山的高度。比如， {3,1,2,4,5}、{4,5,3,1,2}或{1,2,4,5,3}都代表同样结构的环形山。 山峰A和山峰B能够相互看见的条件为: 1.如果A和B是同一座山，认为不能相互看见。 2.如果A和B是不同的山，并且在环中相邻，认为可以相互看见。 3.如果A和B是不同的山，并且在环中不相邻，假设两座山高度的最小值为min。
 * 1)如果A通过顺时针方向到B的途中没有高度比min大的山峰，认为A和B可以相互 看见
 * 2)如果A通过逆时针方向到B的途中没有高度比min大的山峰，认为A和B可以相互 看见
 * 3)两个方向只要有一个能看见，就算A和B可以相互看见 给定一个不含有负数且没有重复值的数组 arr，请返回有多少对山峰能够相互看见。
 * 进阶: 给定一个不含有负数但可能含有重复值的数组arr，返回有多少对山峰能够相互看见。
 *
 */
public class Problem03_VisibleMountains {

	public static class Record {
		public int value;
		public int times;

		public Record(int value) {
			this.value = value;
			this.times = 1;
		}
	}

	public static int getVisibleNum(int[] arr) {
		if (arr == null || arr.length < 2) {
			return 0;
		}
		int size = arr.length;
		int maxIndex = 0;
		// 先在环中找到其中一个最大值的位置，哪一个都行
		for (int i = 0; i < size; i++) {
			maxIndex = arr[maxIndex] < arr[i] ? i : maxIndex;
		}
		Stack<Record> stack = new Stack<Record>();
		// 先把(最大值,1)这个记录放入stack中
		stack.push(new Record(arr[maxIndex]));
		// 从最大值位置的下一个位置开始沿next方向遍历
		int index = nextIndex(maxIndex, size);
		// 用“小找大”的方式统计所有可见山峰对
		int res = 0;
		// 遍历阶段开始，当index再次回到maxIndex的时候，说明转了一圈，遍历阶段就结束
		while (index != maxIndex) {
			// 当前数要进入栈，判断会不会破坏第一维的数字从顶到底依次变大
			// 如果破坏了，就依次弹出栈顶记录，并计算山峰对数量
			while (stack.peek().value < arr[index]) {
				int k = stack.pop().times;
				// 弹出记录为(X,K)，如果K==1，产生2对; 如果K>1，产生2*K + C(2,K)对。
				res += getInternalSum(k) + 2 * k;
			}
			// 当前数字arr[index]要进入栈了，如果和当前栈顶数字一样就合并
			// 不一样就把记录(arr[index],1)放入栈中
			if (stack.peek().value == arr[index]) {
				stack.peek().times++;
			} else {
				stack.push(new Record(arr[index]));
			}
			index = nextIndex(index, size);
		}
		// 清算阶段开始了
		// 清算阶段的第1小阶段
		while (stack.size() > 2) {
			int times = stack.pop().times;
			res += getInternalSum(times) + 2 * times;
		}
		// 清算阶段的第2小阶段
		if (stack.size() == 2) {
			int times = stack.pop().times;
			res += getInternalSum(times)
					+ (stack.peek().times == 1 ? times : 2 * times);
		}
		// 清算阶段的第3小阶段
		res += getInternalSum(stack.pop().times);
		return res;
	}

	// 如果k==1返回0，如果k>1返回C(2,k)
	public static int getInternalSum(int k) {
		return k == 1 ? 0 : (k * (k - 1) / 2);
	}

	// 环形数组中当前位置为i，数组长度为size，返回i的下一个位置
	public static int nextIndex(int i, int size) {
		return i < (size - 1) ? (i + 1) : 0;
	}

	// 环形数组中当前位置为i，数组长度为size，返回i的上一个位置
	public static int lastIndex(int i, int size) {
		return i > 0 ? (i - 1) : (size - 1);
	}

	// for test, O(N^2)的解法，绝对正确
	public static int rightWay(int[] arr) {
		if (arr == null || arr.length < 2) {
			return 0;
		}
		int res = 0;
		HashSet<String> equalCounted = new HashSet<>();
		for (int i = 0; i < arr.length; i++) {
			// 枚举从每一个位置出发，根据“小找大”原则能找到多少对儿，并且保证不重复找
			res += getVisibleNumFromIndex(arr, i, equalCounted);
		}
		return res;
	}

	// for test
	// 根据“小找大”的原则返回从index出发能找到多少对
	// 相等情况下，比如arr[1]==3，arr[5]==3
	// 之前如果从位置1找过位置5，那么等到从位置5出发时就不再找位置1（去重）
	// 之前找过的、所有相等情况的山峰对，都保存在了equalCounted中
	public static int getVisibleNumFromIndex(int[] arr, int index,
			HashSet<String> equalCounted) {
		int res = 0;
		for (int i = 0; i < arr.length; i++) {
			if (i != index) { // 不找自己
				if (arr[i] == arr[index]) {
					String key = Math.min(index, i) + "_" + Math.max(index, i);
					// 相等情况下，确保之前没找过这一对
					if (equalCounted.add(key) && isVisible(arr, index, i)) {
						res++;
					}
				} else if (isVisible(arr, index, i)) { // 不相等的情况下直接找
					res++;
				}
			}
		}
		return res;
	}

	// for test
	// 调用该函数的前提是，lowIndex和highIndex一定不是同一个位置
	// 在“小找大”的策略下，从lowIndex位置能不能看到highIndex位置
	// next方向或者last方向有一个能走通，就返回true，否则返回false
	public static boolean isVisible(int[] arr, int lowIndex, int highIndex) {
		if (arr[lowIndex] > arr[highIndex]) { // “大找小”的情况直接返回false
			return false;
		}
		int size = arr.length;
		boolean walkNext = true;
		int mid = nextIndex(lowIndex, size);
		// lowIndex通过next方向走到highIndex，沿途不能出现比arr[lowIndex]大的数
		while (mid != highIndex) {
			if (arr[mid] > arr[lowIndex]) {
				walkNext = false;// next方向失败
				break;
			}
			mid = nextIndex(mid, size);
		}
		boolean walkLast = true;
		mid = lastIndex(lowIndex, size);
		// lowIndex通过last方向走到highIndex，沿途不能出现比arr[lowIndex]大的数
		while (mid != highIndex) {
			if (arr[mid] > arr[lowIndex]) {
				walkLast = false; // last方向失败
				break;
			}
			mid = lastIndex(mid, size);
		}
		return walkNext || walkLast; // 有一个成功就是能相互看见
	}

	// for test
	public static int[] getRandomArray(int size, int max) {
		int[] arr = new int[(int) (Math.random() * size)];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int) (Math.random() * max);
		}
		return arr;
	}

	// for test
	public static void printArray(int[] arr) {
		if (arr == null || arr.length == 0) {
			return;
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		int size = 10;
		int max = 10;
		int testTimes = 3000000;
		for (int i = 0; i < testTimes; i++) {
			int[] arr = getRandomArray(size, max);
			if (rightWay(arr) != getVisibleNum(arr)) {
				printArray(arr);
				System.out.println(rightWay(arr));
				System.out.println(getVisibleNum(arr));
				break;
			}
		}
	}

}