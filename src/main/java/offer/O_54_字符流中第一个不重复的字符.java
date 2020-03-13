package offer;

/**
 * @author haoshaofei
 * @date 2020/03/13
 *
 * 请实现一个函数用来找出字符流中第一个只出现一次的字符。例如，当从字符流中只读出前两个字符"go"时，第一个只出现一次的字符是"g"。当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。
 */
public class O_54_字符流中第一个不重复的字符 {

    char[] map = new char[128];
    StringBuilder sb = new StringBuilder();

    //Insert one char from stringstream
    public void Insert(char ch)
    {
        map[ch]++;
        sb.append(ch);
    }
    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce()
    {
        for (int i = 0;i < sb.length();i++) {
            if (map[sb.charAt(i)] == 1) {
                return sb.charAt(i);
            }
        }

        return '#';
    }
}