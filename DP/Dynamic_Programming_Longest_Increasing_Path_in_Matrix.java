package DP;/*
 *
 * https://www.geeksforgeeks.org/problems/longest-increasing-path-in-a-matrix/1
 *
 * # Longest Increasing Path in Matrix
 *
 *   Q. Given a matrix with n rows and m columns. Your task is to find the length of the longest path in with the
 *      following constraints
 *
 *        ◦ The values in path strictly increasing.  For example if a path of length k has values a₁, a₂, a₃, .... aₖ,
 *          then for every i from [2, k] this condition must hold a_i > a_i-1.
 *        ◦ No cell should be revisited in the path.
 *        ◦ From each cell,  you can move in any of the four directions: left, right, up, or down.
 *        ◦ You are not allowed to move diagonally or move outside the boundary.
 *
 *    Ex.
 *      Input : n = 3,
 *              m = 3,
 *              matrix[][] = [[1, 2, 3],
 *                            [4, 5, 6],
 *                            [7, 8, 9]]
 *      Output: 5
 *      Explanation: One such path is 1 -> 2 -> 3 -> 6 -> 9,                     |
 *                   where each number is strictly greater than the previous.    |     1 --> 2 --> 3
 *                                                                               |                 ↓
 *  Constraints:                                                                 |     4     5     6
 *        ◦ 1 ≤ n, m ≤ 1000                                                      |                 ↓
 *        ◦ 0 ≤ matrix[i][j] ≤ 2³⁰                                               |     7     8     9
 */

import java.util.Arrays;
import java.util.Scanner;

public class Dynamic_Programming_Longest_Increasing_Path_in_Matrix {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter dimension of matrix: ");
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] mat = new int[n][m];

        System.out.println("Enter matrix elements: ");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                mat[i][j] = sc.nextInt();
            }
        }

        System.out.println("Length of the longest increasing path: ");
        System.out.println(longIncPath(mat, n, m));
    }

    /// Solution
/*
-----------------------------------------------Memoization-+-DFS-traversal-----------------------------------------------
TC : O(n * m)
SC : O(n * m)
*/
    static int memoization(int[][] matrix, int n, int m) {
        // potd.code.hub
        int[][] dp = new int[n][m];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        int max = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (dp[i][j] == -1) {
                    max = Math.max(max, 1 + solve(i, j, n, m, matrix, dp));
                }
            }
        }

        return max;
    }

    private static final int[] dRow = {-1, 0, 1, 0};
    private static final int[] dCol = {0, 1, 0, -1};

    private static int solve(int r, int c, int n, int m, int[][] mat, int[][] dp) {
        if (dp[r][c] != -1) return dp[r][c];
        dp[r][c] = 0;

        int max = 0;

        for (int x = 0; x < 4; x++) {
            int nr = r + dRow[x];
            int nc = c + dCol[x];

            if (0 <= nr && nr < n && 0 <= nc && nc < m && mat[nr][nc] > mat[r][c]) {
                max = Math.max(max, 1 + solve(nr, nc, n, m, mat, dp));
            }
        }

        return dp[r][c] = max;
    }

/*
----------------------------------------------------Khan's-Algorithm----------------------------------------------------
TC : O(n * m)
SC : O(n * m)
*/
    static int longIncPath(int[][] mat, int n, int m) {
        int res = 0;
        int[] dRow = {-1, 0, 1, 0};
        int[] dCol = {0, 1, 0, -1};

        int head = -1;
        int tail = 0;
        int[] queue = new int[n * m];

        int[][] pathLen = new int[n][m];
        int[][] outDegrees = new int[n][m];

        // calculating in-degree
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < m; c++) {

                for (int x = 0; x < 4; x++) {
                    int nr = r + dRow[x];
                    int nc = c + dCol[x];

                    if (0 <= nr && nr < n && 0 <= nc && nc < m && mat[nr][nc] > mat[r][c]) {
                        outDegrees[r][c]++;
                    }
                }

                if (outDegrees[r][c] == 0) {
                    res = 1;
                    pathLen[r][c] = 1;
                    queue[++head] = (r << 16) | c;
                }
            }
        }

        // traversing the graph
        while (tail <= head) {
            int compressedCurr = queue[tail++];
            int r = compressedCurr >> 16;
            int c = compressedCurr & 0xFFFF;

            res = Math.max(res, pathLen[r][c]);

            for (int x = 0; x < 4; x++) {
                int nr = r + dRow[x];
                int nc = c + dCol[x];

                if (0 <= nr && nr < n && 0 <= nc && nc < m) {
                    if (mat[nr][nc] < mat[r][c]) {
                        if (--outDegrees[nr][nc] == 0) {
                            queue[++head] = (nr << 16) | nc;
                        }
                    } else if (mat[nr][nc] > mat[r][c]) {
                        pathLen[r][c] = Math.max(pathLen[r][c], 1 + pathLen[nr][nc]);
                        res = Math.max(res, pathLen[r][c]);
                    }
                }
            }
        }

        return res;
    }
}
