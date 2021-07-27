package designpattern.visitor;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//����ObjectStructure
		ObjectStructure objectStructure = new ObjectStructure();
		
		objectStructure.attach(new Man());
		objectStructure.attach(new Woman());
		
		
		//�ɹ�
		Success success = new Success();
		objectStructure.display(success);
		
		System.out.println("===============");
		Fail fail = new Fail();
		objectStructure.display(fail);
		
		System.out.println("=======�����Ǵ����Ĳ���========");
		
		Wait wait = new Wait();
		objectStructure.display(wait);
	}

}
