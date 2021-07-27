package designpattern.strategy;

public class PekingDuck extends Duck {

	@Override
	public void display() {
		// TODO Auto-generated method stub
		System.out.println("~~����Ѽ~~~");
	}
	
	//��Ϊ����Ѽ���ܷ��裬�����Ҫ��дfly
	@Override
	public void fly() {
		// TODO Auto-generated method stub
		System.out.println("����Ѽ���ܷ���");
	}

}
