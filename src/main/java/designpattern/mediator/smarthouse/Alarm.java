package designpattern.mediator.smarthouse;

//�����ͬ����
public class Alarm extends Colleague {

	//������
	public Alarm(Mediator mediator, String name) {
		super(mediator, name);
		// TODO Auto-generated constructor stub
		//�ڴ���Alarm ͬ�¶���ʱ�����Լ����뵽ConcreteMediator ������[����]
		mediator.Register(name, this);
	}

	public void SendAlarm(int stateChange) {
		SendMessage(stateChange);
	}

	@Override
	public void SendMessage(int stateChange) {
		// TODO Auto-generated method stub
		//���õ��н��߶����getMessage
		this.GetMediator().GetMessage(stateChange, this.name);
	}

}
