package DecodeWays;

import java.util.HashMap;
import java.util.Map;

/**
 * User: Danyang
 * Date: 1/28/2015
 * Time: 13:53
 */
public class Solution {
    Map<String, Integer> cache = new HashMap<>();

    /**
     * Notice:
     * 1. dp
     * @param s
     * @return
     */
    public int numDecodings(String s) {
        if(s.length()<1)
            return 0;
        return getNumDecodings(s);
    }

    int getNumDecodings(String s) {
        if(s.length()<1)
            return 1;
        if(s.length()==1)
            if(s.equals("0"))
                return 0;
            else
                return 1;

        if(!cache.containsKey(s)) {
            int ways = 0;
            if(s.charAt(0)!='0') {
                ways += getNumDecodings(s.substring(1, s.length()));
                if(s.length()>1) {
                    int num =  Integer.parseInt(s.substring(0, 2));
                    if(num>0 && num<=26)
                        ways += getNumDecodings(s.substring(2, s.length()));
                }
            }
            cache.put(s, ways);
        }
        return cache.get(s);
    }
}