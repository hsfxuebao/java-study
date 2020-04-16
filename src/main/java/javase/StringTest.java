package javase;

/**
 * @author haoshaofei
 * @date 2020/04/15
 */
public class StringTest {

	public static void main(String[] args) {

		//2：string的intern使用
		//s1是基本类型，比较值。s2是string实例，比较实例地址
		//字符串类型用equals方法比较时只会比较值
		String s1 = "a";
		String s2 = new String("a");
		//调用intern时,如果s2中的字符不在常量池，则加入常量池并返回常量的引用
		String s3 = s2.intern();
		System.out.println(s1 == s2);
		System.out.println(s1 == s3);

	}

}
