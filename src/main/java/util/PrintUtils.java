package util;

import common.DoubleLinkedNode;
import common.LinkedNode;

/**
 *
 * 打印工具类
 *
 * @author haoshaofei
 * @date 2020/03/15
 */
public class PrintUtils {


	public static void printLinkedList(LinkedNode head) {
		System.out.print("Linked List: ");
		while (head != null) {
			System.out.print(head.value + " ");
			head = head.next;
		}
		System.out.println();
	}

	public static void printDoubleLinkedList(DoubleLinkedNode head) {
		System.out.print("Double Linked List: ");
		DoubleLinkedNode end = null;
		while (head != null) {
			System.out.print(head.value + " ");
			end = head;
			head = head.next;
		}
		System.out.print("| ");
		while (end != null) {
			System.out.print(end.value + " ");
			end = end.last;
		}
		System.out.println();
	}

}
