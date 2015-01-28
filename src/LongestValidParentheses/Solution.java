package LongestValidParentheses;

import java.util.Stack;

/**
 * User: Danyang
 * Date: 1/28/2015
 * Time: 19:31
 *
 * Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed)
 * parentheses substring.

 For "(()", the longest valid parentheses substring is "()", which has length = 2.

 Another example is ")()())", where the longest valid parentheses substring is "()()", which has length = 4.
 */
public class Solution {
    /**
     * Stack
     * https://github.com/zhangdanyangg/LeetCode/blob/master/031%20Longest%20Valid%20Parentheses.py
     *
     * Stack holds the index of unpaired bracket
     * @param s
     * @return
     */
    public int longestValidParentheses(String s) {
        int gmax = 0;
        Stack<Integer> stk = new Stack<>();
        char[] cs = s.toCharArray();
        for(int i=0; i<cs.length; i++) {
            if(cs[i]==')' && !stk.isEmpty() && cs[stk.peek()]=='(') {
                stk.pop();
                if(!stk.isEmpty())
                    gmax = Math.max(gmax, i-stk.peek());
                else
                    gmax = Math.max(gmax, i+1);
            }
            else {
                stk.push(i);
            }
        }
        return gmax;
    }
}