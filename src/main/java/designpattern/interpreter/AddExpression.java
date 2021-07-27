package designpattern.interpreter;

import java.util.HashMap;

/**
 * �ӷ�������
 * @author Administrator
 *
 */
public class AddExpression extends SymbolExpression  {

	public AddExpression(Expression left, Expression right) {
		super(left, right);
	}

	//�������
	//var ��Ȼ�� {a=10,b=20}..
	//һ������debug Դ��,��ok
	public int interpreter(HashMap<String, Integer> var) {
		//super.left.interpreter(var) �� ���� left ���ʽ��Ӧ��ֵ a = 10
		//super.right.interpreter(var): ����right ���ʽ��Ӧֵ b = 20
		return super.left.interpreter(var) + super.right.interpreter(var);
	}
}
