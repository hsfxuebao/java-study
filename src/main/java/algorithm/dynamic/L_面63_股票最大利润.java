package algorithm.dynamic;

/**
 * @author haoshaofei
 * @date 2020/03/30
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
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/gu-piao-de-zui-da-li-run-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class L_面63_股票最大利润 {

	//
	public static int maxProfit(int[] prices) {
		if (prices == null || prices.length == 1) {
			return 0;
		}
		int len = prices.length;

		//记录当前的最小值
		int min = prices[0];
		int res = 0;
		for (int i = 1; i < len; i++) {
			res = Math.max(res, prices[i] - min);
			min = Math.min(min, prices[i]);
		}
		return res;
	}

	public static void main(String[] args) {

		int[] nums = {7,1,5,3,6,4};
		System.out.println(maxProfit(nums));
	}

}
