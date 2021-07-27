package designpattern.singleton.type6;


public class SingletonTest06 {

	public static void main(String[] args) {
		System.out.println("˫�ؼ��");
		Singleton instance = Singleton.getInstance();
		Singleton instance2 = Singleton.getInstance();
		System.out.println(instance == instance2); // true
		System.out.println("instance.hashCode=" + instance.hashCode());
		System.out.println("instance2.hashCode=" + instance2.hashCode());
		
	}

}

/**
 * 双重检查
 */
class Singleton {
	private static volatile Singleton instance;
	
	private Singleton() {}

	public static synchronized Singleton getInstance() {
		if(instance == null) {
			synchronized (Singleton.class) {
				if(instance == null) {
					instance = new Singleton();
				}
			}
			
		}
		return instance;
	}
}