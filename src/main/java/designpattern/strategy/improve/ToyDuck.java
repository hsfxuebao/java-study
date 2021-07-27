package designpattern.strategy.improve;

public class ToyDuck extends Duck{

	
	public ToyDuck() {
		// TODO Auto-generated constructor stub
		flyBehavior = new NoFlyBehavior();
	}
	
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
	
	
}
