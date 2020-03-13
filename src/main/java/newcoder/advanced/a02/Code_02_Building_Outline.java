package newcoder.advanced.a02;

import java.util.*;
import java.util.Map.Entry;

// http://lintcode.com/zh-cn/problem/building-outline/

/**
 *
 * 给定一个N行3列二维数组，每一行表示有一座大楼，一共有N座大楼。 所有大楼的底部都坐落在X轴上，每一行的三个值(a,b,c)代表每座大楼的从(a,0)点开始，到 (b,0)点结束，高度为c。 输入的数据可以保证a<b,且a，b，c均为正数。大楼之间可以有重合。 请输出整体的轮廓线。
 * 例子:给定一个二维数组 [
 *   [1, 3, 3],
 *   [2, 4, 4],
 *   [5, 6, 1]
 * ]
 * 输出为轮廓线 [
 *   [1, 2, 3],
 *   [2, 4, 4],
 *   [5, 6, 1]
 *  ]
 */
public class Code_02_Building_Outline {
	public static class Node {
		public boolean be;
		public int p;
		public int h;

		public Node(boolean bORe, int position, int height) {
			be = bORe;
			p = position;
			h = height;
		}
	}

	private static class NodeComparator implements Comparator<Node> {
		@Override
		public int compare(Node o1, Node o2) {
			if (o1.p != o2.p) {
				return o1.p - o2.p;
			}
			if (o1.be != o2.be) {
				return o1.be ? -1 : 1;
			}
			return 0;
		}
	}

	public static List<List<Integer>> buildingOutline(int[][] buildings) {
		Node[] nodes = new Node[buildings.length * 2];
		for (int i = 0; i < buildings.length; i++) {
			nodes[i * 2] = new Node(true, buildings[i][0], buildings[i][2]);
			nodes[i * 2 + 1] = new Node(false, buildings[i][1], buildings[i][2]);
		}
		Arrays.sort(nodes, new NodeComparator());
		TreeMap<Integer, Integer> htMap = new TreeMap<>();
		TreeMap<Integer, Integer> pmMap = new TreeMap<>();
		for (int i = 0; i < nodes.length; i++) {
			if (nodes[i].be) {
				if (!htMap.containsKey(nodes[i].h)) {
					htMap.put(nodes[i].h, 1);
				} else {
					htMap.put(nodes[i].h, htMap.get(nodes[i].h) + 1);
				}
			} else {
				if (htMap.containsKey(nodes[i].h)) {
					if (htMap.get(nodes[i].h) == 1) {
						htMap.remove(nodes[i].h);
					} else {
						htMap.put(nodes[i].h, htMap.get(nodes[i].h) - 1);
					}
				}
			}
			if (htMap.isEmpty()) {
				pmMap.put(nodes[i].p, 0);
			} else {
				pmMap.put(nodes[i].p, htMap.lastKey());
			}
		}
		List<List<Integer>> res = new ArrayList<>();
		int start = 0;
		int height = 0;
		for (Entry<Integer, Integer> entry : pmMap.entrySet()) {
			int curPosition = entry.getKey();
			int curMaxHeight = entry.getValue();
			if (height != curMaxHeight) {
				if (height != 0) {
					List<Integer> newRecord = new ArrayList<Integer>();
					newRecord.add(start);
					newRecord.add(curPosition);
					newRecord.add(height);
					res.add(newRecord);
				}
				start = curPosition;
				height = curMaxHeight;
			}
		}
		return res;
	}

}
