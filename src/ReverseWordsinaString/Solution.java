package ReverseWordsinaString;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * User: Danyang
 * Date: 1/28/2015
 * Time: 12:19
 *
 * Given an input string, reverse the string word by word.

 For example,
 Given s = "the sky is blue",
 return "blue is sky the".
 */
public class Solution {
    public String reverseWords(String s) {
        List<String> lst = Arrays.asList(s.trim().split("\\s+"));
        Collections.reverse(lst);
        return lst.stream().collect(Collectors.joining(" "));
    }
}