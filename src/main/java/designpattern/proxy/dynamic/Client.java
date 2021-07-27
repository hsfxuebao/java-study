package designpattern.proxy.dynamic;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//����Ŀ�����
		ITeacherDao target = new TeacherDao();
		
		//��Ŀ����󣬴����������, ����ת�� ITeacherDao
		ITeacherDao proxyInstance = (ITeacherDao)new ProxyFactory(target).getProxyInstance();
	
		// proxyInstance=class com.sun.proxy.$Proxy0 �ڴ��ж�̬�����˴������
		System.out.println("proxyInstance=" + proxyInstance.getClass());
		
		//ͨ��������󣬵���Ŀ�����ķ���
		//proxyInstance.teach();
		
		proxyInstance.sayHello(" tom ");
	}

}
