package leetcode;

/**
 * @author haoshaofei
 * @date 2020/03/13
 *
 *
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 *
 * 示例 1:
 *
 * 输入: 121
 * 输出: true
 * 示例 2:
 *
 * 输入: -121
 * 输出: false
 * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 * 示例 3:
 *
 * 输入: 10
 * 输出: false
 * 解释: 从右向左读, 为 01 。因此它不是一个回文数。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindrome-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class X_009_回文数 {

	/**
	 *
	 * @param x
	 * @return
	 */
	public boolean isPalindrome(int x) {
		if (x < 0) {
			return false;
		}
		int copyX = x, reverse = 0;
		while (copyX > 0) {
			reverse = reverse * 10 + copyX % 10;
			copyX /= 10;
		}
		return x == reverse;
	}


	/**
	 * 好好思考下是否需要计算整个长度，比如 1234321，其实不然，我们只需要计算一半的长度即可，
	 * 就是在计算过程中的那个逆序数比不断除 10 的数大就结束计算即可，但是这也带来了另一个问题，
	 * 比如 10 的倍数的数 10010，它也会返回 true，所以我们需要对 10 的倍数的数再加个判断即可，代码如下所示。
	 * @param x
	 * @return
	 */
	public boolean isPalindrome1(int x) {
		if (x < 0 || (x != 0 && x % 10 == 0)) return false;
		int halfReverseX = 0;
		while (x > halfReverseX) {
			halfReverseX = halfReverseX * 10 + x % 10;
			x /= 10;
		}
		return halfReverseX == x || halfReverseX / 10 == x;
	}


}
