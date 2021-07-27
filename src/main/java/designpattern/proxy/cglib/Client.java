package designpattern.proxy.cglib;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//����Ŀ�����
		TeacherDao target = new TeacherDao();
		//��ȡ��������󣬲��ҽ�Ŀ����󴫵ݸ��������
		TeacherDao proxyInstance = (TeacherDao)new ProxyFactory(target).getProxyInstance();

		//ִ�д������ķ���������intecept �������Ӷ�ʵ�� ��Ŀ�����ĵ���
		String res = proxyInstance.teach();
		System.out.println("res=" + res);
	}

}
