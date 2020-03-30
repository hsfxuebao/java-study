package algorithm.dynamic;

import com.google.common.collect.ImmutableList;
import com.sun.org.apache.regexp.internal.RESyntaxException;
import com.sun.org.apache.xpath.internal.functions.FuncFalse;

import javax.crypto.Cipher;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author haoshaofei
 * @date 2020/03/30
 *
 * 设想有个机器人坐在一个网格的左上角，网格 r 行 c 列。机器人只能向下或向右移动，但不能走到一些被禁止的网格（有障碍物）。设计一种算法，寻找机器人从左上角移动到右下角的路径。
 *
 *
 *
 * 网格中的障碍物和空位置分别用 1 和 0 来表示。
 *
 * 返回一条可行的路径，路径由经过的网格的行号和列号组成。左上角为 0 行 0 列。
 *
 * 示例 1:
 *
 * 输入:
 * [
 *   [0,0,0],
 *   [0,1,0],
 *   [0,0,0]
 * ]
 * 输出: [[0,0],[0,1],[0,2],[1,2],[2,2]]
 * 解释:
 * 输入中标粗的位置即为输出表示的路径，即
 * 0行0列（左上角） -> 0行1列 -> 0行2列 -> 1行2列 -> 2行2列（右下角）
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/robot-in-a-grid-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L_面0802_迷路的机器人 {

	//深度优先搜索+路径记录
	public static List<List<Integer>> pathWithObstacles(int[][] obstacleGrid) {
		int row = obstacleGrid.length;
		int col = obstacleGrid[0].length;
		List<List<Integer>> ansList = new ArrayList<>();
		dfs(obstacleGrid, new boolean[row][col], 0, 0, ansList);
		return ansList;

	}


	private static boolean dfs(int[][] nums, boolean[][] visited, int i, int j, List<List<Integer>> result) {

		if (i < 0 || i >= nums.length || j < 0 || j >= nums[0].length
				|| visited[i][j] || nums[i][j] == 1) {
			return false;
		}
		result.add(Arrays.asList(i, j));
		if (i == nums.length - 1 && j == nums[0].length - 1) {
			return true;
		}
		visited[i][j] = true;
		if (dfs(nums, visited,i+1,j,result) || dfs(nums, visited, i, j+1, result)) {
			return true;
		}

		result.remove(result.size() - 1);

		return false;
	}


	public static void main(String[] args) {

		int[][] nums = {{0,0,0},
				{0,1,0},
				{0,0,0}};
		List<List<Integer>> lists = pathWithObstacles(nums);
		System.out.println(lists);
	}
}
