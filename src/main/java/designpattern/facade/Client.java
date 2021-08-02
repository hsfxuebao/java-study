package designpattern.facade;

/**
 * 外观模式
 */
public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 直接使用外观模式
		HomeTheaterFacade homeTheaterFacade = new HomeTheaterFacade();
		homeTheaterFacade.ready();
		homeTheaterFacade.play();
		
		
		homeTheaterFacade.end();
	}

}
