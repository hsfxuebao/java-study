package algorithm.array;

import java.util.Arrays;

/**
 * @author hsfxuebao
 * @date 2020/03/30
 *
 * 有个马戏团正在设计叠罗汉的表演节目，一个人要站在另一人的肩膀上。出于实际和美观的考虑，在上面的人要比下面的人矮一点且轻一点。已知马戏团每个人的身高和体重，请编写代码计算叠罗汉最多能叠几个人。
 *
 * 示例：
 *
 * 输入：height = [65,70,56,75,60,68] weight = [100,150,90,190,95,110]
 * 输出：6
 * 解释：从上往下数，叠罗汉最多能叠 6 层：(56,90), (60,95), (65,100), (68,110), (70,150), (75,190)
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/circus-tower-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L_面1708_马戏团人塔 {



	//动态规划，按照身高升序排序，身高相等后按体重降序：求，体重最长递增子序列
	public static int bestSeqAtIndexBydp(int[] height, int[] weight) {
		int len = height.length;
		int[][] person = new int[len][2];
		for (int i = 0; i < len; ++i) {
			person[i] = new int[]{height[i], weight[i]};
		}
		Arrays.sort(person, (a,b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);

		int[] dp = new int[len];
		for (int i = 0; i < len; i++) {
			int res = person[i][1];
			dp[i] = 1;
			for (int j = 0; j < i; j++) {
				if (res > person[j][1]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
		}
		return dp[len - 1];
	}


	//二分查找
	public static int bestSeqAtIndex(int[] height, int[] weight) {
		int len = height.length;
		int[][] person = new int[len][2];
		for (int i = 0; i < len; ++i) {
			person[i] = new int[]{height[i], weight[i]};
		}
		Arrays.sort(person, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
		int[] dp = new int[len];
		int res = 0;
		for (int[] pair : person) {
			/**
			 * [1] 该搜索键在范围内，但不是数组元素，由1开始计数，得“ - 插入点索引值”；
			 *
			 * [2] 该搜索键在范围内，且是数组元素，由0开始计数，得搜索值的索引值；
			 *
			 * [3] 该搜索键不在范围内，且小于范围（数组）内元素，返回–(fromIndex + 1)；
			 *
			 * [4] 该搜索键不在范围内，且大于范围（数组）内元素，返回 –(toIndex + 1)。
			 */
			int i = Arrays.binarySearch(dp, 0, res, pair[1]);
			if (i < 0) {
				i = -(i + 1);
			}
			dp[i] = pair[1];
			//若i== res表示递增子序列的数量
			if (i == res) {
				++res;
			}
		}
		return res;
	}


	public static void main(String[] args) {

		int[] height = {65,70,56,75,60,68};
		int[] weight = {100,150,90,190,95,110};
		System.out.println(bestSeqAtIndexBydp(height, weight));
		System.out.println(bestSeqAtIndex(height, weight));

	}

}
