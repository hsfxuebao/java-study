package tree;

import common.TreeNode;

import java.util.Stack;

/**
 * @author haoshaofei
 * @date 2020/03/16
 */

/**
 * 实现二叉树的先序、中序、后序遍历，包括递归方式和非递归
 * 方式
 */
public class N_01_二叉树先中后续遍历 {

	public static void preOrderRecur(TreeNode head) {
		if (head == null) {
			return;
		}
		System.out.print(head.value + " ");
		preOrderRecur(head.left);
		preOrderRecur(head.right);
	}

	public static void inOrderRecur(TreeNode head) {
		if (head == null) {
			return;
		}
		inOrderRecur(head.left);
		System.out.print(head.value + " ");
		inOrderRecur(head.right);
	}

	public static void posOrderRecur(TreeNode head) {
		if (head == null) {
			return;
		}
		posOrderRecur(head.left);
		posOrderRecur(head.right);
		System.out.print(head.value + " ");
	}

	public static void preOrderUnRecur(TreeNode head) {
		System.out.print("pre-order: ");
		if (head != null) {
			Stack<TreeNode> stack = new Stack<TreeNode>();
			stack.add(head);
			while (!stack.isEmpty()) {
				head = stack.pop();
				System.out.print(head.value + " ");
				if (head.right != null) {
					stack.push(head.right);
				}
				if (head.left != null) {
					stack.push(head.left);
				}
			}
		}
		System.out.println();
	}

	public static void inOrderUnRecur(TreeNode head) {
		System.out.print("in-order: ");
		if (head != null) {
			Stack<TreeNode> stack = new Stack<TreeNode>();
			while (!stack.isEmpty() || head != null) {
				if (head != null) {
					stack.push(head);
					head = head.left;
				} else {
					head = stack.pop();
					System.out.print(head.value + " ");
					head = head.right;
				}
			}
		}
		System.out.println();
	}

	public static void posOrderUnRecur1(TreeNode head) {
		System.out.print("pos-order: ");
		if (head != null) {
			Stack<TreeNode> s1 = new Stack<TreeNode>();
			Stack<TreeNode> s2 = new Stack<TreeNode>();
			s1.push(head);
			while (!s1.isEmpty()) {
				head = s1.pop();
				s2.push(head);
				if (head.left != null) {
					s1.push(head.left);
				}
				if (head.right != null) {
					s1.push(head.right);
				}
			}
			while (!s2.isEmpty()) {
				System.out.print(s2.pop().value + " ");
			}
		}
		System.out.println();
	}

	public static void posOrderUnRecur2(TreeNode h) {
		System.out.print("pos-order: ");
		if (h != null) {
			Stack<TreeNode> stack = new Stack<TreeNode>();
			stack.push(h);
			TreeNode c = null;
			while (!stack.isEmpty()) {
				c = stack.peek();
				if (c.left != null && h != c.left && h != c.right) {
					stack.push(c.left);
				} else if (c.right != null && h != c.right) {
					stack.push(c.right);
				} else {
					System.out.print(stack.pop().value + " ");
					h = c;
				}
			}
		}
		System.out.println();
	}

	public static void main(String[] args) {
		TreeNode head = new TreeNode(5);
		head.left = new TreeNode(3);
		head.right = new TreeNode(8);
		head.left.left = new TreeNode(2);
		head.left.right = new TreeNode(4);
		head.left.left.left = new TreeNode(1);
		head.right.left = new TreeNode(7);
		head.right.left.left = new TreeNode(6);
		head.right.right = new TreeNode(10);
		head.right.right.left = new TreeNode(9);
		head.right.right.right = new TreeNode(11);

		// recursive
		System.out.println("==============recursive==============");
		System.out.print("pre-order: ");
		preOrderRecur(head);
		System.out.println();
		System.out.print("in-order: ");
		inOrderRecur(head);
		System.out.println();
		System.out.print("pos-order: ");
		posOrderRecur(head);
		System.out.println();

		// unrecursive
		System.out.println("============unrecursive=============");
		preOrderUnRecur(head);
		inOrderUnRecur(head);
		posOrderUnRecur1(head);
		posOrderUnRecur2(head);

	}
}
