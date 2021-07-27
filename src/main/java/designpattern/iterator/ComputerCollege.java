package designpattern.iterator;

import java.util.Iterator;

public class ComputerCollege implements College {

	Department[] departments;
	int numOfDepartment = 0 ;// ���浱ǰ����Ķ������
	
	
	public ComputerCollege() {
		departments = new Department[5];
		addDepartment("Javaרҵ", " Javaרҵ ");
		addDepartment("PHPרҵ", " PHPרҵ ");
		addDepartment("������רҵ", " ������רҵ ");
		
	}
	
	
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "�����ѧԺ";
	}

	@Override
	public void addDepartment(String name, String desc) {
		// TODO Auto-generated method stub
		Department department = new Department(name, desc);
		departments[numOfDepartment] = department;
		numOfDepartment += 1;
	}

	@Override
	public Iterator createIterator() {
		// TODO Auto-generated method stub
		return new ComputerCollegeIterator(departments);
	}

}
