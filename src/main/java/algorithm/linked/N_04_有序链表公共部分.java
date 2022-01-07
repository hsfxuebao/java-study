package algorithm.linked;

/**
 * @author hsfxuebao
 * @date 2020/03/16
 */

import algorithm.common.LinkedNode;
import algorithm.util.PrintUtils;

/**
 * 打印两个有序链表的公共部分
 * 【题目】 给定两个有序链表的头指针head1和head2，打印两个 链表的公共部分。
 */
public class N_04_有序链表公共部分 {


	public static void printCommonPart(LinkedNode head1, LinkedNode head2) {
		System.out.print("Common Part: ");
		while (head1 != null && head2 != null) {
			if (head1.value < head2.value) {
				head1 = head1.next;
			} else if (head1.value > head2.value) {
				head2 = head2.next;
			} else {
				System.out.print(head1.value + " ");
				head1 = head1.next;
				head2 = head2.next;
			}
		}
		System.out.println();
	}

	public static void main(String[] args) {
		LinkedNode node1 = new LinkedNode(2);
		node1.next = new LinkedNode(3);
		node1.next.next = new LinkedNode(5);
		node1.next.next.next = new LinkedNode(6);

		LinkedNode node2 = new LinkedNode(1);
		node2.next = new LinkedNode(2);
		node2.next.next = new LinkedNode(5);
		node2.next.next.next = new LinkedNode(7);
		node2.next.next.next.next = new LinkedNode(8);

		PrintUtils.printLinkedList(node1);
		PrintUtils.printLinkedList(node2);
		printCommonPart(node1, node2);

	}

}
