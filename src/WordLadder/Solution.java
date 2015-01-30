package WordLadder;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * User: Danyang
 * Date: 1/30/2015
 * Time: 22:30
 *
 * Given two words (start and end), and a dictionary, find the length of shortest transformation sequence from start to
 * end, such that:

 Only one letter can be changed at a time
 Each intermediate word must exist in the dictionary
 For example,

 Given:
 start = "hit"
 end = "cog"
 dict = ["hot","dot","dog","lot","log"]
 As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 return its length 5.

 Note:
 Return 0 if there is no such transformation sequence.
 All words have the same length.
 All words contain only lowercase alphabetic characters.
 */
public class Solution {
    /**
     * Algorithm bfs
     *
     * Notice:
     * 1. TLE due to the timing of remove the string from dict;
     * @param start
     * @param end
     * @param dict
     * @return
     */
    public int ladderLength_TLE(String start, String end, Set<String> dict) {
        List<String> q = new ArrayList<>();
        q.add(start);
        int level = 1;
        while(!q.isEmpty()) {
            int l = q.size();
            level++;

            for(int i=0; i<l; i++) {
                String cur = q.get(i);
                dict.remove(cur);

                for(int j=0; j<cur.length(); j++) {
                    char[] c = cur.toCharArray();
                    for(char char1='a'; char1<='z'; char1++) {
                        c[j] = char1;
                        // String next = c.toString();  // bug
                        String next = new String(c);
                        if(next.equals(end))
                            return level;
                        if(dict.contains(next))
                            q.add(next);
                    }
                }
            }
            q = q.subList(l, q.size());
        }
        return 0;
    }

    public int ladderLength(String start, String end, Set<String> dict) {
        List<String> q = new ArrayList<>();
        q.add(start);
        dict.remove(start);
        int level = 1;
        while(!q.isEmpty()) {
            int l = q.size();
            level++;

            for(int i=0; i<l; i++) {
                String cur = q.get(i);

                for(int j=0; j<cur.length(); j++) {
                    char[] c = cur.toCharArray();
                    for(char char1='a'; char1<='z'; char1++) {
                        c[j] = char1;
                        // String next = c.toString();  // bug
                        String next = new String(c);
                        if(next.equals(end))
                            return level;
                        if(dict.contains(next)) {
                            q.add(next);
                            dict.remove(next);
                        }

                    }
                }
            }
            q = q.subList(l, q.size());
        }
        return 0;
    }

    public static void main(String[] args) {
        Set<String> dict = new HashSet<>();
        dict.add("a");
        dict.add("b");
        dict.add("c");
        int ret = new Solution().ladderLength("a", "c", dict);
        System.out.println(ret);
    }
}