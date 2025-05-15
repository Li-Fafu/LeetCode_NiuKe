/**
 * 给出由小写字母组成的字符串 s，重复项删除操作会选择两个相邻且相同的字母，并删除它们。
 *
 * 在 s 上反复执行重复项删除操作，直到无法继续删除。
 *
 * 在完成所有重复项删除操作后返回最终的字符串。答案保证唯一。
 */

import java.util.Stack;

//利用栈数据结构
public class Solution {
    public static String removeDuplicates(String s) {
        Stack stack = new Stack();
        int i = 1, j = 0;
        stack.push(s.charAt(0));
        while(i < s.length() && i >= 0) {
            if(!stack.empty() && stack.peek().equals(s.charAt(i))){
                stack.pop();
                j--;
                i++;
            } else {
                stack.push(s.charAt(i++));
                j++;
            }
        }
        StringBuilder ret = new StringBuilder();
        while(!stack.empty()){
            ret.append(stack.pop());
        }
        return ret.reverse().toString();
    }
    
    public static void main(String[] args) {
        String s = new String("abbaca");
        System.out.println(removeDuplicates(s));
    }
}
