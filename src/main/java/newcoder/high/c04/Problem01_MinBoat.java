package newcoder.high.c04;

/**
 *
 * 给定一个数组arr，长度为N且每个值都是正数，代表N个人的体重。再给定一个正数 limit，代表一艘船的载重。以下是坐船规则，1)每艘船最多只能做两人;2)乘客 的体重和不能超过limit。返回如果同时让这N个人过河最少需要几条船。
 *
 */
public class Problem01_MinBoat {

	// 请保证arr有序
	public static int minBoat(int[] arr, int weight) {
		if (arr == null || arr.length == 0) {
			return 0;
		}
		int lessR = -1;
		for (int i = arr.length - 1; i >= 0; i--) {
			if (arr[i] <= (weight / 2)) {
				lessR = i;
				break;
			}
		}
		if (lessR == -1) {
			return arr.length;
		}
		int lessIndex = lessR;
		int moreIndex = lessR + 1;
		int lessUnused = 0;
		while (lessIndex >= 0) {
			int solved = 0;
			while (moreIndex < arr.length
					&& arr[lessIndex] + arr[moreIndex] <= weight) {
				moreIndex++;
				solved++;
			}
			if (solved == 0) {
				lessUnused++;
				lessIndex--;
			} else {
				lessIndex = Math.max(-1, lessIndex - solved);
			}
		}
		int lessAll = lessR + 1;
		int lessUsed = lessAll - lessUnused;
		int moreUnsolved = arr.length - lessR - 1 - lessUsed;
		return lessUsed + ((lessUnused + 1) >> 1) + moreUnsolved;
	}

	public static void main(String[] args) {
		int[] arr = { 1, 2, 2, 2, 2, 4, 4, 4, 4, 5 };
		int weight = 5;
		System.out.println(minBoat(arr, weight));
	}

}
