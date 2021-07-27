package designpattern.strategy;

public class ToyDuck extends Duck{

	@Override
	public void display() {
		// TODO Auto-generated method stub
		System.out.println("���Ѽ");
	}

	//��Ҫ��д��������з���
	
	public void quack() {
		System.out.println("���Ѽ���ܽ�~~");
	}
	
	public void swim() {
		System.out.println("���Ѽ������Ӿ~~");
	}
	
	public void fly() {
		System.out.println("���Ѽ�������~~~");
	}
}
