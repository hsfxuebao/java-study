package designpattern.proxy.staticproxy;

//代理对象  静态代理
public class TeacherDaoProxy implements ITeacherDao{
	
	private ITeacherDao target; // 目标对象
	
	
	//构造器
	public TeacherDaoProxy(ITeacherDao target) {
		this.target = target;
	}



	@Override
	public void teach() {
		// TODO Auto-generated method stub
		System.out.println("静态代理开始。。。");//����
		target.teach();
		System.out.println("静态代理结束");//����
	}

}
