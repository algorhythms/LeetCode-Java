package LetterCombinationsofaPhoneNumber;

import java.util.*;

/**
 * User: Danyang
 * Date: 1/17/2015
 * Time: 21:23
 *
 * Given a digit string, return all possible letter combinations that the number could represent.

 A mapping of digit to letters (just like on the telephone buttons) is given below.



 Input:Digit string "23"
 Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 Note:
 Although the above answer is in lexicographical order, your answer could be in any order you want.
 */
public class Solution {
    public List<String> letterCombinations(String digits) {
        Map<Integer, List<String>> map = new HashMap<>();
        map.put(2, Arrays.asList("a", "b", "c"));
        map.put(3, Arrays.asList("d", "e", "f"));
        map.put(4, Arrays.asList("g", "h", "i"));
        map.put(5, Arrays.asList("j", "k", "l"));
        map.put(6, Arrays.asList("m", "n", "o"));
        map.put(7, Arrays.asList("p", "q", "r", "s"));
        map.put(8, Arrays.asList("t", "u", "v"));
        map.put(9, Arrays.asList("w", "x", "y", "z"));

        List<String> ret = new ArrayList<>();
        dfs(map, digits, "", ret);
        return ret;
    }

    void dfs(Map<Integer, List<String>> map, String seq, String cur, List<String> ret) {
        if(seq.length()==0) {
            ret.add(cur);
            return;
        }
        int d = seq.charAt(0)-'0';
        for(String s: map.get(d)) {
            dfs(map, seq.substring(1), cur+s, ret);
        }
    }

    public static void main(String[] args) {
        List<String> ret = new Solution().letterCombinations("23");
        System.out.println(ret);
    }
}
