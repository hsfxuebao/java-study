package designpattern.strategy.improve;

public class WildDuck extends Duck {

	
	// 构造器 传入flyBehavior
	public  WildDuck() {
		// TODO Auto-generated constructor stub
		flyBehavior = new GoodFlyBehavior();
	}
	
	
	@Override
	public void display() {
		// TODO Auto-generated method stub
		System.out.println(" 野鸭子 ");
	}

}
