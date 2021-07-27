package designpattern.visitor;

import java.util.LinkedList;
import java.util.List;

//���ݽṹ������ܶ��ˣ�Man , Woman��
public class ObjectStructure {

	//ά����һ������
	private List<Person> persons = new LinkedList<>();
	
	//���ӵ�list
	public void attach(Person p) {
		persons.add(p);
	}
	//�Ƴ�
	public void detach(Person p) {
		persons.remove(p);
	}
	
	//��ʾ�������
	public void display(Action action) {
		for(Person p: persons) {
			p.accept(action);
		}
	}
}
