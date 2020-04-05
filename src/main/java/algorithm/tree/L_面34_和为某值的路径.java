package algorithm.tree;

import algorithm.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author haoshaofei
 * @date 2020/03/31
 *
 * 输入一棵二叉树和一个整数，打印出二叉树中节点值的和为输入整数的所有路径。从树的根节点开始往下一直到叶节点所经过的节点形成一条路径。
 *
 *  
 *
 * 示例:
 * 给定如下二叉树，以及目标和 sum = 22，
 *
 *               5
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \    / \
 *         7    2  5   1
 * 返回:
 *
 * [
 *    [5,4,11,2],
 *    [5,8,4,5]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/er-cha-shu-zhong-he-wei-mou-yi-zhi-de-lu-jing-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L_面34_和为某值的路径 {

	//回溯法
	public static List<List<Integer>> pathSum(TreeNode root, int sum) {

		List<List<Integer>> result = new ArrayList<>();
		LinkedList<Integer> path = new LinkedList<>();
		dfs(root, sum, path, result);
		return result;

	}

	private static void dfs(TreeNode root, int sum, LinkedList<Integer> path, List<List<Integer>> result) {

		if (root == null) {
			return;
		}

		path.add(root.value);
		sum -= root.value;
		if (sum == 0 && root.left == null && root.right == null) {
			result.add(new ArrayList<>(path));
		}
		dfs(root.left, sum, path, result);
		dfs(root.right, sum, path, result);
		path.removeLast();

	}

	public static void main(String[] args) {
		TreeNode head = new TreeNode(5);
		head.left = new TreeNode(4);
		head.right = new TreeNode(8);
		head.left.left = new TreeNode(11);
		head.left.left.left = new TreeNode(7);
		head.left.left.right = new TreeNode(2);
		head.right.left = new TreeNode(13);
		head.right.right = new TreeNode(4);
		head.right.right.left = new TreeNode(5);
		head.right.right.right = new TreeNode(1);
		System.out.println(pathSum(head, 22));
	}

}
