package designpattern.iterator;

import java.util.Iterator;
import java.util.List;

public class OutPutImpl {
	
	// 学院集合
	List<College> collegeList;

	public OutPutImpl(List<College> collegeList) {
		
		this.collegeList = collegeList;
	}
	// 遍历所有学院，调用printDepartment 输出各个学院的专业
	public void printCollege() {
		
		//
		Iterator<College> iterator = collegeList.iterator();
		
		while(iterator.hasNext()) {
			// 去除一个学院
			College college = iterator.next();
			System.out.println("=== "+college.getName() +"=====" );
			printDepartment(college.createIterator()); // 得到对应的迭代器
		}
	}
	
	
	// 输出每一个学院的所有系
	
	public void printDepartment(Iterator iterator) {
		while(iterator.hasNext()) {
			Department d = (Department)iterator.next();
			System.out.println(d.getName());
		}
	}
	
}
