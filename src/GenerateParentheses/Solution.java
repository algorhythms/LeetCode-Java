package GenerateParentheses;

import java.util.ArrayList;
import java.util.List;

/**
 * User: Danyang
 * Date: 1/17/2015
 * Time: 16:29
 */
public class Solution {
    /**
     * Notice:
     * 1. reference to save space
     * @param n
     * @return
     */
    public List<String> generateParenthesis(int n) {
        List<String> ret = new ArrayList<>();
        dfs(n, 0, 0, new StringBuilder(), ret);
        return ret;
    }

    public void dfs(int n, int l, int r, StringBuilder cur, List<String> ret) {
        if(r==n&&l==n) {
            ret.add(cur.toString());
            return ;
        }
        if(l+1<=n) {
            dfs(n, l+1, r, cur.append("("), ret);
            cur.delete(l+r, l+r+1);
        }
        if(l<=n && r<l) {
            dfs(n, l, r+1, cur.append(")"), ret);
            cur.delete(l+r, l+r+1);
        }
    }
}