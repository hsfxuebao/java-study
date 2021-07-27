package designpattern.uml.composition;

public class Computer {
	private Mouse mouse = new Mouse(); //�����Ժ�computer���ܷ���
	private Moniter moniter = new Moniter();//��ʾ�����Ժ�Computer���ܷ���
	public void setMouse(Mouse mouse) {
		this.mouse = mouse;
	}
	public void setMoniter(Moniter moniter) {
		this.moniter = moniter;
	}
	
}
