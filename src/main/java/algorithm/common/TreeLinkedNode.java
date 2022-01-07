package algorithm.common;

/**
 * 树的结构，包含一个指向下一个节点的指针
 *
 * @author hsfxuebao
 * @date 2020/03/13
 */
public class TreeLinkedNode {
    public int value;
    public TreeLinkedNode left;
    public TreeLinkedNode right;
    public TreeLinkedNode next;

    public TreeLinkedNode(int val) {
        this.value = val;
    }
}