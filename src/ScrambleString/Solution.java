package ScrambleString;

import java.util.HashMap;
import java.util.Map;

/**
 * User: Danyang
 * Date: 1/28/2015
 * Time: 19:06
 *
 * Given a string s1, we may represent it as a binary tree by partitioning it to two non-empty substrings recursively.

 Below is one possible representation of s1 = "great":

 great
 /    \
 gr    eat
 / \    /  \
 g   r  e   at
 / \
 a   t
 To scramble the string, we may choose any non-leaf node and swap its two children.

 For example, if we choose the node "gr" and swap its two children, it produces a scrambled string "rgeat".

 rgeat
 /    \
 rg    eat
 / \    /  \
 r   g  e   at
 / \
 a   t
 We say that "rgeat" is a scrambled string of "great".

 Similarly, if we continue to swap the children of nodes "eat" and "at", it produces a scrambled string "rgtae".

 rgtae
 /    \
 rg    tae
 / \    /  \
 r   g  ta  e
 / \
 t   a
 We say that "rgtae" is a scrambled string of "great".

 Given two strings s1 and s2 of the same length, determine if s2 is a scrambled string of s1.
 */
public class Solution {
    /**
     * Algorithm: recursive
     * treat as set of chars
     * partition the string
     *
     * Notice:
     * 1. prune, otherwise TLE
     * @param s1
     * @param s2
     * @return
     */
    public boolean isScramble(String s1, String s2) {
        if(s1.equals(s2))
            return true;
        if(!relaxedEqual(s1, s2))
            return false;

        for(int l=1; l<s1.length(); l++)
            if(isScramble(s1.substring(0, l), s2.substring(0, l)) &&
                    isScramble(s1.substring(l, s1.length()), s2.substring(l, s2.length())) ||
                    isScramble(s1.substring(0, l), s2.substring(s2.length()-l, s2.length())) &&
                            isScramble(s1.substring(l, s1.length()), s2.substring(0, s2.length()-l)))
                return true;
        return false;
    }

    boolean relaxedEqual(String s1, String s2) {
        Map<Character, Integer> bucket = new HashMap<>();
        for(char c: s1.toCharArray()) {
            if(!bucket.containsKey(c))
                bucket.put(c, 0);
            bucket.put(c, bucket.get(c)+1);
        }
        for(char c: s2.toCharArray()) {
            if(!bucket.containsKey(c) || bucket.get(c)<1)
                return false;
            bucket.put(c, bucket.get(c)-1);
        }
        for(Map.Entry<Character, Integer> e: bucket.entrySet()) {
            if(e.getValue()!=0)
                return false;
        }
        return true;
    }
}