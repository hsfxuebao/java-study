package designpattern.facade;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//����ֱ�ӵ��á��� ���鷳
		HomeTheaterFacade homeTheaterFacade = new HomeTheaterFacade();
		homeTheaterFacade.ready();
		homeTheaterFacade.play();
		
		
		homeTheaterFacade.end();
	}

}
