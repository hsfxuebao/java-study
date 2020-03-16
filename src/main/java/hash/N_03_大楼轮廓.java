package hash;

/**
 * @author haoshaofei
 * @date 2020/03/16
 */

import com.google.common.collect.Lists;

import java.util.*;

/**
 *
 * 给定一个N行3列二维数组，每一行表示有一座大楼，一共有N座 大楼。 所有大楼的底部都坐落在X轴上，
 * 每一行的三个值 (a,b,c)代表每座大楼的从(a,0)点开始，到 (b,0)点结束，高 度为c。
 * 输入的数据可以保证a<b,且a，b，c均为正数。大楼之 间可以有重合。
 * 请输出整体的轮廓线。 例子:给定一个二维数组 [ [1, 3, 3], [2, 4, 4], [5, 6, 1] ]
 *
 * 输出为轮廓线[ [1,2,3], [2,4,4], [5,6,1]]
 */
public class N_03_大楼轮廓 {

	public static class Node{

		/**
		 * 是否向上
		 */
		public boolean isUp;
		/**
		 * x位置
		 */
		public int posi;
		/**
		 * 高度
		 */
		public int h;

		public Node(boolean isUp, int posi, int h) {
			this.isUp = isUp;
			this.posi = posi;
			this.h = h;
		}

	}

	public static class NodeComparator implements Comparator<Node> {

		public int compare(Node o1, Node o2) {
			if (o1.posi != o2.posi) {
				return o1.posi - o2.posi;
			}
			if (o1.isUp != o2.isUp) {
				return o1.isUp ? -1 : 1;
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

		//排序
		Arrays.sort(nodes, new NodeComparator());

		//key:高度 value:次数
		TreeMap<Integer, Integer> htMap = new TreeMap<Integer, Integer>();
		//key:位置x  value:高度最大值
		TreeMap<Integer, Integer> pmMap = new TreeMap<Integer, Integer>();

		for (int i = 0; i < nodes.length; i++) {
			if (nodes[i].isUp) {
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
				pmMap.put(nodes[i].posi, 0);
			} else {
				pmMap.put(nodes[i].posi, htMap.lastKey());
			}
		}


		List<List<Integer>> res = Lists.newArrayList();
		int start = 0;
		int height = 0;
		for (Map.Entry<Integer, Integer> entry : pmMap.entrySet()) {
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

	public static void main(String[] args) {

		int[][] res = {
				{1, 3, 3},
				{2, 4, 4},
				{5, 6, 1}
			};
		List<List<Integer>> lists = buildingOutline(res);


	}

}
