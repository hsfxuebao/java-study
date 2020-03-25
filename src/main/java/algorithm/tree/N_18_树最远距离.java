package algorithm.tree;

import algorithm.common.TreeNode;

/**
 * @author haoshaofei
 * @date 2020/03/23
 * 
 *  二叉树中，一个节点可以往上走和往下走，那么从节点A总能走到节点 B。
 *  * 节点A走到节点B的距离为:A走到B最短路径上的节点个数。 求一棵二叉树上的最远距离
 * 
 */
public class N_18_树最远距离 {



	public static int maxDistance(TreeNode head) {
		int[] record = new int[1];
		return posOrder(head, record);
	}

	public static class ReturnType{
		public int maxDistance;
		public int h;

		public ReturnType(int m, int h) {
			this.maxDistance = m;
			this.h = h;
		}
	}

	public static ReturnType process(TreeNode head) {
		if(head == null) {
			return new ReturnType(0,0);
		}
		ReturnType leftReturnType = process(head.left);
		ReturnType rightReturnType = process(head.right);
		int includeHeadDistance = leftReturnType.h + 1 + rightReturnType.h;
		int p1 = leftReturnType.maxDistance;
		int p2 = rightReturnType.maxDistance;
		int resultDistance = Math.max(Math.max(p1, p2), includeHeadDistance);
		int hitself  = Math.max(leftReturnType.h, leftReturnType.h) + 1;
		return new ReturnType(resultDistance, hitself);
	}

	public static int posOrder(TreeNode head, int[] record) {
		if (head == null) {
			record[0] = 0;
			return 0;
		}
		int lMax = posOrder(head.left, record);
		int maxfromLeft = record[0];
		int rMax = posOrder(head.right, record);
		int maxFromRight = record[0];
		int curTreeNodeMax = maxfromLeft + maxFromRight + 1;
		record[0] = Math.max(maxfromLeft, maxFromRight) + 1;
		return Math.max(Math.max(lMax, rMax), curTreeNodeMax);
	}

	public static void main(String[] args) {
		TreeNode head1 = new TreeNode(1);
		head1.left = new TreeNode(2);
		head1.right = new TreeNode(3);
		head1.left.left = new TreeNode(4);
		head1.left.right = new TreeNode(5);
		head1.right.left = new TreeNode(6);
		head1.right.right = new TreeNode(7);
		head1.left.left.left = new TreeNode(8);
		head1.right.left.right = new TreeNode(9);
		System.out.println(maxDistance(head1));

		TreeNode head2 = new TreeNode(1);
		head2.left = new TreeNode(2);
		head2.right = new TreeNode(3);
		head2.right.left = new TreeNode(4);
		head2.right.right = new TreeNode(5);
		head2.right.left.left = new TreeNode(6);
		head2.right.right.right = new TreeNode(7);
		head2.right.left.left.left = new TreeNode(8);
		head2.right.right.right.right = new TreeNode(9);
		System.out.println(process(head2).maxDistance);

	}
	
}
