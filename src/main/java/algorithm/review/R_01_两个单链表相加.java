package algorithm.review;

import algorithm.common.LinkedNode;
import algorithm.util.PrintUtils;

/**
 * @author haoshaofei
 * @date 2020/03/14
 *
 * 问题描述：假设两个链表每个节点值都在0-9之间，那么链表整体可以代表一个整数。例如：9->3>7，可以代表937，6->3,可以代表63
 *
 * 两个链表相加即为937+63=1000，所对应的链表即为1->0->0->0
 *
 *
 */
public class R_01_两个单链表相加 {

	/**
	 * 思路1，反转链表，将低位到高位模拟加法
	 */
	public static LinkedNode addLinkedNode(LinkedNode head1, LinkedNode head2) {
		//逆序两个链表
		head1 = reverseLinkedNode(head1);
		head2 = reverseLinkedNode(head2);

		LinkedNode c1 = head1;
		LinkedNode c2 = head2;
		int num1 = 0;
		int num2 = 0;
		int sum = 0;
		//进位
		int wei = 0;

		LinkedNode pre = null;
		LinkedNode LinkedNode = null;

		while (c1 != null || c2 != null) {

			num1 = c1 != null ? c1.value : 0;
			num2 = c2 != null ? c2.value : 0;
			sum = num1 + num2 + wei;
			pre = LinkedNode;
			LinkedNode = new LinkedNode(sum % 10);
			LinkedNode.next = pre;

			wei = sum / 10;
			c1 = c1 != null ? c1.next : null;
			c2 = c2 != null ? c2.next : null;

		}

		//循环相加之后，判断进位是否还是1
		if (wei != 0) {
			pre = LinkedNode;
			LinkedNode = new LinkedNode(1);
			LinkedNode.next = pre;
		}

		//还原两个单链表结构
		reverseLinkedNode(head1);
		reverseLinkedNode(head2);
		return LinkedNode;

	}

	/**
	 * 反转链表
	 * @param head
	 */
	public static LinkedNode reverseLinkedNode(LinkedNode head) {

		LinkedNode next = null;
		LinkedNode pre = null;

		while (head != null) {

			next = head.next;
			head.next = pre;
			pre = head;

			head = next;
		}

		return pre;
	}

	public static void main(String[] args) {

		LinkedNode node1 = new LinkedNode(1);
		LinkedNode node2 = new LinkedNode(2);
		LinkedNode node3 = new LinkedNode(3);
		LinkedNode node4 = new LinkedNode(4);
		LinkedNode node5 = new LinkedNode(5);
		LinkedNode node6 = new LinkedNode(6);

		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node6;

		LinkedNode node9 = new LinkedNode(9);
		LinkedNode node33 = new LinkedNode(3);
		node9.next = node33;

		LinkedNode node = addLinkedNode(node9, node1);

		PrintUtils.printLinkedList(node);


	}



}
