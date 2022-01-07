package algorithm.linked;

import algorithm.common.LinkedNode;

/**
 * @author hsfxuebao
 * @date 2020/03/29
 *
 * 给定两个用链表表示的整数，每个节点包含一个数位。
 *
 * 这些数位是反向存放的，也就是个位排在链表首部。
 *
 * 编写函数对这两个整数求和，并用链表形式返回结果。
 *
 *  
 *
 * 示例：
 *
 * 输入：(7 -> 1 -> 6) + (5 -> 9 -> 2)，即617 + 295
 * 输出：2 -> 1 -> 9，即912
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sum-lists-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L_面0205_链表求和 {


	public LinkedNode addTwoNumbers(LinkedNode l1, LinkedNode l2) {
		if(l1 == null || l2 == null) {
			return l1 == null ? l2 : l1;
		}
		int carry = 0; //进位
		LinkedNode node = new LinkedNode(0); //求和后的新链表
		LinkedNode cur = node;
		while(l1 != null || l2 != null) {
			int value1 = l1 != null ? l1.value : 0;
			int value2 = l2 != null ? l2.value : 0;
			int sum = value1 + value2 + carry;
			carry = sum / 10;
			node.next = new LinkedNode(sum % 10);
			node = node.next;
			if(l1 != null) {
				l1 = l1.next;
			}
			if(l2 != null) {
				l2 = l2.next;
			}
		}
		if(carry > 0) {
			node.next = new LinkedNode(carry);
		}
		return cur.next;
	}

	
	
}
