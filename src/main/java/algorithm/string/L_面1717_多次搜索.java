package algorithm.string;

import java.util.LinkedList;

/**
 * @author haoshaofei
 * @date 2020/03/29
 *
 * 给定一个较长字符串big和一个包含较短字符串的数组smalls，设计一个方法，根据smalls中的每一个较短字符串，对big进行搜索。输出smalls中的字符串在big里出现的所有位置positions，其中positions[i]为smalls[i]出现的所有位置。
 *
 * 示例：
 *
 * 输入：
 * big = "mississippi"
 * smalls = ["is","ppi","hi","sis","i","ssippi"]
 * 输出： [[1,4],[8],[],[3],[1,4,7,10],[5]]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/multi-search-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L_面1717_多次搜索 {

	private int[][] res;
	private String global_big;

	public int[][] multiSearch(String big, String[] smalls) {
		int len = smalls.length;
		res = new int[len][];
		global_big = big;
		for (int i = 0; i < len; ++i) {

			addToRes(i, smalls[i]);
		}
		return res;
	}

	private void addToRes(int position, String str) {
		if (str.equals("")) {
			res[position] = new int[0];
			return;
		}
		LinkedList<Integer> list = new LinkedList<>();
		int idx = 0;
		while ((idx = global_big.indexOf(str, idx) + 1) != 0) {

			list.addLast(idx - 1);
		}
		res[position] = list.stream().mapToInt(Integer::intValue).toArray();
	}



}
