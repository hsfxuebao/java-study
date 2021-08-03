package designpattern.state;

/**
 * 不能抽奖状态
 *
 */
public class NoRaffleState extends State {

	 // 初始化传入  扣除后改变成可以抽奖的状态
    RaffleActivity activity;

    public NoRaffleState(RaffleActivity activity) {
        this.activity = activity;
    }

    //
    @Override
    public void deductMoney() {
        System.out.println("扣除50积分  可以抽奖了");
        activity.setState(activity.getCanRaffleState());
    }

    @Override
    public boolean raffle() {
        System.out.println("不能抽奖");
        return false;
    }

    @Override
    public void dispensePrize() {
        System.out.println("不能发放奖品");
    }
}
