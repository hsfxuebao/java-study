package designpattern.decorator;

public abstract class Drink {

	public String des; // ����
	private float price = 0.0f;
	public String getDes() {
		return des;
	}
	public void setDes(String des) {
		this.des = des;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	
	//������õĳ��󷽷�
	//������ʵ��
	public abstract float cost();
	
}
