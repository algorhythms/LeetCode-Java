package AddBinary;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * User: Danyang
 * Date: 1/28/2015
 * Time: 0:17
 *
 * Given two binary strings, return their sum (also a binary string).

 For example,
 a = "11"
 b = "1"
 Return "100".
 */
public class Solution {
    /**
     * Reverse
     * @param a
     * @param b
     * @return
     */
    public String addBinary(String a, String b) {
        List<Integer> ret = new ArrayList<>();
        if(a.length()>b.length()) {
            String t = a; a = b; b = t;
        }
        List<Integer> lst_a = a.chars().map(e -> e-'0').boxed().collect(Collectors.toList());
        List<Integer> lst_b = b.chars().map(e -> e-'0').boxed().collect(Collectors.toList());
        Collections.reverse(lst_a);
        Collections.reverse(lst_b);
        int carry = 0;
        for(int i=0; i<lst_b.size(); i++) {
            int s = carry+lst_b.get(i);
            if(i<lst_a.size())
                s += lst_a.get(i);
            ret.add(s%2);
            carry = s/2;
        }
        while(carry!=0) {
            ret.add(carry%2);
            carry -= 1;
        }
        Collections.reverse(ret);
        return ret.stream().map(Object::toString).collect(Collectors.joining());
    }
}