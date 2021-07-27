package designpattern.composite;

public abstract class OrganizationComponent {

	private String name; // ����
	private String des; // ˵��
	
	protected  void add(OrganizationComponent organizationComponent) {
		//Ĭ��ʵ��
		throw new UnsupportedOperationException();
	}
	
	protected  void remove(OrganizationComponent organizationComponent) {
		//Ĭ��ʵ��
		throw new UnsupportedOperationException();
	}

	//������
	public OrganizationComponent(String name, String des) {
		super();
		this.name = name;
		this.des = des;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDes() {
		return des;
	}

	public void setDes(String des) {
		this.des = des;
	}
	
	//����print, ���ɳ����, ���඼��Ҫʵ��
	protected abstract void print();
	
	
}
