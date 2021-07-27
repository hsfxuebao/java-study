package designpattern.interpreter;

import java.util.HashMap;


/**
 * �����Ľ�����
 * @author Administrator
 *
 */
public class VarExpression extends Expression {

	private String key; // key=a,key=b,key=c

	public VarExpression(String key) {
		this.key = key;
	}

	// var ����{a=10, b=20}
	// interpreter ���� �������ƣ����ض�Ӧֵ
	@Override
	public int interpreter(HashMap<String, Integer> var) {
		return var.get(this.key);
	}
}
