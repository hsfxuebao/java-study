package designpattern.memento.game;

import java.util.ArrayList;
import java.util.HashMap;

//�ػ��߶���, ������Ϸ��ɫ��״̬
public class Caretaker {

	//���ֻ����һ��״̬
	private Memento  memento;
	//��GameRole ������״̬
	//private ArrayList<Memento> mementos;
	//�Զ����Ϸ��ɫ������״̬
	//private HashMap<String, ArrayList<Memento>> rolesMementos;

	public Memento getMemento() {
		return memento;
	}

	public void setMemento(Memento memento) {
		this.memento = memento;
	}
	
	
}
