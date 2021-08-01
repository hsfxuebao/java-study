package designpattern.observer.improve;

// 接口  WeatherData 来实现
public interface Subject {
	
	public void registerObserver(Observer o);
	public void removeObserver(Observer o);
	public void notifyObservers();
}
