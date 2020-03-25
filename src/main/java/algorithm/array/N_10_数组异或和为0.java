package algorithm.array;

import java.util.HashMap;

/**
 * @author haoshaofei
 * @date 2020/03/23
 *
 * 定义数组的异或和的概念: 数组中所有的数异或起来，得到的结果叫做数组的异或和， 比如数组{3,2,1}的异或和是，3^2^1 = 0
 *  * 给定一个数组arr，你可以任意把arr分成很多不相容的子数组，你的目的是: 分出来的子数组中，异或和为0的子数组最多。
 *  * 请返回:分出来的子数组中，异或和为0的子数组最多是多少?
 */
public class N_10_数组异或和为0 {


	public static int mostEOR(int[] arr) {
		int ans = 0;
		int xor = 0;
		int[] mosts = new int[arr.length];
		HashMap<Integer, Integer> map = new HashMap<>();
		map.put(0, -1);
		for (int i = 0; i < arr.length; i++) {
			xor ^= arr[i];
			if (map.containsKey(xor)) {
				int pre = map.get(xor);
				mosts[i] = pre == -1 ? 1 : (mosts[pre] + 1);
			}
			if (i > 0) {
				mosts[i] = Math.max(mosts[i - 1], mosts[i]);
			}
			//覆盖原来记录，异或和为sum的离最近的点
			map.put(xor, i);
			ans = Math.max(ans, mosts[i]);
		}
		return ans;
	}

	// for test
	public static int comparator(int[] arr) {
		if (arr == null || arr.length == 0) {
			return 0;
		}
		int[] eors = new int[arr.length];
		int eor = 0;
		for (int i = 0; i < arr.length; i++) {
			eor ^= arr[i];
			eors[i] = eor;
		}
		int[] mosts = new int[arr.length];
		mosts[0] = arr[0] == 0 ? 1 : 0;
		for (int i = 1; i < arr.length; i++) {
			mosts[i] = eors[i] == 0 ? 1 : 0;
			for (int j = 0; j < i; j++) {
				if ((eors[i] ^ eors[j]) == 0) {
					mosts[i] = Math.max(mosts[i], mosts[j] + 1);
				}
			}
			mosts[i] = Math.max(mosts[i], mosts[i - 1]);
		}
		return mosts[mosts.length - 1];
	}

	// for test
	public static int[] generateRandomArray(int maxSize, int maxValue) {
		int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int) ((maxValue + 1) * Math.random());
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

	// for test
	public static void main(String[] args) {
		int testTime = 500000;
		int maxSize = 300;
		int maxValue = 100;
		boolean succeed = true;
		for (int i = 0; i < testTime; i++) {
			int[] arr = generateRandomArray(maxSize, maxValue);
			int res = mostEOR(arr);
			int comp = comparator(arr);
			if (res != comp) {
				succeed = false;
				printArray(arr);
				System.out.println(res);
				System.out.println(comp);
				break;
			}
		}
		System.out.println(succeed ? "Nice!" : "Fucking fucked!");
	}


}
