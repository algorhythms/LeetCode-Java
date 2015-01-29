package SubstringwithConcatenationofAllWords;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * User: Danyang
 * Date: 1/29/2015
 * Time: 10:05
 *
 * You are given a string, S, and a list of words, L, that are all of the same length. Find all starting indices of
 * substring(s) in S that is a concatenation of each word in L exactly once and without any intervening characters.

 For example, given:
 S: "barfoothefoobarman"
 L: ["foo", "bar"]

 You should return the indices: [0,9].
 (order does not matter).
 */
public class Solution {
    /**
     * https://github.com/zhangdanyangg/LeetCode/blob/master/029%20Substring%20with%20Concatenation%20of%20All%20Words.py
     *
     * Algorithm:
     * Two pointers, sliding window, O(n*k)
     *
     * Notice:
     * 1. equal length
     * 2. when fail finding word, i need to go back to beginning
     * @param S
     * @param L
     * @return
     */
    public List<Integer> findSubstring(String S, String[] L) {
        List<Integer> ret = new ArrayList<>();
        if(L.length<1 || S.length()<1)
            return ret;

        Map<String, Long> Lmap_origin = Stream.of(L).collect(
                Collectors.groupingBy(e -> e, Collectors.counting())
        );

        Map<String, Long> Lmap = new HashMap<>(Lmap_origin);  // copy constructor
        List<String> workingWin = new ArrayList<>();

        int i = 0;
        int k = L[0].length();
        int win_e = -1;
        while(i<S.length()) {
            if(workingWin.size()==L.length) {
                ret.add(win_e-workingWin.size()*k);
                int next = win_e-workingWin.size()*k+1;
                if(Lmap.containsKey(S.substring(next, Math.min(next+k, S.length())))) {
                    i = next;
                    workingWin.clear();
                    win_e = -1;
                    Lmap = new HashMap<>(Lmap_origin);
                }
            }


            String word = S.substring(i, Math.min(i+k, S.length()));
            if(!Lmap.containsKey(word)) {
                if(workingWin.isEmpty())
                    i++;
                else
                    i = win_e-workingWin.size()*k+1;
                workingWin.clear();
                win_e = -1;
                Lmap = new HashMap<>(Lmap_origin);
            }
            else if(Lmap.get(word)>0) {  // found remain
                win_e = i+k;
                Lmap.put(word, Lmap.get(word)-1);
                workingWin.add(word);
                i = win_e;
            }
            else {
                int indexOf = workingWin.indexOf(word);
                for(int j=0; j<=indexOf; j++) {
                    String word2 = workingWin.get(j);
                    Lmap.put(word2, Lmap.get(word2)+1);
                }
                win_e = i+k;
                Lmap.put(word, Lmap.get(word)-1);
                workingWin = workingWin.subList(indexOf+1, workingWin.size());
                workingWin.add(word);
                i = win_e;
            }
        }
        if(workingWin.size()==L.length)  // when reaching end: test case Input: "a", ["a"]
            ret.add(win_e-workingWin.size()*k);
        return ret;
    }

    public static void main(String[] args) {
        List<Integer> ret = new Solution().findSubstring("aaaaaaaa", new String[]{"aa", "aa", "aa"});
        List<Integer> expected = Arrays.asList(new Integer[]{0, 1, 2});
        assert ret.equals(expected);
    }
}