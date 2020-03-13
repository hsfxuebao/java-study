package offer;

import java.util.ArrayList;

/**
 * @author haoshaofei
 * @date 2020/03/13
 *
 * 输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
 */
public class O_29_最小的K个数 {

    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        if (input.length == 0 || k == 0 || k > input.length) {
            return new ArrayList<>();
        }

        ArrayList<Integer> res = new ArrayList<>();

        int[] arr = new int[input.length+1];
        int len = arr.length-1;
        for (int i = 1;i < arr.length;i++) {
            arr[i] = input[i-1];
        }

        for (int i = len/2;i >= 1;i--) {
            sink(arr, i, len);
        }

        while (len > 1) {
            swap(arr, 1, len--);
            sink(arr, 1, len);
        }

        for (int i = 0;i < k;i++) {
            res.add(arr[i+1]);
        }

        return res;
    }

    private void sink(int[] arr, int k, int len) {
        while (2 * k <= len) {
            int j = 2 * k;
            if (j < len && arr[j] < arr[j+1]) {
                j++;
            }
            if (arr[k] >= arr[j]) {
                break;
            }
            swap(arr, k, j);
            k = j;
        }
    }

    private void swap(int[] arr,int i,int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}