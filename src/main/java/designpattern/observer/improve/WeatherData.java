package designpattern.observer.improve;

import java.util.ArrayList;

/**
 * 类是核心
 * 1. 包含最细的天气信息
 * 2. 含有观察者集合  使用List 管理
 * 3. 当数据有更新时，就主动调用 List 通知所有的接入者
 *
 */
public class WeatherData implements Subject {
	private float temperatrue;
	private float pressure;
	private float humidity;
	// 观察者集合
	private ArrayList<Observer> observers;
	

	public WeatherData() {
		observers = new ArrayList<Observer>();
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
		// 调用接入方 的 update
		
		notifyObservers();
	}

	// 当数据有更新时，就调用 setData
	public void setData(float temperature, float pressure, float humidity) {
		this.temperatrue = temperature;
		this.pressure = pressure;
		this.humidity = humidity;
		//����dataChange�� �����µ���Ϣ ���͸� ���뷽 currentConditions
		dataChange();
	}

	// 注册
	@Override
	public void registerObserver(Observer o) {
		// TODO Auto-generated method stub
		observers.add(o);
	}

	// 删除
	@Override
	public void removeObserver(Observer o) {
		// TODO Auto-generated method stub
		if(observers.contains(o)) {
			observers.remove(o);
		}
	}

	// 遍历所有的观察者，并通知
	@Override
	public void notifyObservers() {
		// TODO Auto-generated method stub
		for(int i = 0; i < observers.size(); i++) {
			observers.get(i).update(this.temperatrue, this.pressure, this.humidity);
		}
	}
}
