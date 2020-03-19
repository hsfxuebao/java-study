package tree;

import common.TreeNode;

/**
 * @author haoshaofei
 * @date 2020/03/19
 *
 * 判断T1树是否包含T2树
 *
 */
public class N_15_T1树包含T2树 {

	public static boolean contains(TreeNode t1, TreeNode t2) {
		if (t2 == null) {
			return true;
		}
		if (t1 == null) {
			return false;
		}
		return check(t1, t2) || contains(t1.left, t2) || contains(t1.right, t2);
	}

	public static boolean check(TreeNode h, TreeNode t2) {
		if (t2 == null) {
			return true;
		}
		if (h == null || h.value != t2.value) {
			return false;
		}
		return check(h.left, t2.left) && check(h.right, t2.right);
	}

	public static void main(String[] args) {
		TreeNode t1 = new TreeNode(1);
		t1.left = new TreeNode(2);
		t1.right = new TreeNode(3);
		t1.left.left = new TreeNode(4);
		t1.left.right = new TreeNode(5);
		t1.right.left = new TreeNode(6);
		t1.right.right = new TreeNode(7);
		t1.left.left.left = new TreeNode(8);
		t1.left.left.right = new TreeNode(9);
		t1.left.right.left = new TreeNode(10);

		TreeNode t2 = new TreeNode(2);
		t2.left = new TreeNode(4);
		t2.left.left = new TreeNode(8);
		t2.right = new TreeNode(5);

		System.out.println(contains(t1, t2));

	}
	
}
