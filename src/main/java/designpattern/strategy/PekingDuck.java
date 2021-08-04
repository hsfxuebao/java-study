package designpattern.strategy;

public class PekingDuck extends Duck {

	@Override
	public void display() {
		// TODO Auto-generated method stub
		System.out.println("~~北京鸭子~~~");
	}
	
	//因为北京鸭子不能发现，所有需要重写 fly
	@Override
	public void fly() {
		// TODO Auto-generated method stub
		System.out.println("北京鸭子不能飞翔");
	}

}
