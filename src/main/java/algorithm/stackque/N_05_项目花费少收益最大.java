package algorithm.stackque;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author hsfxuebao
 * @date 2020/03/17
 *
 * 输入: 参数1，正数数组costs 参数2，正数数组profits 参数3， 正数k 参数4，正数m
 * 		costs[i]表示i号项目的花费 profits[i]表示i号项目在扣除花 费之后还能挣到的钱(利润) k表示你不能并行、只能串行的最多 做k个项目 m表示你初始的资金 说明:你每做完一个项目，马上获得的收益，可以支持你去做下 一个 项目。
 * 		输出: 你最后获得的最大钱数。
 */
public class N_05_项目花费少收益最大 {


	public static class Node {

		/**
		 * 收益
		 */
		public int p;

		/**
		 * 花费
		 */
		public int c;

		public Node(int p, int c) {
			this.p = p;
			this.c = c;
		}
	}

	public static class MinCostComparator implements Comparator<Node> {

		public int compare(Node o1, Node o2) {
			return o1.c - o2.c;
		}
	}


	public static class MaxProComparator implements Comparator<Node> {


		public int compare(Node o1, Node o2) {
			return o2.p - o2.p;
		}
	}

	public static int getMaxProfit(int k, int M, int[] pro, int[] cost) {

		Node[] nodes = new Node[pro.length];
		for (int i = 0; i < pro.length; i++) {
			nodes[i] = new Node(pro[i], cost[i]);
		}
		PriorityQueue<Node> minCostQ = new PriorityQueue<Node>(pro.length, new MinCostComparator());

		PriorityQueue<Node> maxProQ = new PriorityQueue<Node>(pro.length, new MaxProComparator());

		for (int i = 0; i < nodes.length; i++) {
			minCostQ.add(nodes[i]);
		}

		for (int i = 0; i < k; i++) {

			while (!minCostQ.isEmpty() && minCostQ.peek().c <= M) {
				maxProQ.add(minCostQ.poll());
			}

			if (maxProQ.isEmpty()) {
				return M;
			}

			M += maxProQ.poll().p;

		}
		return M;
	}

}
