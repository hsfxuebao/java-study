package designpattern.template.improve;

//抽象类
public abstract class SoyaMilk {

	//模板方法 make , 可以做成 final , 不让子类进行覆盖
	final void make() {

		select();
		if(customerWantCondiments()) {
			addCondiments();
		}
		soak();
		beat();

	}

	//选材料
	void select() {
		System.out.println("第一步  选取好的黄豆 ");
	}

	//添加不同的配料  抽象方法，子类去实现
	abstract void addCondiments();

	//浸泡
	void soak() {
		System.out.println("第三步 黄豆和材料需要浸泡3小时 ");
	}

	void beat() {
		System.out.println("第4步 黄豆和配料放入豆浆机打碎  ");
	}

	
	//钩子方法 决定是否需要添加配料
	boolean customerWantCondiments() {
		return true;
	}
}
