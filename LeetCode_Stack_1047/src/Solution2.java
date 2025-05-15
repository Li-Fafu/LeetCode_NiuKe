//利用数组模拟栈
public class Solution2 {
    public static String removeDuplicates(String s) {
        StringBuilder ret = new StringBuilder();
        char[] nums = s.toCharArray();
        for(char ch : nums) {
            if(ret.length() > 0 && ch == ret.charAt(ret.length() - 1)) {
                ret.deleteCharAt(ret.length() - 1);
            } else {
                ret.append(ch);
            }
        }
        return ret.toString();
    }
    
    public static void main(String[] args) {
        String s = new String("abbaca");
        System.out.println(removeDuplicates(s));
    }
}
