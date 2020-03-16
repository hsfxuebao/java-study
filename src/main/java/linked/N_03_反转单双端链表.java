package linked;

/**
 * @author haoshaofei
 * @date 2020/03/16
 */

import common.DoubleLinkedNode;
import common.LinkedNode;
import util.PrintUtils;

import java.util.LinkedList;

/**
 * 反转单向和双向链表
 * 【题目】 分别实现反转单向链表和反转双向链表的函数。
 * 【要求】 如果链表长度为N，时间复杂度要求为O(N)，额外空间 复杂度要求为O(1)
 */
public class N_03_反转单双端链表 {

	/**
	 * 反转单向链表
	 * @param head
	 * @return
	 */
	public static LinkedNode reverseLinkedNode(LinkedNode head) {
		if (head == null) {
			return null;
		}

		LinkedNode pre = null;
		LinkedNode next = null;
		while (head != null) {
			next = head.next;
			head.next = pre;
			pre = head;
			head = next;
		}
		return pre;
	}

	/**
	 * 反转双向链表
	 */
	public static DoubleLinkedNode reverseDoubleLinkedNode(DoubleLinkedNode head) {
		if (head == null) {
			return null;
		}

		DoubleLinkedNode pre = null;
		DoubleLinkedNode next;

		while (head != null) {

			next = head.next;
			head.next = pre;
			head.last = next;
			pre = head;
			head = next;

		}
		return pre;
	}

	public static void main(String[] args) {
		LinkedNode head1 = new LinkedNode(1);
		head1.next = new LinkedNode(2);
		head1.next.next = new LinkedNode(3);
		PrintUtils.printLinkedList(head1);
		head1 = reverseLinkedNode(head1);
		PrintUtils.printLinkedList(head1);

		DoubleLinkedNode head2 = new DoubleLinkedNode(1);
		head2.next = new DoubleLinkedNode(2);
		head2.next.last = head2;
		head2.next.next = new DoubleLinkedNode(3);
		head2.next.next.last = head2.next;
		head2.next.next.next = new DoubleLinkedNode(4);
		head2.next.next.next.last = head2.next.next;
		PrintUtils.printDoubleLinkedList(head2);
		PrintUtils.printDoubleLinkedList(reverseDoubleLinkedNode(head2));

	}

}
