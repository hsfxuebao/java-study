package designpattern.memento.theory;

import java.util.ArrayList;
import java.util.List;

public class Caretaker {
	
	//��List �����л��кܶ�ı���¼����
	private List<Memento> mementoList = new ArrayList<Memento>();
	
	public void add(Memento memento) {
		mementoList.add(memento);
	}
	
	//��ȡ����index��Originator �� ����¼����(������״̬)
	public Memento get(int index) {
		return mementoList.get(index);
	}
}
