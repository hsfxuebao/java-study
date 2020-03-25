package algorithm.review;

/**
 * @author haoshaofei
 * @date 2020/03/19
 *
 * 不用加减乘除做加减乘除（位运算）
 */
public class R_04_加减乘除位运算 {


	/**
	 * 加法
	 * @param a
	 * @param b
	 * @return
	 */
	public int add(int a ,int b){
		int carry;
		while (b != 0){
			carry = (a & b) << 1;
			a = a ^b;
			b = carry;
		}
		return a;
	}

	/**
	 * 减法
	 */
	public int subtraction(int a ,int b){
		b = ~b+1;
		return this.add(a,b);
	}


	/**
	 * 乘法
	 */
	int multiplication(int a,int b){
		int i = 0;
		int res = 0;
		//乘数不为 0
		while (b != 0){
			//处理当前位
			//当前位是 1
			if ((b & 1) == 1){
				res += (a << i);
				b = b >> 1;
				//记录当前是第几位
				i++;
			}else {
				//当前位是 0
				b = b >> 1;
				i++;
			}
		}
		return res;
	}

	/**
	 * 除法
	 */
	int division(int a,int b){
		int res;
		if(a<b){
			return 0;
		}else{
			res=division(subtraction(a, b), b)+1;
		}
		return res;
	}


}
