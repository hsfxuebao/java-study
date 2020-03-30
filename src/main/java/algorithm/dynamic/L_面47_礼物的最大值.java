package algorithm.dynamic;

/**
 * @author haoshaofei
 * @date 2020/03/30
 *
 * 在一个 m*n 的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值（价值大于 0）。你可以从棋盘的左上角开始拿格子里的礼物，并每次向右或者向下移动一格、直到到达棋盘的右下角。给定一个棋盘及其上面的礼物的价值，请计算你最多能拿到多少价值的礼物？
 *
 *  
 *
 * 示例 1:
 *
 * 输入:
 * [
 *   [1,3,1],
 *   [1,5,1],
 *   [4,2,1]
 * ]
 * 输出: 12
 * 解释: 路径 1→3→5→2→1 可以拿到最多价值的礼物
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/li-wu-de-zui-da-jie-zhi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L_面47_礼物的最大值 {

	//动态规划
	public static int maxValue(int[][] grid) {
		int row = grid.length;
		int col = grid[0].length;

		int[][] dp = new int[row][col];

		//初始化
		dp[0][0] = grid[0][0];
		for (int i = 1; i < row; i++) {
			dp[i][0] = dp[i-1][0] + grid[i][0];
		}
		for (int j = 1; j < col; j++) {
			dp[0][j] = dp[0][j-1] + grid[0][j];

		}

		for (int i = 1; i < row; i++) {
			for (int j = 1; j < col; j++) {
				dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]) + grid[i][j];
			}
		}

		return dp[row-1][col-1];
	}

	public static void main(String[] args) {

		int[][] grid = {{1,3,1},
				{1,5,1},
				{4,2,1}};
		System.out.println(maxValue(grid));
	}
}
