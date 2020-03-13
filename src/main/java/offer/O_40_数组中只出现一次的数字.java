package offer;

/**
 * @author haoshaofei
 * @date 2020/03/13
 *
 * 一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
 */
public class O_40_数组中只出现一次的数字 {

    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        int e = 0;
        for (int num : array) {
            e ^= num;
        }

        int shift = 0;
        for (int i = 1;i <= 32;i++) {
            if (((1 << i) & e) != 0) {
                shift = i;
                break;
            }
        }

        for (int i = 0;i < array.length;i++) {
            if (((1 << shift) & array[i]) != 0) {
                num1[0] ^= array[i];
            } else {
                num2[0] ^= array[i];
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2,4,3,6,3,2,5,5};
        O_40_数组中只出现一次的数字 s = new O_40_数组中只出现一次的数字();
        s.FindNumsAppearOnce(arr, new int[]{}, new int[]{});
    }
}