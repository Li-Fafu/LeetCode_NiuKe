/**
 * 给你一个字符串表达式 s ，请你实现一个基本计算器来计算并返回它的值。
 *
 * 整数除法仅保留整数部分。
 *
 * 你可以假设给定的表达式总是有效的。所有中间结果将在 [-231, 231 - 1] 的范围内。
 *
 * 注意：不允许使用任何将字符串作为数学表达式计算的内置函数，比如 eval() 。
 */

import java.util.Stack;

public class Solution {
    public int calculate(String ss) {
        Stack<Integer> st = new Stack<>();
        char operator = '+';
        char[] s = ss.toCharArray();
        int i = 0;
        while(i < s.length) {
            if(s[i] == ' '){//处理空格
                i++;
            } else if(s[i] >= '0' && s[i] <= '9') { //处理数字
                int tmp = s[i];
                while(i < s.length && s[i] >= '0' && s[i] <= '9'){
                    tmp = tmp * 10 + (s[i] - '0');
                    i++;
                }
                switch(operator) {
                    case '+' :
                        st.push(tmp);
                        break;
                    case '-' :
                        st.push(-tmp);
                        break;
                    case '/' :
                        st.push(st.pop() / tmp);
                        break;
                    case '*' :
                        st.push(st.pop() * tmp);
                        break;
                }
            } else {// 处理运算符
                operator = s[i++];
            }
        }
        int ret = 0;
        while(!st.empty()){
            ret += st.pop();
        }
        return ret;
    }
}
