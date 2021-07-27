package designpattern.observer.improve;

public class BaiduSite implements Observer {

	// �¶ȣ���ѹ��ʪ��
	private float temperature;
	private float pressure;
	private float humidity;

	// ���� ������������� WeatherData �����ã���ʹ������ģʽ
	public void update(float temperature, float pressure, float humidity) {
		this.temperature = temperature;
		this.pressure = pressure;
		this.humidity = humidity;
		display();
	}

	// ��ʾ
	public void display() {
		System.out.println("===�ٶ���վ====");
		System.out.println("***�ٶ���վ ���� : " + temperature + "***");
		System.out.println("***�ٶ���վ ��ѹ: " + pressure + "***");
		System.out.println("***�ٶ���վ ʪ��: " + humidity + "***");
	}

}
