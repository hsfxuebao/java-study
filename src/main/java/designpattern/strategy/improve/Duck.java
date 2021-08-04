package designpattern.strategy.improve;

public abstract class Duck {

	// 属性 策略模式
	FlyBehavior flyBehavior;
	// 其他属性
	QuackBehavior quackBehavior;
	
	public Duck() {
	
	}

	public abstract void display();//显示鸭子信息
	
	public void quack() {
		System.out.println("鸭子嘎嘎嘎叫~~");
	}
	
	public void swim() {
		System.out.println("鸭子游泳~~");
	}
	
	public void fly() {
		
		// 改进
		if(flyBehavior != null) {
			flyBehavior.fly();
		}
	}

	public void setFlyBehavior(FlyBehavior flyBehavior) {
		this.flyBehavior = flyBehavior;
	}
	
	
	public void setQuackBehavior(QuackBehavior quackBehavior) {
		this.quackBehavior = quackBehavior;
	}
	
	
	
}
