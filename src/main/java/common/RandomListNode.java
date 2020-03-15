package common;

/**
 * 链表结构，包含一个随机指向下一个节点的指针
 * @author haoshaofei
 * @date 2020/03/13
 */
public class RandomListNode {

    public int value;
    public RandomListNode next;
    public RandomListNode random;

    public RandomListNode(int value) {
        this.value = value;
    }
}