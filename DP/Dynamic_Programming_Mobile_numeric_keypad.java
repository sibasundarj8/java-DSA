package DP;/*
 *
 * https://www.geeksforgeeks.org/problems/mobile-numeric-keypad5456/1
 *
 * # Mobile numeric keypad
 *
 *   Q. There is a standard numeric keypad on a mobile phone. You can press the current button or any button that
 *      is directly above, below, to the left, or to the right of it. For example, if you press 5, then pressing
 *      2, 4, 6, or 8 is allowed. However, diagonal movements and pressing the bottom row corner buttons (* and #)
 *      are not allowed.
 *                          _____________
 *                          | 1   2   3 |
 *                          | 4   5   6 |
 *                          | 7   8   9 |
 *                          | *   0   # |
 *                          -------------
 *      Given an integer n, determine how many unique sequences of length n can be formed by pressing buttons on
 *      the keypad, starting from any digit.
 *    Ex.
 *      Input : n = 2
 *      Output: 36
 *      Explanation: Possible 2-digit numbers follow keypad moves -
 *              From 0 → 00, 08 (2),
 *              From 1 → 11, 12, 14 (3),
 *              From 3 → 33, 32, 36 (3), and so on,
 *              total 36 valid combinations are possible.
 */

import java.util.Scanner;

public class Dynamic_Programming_Mobile_numeric_keypad {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("N : ");
        int n = sc.nextInt();

        System.out.println("Number of unique subsequence of length n : " + getCount(n));
    }

    /// Solution
/*
-----------------------------------------------------Space-Optimized-----------------------------------------------------
TC : O(n)
SC : O(1)
*/
    static int getCount(int n) {
        // potd.code.hub
        int ans = 0;
        char[][] keypad = {{'1', '2', '3'}, {'4', '5', '6'}, {'7', '8', '9'}, {'*', '0', '#'}};
        int[][] prev = new int[4][3];
        int[][] curr = new int[4][3];

        for (int i = 0; i < 4; i++)
            for (int j = 0; j < 3; j++)
                if (keypad[i][j] != '*' && keypad[i][j] != '#') prev[i][j] = 1;

        int[] row = {0, -1, 0, 1, 0};
        //           C--U--R---D--L
        int[] col = {0, 0, 1, 0, -1};

        for (int x = 1; x < n; x++) {
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 3; j++) {
                    if (keypad[i][j] == '*' || keypad[i][j] == '#') continue;
                    for (int z = 0; z < 5; z++) {
                        int r = i + row[z];
                        int c = j + col[z];
                        if (r < 0 || r > 3 || c < 0 || c > 2) continue;
                        curr[i][j] += prev[r][c];
                    }
                }
            }
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 3; j++) {
                    prev[i][j] = curr[i][j];
                    curr[i][j] = 0;
                }
            }
        }

        for (int i = 0; i < 4; i++) 
            for (int j = 0; j < 3; j++) 
                ans += prev[i][j];

        return ans;
    }
/*
-------------------------------------------------------Tabulation--------------------------------------------------------
TC : O(n)
SC : O(n)
*/
    static int getCount2(int n) {
        // potd.code.hub
        int ans = 0;
        char[][] keypad = {
                {'1', '2', '3'},
                {'4', '5', '6'},
                {'7', '8', '9'},
                {'*', '0', '#'}
        };
        int[][][] dp = new int[n][4][3];
        for (int i = 0; i < 4; i++) 
            for (int j = 0; j < 3; j++) 
                if (keypad[i][j] != '*' && keypad[i][j] != '#') 
                    dp[0][i][j] = 1;
                
        int[] row = {0, -1, 0, 1, 0};
        //           C--U--R--D---L
        int[] col = {0, 0, 1, 0, -1};

        for (int x = 1; x < n; x++) {
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 3; j++) {
                    if (keypad[i][j] == '*' || keypad[i][j] == '#') continue;
                    for (int z = 0; z < 5; z++) {
                        int r = i + row[z];
                        int c = j + col[z];
                        if (r < 0 || r > 3 || c < 0 || c > 2) continue;
                        dp[x][i][j] += dp[x-1][r][c];
                    }
                }
            }
        }

        for (int i = 0; i < 4; i++) 
            for (int j = 0; j < 3; j++) 
                ans += dp[n-1][i][j];
           
        return ans;
    }
/*
-------------------------------------------------------Memoization-------------------------------------------------------
TC : O(n)
SC : O(n) + (extra n for recursive stack)
*/
    static int getCount3(int n) {
        // potd.code.hub
        int ans = 0;
        char[][] keypad = {
                {'1', '2', '3'},
                {'4', '5', '6'},
                {'7', '8', '9'},
                {'*', '0', '#'}
        };
        int[][][] dp = new int[4][3][n];

        for (int i = 0; i < 4; i++) 
            for (int j = 0; j < 3; j++) 
                if (keypad[i][j] != '*' && keypad[i][j] != '#') 
                    ans += memo(i, j, n - 1, keypad, dp);
                  
        return ans;
    }

    private static int memo(int i, int j, int n, char[][] keypad, int[][][] dp) {
        // base case
        if (i < 0 || i > 3 || j < 0 || j > 2 || keypad[i][j] == '*' || keypad[i][j] == '#') return 0;
        if (n == 0) return 1;
        if (dp[i][j][n] > 0) return dp[i][j][n];

        // recursive work
        int c, u, d, l, r;
        c = memo(i, j, n - 1, keypad, dp);     // current
        u = memo(i-1, j, n-1, keypad, dp);     // up
        d = memo(i+1, j, n-1, keypad, dp);     // down
        l = memo(i, j-1, n-1, keypad, dp);     // left
        r = memo(i, j+1, n-1, keypad, dp);     // right

        // self work
        return dp[i][j][n] = c + u + d + l + r;
    }
}
