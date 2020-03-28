package algorithm.array;

import algorithm.util.PrintUtils;
import jdk.nashorn.internal.runtime.AllocationStrategy;

import java.security.AllPermission;
import java.util.ArrayList;
import java.util.List;

/**
 * @author haoshaofei
 * @date 2020/03/27
 *
 * 幂集。编写一种方法，返回某集合的所有子集。集合中不包含重复的元素。
 *
 * 说明：解集不能包含重复的子集。
 *
 * 示例:
 *
 *  输入： nums = [1,2,3]
 *  输出：
 * [
 *   [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/power-set-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L_面0804_所有子集 {



	public static List<List<Integer>> subSets(int[] nums) {
		List<List<Integer>> allSubList = new ArrayList<>();
		List<Integer> list = new ArrayList<>();
		process(allSubList, list, nums, 0);
		return allSubList;
	}

	private static void process(List<List<Integer>> subList, List<Integer> tempList, int[] nums, int index) {

		subList.add(new ArrayList<>(tempList));
		for (int i = index; i < nums.length; i++) {
			//要当前值
			tempList.add(nums[i]);
			process(subList, tempList, nums, i + 1);
			//不要当前值
			tempList.remove(tempList.size() - 1);
		}

	}

	public static void main(String[] args) {

		int[] nums = {1,2,3};
		System.out.println(subSets(nums));

	}

}
