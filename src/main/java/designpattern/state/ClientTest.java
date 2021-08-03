package designpattern.state;

/**
 *  状态模式
 */
public class ClientTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//  创建活动对象  奖品有一个
        RaffleActivity activity = new RaffleActivity(1);

        // 抽奖30次
        for (int i = 0; i < 30; i++) {
            System.out.println("--------第" + (i + 1) + "抽奖----------");
            // 参加抽奖 第一步点击扣除积分
            activity.debuctMoney();

            // 第二步 抽奖
            activity.raffle();
        }
	}

}
