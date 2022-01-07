package algorithm.linked;

import algorithm.common.LinkedNode;

/**
 * @author hsfxuebao
 * @date 2020/03/16
 */

/**
 * 两个单链表相交的一系列问题
 * 【题目】 在本题中，单链表可能有环，也可能无环。给定两个 单链表的头节点 head1和head2，这两个链表可能相交，
 * 也可能 不相交。请实现一个函数， 如果两个链表相交，请返回相交的 第一个节点;如果不相交，返回null 即可。
 * 要求:如果链表1 的长度为N，链表2的长度为M，时间复杂度请达到 O(N+M)，额外 空间复杂度请达到O(1)。
 */

public class N_06_单链表相交一些列问题 {

	public static LinkedNode getIntersectLinkedNode(LinkedNode head1, LinkedNode head2) {
		if (head1 == null || head2 == null) {
			return null;
		}
		LinkedNode loop1 = getLoopLinkedNode(head1);
		LinkedNode loop2 = getLoopLinkedNode(head2);
		if (loop1 == null && loop2 == null) {
			return noLoop(head1, head2);
		}
		if (loop1 != null && loop2 != null) {
			return bothLoop(head1, loop1, head2, loop2);
		}
		return null;
	}

	public static LinkedNode getLoopLinkedNode(LinkedNode head) {
		if (head == null || head.next == null || head.next.next == null) {
			return null;
		}
		LinkedNode n1 = head.next; // n1 -> slow
		LinkedNode n2 = head.next.next; // n2 -> fast
		while (n1 != n2) {
			if (n2.next == null || n2.next.next == null) {
				return null;
			}
			n2 = n2.next.next;
			n1 = n1.next;
		}
		n2 = head; // n2 -> walk again from head
		while (n1 != n2) {
			n1 = n1.next;
			n2 = n2.next;
		}
		return n1;
	}

	public static LinkedNode noLoop(LinkedNode head1, LinkedNode head2) {
		if (head1 == null || head2 == null) {
			return null;
		}
		LinkedNode cur1 = head1;
		LinkedNode cur2 = head2;
		int n = 0;
		while (cur1.next != null) {
			n++;
			cur1 = cur1.next;
		}
		while (cur2.next != null) {
			n--;
			cur2 = cur2.next;
		}
		if (cur1 != cur2) {
			return null;
		}
		cur1 = n > 0 ? head1 : head2;
		cur2 = cur1 == head1 ? head2 : head1;
		n = Math.abs(n);
		while (n != 0) {
			n--;
			cur1 = cur1.next;
		}
		while (cur1 != cur2) {
			cur1 = cur1.next;
			cur2 = cur2.next;
		}
		return cur1;
	}

	public static LinkedNode bothLoop(LinkedNode head1, LinkedNode loop1, LinkedNode head2, LinkedNode loop2) {
		LinkedNode cur1 = null;
		LinkedNode cur2 = null;
		if (loop1 == loop2) {
			cur1 = head1;
			cur2 = head2;
			int n = 0;
			while (cur1 != loop1) {
				n++;
				cur1 = cur1.next;
			}
			while (cur2 != loop2) {
				n--;
				cur2 = cur2.next;
			}
			cur1 = n > 0 ? head1 : head2;
			cur2 = cur1 == head1 ? head2 : head1;
			n = Math.abs(n);
			while (n != 0) {
				n--;
				cur1 = cur1.next;
			}
			while (cur1 != cur2) {
				cur1 = cur1.next;
				cur2 = cur2.next;
			}
			return cur1;
		} else {
			cur1 = loop1.next;
			while (cur1 != loop1) {
				if (cur1 == loop2) {
					return loop1;
				}
				cur1 = cur1.next;
			}
			return null;
		}
	}

	public static void main(String[] args) {
		// 1->2->3->4->5->6->7->null
		LinkedNode head1 = new LinkedNode(1);
		head1.next = new LinkedNode(2);
		head1.next.next = new LinkedNode(3);
		head1.next.next.next = new LinkedNode(4);
		head1.next.next.next.next = new LinkedNode(5);
		head1.next.next.next.next.next = new LinkedNode(6);
		head1.next.next.next.next.next.next = new LinkedNode(7);

		// 0->9->8->6->7->null
		LinkedNode head2 = new LinkedNode(0);
		head2.next = new LinkedNode(9);
		head2.next.next = new LinkedNode(8);
		head2.next.next.next = head1.next.next.next.next.next; // 8->6
		System.out.println(getIntersectLinkedNode(head1, head2).value);

		// 1->2->3->4->5->6->7->4...
		head1 = new LinkedNode(1);
		head1.next = new LinkedNode(2);
		head1.next.next = new LinkedNode(3);
		head1.next.next.next = new LinkedNode(4);
		head1.next.next.next.next = new LinkedNode(5);
		head1.next.next.next.next.next = new LinkedNode(6);
		head1.next.next.next.next.next.next = new LinkedNode(7);
		head1.next.next.next.next.next.next = head1.next.next.next; // 7->4

		// 0->9->8->2...
		head2 = new LinkedNode(0);
		head2.next = new LinkedNode(9);
		head2.next.next = new LinkedNode(8);
		head2.next.next.next = head1.next; // 8->2
		System.out.println(getIntersectLinkedNode(head1, head2).value);

		// 0->9->8->6->4->5->6..
		head2 = new LinkedNode(0);
		head2.next = new LinkedNode(9);
		head2.next.next = new LinkedNode(8);
		head2.next.next.next = head1.next.next.next.next.next; // 8->6
		System.out.println(getIntersectLinkedNode(head1, head2).value);

	}


}
