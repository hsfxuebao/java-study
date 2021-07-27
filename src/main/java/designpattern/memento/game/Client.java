package designpattern.memento.game;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//������Ϸ��ɫ
		GameRole gameRole = new GameRole();
		gameRole.setVit(100);
		gameRole.setDef(100);
		
		System.out.println("��boss��սǰ��״̬");
		gameRole.display();
		
		//�ѵ�ǰ״̬����caretaker
		Caretaker caretaker = new Caretaker();
		caretaker.setMemento(gameRole.createMemento());
		
		System.out.println("��boss��ս~~~");
		gameRole.setDef(30);
		gameRole.setVit(30);
		
		gameRole.display();
		
		System.out.println("��ս��ʹ�ñ���¼����ָ���վǰ");
		
		gameRole.recoverGameRoleFromMemento(caretaker.getMemento());
		System.out.println("�ָ����״̬");
		gameRole.display();
	}

}
