package designpattern.visitor;

public class Success extends Action {

	@Override
	public void getManResult(Man man) {
		// TODO Auto-generated method stub
		System.out.println(" ���˸������۸ø��ֺܳɹ� !");
	}

	@Override
	public void getWomanResult(Woman woman) {
		// TODO Auto-generated method stub
		System.out.println(" Ů�˸������۸ø��ֺܳɹ� !");
	}

}
