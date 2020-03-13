package offer;


import leetcode.ListNode;

import java.util.ArrayList;

/**
 * @author haoshaofei
 * @date 2020/03/13
 *
 * 输入一个链表，按链表从尾到头的顺序返回一个ArrayList。
 */
public class O_03_从尾到头打印链表 {

    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        if (listNode == null) {
            return new ArrayList<>();
        }

        ArrayList<Integer> res = new ArrayList<>();
        ListNode pre = null;
        ListNode cur = listNode;

        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        while (pre != null) {
            res.add(pre.val);
            pre = pre.next;
        }

        return res;
    }
}