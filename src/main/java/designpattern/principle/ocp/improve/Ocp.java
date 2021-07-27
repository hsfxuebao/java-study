package designpattern.principle.ocp.improve;

public class Ocp {

	public static void main(String[] args) {
		//ʹ�ÿ������ڵ�����
		GraphicEditor graphicEditor = new GraphicEditor();
		graphicEditor.drawShape(new Rectangle());
		graphicEditor.drawShape(new Circle());
		graphicEditor.drawShape(new Triangle());
		graphicEditor.drawShape(new OtherGraphic());
	}

}

//����һ�����ڻ�ͼ���� [ʹ�÷�]
class GraphicEditor {
	//����Shape���󣬵���draw����
	public void drawShape(Shape s) {
		s.draw();
	}

	
}

//Shape�࣬����
abstract class Shape {
	int m_type;
	
	public abstract void draw();//���󷽷�
}

class Rectangle extends Shape {
	Rectangle() {
		super.m_type = 1;
	}

	@Override
	public void draw() {
		// TODO Auto-generated method stub
		System.out.println(" ���ƾ��� ");
	}
}

class Circle extends Shape {
	Circle() {
		super.m_type = 2;
	}
	@Override
	public void draw() {
		// TODO Auto-generated method stub
		System.out.println(" ����Բ�� ");
	}
}

//������������
class Triangle extends Shape {
	Triangle() {
		super.m_type = 3;
	}
	@Override
	public void draw() {
		// TODO Auto-generated method stub
		System.out.println(" ���������� ");
	}
}

//����һ��ͼ��
class OtherGraphic extends Shape {
	OtherGraphic() {
		super.m_type = 4;
	}

	@Override
	public void draw() {
		// TODO Auto-generated method stub
		System.out.println(" ��������ͼ�� ");
	}
}
