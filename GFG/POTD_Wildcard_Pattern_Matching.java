/*
 *     Q. Given two strings pattern and str which may be of different size, You have to return 1
 *        if the wildcard pattern i.e., pattern, matches with str else return 0. All characters of
 *        the string str and pattern always belong to the Alphanumeric characters.
 *        The wildcard pattern can include the characters?
 *        ‘?’ – matches any single character.
 *        ‘*’ – Matches any sequence of characters (including the empty sequence).
 *        Note: The matching should cover the entire str (not partial str).
 *      Examples:
 *              Input: pattern = "ba*a?", str = "baaabab"
 *              Output: 1
 *              Explanation: replace '*' with "aab" and '?' with 'b'.
 */
package GFG;

import java.util.Scanner;

public class POTD_Wildcard_Pattern_Matching {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter String :");
        String str = sc.next();
        System.out.println("Enter Pattern :");
        System.out.println("1. ? to hide a single Char");
        System.out.println("2. * to hide subsequences(may be Empty)");
        String ptr = sc.next();
        System.out.println(wildCard(ptr, str));
    }
    static boolean wildCard(String pattern, String str) {
        // potd.code.hub
        int n = pattern.length();
        int m = str.length();
        int[][]dp = new int[n][m];
        for (int i = 0;i < n;i++)
            for (int j = 0;j < m;j++)
                dp[i][j] = -1;
        return compare(pattern, str,n-1,m-1,dp) == 1;
    }
    static int compare(String p, String s, int i, int j, int[][]dp){
        // Base Case
        if (i < 0 && j < 0) return 1;
        if (i < 0)return 0;
        if (j < 0)return stars(p,i);
        if (dp[i][j] != -1)return dp[i][j];

        // Recursive Work
        if (p.charAt(i) == s.charAt(j) || p.charAt(i) == '?')
            return dp[i][j] = compare(p, s, i-1, j-1, dp);
        else {
            if (p.charAt(i) == '*')
                return dp[i][j] = Math.max(compare(p,s,i-1,j,dp), compare(p,s,i,j-1,dp));
            else return dp[i][j] = 0;
        }
    }
    static int stars(String p, int i){
        while (i >= 0)
            if (p.charAt(i--) != '*') return 0;
        return 1;
    }
}