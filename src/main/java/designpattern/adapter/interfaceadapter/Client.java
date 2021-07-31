package designpattern.adapter.interfaceadapter;

public class Client {
	public static void main(String[] args) {
		
		AbsAdapter absAdapter = new AbsAdapter() {
			//ֻ��Ҫȥ�������� ��Ҫʹ�� �ӿڷ���
			@Override
			public void m1() {
				// TODO Auto-generated method stub

				System.out.println("使用m1的方法");
			}
		};
		
		absAdapter.m1();
	}
}
