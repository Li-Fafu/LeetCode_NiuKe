/**
 * 给你两个二进制字符串 a 和 b ，以二进制字符串的形式返回它们的和。
 * <p>
 * 高精度加法
 */
public class Solution {
    public String addBinary(String a, String b) {
        StringBuilder ret = new StringBuilder();
        int sum = 0;
        int cur1 = a.length() - 1;
        int cur2 = b.length() - 1;
        while(cur1 >= 0 || cur2 >= 0 ||  sum != 0) {
            if(cur1 >= 0) {
                sum += a.charAt(cur1--) - '0';
            }
            if(cur2 >= 0) {
                sum += b.charAt(cur2--) - '0';
            }
            ret.append((char)('0' + (char)(sum%2)));
            sum/=2;
        }
        return ret.reverse().toString();
    }
}
