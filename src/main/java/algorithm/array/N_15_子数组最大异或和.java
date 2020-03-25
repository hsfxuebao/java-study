package algorithm.array;

/**
 * @author haoshaofei
 * @date 2020/03/23
 *
 * 给定一个数组，求子数组的最大异或和。
 *  * 一个数组的异或和为，数组中所有的数异或起来的结果
 *
 */
public class N_15_子数组最大异或和 {


	/**
	 * 直接说这道题时间复杂度O(n)的做法，构建前缀树。假设将0-0、0-1、0-2、…、0-i-1的异或结果全部装在前缀树中，那么以i结尾的最大异或和就是0到某一位置x的异或结果和i异或结果最大，举个例子，假设x是3，0-3的异或结果和i进行异或得到的结果最大，那么就说明4-i的异或结果是最大的。
	 *
	 * 但是如何知道x到底是多少，换句话说，0-x中哪个值和i进行异或得到的结果最大。其实这个也比较好想，假设i是0100（最高位0是符号位），只需要沿着前缀树找到0011，异或出来的结果就是0111，一定就是最大的，如果不能刚好找到合适的，那就有什么选什么，只要保证从最高位开始往下每次的决策是最优的就行
	 *
	 * 有一种特殊情况，假设i还是0100，但是此时前缀树中最高位只有1，没有0，那么最高位得出的异或结果永远是负数，后面的位应该如何选？其实也是按照最优决策去选，假设异或结果是1111，那么转换为十进制就是-1，绝对没有比这还大的负数了
	 */
	public static class Node {
		public Node[] nexts = new Node[2];
	}

	public static class NumTrie {
		public Node head = new Node();

		public void add(int num) {
			Node cur = head;
			for (int move = 31; move >= 0; move--) {
				int path = ((num >> move) & 1);
				cur.nexts[path] = cur.nexts[path] == null ? new Node() : cur.nexts[path];
				cur = cur.nexts[path];
			}
		}

		public int maxXor(int num) {
			Node cur = head;
			int res = 0;
			for (int move = 31; move >= 0; move--) {
				int path = (num >> move) & 1;
				int best = move == 31 ? path : (path ^ 1);
				best = cur.nexts[best] != null ? best : (best ^ 1);
				res |= (path ^ best) << move;
				cur = cur.nexts[best];
			}
			return res;
		}

	}

	public static int maxXorSubarray(int[] arr) {
		if (arr == null || arr.length == 0) {
			return 0;
		}
		int max = Integer.MIN_VALUE;
		int eor = 0;
		NumTrie numTrie = new NumTrie();
		numTrie.add(0);
		for (int i = 0; i < arr.length; i++) {
			eor ^= arr[i];
			max = Math.max(max, numTrie.maxXor(eor));
			numTrie.add(eor);
		}
		return max;
	}

	// for test
	public static int comparator(int[] arr) {
		if (arr == null || arr.length == 0) {
			return 0;
		}
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < arr.length; i++) {
			int eor = 0;
			for (int j = i; j < arr.length; j++) {
				eor ^= arr[j];
				max = Math.max(max, eor);
			}
		}
		return max;
	}

	// for test
	public static int[] generateRandomArray(int maxSize, int maxValue) {
		int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
		}
		return arr;
	}

	// for test
	public static void printArray(int[] arr) {
		if (arr == null) {
			return;
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	// for test
	public static void main(String[] args) {
		int testTime = 500000;
		int maxSize = 30;
		int maxValue = 50;
		boolean succeed = true;
		for (int i = 0; i < testTime; i++) {
			int[] arr = generateRandomArray(maxSize, maxValue);
			int res = maxXorSubarray(arr);
			int comp = comparator(arr);
			if (res != comp) {
				succeed = false;
				printArray(arr);
				System.out.println(res);
				System.out.println(comp);
				break;
			}
		}
		System.out.println(succeed ? "Nice!" : "Fucking fucked!");
	}

}
