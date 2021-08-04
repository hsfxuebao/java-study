package designpattern.strategy;

public class ToyDuck extends Duck{

	@Override
	public void display() {
		// TODO Auto-generated method stub
		System.out.println("玩具鸭子");
	}

	// 需要重写所有的方法
	
	public void quack() {
		System.out.println("玩具燕子不能嘎嘎叫~~");
	}
	
	public void swim() {
		System.out.println("玩具鸭子不能游泳~~");
	}
	
	public void fly() {
		System.out.println("玩具鸭子不能飞翔~~~");
	}
}
