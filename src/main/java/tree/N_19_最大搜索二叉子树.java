package tree;

import common.TreeNode;

/**
 * @author haoshaofei
 * @date 2020/03/23
 *
 * 定一棵二叉树的头节点head，请返回最大搜索二叉子树的大 小
 *
 */
public class N_19_最大搜索二叉子树 {



	public static TreeNode biggestSubBST(TreeNode head) {
		int[] record = new int[3]; // 0->size, 1->min, 2->max
		return posOrder(head, record);
	}

	public static class ReturnType{
		public int size;
		public TreeNode head;
		public int min;
		public int max;

		public ReturnType(int a, TreeNode b,int c,int d) {
			this.size =a;
			this.head = b;
			this.min = c;
			this.max = d;
		}
	}

	public static ReturnType process(TreeNode head) {
		if(head == null) {
			return new ReturnType(0,null,Integer.MAX_VALUE, Integer.MIN_VALUE);
		}
		TreeNode left = head.left;
		ReturnType leftSubTressInfo = process(left);
		TreeNode right = head.right;
		ReturnType rightSubTressInfo = process(right);

		int includeItSelf = 0;
		if(leftSubTressInfo.head == left
				&&rightSubTressInfo.head == right
				&& head.value > leftSubTressInfo.max
				&& head.value < rightSubTressInfo.min
		) {
			includeItSelf = leftSubTressInfo.size + 1 + rightSubTressInfo.size;
		}
		int p1 = leftSubTressInfo.size;
		int p2 = rightSubTressInfo.size;
		int maxSize = Math.max(Math.max(p1, p2), includeItSelf);

		TreeNode maxHead = p1 > p2 ? leftSubTressInfo.head : rightSubTressInfo.head;
		if(maxSize == includeItSelf) {
			maxHead = head;
		}

		return new ReturnType(maxSize,
				maxHead,
				Math.min(Math.min(leftSubTressInfo.min,rightSubTressInfo.min),head.value),
				Math.max(Math.max(leftSubTressInfo.max,rightSubTressInfo.max),head.value));
	}




	public static TreeNode posOrder(TreeNode head, int[] record) {
		if (head == null) {
			record[0] = 0;
			record[1] = Integer.MAX_VALUE;
			record[2] = Integer.MIN_VALUE;
			return null;
		}
		int value = head.value;
		TreeNode left = head.left;
		TreeNode right = head.right;
		TreeNode lBST = posOrder(left, record);
		int lSize = record[0];
		int lMin = record[1];
		int lMax = record[2];
		TreeNode rBST = posOrder(right, record);
		int rSize = record[0];
		int rMin = record[1];
		int rMax = record[2];
		record[1] = Math.min(rMin, Math.min(lMin, value)); // lmin, value, rmin -> min 
		record[2] =  Math.max(lMax, Math.max(rMax, value)); // lmax, value, rmax -> max
		if (left == lBST && right == rBST && lMax < value && value < rMin) {
			record[0] = lSize + rSize + 1;
			return head;
		}
		record[0] = Math.max(lSize, rSize);
		return lSize > rSize ? lBST : rBST;
	}

	// for test -- print tree
	public static void printTree(TreeNode head) {
		System.out.println("Binary Tree:");
		printInOrder(head, 0, "H", 17);
		System.out.println();
	}

	public static void printInOrder(TreeNode head, int height, String to, int len) {
		if (head == null) {
			return;
		}
		printInOrder(head.right, height + 1, "v", len);
		String val = to + head.value + to;
		int lenM = val.length();
		int lenL = (len - lenM) / 2;
		int lenR = len - lenM - lenL;
		val = getSpace(lenL) + val + getSpace(lenR);
		System.out.println(getSpace(height * len) + val);
		printInOrder(head.left, height + 1, "^", len);
	}

	public static String getSpace(int num) {
		String space = " ";
		StringBuffer buf = new StringBuffer();
		for (int i = 0; i < num; i++) {
			buf.append(space);
		}
		return buf.toString();
	}

	public static void main(String[] args) {

		TreeNode head = new TreeNode(6);
		head.left = new TreeNode(1);
		head.left.left = new TreeNode(0);
		head.left.right = new TreeNode(3);
		head.right = new TreeNode(12);
		head.right.left = new TreeNode(10);
		head.right.left.left = new TreeNode(4);
		head.right.left.left.left = new TreeNode(2);
		head.right.left.left.right = new TreeNode(5);
		head.right.left.right = new TreeNode(14);
		head.right.left.right.left = new TreeNode(11);
		head.right.left.right.right = new TreeNode(15);
		head.right.right = new TreeNode(13);
		head.right.right.left = new TreeNode(20);
		head.right.right.right = new TreeNode(16);

		printTree(head);
		TreeNode bst = biggestSubBST(head);
		printTree(bst);

	}


}
