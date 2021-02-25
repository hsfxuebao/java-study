package javase;

/**
 * @author haoshaofei <haoshaofei@kuaishou.com>
 * Created on 2021-01-18
 */
public class User {

    private int number;
    private int age;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "number=" + number +
                ", age=" + age +
                '}';
    }
}
