package designpattern.iterator;

import java.util.Iterator;
import java.util.List;

public class OutPutImpl {
	
	//ѧԺ����
	List<College> collegeList;

	public OutPutImpl(List<College> collegeList) {
		
		this.collegeList = collegeList;
	}
	//��������ѧԺ,Ȼ�����printDepartment �������ѧԺ��ϵ
	public void printCollege() {
		
		//��collegeList ȡ������ѧԺ, Java �е� List �Ѿ�ʵ��Iterator
		Iterator<College> iterator = collegeList.iterator();
		
		while(iterator.hasNext()) {
			//ȡ��һ��ѧԺ
			College college = iterator.next();
			System.out.println("=== "+college.getName() +"=====" );
			printDepartment(college.createIterator()); //�õ���Ӧ������
		}
	}
	
	
	//��� ѧԺ��� ϵ
	
	public void printDepartment(Iterator iterator) {
		while(iterator.hasNext()) {
			Department d = (Department)iterator.next();
			System.out.println(d.getName());
		}
	}
	
}
