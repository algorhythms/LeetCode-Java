package SimplifyPath;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * User: Danyang
 * Date: 1/28/2015
 * Time: 12:31
 * Given an absolute path for a file (Unix-style), simplify it.

 For example,
 path = "/home/", => "/home"
 path = "/a/./b/../../c/", => "/c"
 */
public class Solution {
    public String simplifyPath(String path) {
        List<String> lst = Arrays.asList(path.split("/"));
        List<String> stk = new ArrayList<>();
        for(String elt: lst) {
            if(elt.equals(".")) {
                continue;
            }
            else if(elt.equals("..")) {
                if(!stk.isEmpty())
                    stk.remove(stk.size()-1);
            }
            else if(elt.length()>0) {
                stk.add(elt);
            }
        }
        return "/"+stk.stream().collect(Collectors.joining("/"));
    }

    public static void main(String[] args) {
        String ret = new Solution().simplifyPath("/..");
        assert  ret.equals("/");
    }
}