package designpattern.factory.simplefactory.pizzastore.pizza;

// 披萨抽象类
public abstract class Pizza {
	protected String name; //名称

	// 制作披萨的方法
	public abstract void prepare();

	
	public void bake() {
		System.out.println(name + " baking;");
	}

	public void cut() {
		System.out.println(name + " cutting;");
	}

	public void box() {
		System.out.println(name + " boxing;");
	}

	public void setName(String name) {
		this.name = name;
	}
}
