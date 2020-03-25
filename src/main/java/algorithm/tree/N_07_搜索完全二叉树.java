package algorithm.tree;

import algorithm.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author haoshaofei
 * @date 2020/03/17
 *
 * 搜索二叉树：
 * 完全二叉树：
 *
 */
public class N_07_搜索完全二叉树 {

	/**
	 * 搜索二叉树
	 * @param head
	 * @return
	 */
	public static boolean isBST(TreeNode head) {
		if (head == null) {
			return true;
		}
		boolean res = true;
		TreeNode pre = null;
		TreeNode cur1 = head;
		TreeNode cur2 = null;
		while (cur1 != null) {
			cur2 = cur1.left;
			if (cur2 != null) {
				while (cur2.right != null && cur2.right != cur1) {
					cur2 = cur2.right;
				}
				if (cur2.right == null) {
					cur2.right = cur1;
					cur1 = cur1.left;
					continue;
				} else {
					cur2.right = null;
				}
			}
			if (pre != null && pre.value > cur1.value) {
				res = false;
			}
			pre = cur1;
			cur1 = cur1.right;
		}
		return res;
	}

	/**
	 * 完全二叉树
	 * @param head
	 * @return
	 */
	public static boolean isCBT(TreeNode head) {
		if (head == null) {
			return true;
		}
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		boolean leaf = false;
		TreeNode l = null;
		TreeNode r = null;
		queue.offer(head);
		while (!queue.isEmpty()) {
			head = queue.poll();
			l = head.left;
			r = head.right;
			if ((leaf && (l != null || r != null)) || (l == null && r != null)) {
				return false;
			}
			if (l != null) {
				queue.offer(l);
			}
			if (r != null) {
				queue.offer(r);
			} else {
				leaf = true;
			}
		}
		return true;
	}

	// for test -- print tree
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
		TreeNode head = new TreeNode(4);
		head.left = new TreeNode(2);
		head.right = new TreeNode(6);
		head.left.left = new TreeNode(1);
		head.left.right = new TreeNode(3);
		head.right.left = new TreeNode(5);

		printTree(head);
		System.out.println(isBST(head));
		System.out.println(isCBT(head));

	}

}
