package designpattern.composite;

/**
 * 组合模式
 */
public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// 从大到小创建对象 学校
		OrganizationComponent university = new University("清华大学", " 清华大学 ");
		
		//学院
		OrganizationComponent computerCollege = new College("计算机学院", " 计算机学院 ");
		OrganizationComponent infoEngineercollege = new College("信息工程学院", "信息工程学院");
		
		
		computerCollege.add(new Department("计算机专业", "计算机专业"));
		computerCollege.add(new Department("软件工程", " 软件工程 "));

		//
		infoEngineercollege.add(new Department("ͨ通信工程", "ͨ通信工程"));
		infoEngineercollege.add(new Department("信息工程", "信息工程"));
		
		//将学院加入学校
		university.add(computerCollege);
		university.add(infoEngineercollege);
		
		//university.print();
		infoEngineercollege.print();
	}

}
