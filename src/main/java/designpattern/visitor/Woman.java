package designpattern.visitor;

//˵��
//1. ��������ʹ�õ���˫����, �������ڿͻ��˳����У�������״̬��Ϊ��������Woman��(��һ�η���)
//2. Ȼ��Woman �������Ϊ������ "���巽��" �з���getWomanResult, ͬʱ���Լ�(this)��Ϊ����
//   ���룬��ɵڶ��εķ���
public class Woman extends Person{

	@Override
	public void accept(Action action) {
		// TODO Auto-generated method stub
		action.getWomanResult(this);
	}

}
