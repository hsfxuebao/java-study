package designpattern.builder.improve;

//ָ���ߣ�����ȥָ���������̣����ز�Ʒ
public class HouseDirector {
	
	HouseBuilder houseBuilder = null;

	//构造器 houseBuilder
	public HouseDirector(HouseBuilder houseBuilder) {
		this.houseBuilder = houseBuilder;
	}

	//ͨsetter方法
	public void setHouseBuilder(HouseBuilder houseBuilder) {
		this.houseBuilder = houseBuilder;
	}
	
	// 如何处理房子的流程，交给指挥者
	public House constructHouse() {
		houseBuilder.buildBasic();
		houseBuilder.buildWalls();
		houseBuilder.roofed();
		return houseBuilder.buildHouse();
	}
	
	
}
