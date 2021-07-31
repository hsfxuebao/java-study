package designpattern.composite;

import java.util.ArrayList;
import java.util.List;

public class College extends OrganizationComponent {

	//List 里面包含  Department
	List<OrganizationComponent> organizationComponents = new ArrayList<OrganizationComponent>();

	// 构造器
	public College(String name, String des) {
		super(name, des);
		// TODO Auto-generated constructor stub
	}

	// add
	@Override
	protected void add(OrganizationComponent organizationComponent) {
		// TODO Auto-generated method stub
		//  ����ʵ��ҵ���У�Colleage �� add ��  University add ��һ����ȫһ��
		organizationComponents.add(organizationComponent);
	}

	// remove
	@Override
	protected void remove(OrganizationComponent organizationComponent) {
		// TODO Auto-generated method stub
		organizationComponents.remove(organizationComponent);
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return super.getName();
	}

	@Override
	public String getDes() {
		// TODO Auto-generated method stub
		return super.getDes();
	}

	// print方法 学院里面包含专业
	@Override
	protected void print() {
		// TODO Auto-generated method stub
		System.out.println("--------------" + getName() + "--------------");
		// organizationComponents
		for (OrganizationComponent organizationComponent : organizationComponents) {
			organizationComponent.print();
		}
	}


}
