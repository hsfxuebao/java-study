package designpattern.state;

/**
 * ��Ʒ�������״̬
 * ˵����������activity �ı�� DispenseOutState�� �齱�����
 * @author Administrator
 *
 */
public class DispenseOutState extends State {

	// ��ʼ��ʱ��������
    RaffleActivity activity;

    public DispenseOutState(RaffleActivity activity) {
        this.activity = activity;
    }
    @Override
    public void deductMoney() {
        System.out.println("��Ʒ�������ˣ����´��ٲμ�");
    }

    @Override
    public boolean raffle() {
        System.out.println("��Ʒ�������ˣ����´��ٲμ�");
        return false;
    }

    @Override
    public void dispensePrize() {
        System.out.println("��Ʒ�������ˣ����´��ٲμ�");
    }
}
