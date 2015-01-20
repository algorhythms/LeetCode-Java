package Anagrams;

import java.util.*;

/**
 * User: Danyang
 * Date: 1/20/2015
 * Time: 11:04
 * Given an array of strings, return all groups of strings that are anagrams.

 Note: All inputs will be in lower-case.
 */
public class Solution {
    /**
     * Map and String manipulation
     * @param strs
     * @return need to understand what to return
     */
    public List<String> anagrams(String[] strs) {
        Map<String, List<Integer>> map = new HashMap<>();
        for(int i=0; i<strs.length; i++) {
            String s = sort(strs[i]);
            if(!map.containsKey(s)) {
                List<Integer> lst = new ArrayList<>();
                lst.add(i);
                map.put(s, lst);
            }
            else {
                map.get(s).add(i);
            }
        }

        List<String> ret = new ArrayList<>();
        for(Map.Entry<String, List<Integer>> e: map.entrySet()) {
            if(e.getValue().size()>1) {
                for(Integer i: e.getValue())
                    ret.add(strs[i]);
            }
        }
        return ret;
    }

    public String sort(String s) {
        char [] cs = s.toCharArray();
        Arrays.sort(cs);
        return new String(cs);
    }
}