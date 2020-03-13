package newcoder.primary.stackque;

/**
 * 转圈打印矩阵
 * 【题目】 给定一个整型矩阵matrix，请按照转圈的方式打印它。 例如:1 2 3 45 6 7 89 10 11 121314
 * 15 16 打印结果为:1，2，3，4，8，12，16，15，14，13，9， 5，6，7，11， 10
 * 【要求】 额外空间复杂度为O(1)。
 */
public class Code_05_RotateMatrix {

	public static void rotate(int[][] matrix) {
		int tR = 0;
		int tC = 0;
		int dR = matrix.length - 1;
		int dC = matrix[0].length - 1;
		while (tR < dR) {
			rotateEdge(matrix, tR++, tC++, dR--, dC--);
		}
	}

	public static void rotateEdge(int[][] m, int tR, int tC, int dR, int dC) {
		int times = dC - tC; 
		int tmp = 0;
		for (int i = 0; i != times; i++) {
			tmp = m[tR][tC + i];
			m[tR][tC + i] = m[dR - i][tC];
			m[dR - i][tC] = m[dR][dC - i];
			m[dR][dC - i] = m[tR + i][dC];
			m[tR + i][dC] = tmp;
		}
	}

	public static void printMatrix(int[][] matrix) {
		for (int i = 0; i != matrix.length; i++) {
			for (int j = 0; j != matrix[0].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 },
				{ 13, 14, 15, 16 } };
		printMatrix(matrix);
		rotate(matrix);
		System.out.println("=========");
		printMatrix(matrix);

	}

}
