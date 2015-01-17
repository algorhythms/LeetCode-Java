package ValidParentheses;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * User: Danyang
 * Date: 1/17/2015
 * Time: 16:15
 *
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

 The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
 */
public class Solution {
    /**
     * Notice:
     * 1. Character vs. String in Java, different from Python
     * @param s
     * @return
     */
    public boolean isValid(String s) {
        Map<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('{', '}');
        map.put('[', ']');
        Stack<Character> stk = new Stack<>();
        for(char c: s.toCharArray()) {
            if(map.containsKey(c))
                stk.push(c);
            else {
                if(stk.empty())
                    return false;
                char l = stk.pop();
                if(!map.get(l).equals(c))
                    return false;
            }
        }
        if(stk.empty())
            return true;
        else
            return false;
    }

    public static void main(String[] args) {
        boolean ret = new Solution().isValid("()");
        assert ret==true;
    }
}