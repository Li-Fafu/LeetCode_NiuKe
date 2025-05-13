/**
 *给定两个由小写字母组成的字符串 s1 和 s2，请编写一个程序，
 * 确定其中一个字符串的字符重新排列后，能否变成另一个字符串。
 */
public class Solution {
    public boolean CheckPermutation(String s1, String s2) {
        if(s1.length() != s2.length()){
            return false;
        }
        int[] hash1 = new int[26];
        for(int i = 0; i < s1.length(); i++) {
            hash1[s1.charAt(i) - 'a']++;
        }
        for(int i = 0; i < s2.length(); i++) {
            hash1[s2.charAt(i) - 'a']--;
            if(hash1[s2.charAt(i) - 'a'] < 0){
                return false;
            }
        }
        return true;
    }
}
