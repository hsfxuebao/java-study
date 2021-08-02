package designpattern.mediator.smarthouse;

// 具体的同事类
public class Alarm extends Colleague {

	public Alarm(Mediator mediator, String name) {
		super(mediator, name);
		// TODO Auto-generated constructor stub
		// 创建Alarm 对象，同事将自己放入 Mediator对象中
		mediator.Register(name, this);
	}

	public void SendAlarm(int stateChange) {
		SendMessage(stateChange);
	}

	@Override
	public void SendMessage(int stateChange) {
		// TODO Auto-generated method stub
		//调用中介者对象的 getMessage
		this.GetMediator().GetMessage(stateChange, this.name);
	}

}
