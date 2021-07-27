package designpattern.singleton.type1;

public class SingletonTest01 {

	public static void main(String[] args) {
		//����
		Singleton instance = Singleton.getInstance();
		Singleton instance2 = Singleton.getInstance();
		System.out.println(instance == instance2); // true
		System.out.println("instance.hashCode=" + instance.hashCode());
		System.out.println("instance2.hashCode=" + instance2.hashCode());
	}

}

/**
 * 饿汉式  静态常量
 */
class Singleton {
	
	//1. 私有化构造器
	private Singleton() {
		
	}
	
	// 2. 内部创建实例
	private final static Singleton instance = new Singleton();
	
	//3. 提供一个共有的静态方法，返回实例对象
	public static Singleton getInstance() {
		return instance;
	}
	
}