package designpattern.decorator;

//具体的Decorator 这里是调味品
public class Chocolate extends Decorator {

	public Chocolate(Drink obj) {
		super(obj);
		setDes(" 千克力 ");
		setPrice(3.0f); // 价格
	}

}
