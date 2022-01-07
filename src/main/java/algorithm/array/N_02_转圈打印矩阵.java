package algorithm.array;

/**
 * @author hsfxuebao
 * @date 2020/03/16
 */

import algorithm.util.PrintUtils;

/**
 * 转圈打印矩阵
 * 【题目】 给定一个整型矩阵matrix，请按照转圈的方式打印它。 例如:1 2 3 45 6 7 89 10 11 121314
 * 15 16 打印结果为:1，2，3，4，8，12，16，15，14，13，9， 5，6，7，11， 10
 * 【要求】 额外空间复杂度为O(1)。
 */

public class N_02_转圈打印矩阵 {


	public static void rotate(int[][] matrix) {
		int tR = 0;
		int tC = 0;
		int dR = matrix.length - 1;
		int dC = matrix[0].length - 1;
		while (tR < dR) {
			printEdge(matrix, tR++, tC++, dR--, dC--);
		}
	}


	/**
	 * 转圈打印矩阵
	 * @param m
	 * @param tR
	 * @param tC
	 * @param dR
	 * @param dC
	 */
	public static void printEdge(int[][] m, int tR, int tC, int dR, int dC) {
		if (tR == dR) {
			for (int i = tC; i <= dC; i++) {
				System.out.print(m[tR][i] + " ");
			}
		} else if (tC == dC) {
			for (int i = tR; i <= dR; i++) {
				System.out.print(m[i][tC] + " ");
			}
		} else {
			int curC = tC;
			int curR = tR;
			while (curC != dC) {
				System.out.print(m[tR][curC] + " ");
				curC++;
			}
			while (curR != dR) {
				System.out.print(m[curR][dC] + " ");
				curR++;
			}
			while (curC != tC) {
				System.out.print(m[dR][curC] + " ");
				curC--;
			}
			while (curR != tR) {
				System.out.print(m[curR][tC] + " ");
				curR--;
			}
		}
	}


	public static void main(String[] args) {

		int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 },
				{ 13, 14, 15, 16 } };
		PrintUtils.printMatrix(matrix);
		rotate(matrix);
		System.out.println("=========");
		PrintUtils.printMatrix(matrix);
	}
}
