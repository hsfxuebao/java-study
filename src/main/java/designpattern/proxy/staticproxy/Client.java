package designpattern.proxy.staticproxy;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//����Ŀ�����(���������)
		TeacherDao teacherDao = new TeacherDao();
		
		//�����������, ͬʱ����������󴫵ݸ��������
		TeacherDaoProxy teacherDaoProxy = new TeacherDaoProxy(teacherDao);
		
		//ͨ��������󣬵��õ����������ķ���
		//����ִ�е��Ǵ������ķ��������������ȥ����Ŀ�����ķ��� 
		teacherDaoProxy.teach();
	}

}
