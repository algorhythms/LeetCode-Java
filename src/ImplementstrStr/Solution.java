package ImplementstrStr;

/**
 * User: Danyang
 * Date: 1/29/2015
 * Time: 19:26
 *
 * Implement strStr().

 Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 */
public class Solution {
    /**
     * KMP
     *
     * Notice:
     * 1. build a table of the length of matched prefix_suffix - PREFIX SUFFIX LENGTH TABLE
     * 2. test case "mississippi", "issip"; "redoredoreo", "redoreo"
     * 3. S[i+j]
     * @param haystack
     * @param needle
     * @return
     */
    public int strStr(String haystack, String needle) {
        if(haystack.length()<needle.length())
            return -1;
        if(needle.length()<=1)
            return haystack.indexOf(needle);

        char[] S = haystack.toCharArray();
        char[] W = needle.toCharArray();
        // build prefix_suffix_length_table
        int[] T = new int[W.length+1];
        T[0] = -1;
        T[1] = 0;
        int i = 0;
        int j;
        for(j=1; j<W.length; ) {
            if(W[i]==W[j]) {
                T[j+1] = i+1;
                i++;
                j++;
            }
            else if(i!=0) {  // reredo...rerereply
                i = T[i];
            }
            else {
                T[j+1] = 0;
                j++;
            }
        }

        // search
        i = 0;
        j = 0;
        while(i+j<S.length) {
            if(S[i+j]==W[j]) {
                j++;
                if(j==W.length)
                    return i;
            }
            else {
                if(T[j]!=-1) {
                    i = i+j-T[j];
                    j = T[j];
                }
                else {
                    i += 1;
                    j = 0;
                }
            }
        }
        return -1;
    }
}