package DP;/*
 *
 * https://leetcode.com/problems/number-of-sets-of-k-non-overlapping-line-segments/
 *
 * # LC. 1621. Number of Sets of K Non-Overlapping Line Segments
 *
 *   Q. Given n points on a 1-D plane, where the ith point (from 0 to n-1) is at x = i, find the number of ways we can
 *      draw exactly k non-overlapping line segments such that each segment covers two or more points. The endpoints of
 *      each segment must have integral coordinates. The k line segments do not have to cover all n points, and they are
 *      allowed to share endpoints.
 *
 *      Return the number of ways we can draw k non-overlapping line segments. Since this number can be huge, return it
 *      modulo 10⁹ + 7.
 *
 *    Ex.
 *      Input: n = 4, k = 2
 *      Output: 5
 *      Explanation: The two line segments are shown in red and blue.
 *                   there are 5 different ways (0, 2), (2, 3),
 *                                              (0, 1), (1, 3),
 *                                              (0, 1), (2, 3),
 *                                              (1, 2), (2, 3),
 *                                              (0, 1), (1, 2).
 *
 *  Constraints:
 *        ◦ 2 <= n <= 1000
 *        ◦ 1 <= k <= n-1
 */

import java.util.Scanner;

public class Dynamic_Programming_1621_Number_of_Sets_of_K_Non_Overlapping_Line_Segments {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("n: ");
        int n = sc.nextInt();

        System.out.print("k: ");
        int k = sc.nextInt();

        System.out.println("Number of ways we can draw k non-overlapping line segments: ");
        System.out.println(numberOfSets(n, k));
    }

    /// Solution
/*
-------------------------------------------------------memoization-------------------------------------------------------
TC : O(n × k)
SC : O(n × k) + extra recursive call stack
*/
    private static final int MOD = (int) (1e9 + 7);

    static int approach_1(int n, int k) {
        // potd.code.hub
        int[][][] dp = new int[n + 1][k + 1][2];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= k; j++) {
                dp[i][j][0] = -1;
                dp[i][j][1] = -1;
            }
        }

        return solve(n, k, 0, dp);
    }

    private static int solve(int i, int x, int flag, int[][][] dp) {
        // base case
        if (x < 0) return 0;

        if (i == 0) {
            if (x == 0 && flag == 0) return 1;
            return 0;
        }

        if (dp[i][x][flag] != -1) {
            return dp[i][x][flag];
        }

        // recursive case
        int a = solve(i - 1, x - 1, 1, dp);              // start new segment
        int b = (flag == 1) ? solve(i - 1, x, 1, dp) : 0;   // extend same line
        int c = solve(i - 1, x, 0, dp);                     // skip position

        return dp[i][x][flag] = (((a + b) % MOD) + c) % MOD;
    }

/*
-------------------------------------------------------tabulation-------------------------------------------------------
TC : O(n × k)
SC : O(n × k)
*/

    static int approach_2(int n, int k) {
        // potd.code.hub
        int mod = (int) 1e9 + 7;
        int[][][] dp = new int[n + 1][k + 1][2];

        // base case simulation
        dp[0][0][0] = 1;

        for (int i = 1; i <= n; i++) {
            for (int x = 0; x <= k; x++) {

                // recursive case simulation
                int a = (x > 0) ? dp[i - 1][x - 1][1] : 0;  // start new segment
                int b = dp[i - 1][x][1];                    // extend same line
                int c = dp[i - 1][x][0];                    // skip position

                dp[i][x][0] = (a + c) % mod;
                dp[i][x][1] = (((a + b) % mod) + c) % mod;
            }
        }

        return dp[n][k][0];
    }

/*
-----------------------------------------------------space-optimized-----------------------------------------------------
TC : O(n × k)
SC : O(2k)
*/
    static int approach_3(int n, int k) {
        // potd.code.hub
        int mod = (int) 1e9 + 7;
        int[][] curr = new int[k + 1][2];
        int[][] prev = new int[k + 1][2];

        // base case simulation
        prev[0][0] = 1;

        for (int i = 1; i <= n; i++) {
            for (int x = 0; x <= k; x++) {

                // recursive case simulation
                int a = (x > 0) ? prev[x - 1][1] : 0;  // start new segment
                int b = prev[x][1];                    // extend same line
                int c = prev[x][0];                    // skip position

                curr[x][0] = (a + c) % mod;
                curr[x][1] = (((a + b) % mod) + c) % mod;
            }

            int[][] temp = curr;
            curr = prev;
            prev = temp;
        }

        return prev[k][0];
    }

/*
------------------------------------------------single-array-optmization------------------------------------------------
TC : O(n × k)
SC : O(k)
*/
    static int numberOfSets(int n, int k) {
        // potd.code.hub
        int mod = (int) 1e9 + 7;
        int[][] dp = new int[k + 1][2];

        // base case simulation
        dp[0][0] = 1;

        for (int i = 1; i <= n; i++) {
            for (int x = k; x >= 0; x--) {

                // recursive case simulation
                int a = (x > 0) ? dp[x - 1][1] : 0;  // start new segment
                int b = dp[x][1];                    // extend same line
                int c = dp[x][0];                    // skip position

                dp[x][0] = (a + c) % mod;
                dp[x][1] = (((a + b) % mod) + c) % mod;
            }
        }

        return dp[k][0];
    }
}
