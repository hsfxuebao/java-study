package offer;

import com.example.demo.leetcode.TreeNode;

import java.util.LinkedList;

/**
 * @author haoshaofei
 * @date 2020/03/13
 */
public class O_61_序列化二叉树 {

    StringBuilder sb = new StringBuilder();

    String Serialize(TreeNode root) {
        if (root == null) {
            return sb.append("#!").toString();
        }

        sb.append(root.val).append("!");
        Serialize(root.left);
        Serialize(root.right);

        return sb.toString();
    }
    TreeNode Deserialize(String str) {
        if (str == null || str.length() == 0) {
            return null;
        }

        String[] nodeStr = str.split("!");
        LinkedList<String> queue = new LinkedList<>();

        for (int i = 0;i < nodeStr.length;i++) {
            queue.add(nodeStr[i]);
        }

        return forOrder(queue);
    }

    private TreeNode forOrder(LinkedList<String> queue) {
        String s = queue.poll();
        if ("#".equals(s)) {
            return null;
        }

        TreeNode node = new TreeNode(Integer.valueOf(s));
        node.left = forOrder(queue);
        node.right = forOrder(queue);

        return node;
    }
}