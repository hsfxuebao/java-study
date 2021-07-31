package designpattern.adapter.classadapter;

//被适配的类
public class Voltage220V {
	//输出220V
	public int output220V() {
		int src = 220;
		System.out.println("电压" + src + "伏");
		return src;
	}
}
