package tree;

import common.TreeNode;


/**
 * @author haoshaofei
 * @date 2020/03/16
 *
 * 直观打印二叉树
 */

public class N_02_直观打印二叉树 {


	public static void printTree(TreeNode head) {
		System.out.println("Binary Tree:");
		printInOrder(head, 0, "H", 17);
		System.out.println();
	}

	public static void printInOrder(TreeNode head, int height, String to, int len) {
		if (head == null) {
			return;
		}
		printInOrder(head.right, height + 1, "v", len);
		String val = to + head.value + to;
		int lenM = val.length();
		int lenL = (len - lenM) / 2;
		int lenR = len - lenM - lenL;
		val = getSpace(lenL) + val + getSpace(lenR);
		System.out.println(getSpace(height * len) + val);
		printInOrder(head.left, height + 1, "^", len);
	}

	public static String getSpace(int num) {
		String space = " ";
		StringBuffer buf = new StringBuffer();
		for (int i = 0; i < num; i++) {
			buf.append(space);
		}
		return buf.toString();
	}

	public static void main(String[] args) {
		TreeNode head = new TreeNode(1);
		head.left = new TreeNode(-222222222);
		head.right = new TreeNode(3);
		head.left.left = new TreeNode(Integer.MIN_VALUE);
		head.right.left = new TreeNode(55555555);
		head.right.right = new TreeNode(66);
		head.left.left.right = new TreeNode(777);
		printTree(head);

		head = new TreeNode(1);
		head.left = new TreeNode(2);
		head.right = new TreeNode(3);
		head.left.left = new TreeNode(4);
		head.right.left = new TreeNode(5);
		head.right.right = new TreeNode(6);
		head.left.left.right = new TreeNode(7);
		printTree(head);

		head = new TreeNode(1);
		head.left = new TreeNode(1);
		head.right = new TreeNode(1);
		head.left.left = new TreeNode(1);
		head.right.left = new TreeNode(1);
		head.right.right = new TreeNode(1);
		head.left.left.right = new TreeNode(1);
		printTree(head);

	}
	
}
