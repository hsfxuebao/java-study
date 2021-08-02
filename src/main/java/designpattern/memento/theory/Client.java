package designpattern.memento.theory;

/**
 * 备忘录模式
 */
public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Originator originator = new Originator();
		Caretaker caretaker = new Caretaker();
		
		originator.setState("状态1 攻击力100");
		
		//�����˵�ǰ��״̬
		caretaker.add(originator.saveStateMemento());
		
		originator.setState("状态2 攻击力80");
		
		caretaker.add(originator.saveStateMemento());
		
		originator.setState("状态3 攻击力60");
		caretaker.add(originator.saveStateMemento());
		
		
		
		System.out.println("当前的状态是=" + originator.getState());
		
		// 希望得到的状态1 将originator 恢复到状态1
		
		originator.getStateFromMemento(caretaker.get(0));
		System.out.println("回复到状态1 当前状态是");
		System.out.println("当前状态是 =" + originator.getState());
		
		
		
	}

}
