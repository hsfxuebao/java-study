package algorithm.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hsfxuebao
 * @date 2020/03/30
 *
 * 给定一个方阵，其中每个单元(像素)非黑即白。设计一个算法，找出 4 条边皆为黑色像素的最大子方阵。
 *
 * 返回一个数组 [r, c, size] ，其中 r, c 分别代表子方阵左上角的行号和列号，size 是子方阵的边长。若有多个满足条件的子方阵，返回 r 最小的，若 r 相同，返回 c 最小的子方阵。若无满足条件的子方阵，返回空数组。
 *
 * 示例 1:
 *
 * 输入:
 * [
 *    [1,0,1],
 *    [0,0,1],
 *    [0,0,1]
 * ]
 * 输出: [1,0,2]
 * 解释: 输入中 0 代表黑色，1 代表白色，标粗的元素即为满足条件的最大子方阵
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/max-black-square-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L_面1723_最大黑方阵 {


	public static List<Integer> findSquare(int[][] matrix) {
		ArrayList<Integer> result = new ArrayList<>();
		if (matrix == null) {
			return result;
		}
		int row = matrix.length;
		int col = matrix[0].length;
		int[][] right = new int[row][col];
		int[][] down = new int[row][col];
		setBoardMap(matrix,right,down);

		for (int size = Math.min(row, col); size > 0 ; size--) {
			List<Integer> list = hasSizeOfBoard(size, right, down, result);
			if (list.size() > 0) {
				list.add(size);
				return result;
			}
		}
		return result;

	}

	private static List<Integer> hasSizeOfBoard(int size, int[][] right, int[][] down, List<Integer> result) {

		int row = right.length;
		int col = right[0].length;

		for (int i = 0; i < row - size + 1; i++) {
			for (int j = 0; j < col - size + 1; j++) {
				if (right[i][j] >= size && down[i][j] >= size
						&& right[i + size - 1][j] >= size && down[i][j + size - 1] >= size) {
					result.add(i);
					result.add(j);
					return result;
				}
			}
		}
		return result;
	}

	public static void setBoardMap(int[][] matrix, int[][] right, int[][] down) {
		int row = matrix.length;
		int col = matrix[0].length;

		//初始化
		if (matrix[row - 1][col - 1] == 0) {
			right[row-1][col-1] = 1;
			down[row-1][col-1] = 1;
		}

		for (int i = row-2; i >= 0 ; i--) {
			if (matrix[i][col - 1] == 0) {
				right[i][col - 1] = 1;
				down[i][col-1] = down[i+1][col-1] + 1;
			}
		}
		for (int j = col-2; j >= 0; j--) {
			if (matrix[row - 1][j] == 0) {
				down[row-1][j] = 1;
				right[row-1][j] = right[row-1][j+1] + 1;
			}

		}

		for (int i = row-2; i >= 0; i--) {
			for (int j = col-2; j >= 0; j--) {
				if (matrix[i][j] == 0) {
					right[i][j] = right[i][j+1] + 1 ;
					down[i][j] = down[i+1][j] + 1;
				}
			}
		}

	}

	public static void main(String[] args) {

		int[][] matrix = {{1,0,1},
				{0,0,1},
				{0,0,1}};
		System.out.println(findSquare(matrix));

		int[][] matrix1 = {{0,1,1},
				{1,0,1},
				{1,1,0}};
		System.out.println(findSquare(matrix1));
	}
}
