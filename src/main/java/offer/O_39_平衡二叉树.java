package offer;

import com.example.demo.leetcode.TreeNode;

/**
 * @author haoshaofei
 * @date 2020/03/13
 *
 * 输入一棵二叉树，判断该二叉树是否是平衡二叉树。
 */
public class O_39_平衡二叉树 {

    public boolean IsBalanced_Solution(TreeNode root) {
        if (root == null) {
            return true;
        }

        int left = TreeDepth(root.left);
        int right = TreeDepth(root.right);

        if (Math.abs(left - right) >= 2) {
            return false;
        }

        return IsBalanced_Solution(root.left) && IsBalanced_Solution(root.right);
    }

    public int TreeDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return Math.max(TreeDepth(root.left), TreeDepth(root.right)) + 1;
    }
}