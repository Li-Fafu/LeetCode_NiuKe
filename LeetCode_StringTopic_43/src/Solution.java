/**
 * 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
 * 注意：不能使用任何内置的 BigInteger 库或直接将输入转换为整数。
 */
public class Solution {
    public String multiply(String num1, String num2) {
        if(num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        StringBuilder ret = new StringBuilder();
        StringBuilder str1 = new StringBuilder(num1);
        StringBuilder str2 = new StringBuilder(num2);
        num1 = str1.reverse().toString();
        num2 = str2.reverse().toString();
        int[] tmp = new int[num1.length() + num2.length() - 1];
        int i = 0;
        for(; i < num2.length(); i++) {
            for(int j = 0; j < num1.length(); j++) {
                tmp[i + j] += (num2.charAt(i) - '0') * (num1.charAt(j) - '0');
            }
        }
        int sum = 0;
        i = 0;
        while(i < (num1.length() + num2.length() - 1) || sum != 0) {
            if(i < (num1.length() + num2.length() - 1)) {
                sum += tmp[i++];
            }
            ret.append((char) (sum % 10 + '0'));
            sum /= 10;
        }
        
        return ret.reverse().toString();
    }
    
    public static void main(String[] args) {
        String s1= "2";
        String s2= "3";
        Solution solution = new Solution();
        System.out.println(solution.multiply(s1, s2));
    }
}
