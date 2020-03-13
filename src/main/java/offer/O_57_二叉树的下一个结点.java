package offer;

import com.example.demo.leetcode.TreeLinkNode;

/**
 * @author haoshaofei
 * @date 2020/03/13
 *
 * 给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
 */
public class O_57_二叉树的下一个结点 {

    public TreeLinkNode GetNext(TreeLinkNode pNode)
    {
        if(pNode.right != null){
            pNode = pNode.right;
            while(pNode.left != null){
                pNode = pNode.left;
            }
            return pNode;
        }
        if(pNode.next != null && pNode.next.left == pNode){
            return pNode.next;
        }
        while(pNode.next != null ){
            if(pNode.next.left == pNode){
                return pNode.next;
            }
            pNode = pNode.next;
        }
        return null;
    }
}