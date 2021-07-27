package designpattern.flyweight;

//������վ
public class ConcreteWebSite extends WebSite {

	//����Ĳ��֣��ڲ�״̬
	private String type = ""; //��վ��������ʽ(����)

	
	//������
	public ConcreteWebSite(String type) {
		
		this.type = type;
	}


	@Override
	public void use(User user) {
		// TODO Auto-generated method stub
		System.out.println("��վ�ķ�����ʽΪ:" + type + " ��ʹ���� .. ʹ������" + user.getName());
	}
	
	
}
