package designpattern.iterator;

import java.util.Iterator;

public interface College {
	
	public String getName();
	
	//����ϵ�ķ���
	public void addDepartment(String name, String desc);
	
	//����һ��������,����
	public Iterator  createIterator();
}
