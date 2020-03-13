package offer;

/**
 * @author haoshaofei
 * @date 2020/03/13
 *
 * 写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。
 */
public class O_48_不用加减乘除做加法 {

    /**
     * 注：本人是真的烦这种找规律或脑筋急转弯的问题
     */
    public int Add(int num1,int num2) {
        while(num2 != 0){
            int temp = num1 ^ num2; //异或
            num2 = (num1 & num2) << 1;
            num1 = temp;
        }
        return num1;
    }
}