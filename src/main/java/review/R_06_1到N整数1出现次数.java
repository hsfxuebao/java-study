package review;

/**
 * @author haoshaofei
 * @date 2020/03/20
 *
 * 输入一个整数n，求从1到n这n个整数的十进制表示中1出现的次数。
 * 例如输入12，从1到12这些整数中包含1的数字有1， 10, 11和12；1一共出现了5次。
 *
 */
public class R_06_1到N整数1出现次数 {


	/**
	 * 故总结：
	 *
	 * 1、取第 i 位左边的数字（高位），乘以 10 ^(i−1) ，得到基础值 a 。
	 * 2、取第 i 位数字，计算修正值： 
	 * 1、如果大于 X，则结果为 a+ 10 ^(i−1) 。
	 * 2、如果小于 X，则结果为 a 。
	 * 3、如果等 X，则取第 i 位右边（低位）数字，设为 b ，最后结果为 a+b+1 。
	 *
	 * @param n ： 整数
	 * @param x ：0-9出现的次数，可以传
	 * @return
	 */
	public static int numberOf1Between1AndN(int n, int x){
		if(n < 0 || x < 1 || x > 9){
			return 0;
		}
		int curr, low, temp, high = n, i = 1, total = 0;
		while(high!=0){
			high = n / (int)Math.pow(10, i); //获取第i位的高位
			temp = n % (int)Math.pow(10, i); //
			curr = temp / (int)Math.pow(10, i-1); //获取第i位
			low = temp%(int)Math.pow(10, i-1); //获取第i位的低位
			if(curr == x){ //等于x
				total += high*(int)Math.pow(10, i-1)+ low + 1;
			}else if(curr < x){ //小于x
				total += high*(int) Math.pow(10, i-1);
			}else{ //大于x
				total += (high + 1) * (int)Math.pow(10, i-1);
			}
			i++;
		}
		return total;
	}

	public static void main(String[] args) {
		int nums = numberOf1Between1AndN(21354, 1);
		System.out.println(nums);
	}


}
