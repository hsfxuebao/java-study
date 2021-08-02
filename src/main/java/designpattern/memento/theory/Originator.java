package designpattern.memento.theory;

public class Originator {

	private String state;// 状态信息

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	
	// 一个方法  可以保存一个状态 对象Memento
	public Memento saveStateMemento() {
		return new Memento(state);
	}
	
	//ͨ 通过备忘录对象 恢复状态
	public void getStateFromMemento(Memento memento) {
		state = memento.getState();
	}
}
