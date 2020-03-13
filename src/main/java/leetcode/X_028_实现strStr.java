package leetcode;
/**
 * @author haoshaofei
 * @date 2020/03/13
 *
 * 实现 strStr() 函数。
 * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
 *
 * 示例 1:
 * 输入: haystack = "hello", needle = "ll"
 * 输出: 2
 * 示例 2:
 * 输入: haystack = "aaaaa", needle = "bba"
 * 输出: -1
 *
 */
public class X_028_实现strStr {

    /**
     * 以下未暴力算法，最佳的算法应是KMP算法，不打算给出，感兴趣可以自行查阅
     */
    public int strStr(String haystack, String needle) {
        if (needle.length() == 0) {
            return 0;
        }
        if (haystack.length() < needle.length()) {
            return -1;
        }

        int len1 = haystack.length();
        int len2 = needle.length();

        for (int i = 0;i <= len1-len2;i++) {
            if (haystack.charAt(i) == needle.charAt(0) && valid(i, haystack, needle)) {
                return i;
            }
        }

        return -1;
    }

    private boolean valid(int i, String haystack, String needle) {
        int index = 0;
        while (index < needle.length() && haystack.charAt(i) == needle.charAt(index)) {
            index++;
            i++;
        }

        return index == needle.length();
    }

    public static void main(String[] args) {
        X_028_实现strStr s = new X_028_实现strStr();
        s.strStr("a","a");
    }
}