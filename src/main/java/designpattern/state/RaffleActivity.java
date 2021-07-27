package designpattern.state;

/**
 * �齱� //
 * 
 * @author Administrator
 *
 */
public class RaffleActivity {

	// state ��ʾ���ǰ��״̬���Ǳ仯
    State state = null;
    // ��Ʒ����
    int count = 0;
    
    // �ĸ����ԣ���ʾ����״̬
    State noRafflleState = new NoRaffleState(this);
    State canRaffleState = new CanRaffleState(this);
    
    State dispenseState =   new DispenseState(this);
    State dispensOutState = new DispenseOutState(this);

    //������
    //1. ��ʼ����ǰ��״̬Ϊ noRafflleState�������ܳ齱��״̬��
    //2. ��ʼ����Ʒ������ 
    public RaffleActivity( int count) {
        this.state = getNoRafflleState();
        this.count = count;
    }

    //�۷�, ���õ�ǰ״̬�� deductMoney
    public void debuctMoney(){
        state.deductMoney();
    }

    //�齱 
    public void raffle(){
    	// �����ǰ��״̬�ǳ齱�ɹ�
        if(state.raffle()){
        	//��ȡ��Ʒ
            state.dispensePrize();
        }

    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    //��������ע�⣬ÿ��ȡһ�ν�Ʒ��count--
    public int getCount() {
    	int curCount = count; 
    	count--;
        return curCount;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public State getNoRafflleState() {
        return noRafflleState;
    }

    public void setNoRafflleState(State noRafflleState) {
        this.noRafflleState = noRafflleState;
    }

    public State getCanRaffleState() {
        return canRaffleState;
    }

    public void setCanRaffleState(State canRaffleState) {
        this.canRaffleState = canRaffleState;
    }

    public State getDispenseState() {
        return dispenseState;
    }

    public void setDispenseState(State dispenseState) {
        this.dispenseState = dispenseState;
    }

    public State getDispensOutState() {
        return dispensOutState;
    }

    public void setDispensOutState(State dispensOutState) {
        this.dispensOutState = dispensOutState;
    }
}
