package designpattern.builder.improve;


// 抽象的建造者
public abstract class HouseBuilder {

	protected House house = new House();
	
	// 将建造的方法写好，抽象的方法
	public abstract void buildBasic();
	public abstract void buildWalls();
	public abstract void roofed();
	
	// 建造房子，将产品返回（房子）
	public House buildHouse() {
		return house;
	}
	
}
