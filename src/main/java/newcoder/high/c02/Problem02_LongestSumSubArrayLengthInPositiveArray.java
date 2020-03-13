package newcoder.high.c02;

/**
 *   给定一个数组 arr，该数组无序，但每个值均为正数，再给定一个正数 k。求 arr 的 所有子 数组中所有元素相加和为 k 的最长子数组长度。 例如，arr=[1,2,1,1,1]，k=3。
 * 累加和为 3 的最长子数组为[1,1,1]，所以结果返回 3。 要求:时间复杂度O(N)，额外空间复杂度O(1)
 */
public class Problem02_LongestSumSubArrayLengthInPositiveArray {

	public static int getMaxLength(int[] arr, int k) {
		if (arr == null || arr.length == 0 || k <= 0) {
			return 0;
		}
		int left = 0;
		int right = 0;
		int sum = arr[0];
		int len = 0;
		while (right < arr.length) {
			if (sum == k) {
				len = Math.max(len, right - left + 1);
				sum -= arr[left++];
			} else if (sum < k) {
				right++;
				if (right == arr.length) {
					break;
				}
				sum += arr[right];
			} else {
				sum -= arr[left++];
			}
		}
		return len;
	}

	public static int[] generatePositiveArray(int size) {
		int[] result = new int[size];
		for (int i = 0; i != size; i++) {
			result[i] = (int) (Math.random() * 10) + 1;
		}
		return result;
	}

	public static void printArray(int[] arr) {
		for (int i = 0; i != arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		int len = 20;
		int k = 15;
		int[] arr = generatePositiveArray(len);
		printArray(arr);
		System.out.println(getMaxLength(arr, k));

	}

}
