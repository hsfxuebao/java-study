package designpattern.observer;

/**
 * ���Ǻ���
 * 1. �������µ����������Ϣ 
 * 2. ���� CurrentConditions ����
 * 3. �������и���ʱ���������ĵ���   CurrentConditions����update����(�� display), �������ǣ����뷽���Ϳ������µ���Ϣ
 * @author Administrator
 *
 */
public class WeatherData {
	private float temperatrue;
	private float pressure;
	private float humidity;
	private CurrentConditions currentConditions;
	//�����µĵ�����

	public WeatherData(CurrentConditions currentConditions) {
		this.currentConditions = currentConditions;
	}

	public float getTemperature() {
		return temperatrue;
	}

	public float getPressure() {
		return pressure;
	}

	public float getHumidity() {
		return humidity;
	}

	public void dataChange() {
		//���� ���뷽�� update
		currentConditions.update(getTemperature(), getPressure(), getHumidity());
	}

	//�������и���ʱ���͵��� setData
	public void setData(float temperature, float pressure, float humidity) {
		this.temperatrue = temperature;
		this.pressure = pressure;
		this.humidity = humidity;
		//����dataChange�� �����µ���Ϣ ���͸� ���뷽 currentConditions
		dataChange();
	}
}
