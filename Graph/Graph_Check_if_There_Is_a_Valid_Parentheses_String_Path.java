package Graph;/*
 *
 * https://leetcode.com/problems/check-if-there-is-a-valid-parentheses-string-path/
 *
 * # LC. 2267. Check if There Is a Valid Parentheses String Path
 *
 *   Q. A parentheses string is a non-empty string consisting only of '(' and ')'. It is valid if any of the
 *      following conditions is true:
 *        ◦ It is ().
 *        ◦ It can be written as AB (A concatenated with B), where A and B are valid parentheses strings.
 *        ◦ It can be written as (A), where A is a valid parentheses string.
 *
 *      You are given an m x n matrix of parentheses grids. A valid parentheses string path in the grid is a
 *      path satisfying all the following conditions:
 *        ◦ The path starts from the upper left cell (0, 0).
 *        ◦ The path ends at the bottom-right cell (m - 1, n - 1).
 *        ◦ The path only ever moves down or right.
 *        ◦ The resulting parentheses string formed by the path is valid.
 *
 *      Return true if there exists a valid parentheses string path in the grid. Otherwise, return false.
 *
 *    Ex.
 *      Input : grid = '(' '(' '('
 *                     ')' '(' ')'
 *                     '(' '(' ')'
 *                     '(' '(' ')'
 *      Output: true
 *      Explanation: The above diagram shows two possible paths that form valid parentheses strings.
 *                   The first path shown results in the valid parentheses string "()(())".
 *                   The second path shown results in the valid parentheses string "((()))".
 *                   Note that there may be other valid parentheses string paths.
 *
 *  Constraints:
 *        ◦ m == grid.length
 *        ◦ n == grid[i].length
 *        ◦ 1 <= m, n <= 100
 *        ◦ grid[i][j] is either '(' or ')'.
 */

import java.util.Scanner;

public class Graph_Check_if_There_Is_a_Valid_Parentheses_String_Path {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter dimension of grid: ");
        int n = sc.nextInt();
        int m = sc.nextInt();
        char[][] grid = new char[n][m];

        System.out.println("Enter elements: ");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                grid[i][j] = sc.next().charAt(0);

                if (grid[i][j] != '(' && grid[i][j] != ')') {
                    throw new IllegalArgumentException("Invalid input. Must be an parenthesis");
                }
            }
        }

        System.out.println("is there a valid path: ");
        System.out.println(hasValidPath(grid) ? "YES" : "NO");
    }

    /// Solution
    static boolean hasValidPath(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int pathLen = n + m - 1;

        // odd length parentheses never be valid
        if ((pathLen & 1) == 1) return false;

        int[][][] dp = new int[n][m][n + m];

        return solve(n - 1, m - 1, pathLen, pathLen, grid, dp);
    }

    private static boolean solve(int i, int j, int bal, int tar, char[][] grid, int[][][] dp) {
        // base case
        if (i < 0 || j < 0) return false;
        if (bal > tar) return false;

        if (i == 0 && j == 0) {
            int val = (grid[i][j] == '(') ? 1 : -1;
            return bal + val == tar;
        }

        if (dp[i][j][bal] != 0) return dp[i][j][bal] == 1;

        // recursive case
        int val = (grid[i][j] == '(') ? 1 : -1;

        boolean res = solve(i - 1, j, bal + val, tar, grid, dp) ||
                solve(i, j - 1, bal + val, tar, grid, dp);

        dp[i][j][bal] = res ? 1 : -1;
        return res;
    }
}
