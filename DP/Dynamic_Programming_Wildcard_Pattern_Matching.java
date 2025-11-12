package DP;/*
 *
 * https://www.geeksforgeeks.org/problems/wildcard-pattern-matching/1
 *
 * # Wildcard Pattern Matching
 *
 *   Q. Given two strings pat and txt which may be of different sizes, You have to return true if the wildcard pattern
 *      i.e. pat, matches with txt else return false.
 *
 *      The wildcard pattern pat can include the characters '?' and '*'.
 *
 *      '?' – matches any single character.
 *      '*' – matches any sequence of characters (including the empty sequence).
 *
 *      Note: The matching should cover the entire txt (not partial txt).
 *   Ex.
 *      Input : txt = "abc", pat = "*"
 *      Output: true
 *      Explanation: '*' matches with whole text "abc".
 *
 *   Constraints:
 *      1 ≤ txt.size(), pat.size() ≤ 100
 */

import java.util.Scanner;

public class Dynamic_Programming_Wildcard_Pattern_Matching {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Text: ");
        String txt = sc.next();

        System.out.println("Pattern: ");
        String pat = sc.next();

        System.out.println("[pat == mat] : " + wildCard(txt, pat));
    }

    /// Solution
    static boolean wildCard(String txt, String pat) {
        // potd.code.hub
        int n = txt.length() - 1;
        int m = pat.length() - 1;
        Boolean[][] dp = new Boolean[n][m];

        return f(0, 0, n, m, txt, pat, dp);
    }

    private static boolean f(int i, int j, int n, int m, String txt, String pat, Boolean[][] dp) {
        // base case
        if (i >= n && j >= m) return true;
        if (j >= m) return false;
        if (i >= n) return checkStar(j, m, pat);
        if (dp[i][j] != null) return dp[i][j];

        // recursive work
        boolean ans = false;
        if (pat.charAt(j) == '?' || txt.charAt(i) == pat.charAt(j))
            ans = f(i + 1, j + 1, n, m, txt, pat, dp);
        else if (pat.charAt(j) == '*')
            ans = (f(i, j + 1, n, m, txt, pat, dp) || f(i + 1, j, n, m, txt, pat, dp));

        return dp[i][j] = ans;
    }

    private static boolean checkStar(int j, int n, String pat) {
        while (j < n)
            if (pat.charAt(j++) != '*') return false;
        return true;
    }
}
