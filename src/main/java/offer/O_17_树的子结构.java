package offer;

import com.example.demo.leetcode.TreeNode;

/**
 * @author haoshaofei
 * @date 2020/03/13
 *
 * 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 */
public class O_17_树的子结构 {

    public boolean HasSubtree(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null) {
            return false;
        }

        return process(root1, root2) || process(root1.left, root2) || process(root1.right, root2);
    }

    private boolean process(TreeNode root1, TreeNode root2) {
        if (root2 == null) {
            return true;
        }
        if (root1 == null || root1.val != root2.val) {
            return false;
        }

        return process(root1.left, root2.left) && process(root1.right, root2.right);
    }
}