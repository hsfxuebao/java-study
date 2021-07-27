package designpattern.memento.game;

public class GameRole {

	private int vit;
	private int def;
	
	//����Memento ,�����ݵ�ǰ��״̬�õ�Memento
	public Memento createMemento() {
		return new Memento(vit, def);
	}
	
	//�ӱ���¼���󣬻ָ�GameRole��״̬
	public void recoverGameRoleFromMemento(Memento memento) {
		this.vit = memento.getVit();
		this.def = memento.getDef();
	}
	
	//��ʾ��ǰ��Ϸ��ɫ��״̬
	public void display() {
		System.out.println("��Ϸ��ɫ��ǰ�Ĺ�������" + this.vit + " ������: " + this.def);
	}

	public int getVit() {
		return vit;
	}

	public void setVit(int vit) {
		this.vit = vit;
	}

	public int getDef() {
		return def;
	}

	public void setDef(int def) {
		this.def = def;
	}
	
	
}
