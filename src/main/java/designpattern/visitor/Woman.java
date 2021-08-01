package designpattern.visitor;

// 说明
//1. 使用了双分派，首先在客户端程序中，将具体状态传给Woman(第一次双分)
//2. 然后Woman调用作为参数的"具体方法"中getWomanResult()方法，同时
// 将自己this作为参数传入，完成第二次分派
public class Woman extends Person{

	@Override
	public void accept(Action action) {
		// TODO Auto-generated method stub
		action.getWomanResult(this);
	}

}
