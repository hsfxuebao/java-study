package algorithm.array;

/**
 * @author haoshaofei
 * @date 2020/03/29
 *
 * 给定M×N矩阵，每一行、每一列都按升序排列，请编写代码找出某元素。
 *
 * 示例:
 *
 * 现有矩阵 matrix 如下：
 *
 * [
 *   [1,   4,  7, 11, 15],
 *   [2,   5,  8, 12, 19],
 *   [3,   6,  9, 16, 22],
 *   [10, 13, 14, 17, 24],
 *   [18, 21, 23, 26, 30]
 * ]
 * 给定 target = 5，返回 true。
 *
 * 给定 target = 20，返回 false。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sorted-matrix-search-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L_面1009_排序矩阵中查找 {

	public static boolean searchMatrix(int[][] matrix, int target) {


		int row = matrix.length;
		int col = matrix[0].length;

		int i = 0;
		int j = col - 1;

		while (i < row && j >= 0) {
			if (matrix[i][j] < target) {
				i++;
			} else if (matrix[i][j] > target) {
				j--;
			} else {
				return true;
			}

		}
		return false;
	}

	public static void main(String[] args) {

		int[][] matrix = {
				{1,   4,  7, 11, 15},
		        {2,   5,  8, 12, 19},
			    {3,   6,  9, 16, 22},
				{10, 13, 14, 17, 24},
				{18, 21, 23, 26, 30}
		};
		int target = 1100;

		System.out.println(searchMatrix(matrix, target));
	}
}
