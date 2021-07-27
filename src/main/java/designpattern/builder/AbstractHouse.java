package designpattern.builder;

public abstract class AbstractHouse {
	
	//��ػ�
	public abstract void buildBasic();
	//��ǽ
	public abstract void buildWalls();
	//�ⶥ
	public abstract void roofed();
	
	public void build() {
		buildBasic();
		buildWalls();
		roofed();
	}
	
}
