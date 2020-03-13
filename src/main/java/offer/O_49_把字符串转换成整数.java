package offer;

/**
 * @author haoshaofei
 * @date 2020/03/13
 *
 * 将一个字符串转换成一个整数，要求不能使用字符串转换整数的库函数。 数值为0或者字符串不是一个合法的数值则返回0
 * 输入描述:
 * 输入一个字符串,包括数字字母符号,可以为空
 * 输出描述:
 * 如果是合法的数值表达则返回该数字，否则返回0
 */
public class O_49_把字符串转换成整数 {

    public int StrToInt(String str) {
        if(str == null || str.length() == 0){
            return 0;
        }

        int res = 0;
        for(int i = 0;i < str.length();i++){
            if(i == 0 && (str.charAt(i) == '+' || str.charAt(i) == '-')){
                continue;
            }
            if(str.charAt(i) > '9' || str.charAt(i) < '0'){
                return 0;
            }
            res *= 10;
            res += (str.charAt(i) - '0');
        }

        //1.防止+出现报错
        //2.防止超过int范围的数
        if (str.length() != 1 && (Long.valueOf(str) > Integer.MAX_VALUE || Long.valueOf(str) < Integer.MIN_VALUE)) {
            return 0;
        }
        return str.charAt(0) == '-' ? -res:res ;
    }

}