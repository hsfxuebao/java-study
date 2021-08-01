package designpattern.flyweight;

//具体的网站
public class ConcreteWebSite extends WebSite {

	//共享的部分  内部状态
	private String type = ""; //网站发布的形式类型

	
	//构造器
	public ConcreteWebSite(String type) {
		
		this.type = type;
	}


	@Override
	public void use(User user) {
		// TODO Auto-generated method stub
		System.out.println("网站发布的形式:" + type + "使用中。。使用者 为 " + user.getName());
	}
	
	
}
