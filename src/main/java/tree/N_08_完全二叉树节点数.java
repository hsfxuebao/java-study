package tree;

import common.TreeNode;

/**
 * @author haoshaofei
 * @date 2020/03/17
 *
 *
 * 题目：已知一棵完全二叉树，求其节点的个数
 *
 * 要求：时间复杂度低于O(N)，N为这棵树的节点个数
 *
 * 完全二叉树的概念就不多叙述了。
 *
 * 讲讲思路：题目的要求是时间复杂度低于O(N)，所以遍历的方式就不用考虑了，根据完全二叉树的特点可以知道，从头节点head开始一直往左走可以可以到达完全二叉树的最底层，
 * 而就是可以计算出二叉树的高度H了，（默认给定的一定是完全二叉树，，，）
 *
 * 1）当头结点的右子节点作为头节点来计算他的高度h+1等于H的时候，说明head的左子树是一棵满二叉树，可以使用公式t = 2^level-1,
 * 也就是节点个数t等于2的层数次方-1。这个时候，发现右子树可以使用递归的方式计算，因为自问题与原问题是一致的。
 *
 * 2）当头结点的右子节点作为头节点来计算他的高度h+1不等于H的时候，说明head的右子树是一颗满二叉树。而左子树同（1），应该使用递归的方式解决。
 */

public class N_08_完全二叉树节点数 {



	public static int TreeNodeNum(TreeNode head) {
		if (head == null) {
			return 0;
		}
		return bs(head, 1, mostLeftLevel(head, 1));
	}


	public static int bs(TreeNode TreeNode, int l, int h) {
		if (l == h) {
			return 1;
		}
		if (mostLeftLevel(TreeNode.right, l + 1) == h) {
			return (1 << (h - l)) + bs(TreeNode.right, l + 1, h);
		} else {
			return (1 << (h - l - 1)) + bs(TreeNode.left, l + 1, h);
		}
	}

	public static int mostLeftLevel(TreeNode TreeNode, int level) {
		while (TreeNode != null) {
			level++;
			TreeNode = TreeNode.left;
		}
		return level - 1;
	}

	public static void main(String[] args) {
		TreeNode head = new TreeNode(1);
		head.left = new TreeNode(2);
		head.right = new TreeNode(3);
		head.left.left = new TreeNode(4);
		head.left.right = new TreeNode(5);
		head.right.left = new TreeNode(6);
		System.out.println(TreeNodeNum(head));

	}

}
