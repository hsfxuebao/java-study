package designpattern.mediator.smarthouse;

/**
 * 中介者模式
 */
public class ClientTest {

	public static void main(String[] args) {
		// 创建中介者对象
		Mediator mediator = new ConcreteMediator();
		
		Alarm alarm = new Alarm(mediator, "alarm");

		// 创建CoffeeMachine对象 并加入到 CoffeeMachine中hashMap中
		CoffeeMachine coffeeMachine = new CoffeeMachine(mediator,
				"coffeeMachine");
		
		Curtains curtains = new Curtains(mediator, "curtains");
		TV tV = new TV(mediator, "TV");
		
		// 让闹钟发出消息
		alarm.SendAlarm(0);
		coffeeMachine.FinishCoffee();
		alarm.SendAlarm(1);
	}

}
