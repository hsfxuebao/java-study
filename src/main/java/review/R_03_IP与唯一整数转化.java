package review;

/**
 * @author haoshaofei
 * @date 2020/03/16
 */

import org.apache.commons.lang3.StringUtils;

/**
 * 将ip装成唯一整数
 */

public class R_03_IP与唯一整数转化 {


	/**
	 * 将ip转成整数
	 * 原理：IP地址每段可以看成是8位无符号整数即0-255，把每段拆分成一个二进制形式组合起来，
	 * 然后把这个二进制数转变成
	 * 一个无符号32为整数。
	 *
	 * 举例：一个ip地址为10.0.3.193
	 * 每段数字             相对应的二进制数
	 * 10                   00001010
	 * 0                    00000000
	 * 3                    00000011
	 * 193                  11000001
	 * 组合起来即为：00001010 00000000 00000011 11000001,
	 * 转换为10进制就是：167773121，即该IP地址转换后的数字就是它了。
	 */
	public static long ip2int(String ip) {
		String[] items = ip.split("\\.");
		return Long.valueOf(items[0]) << 24
				| Long.valueOf(items[1]) << 16
				| Long.valueOf(items[2]) << 8 | Long.valueOf(items[3]);
	}


	/**
	 * 将整数转成ip
	 * 原理：把这个整数转换成一个32位二进制数。从左到右，每8位进行一下分割，
	 * 得到4段8位的二进制数，把这些二进制数转换成整数然后加上”.”就是这个ip地址了
	 *
	 * 举例:167773121
	 * 二进制表示形式为：00001010 00000000 00000011 11000001
	 * 分割成四段：00001010,00001010,00000011,11000001,分别转换为整数后加上“.”就得到了10.0.3.193。
	 */
	public static String int2ip(long ipInt) {
		StringBuilder sb = new StringBuilder();
		sb.append((ipInt >> 24) & 0xFF).append(".");
		sb.append((ipInt >> 16) & 0xFF).append(".");
		sb.append((ipInt >> 8) & 0xFF).append(".");
		sb.append(ipInt & 0xFF).append(".");


		return sb.toString();
	}


	public static void main(String[] args) {

		String ip = "10.0.3.193";
		System.out.println(ip2int(ip));

		Long ipLong = 167773121L;
		System.out.println(int2ip(ipLong));
	}
}
