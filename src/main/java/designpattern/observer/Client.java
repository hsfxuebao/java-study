package designpattern.observer;

public class Client {
	public static void main(String[] args) {
		//创建 currentConditions
		CurrentConditions currentConditions = new CurrentConditions();
		// 创建 WeatherData 并将接入方 currentConditions 传递到 WeatherData
		WeatherData weatherData = new WeatherData(currentConditions);
		
		// 跟新天气情况
		weatherData.setData(30, 150, 40);
		
		// 天气情况变化
		System.out.println("============��������仯=============");
		weatherData.setData(40, 160, 20);
		

	}
}
