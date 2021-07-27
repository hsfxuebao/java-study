package designpattern.singleton.type2;

public class SingletonTest02 {

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
 * 饿汉式  静态变量
 */

class Singleton {
	
	//1. 私有化构造器
	private Singleton() {
		
	}
	

	// 内部创建实例对象
	private  static Singleton instance;
	
	static { // 静态代码块中，创建单例对象
		instance = new Singleton();
	}
	
	//3. 对外暴露的静态方法，返回实例对象
	public static Singleton getInstance() {
		return instance;
	}
	
}