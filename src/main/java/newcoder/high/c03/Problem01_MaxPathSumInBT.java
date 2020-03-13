package newcoder.high.c03;

/**
 *
 * 给定一棵二叉树的头节点head，可以从树中的任何一点出发，如果走的话只能向下， 也可以选择随时停止，所形成的轨迹叫做一条路径，路径上所有值的累加和叫作路径 和。求这棵树上的最大路径和。
 *
 */
public class Problem01_MaxPathSumInBT {

	public static class Node {
		public int value;
		public Node left;
		public Node right;

		public Node(int val) {
			value = val;
		}
	}

	public static int maxPathSum(Node head) {
		if (head == null) {
			return 0;
		}
		ReturnType allData = process(head);
		return allData.maxValue < 0 ? allData.maxValue : allData.maxPathSumAll;
	}

	public static class ReturnType {
		public int maxPathSumAll;
		public int maxPathSumHead;
		public int maxValue;

		public ReturnType(int all, int fromHead, int max) {
			maxPathSumAll = all;
			maxPathSumHead = fromHead;
			maxValue = max;
		}
	}

	public static ReturnType process(Node x) {
		if (x == null) {
			return new ReturnType(0, 0, Integer.MIN_VALUE);
		}
		ReturnType leftData = process(x.left);
		ReturnType rightData = process(x.right);
		int maxValue = Math.max(x.value, Math.max(leftData.maxValue, rightData.maxValue));
		int maxPathSumHead = Math.max(leftData.maxPathSumHead, rightData.maxPathSumHead) + x.value;
		maxPathSumHead = Math.max(x.value, maxPathSumHead);
		int maxPathSumAll = Math.max(Math.max(leftData.maxPathSumAll, rightData.maxPathSumAll), maxPathSumHead);
		return new ReturnType(maxPathSumAll, maxPathSumHead, maxValue);
	}

	public static void main(String[] args) {
		Node head1 = new Node(-7);
		head1.left = new Node(-7);
		head1.right = new Node(-7);
		head1.left.left = new Node(3);
		head1.right.left = new Node(-7);
		head1.left.left.left = new Node(2);
		System.out.println(maxPathSum(head1));

		Node head2 = new Node(-7);
		head2.left = new Node(-6);
		head2.right = new Node(-5);
		head2.left.left = new Node(-3);
		head2.right.left = new Node(-4);
		head2.left.left.left = new Node(-2);
		System.out.println(maxPathSum(head2));

	}

}
