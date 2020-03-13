package offer;

import com.example.demo.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @author haoshaofei
 * @date 2020/03/13
 *
 * 从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
 */
public class O_60_把二叉树打印成多行 {

    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        if (pRoot == null) {
            return new ArrayList<>();
        }

        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(pRoot);

        while (!queue.isEmpty()) {
            int size = queue.size();

            while (size-- > 0) {
                TreeNode node = queue.pollFirst();
                list.add(node.val);

                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }

            res.add(new ArrayList(list));
            list = new ArrayList();
        }

        return res;
    }
}