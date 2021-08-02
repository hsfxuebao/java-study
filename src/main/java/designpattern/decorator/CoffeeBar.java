package designpattern.decorator;

/**
 * 装饰模式
 */
public class CoffeeBar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 装饰着模式下的订单 2份牛奶 + 一份LongBlack

		// 1. 点一份 LongBlack
		Drink order = new LongBlack();
		System.out.println("费用1=" + order.cost());
		System.out.println("描述" + order.getDes());

		// 2. order 加一份牛奶
		order = new Milk(order);

		System.out.println("order 加一份牛奶 费用=" + order.cost());
		System.out.println("order �加一份牛奶  描述= " + order.getDes());

		// 3. order 加一份巧克力

		order = new Chocolate(order);

		System.out.println("order 加一份牛奶 加一份巧克力�  价格 =" + order.cost());
		System.out.println("order 加一份牛奶 加一份巧克力 描述= " + order.getDes());

		// 3. order 加一份巧克力

		order = new Chocolate(order);

		System.out.println("order 加一份牛奶 加2份巧克力  价格 =" + order.cost());
		System.out.println("order 加一份牛奶 加2份巧克力 描述= " + order.getDes());
	
		System.out.println("===========================");
		
		Drink order2 = new DeCaf();
		
		System.out.println("order2 无因咖啡 价格=" + order2.cost());
		System.out.println("order2 无因咖啡 描述 = " + order2.getDes());
		
		order2 = new Milk(order2);
		
		System.out.println("order2 加一份牛奶  价格=" + order2.cost());
		System.out.println("order2 加一分牛奶 描述 = " + order2.getDes());

	
	}

}
