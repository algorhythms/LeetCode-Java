package LongestSubstringWithoutRepeatingCharacters;

import java.util.HashSet;
import java.util.Set;

/**
 * User: Danyang
 * Date: 1/14/2015
 * Time: 21:32
 * Given a string, find the length of the longest substring without repeating characters. For example, the longest
 * substring without repeating letters for "abcabcbb" is "abc", which the length is 3. For "bbbbb" the longest substring
 * is "b", with the length of 1.
 */
public class Solution {
    /**
     * Window expanding
     * O(n)
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        int l = 0;
        int r = 0;
        int max = 0;
        Set<Character> appeared = new HashSet<>();
        for(; r<s.length(); r++) {
            if(!appeared.contains(s.charAt(r))) {
                appeared.add(s.charAt(r));
            }
            else {
                while(s.charAt(l)!=s.charAt(r)) {
                    appeared.remove(s.charAt(l));
                    l++;
                }
                if(l!=r)
                    l++;
            }
            max = Math.max(max, r-l+1);
        }
        return max;
    }
}