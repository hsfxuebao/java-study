package algorithm.array;

/**
 * @author hsfxuebao
 * @date 2020/03/20
 *
 * 假设把某股票的价格按照时间先后顺序存储在数组中，请问买卖该股票一次可能获得的最大利润是多少？
 *
 *
 *
 * 示例 1:
 *
 * 输入: [7,1,5,3,6,4]
 * 输出: 5
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 *      注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。
 */
public class L_面63_股票最大收益 {


	/**
	 * 可以求出序列两两之间的差值，然后开始累加，如果累加和为负数，
	 * 说明这不是最佳适合的买入点，可以清零，从后继续开始，找到累加和的最大值，更新即可。
	 */
	public static Integer getMaxProfit(int[] arr) {

		if (arr == null) {
			return 0;
		}
		int length = arr.length;
		int maxProfit = 0;
		for (int i = 1; i < length; i++) {
			maxProfit += arr[i] - arr[i-1];
			if (maxProfit < 0) {
				maxProfit = 0;
			}
		}

		return maxProfit;
	}

	public static void main(String[] args) {
		int[] arr = {100,80,120,130,70,60,100,125};
		System.out.println(getMaxProfit(arr));
	}

}
