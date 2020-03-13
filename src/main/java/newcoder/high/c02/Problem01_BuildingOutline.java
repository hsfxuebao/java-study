package newcoder.high.c02;

import java.util.*;
import java.util.Map.Entry;

public class Problem01_BuildingOutline {

	// 描述高度变化的对象
	public static class Node {
		public int x; // x轴上的值
		public boolean isAdd;// true为加入，false为删除
		public int h; // 高度

		public Node(int x, boolean isAdd, int h) {
			this.x = x;
			this.isAdd = isAdd;
			this.h = h;
		}
	}

	// 排序的比较策略
	// 1，第一个维度的x值从小到大。
	// 2，如果第一个维度的值相等，看第二个维度的值，“加入”排在前，“删除”排在后
	// 3，如果两个对象第一维度和第二个维度的值都相等，则认为两个对象相等，谁在前都行。
	public static class NodeComparator implements Comparator<Node> {
		@Override
		public int compare(Node o1, Node o2) {
			if (o1.x != o2.x) {
				return o1.x - o2.x;
			}
			if (o1.isAdd != o2.isAdd) {
				return o1.isAdd ? -1 : 1;
			}
			return 0;
		}
	}

	// 全部流程的主方法
	public static List<List<Integer>> buildingOutline(int[][] matrix) {
		Node[] nodes = new Node[matrix.length * 2];
		// 每一个大楼轮廓数组，产生两个描述高度变化的对象
		for (int i = 0; i < matrix.length; i++) {
			nodes[i * 2] = new Node(matrix[i][0], true, matrix[i][2]);
			nodes[i * 2 + 1] = new Node(matrix[i][1], false, matrix[i][2]);
		}

		// 把描述高度变化的对象数组，按照规定的排序策略排序
		Arrays.sort(nodes, new NodeComparator());

		// TreeMap就是java中的红黑树结构，直接当作有序表来使用
		TreeMap<Integer, Integer> mapHeightTimes = new TreeMap<>();
		TreeMap<Integer, Integer> mapXvalueHeight = new TreeMap<>();
		for (int i = 0; i < nodes.length; i++) {
			if (nodes[i].isAdd) { // 如果当前是加入操作
				if (!mapHeightTimes.containsKey(nodes[i].h)) { // 没有出现的高度直接新加记录
					mapHeightTimes.put(nodes[i].h, 1);
				} else { // 之前出现的高度，次数加1即可
					mapHeightTimes.put(nodes[i].h,
							mapHeightTimes.get(nodes[i].h) + 1);
				}
			} else { // 如果当前是删除操作
				if (mapHeightTimes.get(nodes[i].h) == 1) { // 如果当前的高度出现次数为1，直接删除记录
					mapHeightTimes.remove(nodes[i].h);
				} else { // 如果当前的高度出现次数大于1，次数减1即可
					mapHeightTimes.put(nodes[i].h,
							mapHeightTimes.get(nodes[i].h) - 1);
				}
			}

			// 根据mapHeightTimes中的最大高度，设置mapXvalueHeight表
			if (mapHeightTimes.isEmpty()) { // 如果mapHeightTimes为空，说明最大高度为0
				mapXvalueHeight.put(nodes[i].x, 0);
			} else { // 如果mapHeightTimes不为空，通过mapHeightTimes.lastKey()取得最大高度
				mapXvalueHeight.put(nodes[i].x, mapHeightTimes.lastKey());
			}
		}
		// res为结果数组，每一个List<Integer>代表一个轮廓线，有开始位置，结束位置，高度，一共三个信息
		List<List<Integer>> res = new ArrayList<>();
		// 一个新轮廓线的开始位置
		int start = 0;
		// 之前的最大高度
		int preHeight = 0;
		// 根据mapXvalueHeight生成res数组
		for (Entry<Integer, Integer> entry : mapXvalueHeight.entrySet()) {
			// 当前位置
			int curX = entry.getKey();
			// 当前最大高度
			int curMaxHeight = entry.getValue();
			if (preHeight != curMaxHeight) { // 之前最大高度和当前最大高度不一样时
				if (preHeight != 0) {
					res.add(new ArrayList<>(Arrays.asList(start, curX, preHeight)));
				}
				start = curX;
				preHeight = curMaxHeight;
			}
		}
		return res;
	}

}
