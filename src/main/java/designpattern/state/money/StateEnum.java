package designpattern.state.money;

/**
 * ״̬ö����
 * @author Administrator
 *
 */
public enum StateEnum {

	 //��������
    GENERATE(1, "GENERATE"),

    //�����
    REVIEWED(2, "REVIEWED"),

    //�ѷ���
    PUBLISHED(3, "PUBLISHED"),

    //������
    NOT_PAY(4, "NOT_PAY"),

    //�Ѹ���
    PAID(5, "PAID"),

    //�����
    FEED_BACKED(6, "FEED_BACKED");

    private int key;
    private String value;

    StateEnum(int key, String value) {
        this.key = key;
        this.value = value;
    }
    public int getKey() {return key;}
    public String getValue() {return value;}
}
