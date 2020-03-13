package offer;

/**
 * @author haoshaofei
 * @date 2020/03/13
 *
 * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 * 保证base和exponent不同时为0
 */
public class O_12_数值的整数次方 {

    public double Power(double base, int exponent) {
        if (base == 0) {
            return 0;
        }
        if (exponent == 0) {
            return 1;
        }
        if (exponent == 1) {
            return base;
        }

        if (exponent < 0) {
            base = 1/base;
            exponent = -exponent;
        }

        if (exponent % 2 == 0) {
            return Power(base, exponent/2) * Power(base, exponent/2);
        } else {
            return Power(base, exponent/2) * Power(base, exponent/2) * base;
        }
    }

    public static void main(String[] args) {
        O_12_数值的整数次方 s = new O_12_数值的整数次方();
        s.Power(2, -3);
    }
}