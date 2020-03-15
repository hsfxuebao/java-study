package sort;

/**
 * 荷兰国旗问题：
 * 给定一个数组arr，和一个数num，请把小于num的数放在数组的左边，
 * 等于num的数放在数组的中间，大于num的数放在数组的右边。
 * 要求额外空间复杂度O(1)，时间复杂度O(N)
 */
public class N_08_NetherlandsFlag {

	public static int[] partition(int[] arr, int l, int r, int p) {
		int less = l - 1;
		int more = r + 1;
		while (l < more) {
			if (arr[l] < p) {
				swap(arr, ++less, l++);
			} else if (arr[l] > p) {
				swap(arr, --more, l);
			} else {
				l++;
			}
		}
		return new int[] { less + 1, more - 1 };
	}

	// for test
	public static void swap(int[] arr, int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}

	// for test
	public static int[] generateArray() {
		int[] arr = new int[10];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int) (Math.random() * 3);
		}
		return arr;
	}

	// for test
	public static void printArray(int[] arr) {
		if (arr == null) {
			return;
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		int[] test = generateArray();

		printArray(test);
		int[] res = partition(test, 0, test.length - 1, 1);
		printArray(test);
		System.out.println(res[0]);
		System.out.println(res[1]);

	}
}
