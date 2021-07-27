package designpattern.principle.ocp;

public class Ocp {

	public static void main(String[] args) {
		//ʹ�ÿ������ڵ�����
		GraphicEditor graphicEditor = new GraphicEditor();
		graphicEditor.drawShape(new Rectangle());
		graphicEditor.drawShape(new Circle());
		graphicEditor.drawShape(new Triangle());
	}

}

//����һ�����ڻ�ͼ���� [ʹ�÷�]
class GraphicEditor {
	//����Shape����Ȼ�����type�������Ʋ�ͬ��ͼ��
	public void drawShape(Shape s) {
		if (s.m_type == 1)
			drawRectangle(s);
		else if (s.m_type == 2)
			drawCircle(s);
		else if (s.m_type == 3)
			drawTriangle(s);
	}

	//���ƾ���
	public void drawRectangle(Shape r) {
		System.out.println(" ���ƾ��� ");
	}

	//����Բ��
	public void drawCircle(Shape r) {
		System.out.println(" ����Բ�� ");
	}
	
	//����������
	public void drawTriangle(Shape r) {
		System.out.println(" ���������� ");
	}
}

//Shape�࣬����
class Shape {
	int m_type;
}

class Rectangle extends Shape {
	Rectangle() {
		super.m_type = 1;
	}
}

class Circle extends Shape {
	Circle() {
		super.m_type = 2;
	}
}

//������������
class Triangle extends Shape {
	Triangle() {
		super.m_type = 3;
	}
}
