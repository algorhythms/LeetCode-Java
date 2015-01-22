package ClimbingStairs;

/**
 * User: Danyang
 * Date: 1/22/2015
 * Time: 20:38
 *
 * You are climbing a stair case. It takes n steps to reach to the top.

 Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 */
public class Solution {
    /**
     * basic dp
     * f[i] = f[i-2]+f[i-1]
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        if(n<0)
            return 0;
        if(n==1)
            return 1;
        if(n==2)
            return 2;

        int a = 1;
        int b = 2;
        while(n>=3) {
            int t = b;
            b = a+b;
            a = t;
            n--;
        }
        return b;
    }
}