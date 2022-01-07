package algorithm.array;

/**
 * @author hsfxuebao
 * @date 2020/03/29
 * 编写一个函数，不用临时变量，直接交换numbers = [a, b]中a与b的值。
 *
 * 示例：
 *
 * 输入: numbers = [1,2]
 * 输出: [2,1]
 */
public class L_面1601_交换数字 {

	public int[] swapNumbers(int[] numbers) {
		numbers[0] = numbers[0] - numbers[1];
		numbers[1] = numbers[1] + numbers[0];
		numbers[0] = numbers[1] - numbers[0];
		return numbers;

	}


}
