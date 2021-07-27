package designpattern.bridge;

public class UpRightPhone extends Phone {
	
		//������
		public UpRightPhone(Brand brand) {
			super(brand);
		}
		
		public void open() {
			super.open();
			System.out.println(" ֱ����ʽ�ֻ� ");
		}
		
		public void close() {
			super.close();
			System.out.println(" ֱ����ʽ�ֻ� ");
		}
		
		public void call() {
			super.call();
			System.out.println(" ֱ����ʽ�ֻ� ");
		}
}
