package algorithm.array;

import algorithm.util.PrintUtils;
import org.omg.CORBA.MARSHAL;

/**
 * @author haoshaofei
 * @date 2020/03/27
 * 编写一种算法，若M × N矩阵中某个元素为0，则将其所在的行与列清零。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：
 * [
 *   [1,1,1],
 *   [1,0,1],
 *   [1,1,1]
 * ]
 * 输出：
 * [
 *   [1,0,1],
 *   [0,0,0],
 *   [1,0,1]
 * ]
 *
 *
 */
public class L_面0108_零矩阵 {


	/**
	 * 	用两个一维数组（初始化元素为1）分别记录要清零的行，
	 * 	然后根据matrix[i][j]*=row[i]*col[j];计算出矩阵的元素值即可
	 */
	public static void setZeroes(int[][] matrix) {
		int[] row = new int[matrix.length];
		int[] col = new int[matrix[0].length];

		for (int i = 0; i < row.length; i++) {
			row[i] = 1;
		}
		for (int i = 0; i < col.length; i++) {
			col[i] = 1;
		}
		for (int i = 0; i < row.length; i++) {
			for (int j = 0; j < col.length; j++) {
				if (matrix[i][j] == 0) {
					row[i] = 0;
					col[j] = 0;
				}
			}
		}

		for (int i = 0; i < row.length; i++) {

			for (int j = 0; j < col.length; j++) {
				matrix[i][j] *= row[i] * col[j];
			}
		}

	}

	public static void main(String[] args) {

		int[][] matrix = {
				{1,1,1},
				{1,0,1},
				{1,1,1}
		};
		setZeroes(matrix);
		PrintUtils.printMatrix(matrix);

	}
}
