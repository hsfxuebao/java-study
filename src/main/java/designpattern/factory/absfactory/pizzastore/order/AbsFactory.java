package designpattern.factory.absfactory.pizzastore.order;


import designpattern.factory.absfactory.pizzastore.pizza.Pizza;

// 抽象工厂接口
public interface AbsFactory {
	// 让子类具体实现
	public Pizza createPizza(String orderType);
}
