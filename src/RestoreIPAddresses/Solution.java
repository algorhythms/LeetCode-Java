package RestoreIPAddresses;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * User: Danyang
 * Date: 1/28/2015
 * Time: 10:58
 *
 * Given a string containing only digits, restore it by returning all possible valid IP address combinations.

 For example:
 Given "25525511135",

 return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)
 */
public class Solution {
    /**
     * Notice:
     * 1. zero heading
     * @param s
     * @return
     */
    public List<String> restoreIpAddresses(String s) {
        List<String> ret = new ArrayList<>();
        dfs(s, 4, new ArrayList<>(), ret);
        return ret;
    }

    void dfs(String seq, int n, List<String> cur, List<String> ret) {
        if(n==0) {
            if(seq.length()==0)
                ret.add(cur.stream().collect(Collectors.joining(".")));
        }
        else {
            for(int i=1; i<=seq.length() && i<=3; i++) {
                String sub = seq.substring(0, i);
                if(isValidSegment(sub)) {
                    cur.add(sub);
                    dfs(seq.substring(i, seq.length()), n-1, cur, ret);
                    cur.remove(cur.size()-1);
                }
            }
        }

    }

    boolean isValidSegment(String s) {
        if(s.length()>3 || s.length()<1)
            return false;
        if(s.length()>1 && s.charAt(0)=='0')
            return false;
        if(Integer.parseInt(s)>255)
            return false;
        return true;
    }

    public static void main(String[] args) {
        List<String> ret = new Solution().restoreIpAddresses("25525511135");
        System.out.println(ret);
    }
}