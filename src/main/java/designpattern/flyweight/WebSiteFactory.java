package designpattern.flyweight;

import java.util.HashMap;

// 网站工厂类 根据需要返回一个网站
public class WebSiteFactory {

	
	//集合  充当池的作用
	private HashMap<String, ConcreteWebSite> pool = new HashMap<>();
	

	public WebSite getWebSiteCategory(String type) {
		if(!pool.containsKey(type)) {
			//创建一个网站 并放入池中
			pool.put(type, new ConcreteWebSite(type));
		}
		
		return (WebSite)pool.get(type);
	}
	
	// 获取网站的分类总数
	public int getWebSiteCount() {
		return pool.size();
	}
}
