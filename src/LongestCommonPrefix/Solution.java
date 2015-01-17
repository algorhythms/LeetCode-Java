package LongestCommonPrefix;

/**
 * User: Danyang
 * Date: 1/17/2015
 * Time: 13:00
 *
 * Write a function to find the longest common prefix string amongst an array of strings.
 */
public class Solution {
    /**
     * Just iterate
     * @param strs
     * @return
     */
    public String longestCommonPrefix(String[] strs) {
        StringBuilder sb = new StringBuilder("");
        int i = 0;
        if(strs.length==0)
            return sb.toString();

        while(true) {
            if(strs[0].length()-1<i)
                return sb.toString();

            char c = strs[0].charAt(i);
            for(int j=1; j<strs.length; j++) {
                if(strs[j].length()-1<i || strs[j].charAt(i)!=c)
                    return sb.toString();
            }
            sb.append(c);
            i++;
        }
    }
}