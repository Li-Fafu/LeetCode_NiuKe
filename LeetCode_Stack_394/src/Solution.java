/**
 * 给定一个经过编码的字符串，返回它解码后的字符串。
 * 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
 * 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
 * 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。
 */

import java.util.Stack;

public class Solution {
    public static String decodeString(String s) {
        Stack<StringBuilder> sts = new Stack<>();
        Stack<Integer> stnums = new Stack<>();
        char[] ss = s.toCharArray();
        sts.push(new StringBuilder());
        
        for (int i = 0; i < ss.length; ) {
            
            if(ss[i] <= '9' && ss[i] >= '0') {
                int tmpnums = 0;
                while(i < ss.length && ss[i] <= '9' && ss[i] >= '0') {
                    tmpnums = tmpnums * 10 + (ss[i] - '0');
                    i++;
                }
                stnums.push(tmpnums);
            } else if(ss[i] == '[') {
                i++;
                StringBuilder tmp = new StringBuilder();
                while(i < ss.length && ss[i] <= 'z' && ss[i] >= 'a') {
                    tmp.append(ss[i]);
                    i++;
                }
                sts.push(tmp);
            } else if(ss[i] == ']') {
                int k = stnums.pop();
                StringBuilder tmp = sts.pop();
                while(k-- > 0 ) {
                    sts.peek().append(tmp);
                }
                i++;
            } else {
                StringBuilder tmp = new StringBuilder();
                while(i < ss.length && ss[i] <= 'z' && ss[i] >= 'a') {
                    tmp.append(ss[i]);
                    i++;
                }
                sts.peek().append(tmp);
            }
        }
        return sts.pop().toString();
    }
    
    public static void main(String[] args) {
        System.out.println(decodeString("3[a]2[bc]"));
    }
}
