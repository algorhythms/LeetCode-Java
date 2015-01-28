package MinimumWindowSubstring;

import java.util.HashMap;
import java.util.Map;

/**
 * User: Danyang
 * Date: 1/28/2015
 * Time: 15:42
 *
 * Given a string S and a string T, find the minimum window in S which will contain all the characters in T in
 * complexity O(n).

 For example,
 S = "ADOBECODEBANC"
 T = "ABC"
 Minimum window is "BANC".

 Note:
 If there is no such window in S that covers all characters in T, return the empty string "".

 If there are multiple such windows, you are guaranteed that there will always be only one unique minimum window in S.
 */
public class Solution {
    /**
     * Expand and shrink window
     * Notice:
     * 1. T can have duplicated
     * @param S
     * @param T
     * @return
     */
    public String minWindow(String S, String T) {
        Map<Character, Integer> current = new HashMap<>();
        Map<Character, Integer> required = new HashMap<>();
        for(char c: T.toCharArray()) {
            current.put(c, 0);
            if(!required.containsKey(c))
                required.put(c, 0);
            required.put(c, required.get(c)+1);
        }
        int min_s = -1;
        int min_e = S.length();

        int i = 0;
        int j = 0;
        while(i<S.length() && j<S.length()+1) {
            if(!foundAll(current, required)) {
                if(j<S.length() && current.containsKey(S.charAt(j))) {
                    current.put(S.charAt(j), current.get(S.charAt(j))+1);
                }
                j++;
            }
            else {
                if(min_e-min_s>j-i) {
                    min_s = i;
                    min_e = j;
                }
                if(current.containsKey(S.charAt(i))) {
                    current.put(S.charAt(i), current.get(S.charAt(i))-1);
                }
                i++;
            }
        }
        if(min_s!=-1)
            return S.substring(min_s, min_e);
        else
            return "";
    }

    boolean foundAll(Map<Character, Integer> cur, Map<Character, Integer> required) {
        for(Map.Entry<Character, Integer> e: cur.entrySet()) {
            if(e.getValue()<required.get(e.getKey()))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String ret = new Solution().minWindow("a", "aa");
        System.out.println(ret);
    }
}
