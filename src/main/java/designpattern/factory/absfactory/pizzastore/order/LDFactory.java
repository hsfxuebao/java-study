package designpattern.factory.absfactory.pizzastore.order;


import designpattern.factory.absfactory.pizzastore.pizza.LDCheesePizza;
import designpattern.factory.absfactory.pizzastore.pizza.LDPepperPizza;
import designpattern.factory.absfactory.pizzastore.pizza.Pizza;

public class LDFactory implements AbsFactory {

	@Override
	public Pizza createPizza(String orderType) {
		System.out.println("抽象工厂模式");
		Pizza pizza = null;
		if (orderType.equals("cheese")) {
			pizza = new LDCheesePizza();
		} else if (orderType.equals("pepper")) {
			pizza = new LDPepperPizza();
		}
		return pizza;
	}

}
