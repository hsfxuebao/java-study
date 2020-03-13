package offer;

import com.example.demo.leetcode.TreeNode;

import java.util.Stack;

/**
 * @author haoshaofei
 * @date 2020/03/13
 *
 * 给定一棵二叉搜索树，请找出其中的第k小的结点。例如， （5，3，7，2，4，6，8）    中，按结点数值大小顺序第三小结点的值为4。
 */
public class O_62_二叉搜索树的第k个结点 {

    TreeNode KthNode(TreeNode pRoot, int k)
    {
        Stack<TreeNode> stack = new Stack<>();
        int count = 0;

        while (!stack.isEmpty() || pRoot != null) {
            if (pRoot != null) {
                stack.push(pRoot);
                pRoot = pRoot.left;
            } else {
                pRoot = stack.pop();
                if (++count == k) {
                    return pRoot;
                }
                pRoot = pRoot.right;
            }
        }

        return null;
    }

}