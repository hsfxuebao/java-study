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
		
		//��̬�ı�ĳ���������Ϊ, ����Ѽ ���ܷ�
		pekingDuck.setFlyBehavior(new NoFlyBehavior());
		System.out.println("����Ѽ��ʵ�ʷ�������");
		pekingDuck.fly();
	}

}
