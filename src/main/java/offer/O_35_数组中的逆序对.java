package offer;

/**
 * @author haoshaofei
 * @date 2020/03/13
 *
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组,求出这个数组中的逆序对的总数P。并将P对1000000007取模的结果输出。 即输出P%1000000007
 */
public class O_35_数组中的逆序对 {

    /**
     * 因为要输出P%1000000007，比较烦人。 后续没有coding，只是把之前的赋值上去
     * 归并排序来结局
     */
    int count = 0;
    public int InversePairs(int [] array) {
        if(array == null || array.length == 0){
            return 0;
        }
        part(array,0,array.length-1);
        return count;
    }

    private void part(int[] arr,int left,int right){
        if(left >= right){
            return ;
        }
        int mid = left + right >> 1 ;
        part(arr,left,mid);
        part(arr,mid+1,right);
        merge(arr,left,mid,right);
    }

    private void merge(int[] arr,int left,int mid,int right){
        int[] tmp = new int[right-left+1];

        int i = left;
        int j = mid+1;
        int k = 0;
        while(i <= mid && j <= right){
            if(arr[i] <= arr[j]){
                tmp[k++] = arr[i++];
            }else{
                tmp[k++] = arr[j++];
                count += mid - i + 1;
                count %= 1000000007;
            }
        }

        while(i <= mid){
            tmp[k++] = arr[i++];
        }
        while(j <= right){
            tmp[k++] = arr[j++];
        }
        for(int p = 0;p < tmp.length;p++){
            arr[left+p] = tmp[p];
        }
    }
}