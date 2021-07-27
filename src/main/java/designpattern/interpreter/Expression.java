package designpattern.interpreter;

import java.util.HashMap;

/**
 * ��������ʽ��ͨ��HashMap ��ֵ��, ���Ի�ȡ��������ֵ
 * 
 * @author Administrator
 *
 */
public abstract class Expression {
	// a + b - c
	// ���͹�ʽ����ֵ, key ���ǹ�ʽ(���ʽ) ����[a,b,c], value���Ǿ��Ǿ���ֵ
	// HashMap {a=10, b=20}
	public abstract int interpreter(HashMap<String, Integer> var);
}
