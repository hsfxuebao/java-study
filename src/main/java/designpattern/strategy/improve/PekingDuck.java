package designpattern.strategy.improve;

public class PekingDuck extends Duck {

	
	//���籱��Ѽ���Է��裬���Ƿ��輼��һ��
	public PekingDuck() {
		// TODO Auto-generated constructor stub
		flyBehavior = new BadFlyBehavior();
		
	}
	
	@Override
	public void display() {
		// TODO Auto-generated method stub
		System.out.println("~~����Ѽ~~~");
	}
	
	

}
