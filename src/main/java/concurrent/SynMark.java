package concurrent;

import org.openjdk.jol.info.ClassLayout;

/**
 * @author hsfxuebao
 * @date 2020/04/22
 */
public class SynMark {

	static class A{
		private int x = 666;
	}


	public static void main(String[] args) {
		A a = new A();

		System.out.println(ClassLayout.parseInstance(a).toPrintable());
	}

}
