package designpattern.uml.aggregation;

public class Computer {
	private Mouse mouse; //�����Ժ�computer����
	private Moniter moniter;//��ʾ�����Ժ�Computer����
	public void setMouse(Mouse mouse) {
		this.mouse = mouse;
	}
	public void setMoniter(Moniter moniter) {
		this.moniter = moniter;
	}
	
}
