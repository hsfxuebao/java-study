package designpattern.memento.game;

/**
 * 守护者对象 保存游戏角色的状态
 */
public class Caretaker {

	// 只保存一次状态
	private Memento  memento;
	// GameRole
	//private ArrayList<Memento> mementos;
	//
	//private HashMap<String, ArrayList<Memento>> rolesMementos;

	public Memento getMemento() {
		return memento;
	}

	public void setMemento(Memento memento) {
		this.memento = memento;
	}
	
	
}
