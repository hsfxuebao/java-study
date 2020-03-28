package algorithm.array;

/**
 * @author haoshaofei
 * @date 2020/03/28
 *
 * 搜索旋转数组。给定一个排序后的数组，包含n个整数，但这个数组已被旋转过很多次了，次数不详。请编写代码找出数组中的某个元素，假设数组元素原先是按升序排列的。若有多个相同元素，返回索引值最小的一个。
 *
 * 示例1:
 *
 *  输入: arr = [15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14], target = 5
 *  输出: 8（元素5在该数组中的索引）
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/search-rotate-array-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L_面1003_搜索旋转数组 {

	public static Integer getIndex(int[] arr, int target) {

		int length = arr.length;
		if (length == 0) {
			return -1;
		}
		int left = 0;
		int right = length - 1;

		while (left < right) {

			int mid = ((left + right) >> 1);
			//左值小于中值，说左边区间是升序
			if (arr[left] < arr[mid]) {
				if (arr[left] <= target && target <= arr[mid]) {
					right = mid;
				} else {
					left = mid + 1;
				}
				//左值大于中值，说明左半部分是升序，右半部分是升序,但是这两部分不是连续的
			} else if (arr[left] > arr[mid]) {
				if (arr[left] <= target || target <= arr[mid]) {
					right = mid;
				} else {
					left = mid + 1;
				}
				//左值等于中值，说明找到目标或者重复值
			} else {
				if (arr[left] != target) {
					left = left + 1;
				} else {
					right = left;
				}

			}

		}
		return arr[left] == target ? left : -1;
	}

	public static void main(String[] args) {
		int[] arr = {15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14};
		int[] arr1 = {15, 16, 19, 20, 25, 1, 3, 5, 5, 7, 10, 14};

		int target = 5;
		System.out.println(getIndex(arr, target));
		System.out.println(getIndex(arr1, target));
	}
}
