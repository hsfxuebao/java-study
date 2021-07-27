package designpattern.factory.factorymethod.pizzastore.order;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import designpattern.factory.factorymethod.pizzastore.pizza.Pizza;


public abstract class OrderPizza {

	// 抽象方法，让各个工厂自己去实现
	abstract Pizza createPizza(String orderType);
	
	// 构造器
	public OrderPizza() {
		Pizza pizza = null;
		String orderType; // 类型
		do {
			orderType = getType();
			pizza = createPizza(orderType); //抽象方法，工厂子类进行实现
			//制作披萨过程
			pizza.prepare();
			pizza.bake();
			pizza.cut();
			pizza.box();
			
		} while (true);
	}

	

	// 获取披萨类型
	private String getType() {
		try {
			BufferedReader strin = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("input pizza 类型:");
			String str = strin.readLine();
			return str;
		} catch (IOException e) {
			e.printStackTrace();
			return "";
		}
	}

}
