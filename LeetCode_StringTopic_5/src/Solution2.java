public class Solution2 {
    public String longestPalindrome(String s) {
        if(s.length() == 1) {
            return s;
        }
        int left = 0, right = 0;
        int len = 0, start = 0;
        for(int i = 0; i < s.length() - 1; i++) {
            
            left = i;
            right = i;
            while(right < s.length() && left >= 0 && s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
            }
            if((right - left - 1) > len) {
                start = left + 1;
                len = right - left - 1;
            }
            left = i;
            right = i + 1;
            while(right < s.length() && left >= 0 && s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
            }
            if((right - left - 1) > len) {
                start = left + 1;
                len = right - left - 1;
            }
        }
            return s.substring(start, start + len);
       
    }
        public static void main (String[] args){
            String s = new String("babad");
            Solution2 solution2 = new Solution2();
            System.out.println(solution2.longestPalindrome(s));
        }
    }
