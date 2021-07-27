package designpattern.principle.liskov.improve;

public class Liskov {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		A a = new A();
		System.out.println("11-3=" + a.func1(11, 3));
		System.out.println("1-8=" + a.func1(1, 8));

		System.out.println("-----------------------");
		B b = new B();
		//��ΪB�಻�ټ̳�A�࣬��˵����ߣ�������func1�������
		//������ɵĹ��ܾͻ����ȷ
		System.out.println("11+3=" + b.func1(11, 3));//���ﱾ�������11+3
		System.out.println("1+8=" + b.func1(1, 8));// 1+8
		System.out.println("11+3+9=" + b.func2(11, 3));
		
		
		//ʹ�������Ȼ����ʹ�õ�A����ط���
		System.out.println("11-3=" + b.func3(11, 3));// ���ﱾ�������11-3
		

	}

}

//����һ�����ӻ����Ļ���
class Base {
	//�Ѹ��ӻ����ķ����ͳ�Աд��Base��
}

// A��
class A extends Base {
	// �����������Ĳ�
	public int func1(int num1, int num2) {
		return num1 - num2;
	}
}

// B��̳���A
// ������һ���¹��ܣ�������������,Ȼ���9���
class B extends Base {
	//���B��Ҫʹ��A��ķ���,ʹ����Ϲ�ϵ
	private A a = new A();
	
	//�����д��A��ķ���, ����������ʶ
	public int func1(int a, int b) {
		return a + b;
	}

	public int func2(int a, int b) {
		return func1(a, b) + 9;
	}
	
	//������Ȼ��ʹ��A�ķ���
	public int func3(int a, int b) {
		return this.a.func1(a, b);
	}
}
