package newcoder.advanced.a06;

/**
 * 环形单链表的约瑟夫问题
 * 【题目】 据说著名犹太历史学家Josephus有过以下故事:在罗马人占领乔塔帕特后， 39个犹太人与Josephus及他的朋友躲到一个洞中，39个犹太人决定宁愿死也 不要被敌人抓到，于是决定了一个自杀方式，41个人排成一个圆圈，由第1个 人开始报数，报数到3的人就自杀，然后再由下一个人重新报1，报数到3的人 再自杀，这样依次下去，直到剩下最后一个人时，那个人可以自由选择自己的 命运。这就是著名的约瑟夫问题。现在请用单向环形链表描述该结构并呈现整 个自杀过程。
 * 输入:一个环形单向链表的头节点head和报数的值m。 返回:最后生存下来的节点，且这个节点自己组成环形单向链表，其他节点都 删掉。
 * 进阶: 如果链表节点数为N，想在时间复杂度为O(N)时完成原问题的要求，该怎么实 现?
 *
 */
public class Code_06_JosephusProblem {

	public static class Node {
		public int value;
		public Node next;

		public Node(int data) {
			this.value = data;
		}
	}

	public static Node josephusKill1(Node head, int m) {
		if (head == null || head.next == head || m < 1) {
			return head;
		}
		Node last = head;
		while (last.next != head) {
			last = last.next;
		}
		int count = 0;
		while (head != last) {
			if (++count == m) {
				last.next = head.next;
				count = 0;
			} else {
				last = last.next;
			}
			head = last.next;
		}
		return head;
	}

	public static Node josephusKill2(Node head, int m) {
		if (head == null || head.next == head || m < 1) {
			return head;
		}
		Node cur = head.next;
		int tmp = 1; // tmp -> list size
		while (cur != head) {
			tmp++;
			cur = cur.next;
		}
		tmp = getLive(tmp, m); // tmp -> service node position
		while (--tmp != 0) {
			head = head.next;
		}
		head.next = head;
		return head;
	}

	public static int getLive(int i, int m) {
		if (i == 1) {
			return 1;
		}
		return (getLive(i - 1, m) + m - 1) % i + 1;
	}

	public static void printCircularList(Node head) {
		if (head == null) {
			return;
		}
		System.out.print("Circular List: " + head.value + " ");
		Node cur = head.next;
		while (cur != head) {
			System.out.print(cur.value + " ");
			cur = cur.next;
		}
		System.out.println("-> " + head.value);
	}

	public static void main(String[] args) {
		Node head1 = new Node(1);
		head1.next = new Node(2);
		head1.next.next = new Node(3);
		head1.next.next.next = new Node(4);
		head1.next.next.next.next = new Node(5);
		head1.next.next.next.next.next = head1;
		printCircularList(head1);
		head1 = josephusKill1(head1, 3);
		printCircularList(head1);

		Node head2 = new Node(1);
		head2.next = new Node(2);
		head2.next.next = new Node(3);
		head2.next.next.next = new Node(4);
		head2.next.next.next.next = new Node(5);
		head2.next.next.next.next.next = head2;
		printCircularList(head2);
		head2 = josephusKill2(head2, 3);
		printCircularList(head2);

	}

}