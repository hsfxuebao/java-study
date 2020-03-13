package offer;

/**
 * @author haoshaofei
 * @date 2020/03/13
 *
 * 请实现一个函数用来匹配包括'.'和'*'的正则表达式。模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（包含0次）。 在本题中，匹配是指字符串的所有字符匹配整个模式。例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但是与"aa.a"和"ab*a"均不匹配
 */
public class O_52_正则表达式匹配 {

    /**
     * 不建议做这种题，浪费时间
     */
    public boolean match(char[] str, char[] pattern){
        if(str == null || pattern == null) return false;

        int strIndex = 0;
        int patIndex = 0;

        return matchCore(str,strIndex,pattern,patIndex);
    }

    private boolean matchCore(char[] str, int strIndex, char[] pattern,
                              int patIndex) {

        if(str.length == strIndex && pattern.length == patIndex) {
            return true;
        }
        if(str.length != strIndex && pattern.length == patIndex) {
            return false;
        }

        if(patIndex+1 < pattern.length && pattern[patIndex+1] == '*'){
            if((strIndex < str.length && pattern[patIndex] == '.') || (strIndex < str.length && pattern[patIndex] == str[strIndex])){
                return matchCore(str,strIndex + 1,pattern,patIndex) || matchCore(str,strIndex,pattern,patIndex + 2);
            }else{
                return matchCore(str,strIndex,pattern,patIndex + 2);
            }
        }else{
            if((strIndex < str.length && pattern[patIndex] == '.') || (strIndex < str.length && pattern[patIndex] == str[strIndex])){
                return matchCore(str,strIndex + 1,pattern,patIndex + 1);
            }else{
                return false;
            }
        }

    }
}