package designpattern.state.money;

/**
 * ״̬�ӿ�
 * @author Administrator
 *
 */
public interface State {

	/**
     * ����
     */
    void checkEvent(Context context);

    /**
     * ����ʧ��
     */
    void checkFailEvent(Context context);

    /**
     * ���۷���
     */
    void makePriceEvent(Context context);

    /**
     * �ӵ�
     */
    void acceptOrderEvent(Context context);

    /**
     * ���˽ӵ�ʧЧ
     */
    void notPeopleAcceptEvent(Context context);

    /**
     * ����
     */
    void payOrderEvent(Context context);

    /**
     * �ӵ�����֧��ʧЧ
     */
    void orderFailureEvent(Context context);

    /**
     * ����
     */
    void feedBackEvent(Context context);


    String getCurrentState();
}
