package designpattern.proxy.cglib;

import designpattern.proxy.staticproxy.TeacherDao;
import designpattern.proxy.staticproxy.TeacherDaoProxy;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//创建目标对象  被代理的对象
		designpattern.proxy.staticproxy.TeacherDao teacherDao = new TeacherDao();
		
		//创建代理对象，同时将被代理对象传进去
		TeacherDaoProxy teacherDaoProxy = new TeacherDaoProxy(teacherDao);
		
		//ͨ 通过代理对象，调用被代理对象的方法
		// 即 执行的是代理对象的方法，代理对象再去调用目标对象的方法
		teacherDaoProxy.teach();
	}

}
