package designpattern.state;

/**
 *  奖品发放完毕状态
 *  说明 当我们 activity 变成 DispenseOutState 抽奖活动结束
 *
 */
public class DispenseOutState extends State {

	// 传入活动引入
    RaffleActivity activity;

    public DispenseOutState(RaffleActivity activity) {
        this.activity = activity;
    }
    @Override
    public void deductMoney() {
        System.out.println("奖品发完了，请下次再参加");
    }

    @Override
    public boolean raffle() {
        System.out.println("奖品发放完毕了，请下次参加");
        return false;
    }

    @Override
    public void dispensePrize() {
        System.out.println("奖品发放完毕了，请下次参加");
    }
}
