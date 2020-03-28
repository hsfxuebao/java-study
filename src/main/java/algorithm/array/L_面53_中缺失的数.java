package algorithm.array;

/**
 * @author haoshaofei
 * @date 2020/03/28
 *
 * 一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: [0,1,3]
 * 输出: 2
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/que-shi-de-shu-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L_面53_中缺失的数 {

	public static Integer getDiff(int[] arr) {

		int left = 0;
		int right = arr.length - 1;
		while (left <= right) {
			int mid = (right + left) >> 1;
			if (arr[mid] != mid) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		return left;
	}

	public static void main(String[] args) {
		int[] num = {0,1,3};
		System.out.println(getDiff(num));
	}
}
