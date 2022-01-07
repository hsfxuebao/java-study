package concurrent;

import org.openjdk.jol.info.ClassLayout;

/**
 * @author hsfxuebao
 * @date 2020/04/22
 */
public class SynExample2 {

	public synchronized void test() {

		int i = 1;
		int j = 2;
		System.out.println(i + j);

	}

	public static void main(String[] args) {
		Thread thread=new Thread(new Runnable() {
			@Override
			public void run() {
				synchronized (this){
					System.out.println(ClassLayout.parseInstance(this).toPrintable());
				}
			}
		});
		thread.start();

	}

}
