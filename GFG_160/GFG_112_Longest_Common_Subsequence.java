package GFG_160;/*
 *
 * https://www.geeksforgeeks.org/problems/longest-common-subsequence-1587115620/1
 *
 * # Longest Common Subsequence
 *
 *   Q. Given two strings s1 and s2, return the length of their longest common subsequence (LCS).
 *      If there is no common subsequence, return 0.
 *
 *      A subsequence is a sequence that can be derived from the given string by deleting some or
 *      no elements without changing the order of the remaining elements. For example, "ABE" is a
 *      subsequence of "ABCDE".
 *    Ex.
 *      Input : s1 = "ABCDGH", s2 = "AEDFHR"
 *      Output: 3
 *      Explanation: The longest common subsequence of "ABCDGH" and "AEDFHR" is "ADH", which has a
 *                   length of 3.
 */
import java.util.Scanner;

public class GFG_112_Longest_Common_Subsequence {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("String 1: ");
        String s1 = sc.next();

        System.out.println("String 2: ");
        String s2 = sc.next();

        System.out.println(lcs(s1, s2));
    }

    /// Solution
    
    /// It is the tabulation top-down approach with index shifting, 
    /// but here I take only two arrays of size m to store current row and previous Array.
    ///  Time Complexity: O(n*m)
    /// Space Complexity: O(m)
    static int lcs(String s1, String s2) {
        // potd.code.hub
        int n = s1.length(), m = s2.length();
        int[]curr = new int[m+1];
        int[]prev = new int[m+1];

        for (int i = 1;i <= n;i++){
            for (int j = 1;j <= m;j++){
                if (s1.charAt(i-1) == s2.charAt(j-1))
                    curr[j] = prev[j-1] + 1;
                else curr[j] = Math.max(prev[j], curr[j-1]);
            }
            prev = curr.clone();
        }

        return curr[m];
    }

    /// It is the tabulation top-down approach with index shifting
    ///  Time Complexity: O(n*m)
    /// Space Complexity: O(n*m)
    /*
    static int lcs(String s1, String s2) {
        // potd.code.hub
        int n = s1.length(), m = s2.length();
        int[][]dp = new int[n+1][m+1];

        for (int i = 1;i <= n;i++){
            for (int j = 1;j <= m;j++){
                if (s1.charAt(i-1) == s2.charAt(j-1))
                    dp[i][j] = dp[i-1][j-1] + 1;
                else dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }

        return dp[n][m];
    }
    */

    ///  It is the recursive bottom-up approach whit memoization
    ///  Time Complexity: O(n*m)
    /// Space Complexity: O(n*m)
    /*
    private static int solve (String s1, String s2, int i1, int i2, int ans, int[][]dp){
        // base case
        if (i1 < 0 || i2 < 0) return 0;
        if (dp[i1][i2] != -1) return dp[i1][i2];

        if (s1.charAt(i1) == s2.charAt(i2))
            ans = 1+solve(s1, s2, i1-1, i2-1, ans, dp);
        else ans = Math.max(solve(s1, s2, i1-1, i2, ans, dp), solve(s1, s2, i1, i2-1, ans, dp));

        dp[i1][i2] = ans;
        return ans;
    }
    */
}
