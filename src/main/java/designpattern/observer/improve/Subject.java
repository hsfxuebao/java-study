package designpattern.observer.improve;

//�ӿ�, ��WeatherData ��ʵ�� 
public interface Subject {
	
	public void registerObserver(Observer o);
	public void removeObserver(Observer o);
	public void notifyObservers();
}
