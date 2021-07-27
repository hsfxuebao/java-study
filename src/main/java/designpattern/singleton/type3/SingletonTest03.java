package designpattern.singleton.type3;


public class SingletonTest03 {

	public static void main(String[] args) {
		System.out.println("����ʽ1 �� �̲߳���ȫ~");
		Singleton instance = Singleton.getInstance();
		Singleton instance2 = Singleton.getInstance();
		System.out.println(instance == instance2); // true
		System.out.println("instance.hashCode=" + instance.hashCode());
		System.out.println("instance2.hashCode=" + instance2.hashCode());
	}

}

/**
 * 懒汉式  线程不安全
 */
class Singleton {
	private static Singleton instance;
	
	private Singleton() {}
	
	// 静态的共有方法，当使用到该方法时，采取创建实例
	// 懒汉式
	public static Singleton getInstance() {
		if(instance == null) {
			instance = new Singleton();
		}
		return instance;
	}
}