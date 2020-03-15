package review;

import common.Node;
import newcoder.primary.stackque.Code_07_ReverseList;

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
	public static  Node addNode(Node head1, Node head2) {
		//逆序两个链表
		head1 = reverseNode(head1);
		head2 = reverseNode(head2);

		Node c1 = head1;
		Node c2 = head2;
		int num1 = 0;
		int num2 = 0;
		int sum = 0;
		//进位
		int wei = 0;

		Node pre = null;
		Node node = null;

		while (c1 != null || c2 != null) {

			num1 = c1 != null ? c1.value : 0;
			num2 = c2 != null ? c2.value : 0;
			sum = num1 + num2 + wei;
			pre = node;
			node = new Node(sum % 10);
			node.next = pre;

			wei = sum / 10;
			c1 = c1 != null ? c1.next : null;
			c2 = c2 != null ? c2.next : null;

		}

		//循环相加之后，判断进位是否还是1
		if (wei != 0) {
			pre = node;
			node = new Node(1);
			node.next = pre;
		}

		//还原两个单链表结构
		reverseNode(head1);
		reverseNode(head2);
		return node;

	}

	/**
	 * 反转链表
	 * @param head
	 */
	public static Node reverseNode(Node head) {

		Node next = null;
		Node pre = null;

		while (head != null) {

			next = head.next;
			head.next = pre;
			pre = head;

			head = next;
		}

		return pre;
	}

	public static void main(String[] args) {

		Node node1 = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		Node node4 = new Node(4);
		Node node5 = new Node(5);
		Node node6 = new Node(6);

		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node6;
		node6.next = null;

		Node node9 = new Node(9);
		node9.next = node4;
		node4.next = node5;
		node5.next = null;

		Node node = addNode(node9, node1);

		printLinkedList(node);


	}

	public static void printLinkedList(Node head) {
		System.out.print("Linked List: ");
		while (head != null) {
			System.out.print(head.value + " ");
			head = head.next;
		}
		System.out.println();
	}

}
