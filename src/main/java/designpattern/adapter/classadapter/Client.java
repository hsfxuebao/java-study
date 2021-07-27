package designpattern.adapter.classadapter;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(" === ��������ģʽ ====");
		Phone phone = new Phone();
		phone.charging(new VoltageAdapter());
	}

}
