package offer;

/**
 * @author haoshaofei
 * @date 2020/03/13
 *
 * 给定一个数组A[0, 1, ..., n-1],请构建一个数组B[0,1,...,n-1],其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。不能使用除法。
 */
public class O_51_构建乘积数组 {

    /**
     * 比较无聊的题
     */
    public int[] multiply(int[] A) {
        int[] B = new int[A.length];
        if(A == null || A.length == 0){
            return B;
        }
        B[0] = 1;
        if(A.length == 1){
            B[0] = 0;
            return B;
        }
        for(int i = 1;i < A.length;i++){
            B[i] =  A[i-1] * B[i-1];
        }
        int c = 1;
        for(int i = A.length -2;i >= 0;i--){
            A[i+1] = A[i+1] * c;
            B[i] = B[i] * A[i+1];
            c = A[i+1];
        }
        return B;

    }
}