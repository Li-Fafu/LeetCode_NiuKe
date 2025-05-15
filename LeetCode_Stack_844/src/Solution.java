/**
 *给定 s 和 t 两个字符串，当它们分别被输入到空白的文本编辑器后，如果两者相等，返回 true 。# 代表退格字符。
 *
 * 注意：如果对空文本输入退格字符，文本继续为空。
 */
public class Solution {
    public boolean backspaceCompare(String s, String t) {
        return changeStr(s).equals(changeStr(t));
    }
    
    private String changeStr(String t) {
        StringBuilder ret = new StringBuilder();
        char[] s = t.toCharArray();
        for(char ch : s) {
            if(ch != '#') {
                ret.append(ch);
            } else {
                if(ret.length() > 0) {
                    ret.deleteCharAt(ret.length() - 1);
                }
            }
        }
        return ret.toString();
    }
}
