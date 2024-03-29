package algorithm.linked;

import algorithm.common.LinkedNode;

import java.util.Stack;

/**
 * @author hsfxuebao
 * @date 2020/03/16
 */

/**
 * 判断一个链表是否为回文结构
 * 【题目】 给定一个链表的头节点head，请判断该链表是否为回 文结构。
 * 例如: 1->2->1，返回true。 1->2->2->1，返回true。 15->6->15，返回true。 1->2->3，返回false。
 * 进阶: 如果链表长度为N，时间复杂度达到O(N)，额外空间复杂 度达到O(1)。
 */
public class N_05_链表回文结构 {

	// need n extra space
	public static boolean isPalindrome1(LinkedNode head) {
		Stack<LinkedNode> stack = new Stack<LinkedNode>();
		LinkedNode cur = head;
		while (cur != null) {
			stack.push(cur);
			cur = cur.next;
		}
		while (head != null) {
			if (head.value != stack.pop().value) {
				return false;
			}
			head = head.next;
		}
		return true;
	}

	// need n/2 extra space
	public static boolean isPalindrome2(LinkedNode head) {
		if (head == null || head.next == null) {
			return true;
		}
		LinkedNode right = head.next;
		LinkedNode cur = head;
		while (cur.next != null && cur.next.next != null) {
			right = right.next;
			cur = cur.next.next;
		}
		Stack<LinkedNode> stack = new Stack<LinkedNode>();
		while (right != null) {
			stack.push(right);
			right = right.next;
		}
		while (!stack.isEmpty()) {
			if (head.value != stack.pop().value) {
				return false;
			}
			head = head.next;
		}
		return true;
	}

	// need O(1) extra space
	public static boolean isPalindrome3(LinkedNode head) {
		if (head == null || head.next == null) {
			return true;
		}
		LinkedNode n1 = head;
		LinkedNode n2 = head;
		while (n2.next != null && n2.next.next != null) { // find mid LinkedNode
			n1 = n1.next; // n1 -> mid
			n2 = n2.next.next; // n2 -> end
		}
		n2 = n1.next; // n2 -> right part first LinkedNode
		n1.next = null; // mid.next -> null
		LinkedNode n3 = null;
		while (n2 != null) { // right part convert
			n3 = n2.next; // n3 -> save next LinkedNode
			n2.next = n1; // next of right LinkedNode convert
			n1 = n2; // n1 move
			n2 = n3; // n2 move
		}
		n3 = n1; // n3 -> save last LinkedNode
		n2 = head;// n2 -> left first LinkedNode
		boolean res = true;
		while (n1 != null && n2 != null) { // check palindrome
			if (n1.value != n2.value) {
				res = false;
				break;
			}
			n1 = n1.next; // left to mid
			n2 = n2.next; // right to mid
		}
		n1 = n3.next;
		n3.next = null;
		while (n1 != null) { // recover list
			n2 = n1.next;
			n1.next = n3;
			n3 = n1;
			n1 = n2;
		}
		return res;
	}

	public static void printLinkedList(LinkedNode LinkedNode) {
		System.out.print("Linked List: ");
		while (LinkedNode != null) {
			System.out.print(LinkedNode.value + " ");
			LinkedNode = LinkedNode.next;
		}
		System.out.println();
	}

	public static void main(String[] args) {

		LinkedNode head = null;
		printLinkedList(head);
		System.out.print(isPalindrome1(head) + " | ");
		System.out.print(isPalindrome2(head) + " | ");
		System.out.println(isPalindrome3(head) + " | ");
		printLinkedList(head);
		System.out.println("=========================");

		head = new LinkedNode(1);
		printLinkedList(head);
		System.out.print(isPalindrome1(head) + " | ");
		System.out.print(isPalindrome2(head) + " | ");
		System.out.println(isPalindrome3(head) + " | ");
		printLinkedList(head);
		System.out.println("=========================");

		head = new LinkedNode(1);
		head.next = new LinkedNode(2);
		printLinkedList(head);
		System.out.print(isPalindrome1(head) + " | ");
		System.out.print(isPalindrome2(head) + " | ");
		System.out.println(isPalindrome3(head) + " | ");
		printLinkedList(head);
		System.out.println("=========================");

		head = new LinkedNode(1);
		head.next = new LinkedNode(1);
		printLinkedList(head);
		System.out.print(isPalindrome1(head) + " | ");
		System.out.print(isPalindrome2(head) + " | ");
		System.out.println(isPalindrome3(head) + " | ");
		printLinkedList(head);
		System.out.println("=========================");

		head = new LinkedNode(1);
		head.next = new LinkedNode(2);
		head.next.next = new LinkedNode(3);
		printLinkedList(head);
		System.out.print(isPalindrome1(head) + " | ");
		System.out.print(isPalindrome2(head) + " | ");
		System.out.println(isPalindrome3(head) + " | ");
		printLinkedList(head);
		System.out.println("=========================");

		head = new LinkedNode(1);
		head.next = new LinkedNode(2);
		head.next.next = new LinkedNode(1);
		printLinkedList(head);
		System.out.print(isPalindrome1(head) + " | ");
		System.out.print(isPalindrome2(head) + " | ");
		System.out.println(isPalindrome3(head) + " | ");
		printLinkedList(head);
		System.out.println("=========================");

		head = new LinkedNode(1);
		head.next = new LinkedNode(2);
		head.next.next = new LinkedNode(3);
		head.next.next.next = new LinkedNode(1);
		printLinkedList(head);
		System.out.print(isPalindrome1(head) + " | ");
		System.out.print(isPalindrome2(head) + " | ");
		System.out.println(isPalindrome3(head) + " | ");
		printLinkedList(head);
		System.out.println("=========================");

		head = new LinkedNode(1);
		head.next = new LinkedNode(2);
		head.next.next = new LinkedNode(2);
		head.next.next.next = new LinkedNode(1);
		printLinkedList(head);
		System.out.print(isPalindrome1(head) + " | ");
		System.out.print(isPalindrome2(head) + " | ");
		System.out.println(isPalindrome3(head) + " | ");
		printLinkedList(head);
		System.out.println("=========================");

		head = new LinkedNode(1);
		head.next = new LinkedNode(2);
		head.next.next = new LinkedNode(3);
		head.next.next.next = new LinkedNode(2);
		head.next.next.next.next = new LinkedNode(1);
		printLinkedList(head);
		System.out.print(isPalindrome1(head) + " | ");
		System.out.print(isPalindrome2(head) + " | ");
		System.out.println(isPalindrome3(head) + " | ");
		printLinkedList(head);
		System.out.println("=========================");

	}

}
