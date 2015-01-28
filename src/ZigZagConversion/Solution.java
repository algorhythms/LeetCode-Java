package ZigZagConversion;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * User: Danyang
 * Date: 1/28/2015
 * Time: 11:24
 *
 * he string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to
 * display this pattern in a fixed font for better legibility)

 P   A   H   N
 A P L S I I G
 Y   I   R
 And then read line by line: "PAHNAPLSIIGYIR"
 Write the code that will take a string and make this conversion given a number of rows:

 string convert(string text, int nRows);
 convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
 */
public class Solution {
    /**
     * Notice:
     * 1. new ArrayList<>(n); // initialize array with length n, but not the object itself
     * @param s
     * @param nRows
     * @return
     */
    public String convert(String s, int nRows) {
        List<StringBuilder> rows = new ArrayList<>();
        for(int i=0; i<nRows; i++)
            rows.add(new StringBuilder());
        if(nRows==1)
            return s;
        char[] cs = s.toCharArray();
        for(int i=0; i<cs.length; i++) {
            int pos = i%(2*nRows-2);
            if(pos<nRows)
                rows.get(pos).append(cs[i]);
            else
                rows.get(2*nRows-2-pos).append(cs[i]);
        }
        return rows.stream().map(StringBuilder::toString).collect(Collectors.joining());
    }

    public static void main(String[] args) {
        String ret = new Solution().convert("A", 2);
        System.out.println(ret);
    }
}