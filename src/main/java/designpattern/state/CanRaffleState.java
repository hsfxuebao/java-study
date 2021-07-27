package designpattern.state;

import java.util.Random;

/**
 * ���Գ齱��״̬
 * @author Administrator
 *
 */
public class CanRaffleState extends State {

    RaffleActivity activity;

    public CanRaffleState(RaffleActivity activity) {
        this.activity = activity;
    }

    //�Ѿ��۳��˻��֣������ٿ�
    @Override
    public void deductMoney() {
        System.out.println("�Ѿ���ȡ���˻���");
    }

    //���Գ齱, ���꽱�󣬸���ʵ��������ĳ��µ�״̬
    @Override
    public boolean raffle() {
        System.out.println("���ڳ齱�����Եȣ�");
        Random r = new Random();
        int num = r.nextInt(10);
        // 10%�н�����
        if(num == 0){
            // �ı�״̬Ϊ���Ž�Ʒ context
            activity.setState(activity.getDispenseState());
            return true;
        }else{
            System.out.println("���ź�û�г��н�Ʒ��");
            // �ı�״̬Ϊ���ܳ齱
            activity.setState(activity.getNoRafflleState());
            return false;
        }
    }

    // ���ܷ��Ž�Ʒ
    @Override
    public void dispensePrize() {
        System.out.println("û�н������ܷ��Ž�Ʒ");
    }
}
