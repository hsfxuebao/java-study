package offer;

/**
 * @author haoshaofei
 * @date 2020/03/13
 *
 * 在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置, 如果没有则返回 -1（需要区分大小写）.
 */
public class O_34_第一个只出现一次的字符 {

    public int FirstNotRepeatingChar(String str) {
        char[] map = new char[128];

        for (int i = 0;i < str.length();i++) {
            map[str.charAt(i)]++;
        }

        for (int i = 0;i < str.length();i++) {
            if (map[str.charAt(i)] == 1) {
                return i;
            }
        }
        return -1;
    }
}