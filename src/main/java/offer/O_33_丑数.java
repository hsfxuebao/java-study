package offer;

/**
 * @author haoshaofei
 * @date 2020/03/13
 *
 * 把只包含质因子2、3和5的数称作丑数（Ugly Number）。例如6、8都是丑数，但14不是，因为它包含质因子7。 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
 */
public class O_33_丑数 {

    public int GetUglyNumber_Solution(int index) {
        if (index < 7) {
            return index;
        }

        int[] arr = new int[index];
        arr[0] = 1;
        int i = 0;
        int j = 0;
        int k = 0;

        for (int p = 1;p < index;p++) {
            arr[p] = Math.min(arr[i]*2, Math.min(arr[j]*3, arr[k]*5));
            if (arr[p] == arr[i] * 2) {
                i++;
            }
            if (arr[p] == arr[j] * 3) {
                j++;
            }
            if (arr[p] == arr[k] * 5) {
                k++;
            }
        }

        return arr[index-1];
    }
}