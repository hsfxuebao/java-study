package designpattern.singleton.type7;


public class SingletonTest07 {

	public static void main(String[] args) {
		System.out.println("ʹ�þ�̬�ڲ�����ɵ���ģʽ");
		Singleton instance = Singleton.getInstance();
		Singleton instance2 = Singleton.getInstance();
		System.out.println(instance == instance2); // true
		System.out.println("instance.hashCode=" + instance.hashCode());
		System.out.println("instance2.hashCode=" + instance2.hashCode());
		
	}

}

/**
 * 静态内部类完成，推荐使用
 */
class Singleton {
	private static volatile Singleton instance;
	
	// 私有化构造器
	private Singleton() {}
	
	// 静态内部类，有一个静态属性
	private static class SingletonInstance {
		private static final Singleton INSTANCE = new Singleton(); 
	}
	
	// 对外暴露的方法SingletonInstance.INSTANCE
	
	public static synchronized Singleton getInstance() {
		
		return SingletonInstance.INSTANCE;
	}
}