package designpattern.observer;

/**
 * 类是核心
 * 1. 包含最细的天气情况信息
 * 2. 含有 CurrentConditions 信息
 * 3.  当有数据更新时 就主动调用 CurrentConditions  的 update（）
 * @author Administrator
 *
 */
public class WeatherData {
	private float temperatrue;
	private float pressure;
	private float humidity;
	private CurrentConditions currentConditions;
	// 加入新第三方

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
		//update
		currentConditions.update(getTemperature(), getPressure(), getHumidity());
	}

	// 有数据更新 setData
	public void setData(float temperature, float pressure, float humidity) {
		this.temperatrue = temperature;
		this.pressure = pressure;
		this.humidity = humidity;
		// 调用 dataChange 将新的天气情况推送给 接入方 currentConditions
		dataChange();
	}
}
