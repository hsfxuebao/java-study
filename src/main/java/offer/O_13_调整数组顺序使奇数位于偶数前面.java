package offer;

/**
 * @author haoshaofei
 * @date 2020/03/13
 *
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 */
public class O_13_调整数组顺序使奇数位于偶数前面 {

    /**
     * 1.申请数组，O（N）的额外空间复杂度
     * 2.利用插入排序的思想，O（N^2）的额外时间复杂度
     */
    public void reOrderArray(int [] array) {
        int[] arr = new int[array.length];

        int odd = 0;
        int even = arr.length-1;

        for (int i = 0,j = arr.length-1;i < arr.length;i++,j--) {
            if (array[i] % 2 != 0) {
                arr[odd++] = array[i];
            }
            if (array[j] % 2 == 0) {
                arr[even--] = array[j];
            }
        }

        for (int i = 0;i < array.length;i++) {
            array[i] = arr[i];
        }
    }
}