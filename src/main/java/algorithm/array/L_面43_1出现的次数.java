package algorithm.array;

import javax.xml.ws.Holder;
import java.util.Collections;
import java.util.List;

/**
 * @author haoshaofei
 * @date 2020/03/29
 *
 *输入一个整数 n ，求1～n这n个整数的十进制表示中1出现的次数。
 *
 * 例如，输入12，1～12这些整数中包含1 的数字有1、10、11和12，1一共出现了5次。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：n = 12
 * 输出：5
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/1nzheng-shu-zhong-1chu-xian-de-ci-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L_面43_1出现的次数 {

	public  static int countDigitOne(int n) {

		if (n <= 0) {
			return 0;
		}
		int high = n;
		int low = 0;
		int cur = 0;
		int temp = 0;
		int index = 1;
		int total = 0;

		while (high != 0) {
			high = n / (int) Math.pow(10, index);
			temp = n % (int) Math.pow(10, index);
			cur = temp / (int) Math.pow(10, (index - 1));
			low = temp % (int) Math.pow(10, (index - 1));

			if (cur > 1) {
				total += (high + 1) * Math.pow(10, (index - 1));
			} else if (cur == 1) {
				total += high * Math.pow(10, (index - 1)) + (low + 1);
			} else {
				total += high * Math.pow(10, (index - 1));
			}
			index++;
		}
		return total;
	}

	public static void main(String[] args) {
		System.out.println(countDigitOne(12));

	}
}
