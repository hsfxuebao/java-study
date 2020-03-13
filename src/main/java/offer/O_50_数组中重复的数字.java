package offer;

/**
 * @author haoshaofei
 * @date 2020/03/13
 *
 * 在一个长度为n的数组里的所有数字都在0到n-1的范围内。 数组中某些数字是重复的，但不知道有几个数字是重复的。也不知道每个数字重复几次。请找出数组中任意一个重复的数字。 例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是第一个重复的数字2。
 */
public class O_50_数组中重复的数字 {

    /**
     * 因为数组类面的数字都是0~n-1,所以相当于判断链表是否有环。
     * （下面是网上的解答，说是O(n)时间复杂度，但感觉下面的算法时间复杂度达不到O（n），不过通过判断链表是否有环可以达到）
     */
    public boolean duplicate(int numbers[],int length,int [] duplication) {
        if (numbers == null || numbers.length == 0) {
            return false;
        }

        for (int i = 0;i < numbers.length;i++) {
            while (numbers[i] != i) {
                if (numbers[i] == numbers[numbers[i]]) {
                    duplication[0] = numbers[i];
                    return true;
                }
                swap(numbers, i, numbers[i]);
            }
        }

        return false;
    }

    private void swap(int[] arr,int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}