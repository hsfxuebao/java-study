package designpattern.adapter.classadapter;

//���������
public class Voltage220V {
	//���220V�ĵ�ѹ
	public int output220V() {
		int src = 220;
		System.out.println("��ѹ=" + src + "��");
		return src;
	}
}
