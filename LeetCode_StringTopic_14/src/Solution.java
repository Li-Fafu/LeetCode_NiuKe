/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 *
 * 如果不存在公共前缀，返回空字符串 ""。
 */
public class Solution {
    public String longestCommonPrefix(String[] strs) {
        String ret = new String();
        for(int i = 0; i < strs.length - 1; i++) {
            ret = findCommen(strs[i], strs[i+1]);
        }
        return ret;
    }
    
    public static String findCommen(String s1, String s2){
        for(int i = 0; i < Math.min(s1.length(), s2.length()); i++) {
            if (s1.charAt(i) != s2.charAt(i)){
                return s1.substring(0,i);
            }
        }
        return s1.length() < s2.length() ? s1 : s2;
    }
}
