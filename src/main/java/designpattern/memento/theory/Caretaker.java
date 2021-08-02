package designpattern.memento.theory;

import java.util.ArrayList;
import java.util.List;

public class Caretaker {
	
	// List 中很多的备忘录对象
	private List<Memento> mementoList = new ArrayList<Memento>();
	
	public void add(Memento memento) {
		mementoList.add(memento);
	}
	
	// 获取到第index 个 的备忘录对象
	public Memento get(int index) {
		return mementoList.get(index);
	}
}
