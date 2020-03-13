package offer;

import java.util.ArrayList;

/**
 * @author haoshaofei
 * @date 2020/03/13
 *
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，例如，如果输入如下4 X 4矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 */
public class O_19_顺时针打印矩阵 {

	public ArrayList<Integer> printMatrix(int[][] matrix) {
		if (matrix.length == 0 || matrix[0].length == 0) {
			return new ArrayList<>();
		}

		ArrayList<Integer> res = new ArrayList<>();
		process(matrix, res, 0, matrix.length - 1, 0, matrix[0].length - 1);

		return res;
	}

	private ArrayList<Integer> process(int[][] array, ArrayList<Integer> list,
									   int top, int down,
									   int left, int right) {
		if (left > right || top > down) {
			return list;
		}

		for (int i = left; i <= right; i++) {
			list.add(array[top][i]);
		}
		for (int i = top + 1; i < down; i++) {
			list.add(array[i][right]);
		}
		if (top != down) {
			for (int i = right; i >= left; i--) {
				list.add(array[down][i]);
			}
		}
		if (left != right) {
			for (int i = down - 1; i > top; i--) {
				list.add(array[i][left]);
			}
		}
		return process(array, list, top + 1, down - 1, left + 1, right - 1);
	}

	public static void main(String[] args) {
		O_19_顺时针打印矩阵 s = new O_19_顺时针打印矩阵();
		s.printMatrix(new int[][]{{1}, {2}, {3}, {4}, {5}});
	}
}