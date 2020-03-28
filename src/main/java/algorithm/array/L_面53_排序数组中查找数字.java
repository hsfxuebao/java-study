package algorithm.array;

/**
 * @author haoshaofei
 * @date 2020/03/28
 *
 * 统计一个数字在排序数组中出现的次数。
 *
 *
 *
 * 示例 1:
 *
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: 2
 */
public class L_面53_排序数组中查找数字 {

	//二分查找 k-0.5, k+0.5 两数应该插入的位置
	public static Integer getNumber(int[] arr, int target) {

		return binarySearch(arr, target + 0.5) - binarySearch(arr, target - 0.5);
	}

	private static Integer binarySearch(int[] arr, double target) {

		int length = arr.length;
		int left = 0;
		int right = length - 1;

		while (left <= right) {
			int mid = (left + right) >> 1;
			if (arr[mid] < target) {
				left = mid + 1;
			} else if (arr[mid] > target) {
				right = mid - 1;
			}
		}
		return left;
	}

	public static void main(String[] args) {
		int[] arr = {5,7,7,8,8,10};
		System.out.println(getNumber(arr, 8));
	}
}
