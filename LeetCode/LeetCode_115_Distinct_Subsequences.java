package LeetCode;/*
 *
 * https://leetcode.com/problems/distinct-subsequences/
 *
 * # LC. 115. Distinct Subsequences
 *
 *   Q. Given two strings s and t, return the number of distinct subsequences of s which equals t.
 *      The test cases are generated so that the answer fits on a 32-bit signed integer.
 *
 *    Ex.
 *      Input : s = "babgbag", t = "bag"
 *      Output: 5
 *      Explanation:
 *              As shown below, there are 5 ways you can generate "bag" from s.
 *                                                  [b] [a] b [g] b   a   g
 *                                                  [b] [a] b  g  b   a  [g]
 *                                                  [b]  a  b  g  b  [a] [g]
 *                                                   b   a [b] g  b  [a] [g]
 *                                                   b   a  b  g [b] [a] [g]
 *
 *  Constraints:
 *        ◦ 1 <= s.length, t.length <= 1000
 *        ◦ s and t consist of English letters.
 */

import java.util.Arrays;
import java.util.Scanner;

public class LeetCode_115_Distinct_Subsequences {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("S : ");
        String s = sc.nextLine();

        System.out.print("T : ");
        String t = sc.nextLine();

        System.out.println("Number of distinct subsequences : ");
        System.out.println(numDistinct(s, t));
    }

    /// Solution
/*
-------------------------------------------------------memoization-------------------------------------------------------
TC : O(n × m)
SC : O(n × m) + O(n) recursion stack
*/
    static int approach_1(String s, String t) {
        int n = s.length();
        int m = t.length();
        int[][] dp = new int[n][m];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        return solve(n - 1, m - 1, s.toCharArray(), t.toCharArray(), dp);
    }

    private static int solve(int i, int j, char[] s, char[] t, int[][] dp) {
        // base case
        if (j < 0) return 1;
        if (i < 0) return 0;
        if (i < j) return 0;
        if (dp[i][j] != -1) return dp[i][j];

        // recursive work
        int total = solve(i - 1, j, s, t, dp);
        if (s[i] == t[j]) total += solve(i - 1, j - 1, s, t, dp);

        return dp[i][j] = total;
    }

/*
-------------------------------------------------------tabulation-------------------------------------------------------
TC : O(n × m)
SC : O(n × m)
*/
    static int approach_2(String s, String t) {
        int n = s.length();
        int m = t.length();

        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();
        int[][] dp = new int[n + 1][m + 1];

        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (i < j) break;

                dp[i][j] = dp[i - 1][j];

                if (sArray[i - 1] == tArray[j - 1]) {
                    dp[i][j] += dp[i - 1][j - 1];
                }
            }
        }

        return dp[n][m];
    }

/*
---------------------------------------------------space-optimization---------------------------------------------------
TC : O(n × m)
SC : O(m)
*/
    static int numDistinct(String s, String t) {
        int n = s.length();
        int m = t.length();

        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();
        int[] prev = new int[m + 1];
        int[] curr = new int[m + 1];

        curr[0] = prev[0] = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (i < j) break;

                curr[j] = prev[j];

                if (sArray[i - 1] == tArray[j - 1]) {
                    curr[j] += prev[j - 1];
                }
            }

            int[] temp = curr;
            curr = prev;
            prev = temp;
        }

        return prev[m];
    }
}
