package tree;

import common.TreeNode;

import java.util.HashMap;

/**
 * @author haoshaofei
 * @date 2020/03/19
 *
 * 给定一棵二叉树的头节点head，
 * 和一个整数sum，二叉树每个节点上都 有数字，
 * 我们规定路径必须是从上往下的，求二叉树上累加和为sum的 最长路径长度。
 *
 */
public class N_09_累加和最长路径 {

	/**
	 * sumMap:保存从head开始的一条路径上的累加和；
	 *        key:保存某个累加和；
	 *        value:在这个累加和在路径中《最早》出现的层数
	 * 对于当前节点，需要父节点的累加和+当前节点的值（所以需要先序遍历的变形应用）
	 * 保证level为最早出现这个累加和的层数：
	 *     sumMap中加入某个累加和时，判断是否已经有该累加和，没有了加入；有不加入；
	 *
	 *  求解以每个节点结尾的情况下，累加和为规定值的最长路径长度；
	 */

	public static int getMaxLength(TreeNode head, int sum) {
		HashMap<Integer, Integer> sumMap = new HashMap<Integer, Integer>();
		sumMap.put(0, 0); // important
		return preOrder(head, sum, 0, 1, 0, sumMap);
	}

	public static int preOrder(TreeNode head, int sum, int preSum, int level,
							   int maxLen, HashMap<Integer, Integer> sumMap) {
		if (head == null) {
			return maxLen;
		}
		int curSum = preSum + head.value;

		//保证level为最早出现这个累加和的层数
		if (!sumMap.containsKey(curSum)) {
			sumMap.put(curSum, level);
		}
		//求解以每个节点结尾的情况下，累积和为规定值的最长路径长度，更新最大路径长度
		if (sumMap.containsKey(curSum - sum)) {
			maxLen = Math.max(level - sumMap.get(curSum - sum), maxLen);
		}
		//遍历左右子树
		maxLen = preOrder(head.left, sum, curSum, level + 1, maxLen, sumMap);
		maxLen = preOrder(head.right, sum, curSum, level + 1, maxLen, sumMap);

		//返回父节点之前，删除当前节点新加入的sumMap(通过level判断)，因为父节点是不会用到子节点的累加和的层数的
		if (level == sumMap.get(curSum)) {
			sumMap.remove(curSum);
		}
		return maxLen;
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
		TreeNode head = new TreeNode(-3);
		head.left = new TreeNode(3);
		head.right = new TreeNode(-9);
		head.left.left = new TreeNode(1);
		head.left.right = new TreeNode(0);
		head.left.right.left = new TreeNode(1);
		head.left.right.right = new TreeNode(6);
		head.right.left = new TreeNode(2);
		head.right.right = new TreeNode(1);
		printTree(head);
		System.out.println(getMaxLength(head, 6));
		System.out.println(getMaxLength(head, -9));

	}

}
