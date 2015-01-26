package WordSearch;

/**
 * User: Danyang
 * Date: 1/26/2015
 * Time: 14:16
 *
 * Given a 2D board and a word, find if the word exists in the grid.

 The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally
 or vertically neighboring. The same letter cell may not be used more than once.

 For example,
 Given board =

 [
 ["ABCE"],
 ["SFCS"],
 ["ADEE"]
 ]
 word = "ABCCED", -> returns true,
 word = "SEE", -> returns true,
 word = "ABCB", -> returns false.
 */
public class Solution {
    int[][] directions = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    /**
     * O(N*2)*O(N*2)
     * traverse + dfs
     * @param board
     * @param word
     * @return
     */
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for(int i=0; i<m; i++)
            for(int j=0; j<n; j++)
                visited[i][j] = false;


        for(int i=0; i<m; i++)
            for(int j=0; j<n; j++)
                if(dfs(board, word, visited, 0, i, j))
                    return true;
        return false;
    }

    boolean dfs(char[][] board, String word, boolean[][] visited, int cur, int i, int j) {
        int m = board.length;
        int n = board[0].length;
        if(board[i][j]==word.charAt(cur)) {
            if(cur==word.length()-1)
                return true;
            visited[i][j] = true;
            for(int dir=0; dir<4; dir++) {
                int next_i = i+directions[dir][0];
                int next_j = j+directions[dir][1];
                if(next_i>=0 && next_i<m && next_j>=0 && next_j<n && !visited[next_i][next_j]) {
                    if(dfs(board, word, visited, cur+1, next_i, next_j))
                        return true;
                }
            }
            visited[i][j] = false;
        }
        return false;
    }

    public static void main(String[] args) {
        new Solution().exist(new char[][] {{'a', 'a'}}, "aa");
    }
}