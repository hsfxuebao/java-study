package designpattern.observer;

public class Client {
	public static void main(String[] args) {
		//�������뷽 currentConditions
		CurrentConditions currentConditions = new CurrentConditions();
		//���� WeatherData ���� ���뷽 currentConditions ���ݵ� WeatherData��
		WeatherData weatherData = new WeatherData(currentConditions);
		
		//�����������
		weatherData.setData(30, 150, 40);
		
		//��������仯
		System.out.println("============��������仯=============");
		weatherData.setData(40, 160, 20);
		

	}
}
