package designpattern.strategy.improve;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WildDuck wildDuck = new WildDuck();
		wildDuck.fly();//
		
		ToyDuck toyDuck = new ToyDuck();
		toyDuck.fly();
		
		PekingDuck pekingDuck = new PekingDuck();
		pekingDuck.fly();
		
		// 动态改变某个对象的行为 北京鸭子不能飞翔
		pekingDuck.setFlyBehavior(new NoFlyBehavior());
		System.out.println("北京鸭子的是飞翔能力");
		pekingDuck.fly();
	}

}
