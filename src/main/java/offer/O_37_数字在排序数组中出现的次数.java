package offer;

/**
 * @author haoshaofei
 * @date 2020/03/13
 *
 * 统计一个数字在排序数组中出现的次数。
 */
public class O_37_数字在排序数组中出现的次数 {


    public int GetNumberOfK(int [] array , int k) {
        if (array.length == 0) {
            return 0;
        }

        int left = 0;
        int right = array.length-1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (array[mid] < k) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        if (array[left] != k) {
            return 0;
        }

        int tmp = left;
        left = 0;
        right = array.length-1;
        while (left < right) {
            int mid = left + (right - left + 1) / 2;
            if (array[mid] <= k) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }

        return right - tmp + 1;
    }
}