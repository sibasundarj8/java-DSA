package Graph;/*
 * 
 * https://www.geeksforgeeks.org/problems/replace-os-with-xs0052/1
 *
 * # Replace O's with X's
 *
 *   Q. Given a matrix mat where every element is either 'O' or 'X'. Replace all 'O' or a group
 *      of 'O' with 'X' that are surrounded by 'X'.
 *
 *      A 'O' (or a set of 'O') is considered to be surrounded by 'X' if there are
 *      'X' at locations just below, just above, just left and just right of it.
 *   Ex.
 *      Input : mat = [['X', 'X', 'X', 'X'],
 *                     ['X', 'O', 'X', 'X'],
 *                     ['X', 'O', 'O', 'X'],
 *                     ['X', 'O', 'X', 'X'],
 *                     ['X', 'X', 'O', 'O']]
 *
 *      Output: [['X', 'X', 'X', 'X'],
 *               ['X', 'X', 'X', 'X'],
 *               ['X', 'X', 'X', 'X'],
 *               ['X', 'X', 'X', 'X'],
 *               ['X', 'X', 'O', 'O']]
 *
 *      Explanation: We only changed those 'O' that are surrounded by 'X'
 */

import java.util.Arrays;

public class Graph_Replace_Os_with_Xs {

    /// main Method
    public static void main(String[] args) {
        char[][] mat = {{'X', 'X', 'X', 'X'},
                        {'X', 'O', 'X', 'X'},
                        {'X', 'O', 'O', 'X'},
                        {'X', 'O', 'X', 'X'},
                        {'X', 'X', 'O', 'O'}};
        char[][] ans = fill(mat);

        for (char[] i : ans){
            for (char j : i)
                System.out.print(j + " ");
            System.out.println();
        }
    }

    /// Solution
    static char[][] fill(char[][]mat) {
        // potd.code.hub
        int n = mat.length, m = mat[0].length;

        char[][] ans = new char[n][m];
        Arrays.stream(ans).forEach(a -> Arrays.fill(a, 'X'));

        int[]dRow = {0, -1, 0, 1};
        int[]dCol = {-1, 0, 1, 0};

        for (int i = 0;i < n;i++){
            // 1st col
            if (mat[i][0] == 'O' && ans[i][0] == 'X')
                dfs(i, 0, mat, ans, dRow, dCol, n, m);
            // last col
            if (mat[i][m-1] == 'O' && ans[i][m-1] == 'X')
                dfs(i, m-1, mat, ans, dRow, dCol, n, m);
        }

        for (int i = 0;i < m;i++){
            // 1st row
            if (mat[0][i] == 'O' && ans[0][i] == 'X')
                dfs(0, i, mat, ans, dRow, dCol, n, m);
            // last row
            if (mat[n-1][i] == 'O' && ans[n-1][i] == 'X')
                dfs(n-1, i, mat, ans, dRow, dCol, n, m);
        }

        return ans;
    }
    private static void dfs (int r, int c, char[][]mat, char[][]ans, int[]dRow, int[]dCol, int n, int m){
        ans[r][c] = 'O';
        for (int i = 0;i < 4;i++){
            int nRow = r + dRow[i];
            int nCol = c + dCol[i];
            if (0 <= nRow && nRow < n && 0 <= nCol && nCol < m &&
                mat[nRow][nCol] == 'O' && ans[nRow][nCol] == 'X'){
                dfs(nRow, nCol, mat, ans, dRow, dCol, n, m);
            }
        }
    }
}
