package designpattern.iterator;

import java.util.Iterator;


public class ComputerCollegeIterator implements Iterator {

	//����������ҪDepartment ���������ķ�ʽ���=>����
	Department[] departments;
	int position = 0; //������λ��
	
	
	
	
	public ComputerCollegeIterator(Department[] departments) {
		this.departments = departments;
	}

	//�ж��Ƿ�����һ��Ԫ��
	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		if(position >= departments.length || departments[position] == null) {
			return false;
		}else {
		
			return true;
		}
	}

	@Override
	public Object next() {
		// TODO Auto-generated method stub
		Department department = departments[position];
		position += 1;
		return department;
	}
	
	//ɾ���ķ�����Ĭ�Ͽ�ʵ��
	public void remove() {
		
	}

}
