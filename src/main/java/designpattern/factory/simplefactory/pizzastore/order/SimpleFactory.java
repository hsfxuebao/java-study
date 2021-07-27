package designpattern.factory.simplefactory.pizzastore.order;


import designpattern.factory.simplefactory.pizzastore.pizza.CheesePizza;
import designpattern.factory.simplefactory.pizzastore.pizza.GreekPizza;
import designpattern.factory.simplefactory.pizzastore.pizza.PepperPizza;
import designpattern.factory.simplefactory.pizzastore.pizza.Pizza;

//订购披萨工厂
public class SimpleFactory {

	// 根据orderType返回对应的披萨对象
	public Pizza createPizza(String orderType) {

		Pizza pizza = null;

		System.out.println(" 工厂模式1");
		if (orderType.equals("greek")) {
			pizza = new GreekPizza();
			pizza.setName(" 希腊披萨 ");
		} else if (orderType.equals("cheese")) {
			pizza = new CheesePizza();
			pizza.setName("奶酪披萨");
		} else if (orderType.equals("pepper")) {
			pizza = new PepperPizza();
			pizza.setName("胡椒披萨");
		}
		
		return pizza;
	}
	
	// 简单工厂模式，也 静态工厂模式
	
	public static Pizza createPizza2(String orderType) {

		Pizza pizza = null;

		System.out.println(" 工厂模式2");
		if (orderType.equals("greek")) {
			pizza = new GreekPizza();
			pizza.setName(" 希腊披萨 ");
		} else if (orderType.equals("cheese")) {
			pizza = new CheesePizza();
			pizza.setName("奶酪披萨");
		} else if (orderType.equals("pepper")) {
			pizza = new PepperPizza();
			pizza.setName("胡椒披萨");
		}

		return pizza;
		
	}

}
