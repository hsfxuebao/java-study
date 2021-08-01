package designpattern.iterator;

import java.util.Iterator;

public interface College {
	
	public String getName();
	
	// add 系的方法
	public void addDepartment(String name, String desc);
	
	// 返回一个迭代器，遍历
	public Iterator  createIterator();
}
