package Recursion;/*
 *
 * https://www.geeksforgeeks.org/problems/find-all-possible-palindromic-partitions-of-a-string/1
 *
 * # All Palindromic Partitions
 *
 *   Q. Given a string s, find all possible ways to partition it such that every substring in the partition is a
 *      palindrome.
 *   ex.
 *      Input : s = "abcba"
 *      Output: [[a, b, c, b, a], [a, bcb, a], [abcba]]
 *      Explanation: [a, b, c, b, a], [a, bcb, a] and [abcba] are the only partitions of "abcba" where each substring
 *                   is a palindrome.
 */

import java.util.ArrayList;
import java.util.Scanner;

public class Recursion_51_All_Palindromic_Partitions {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter text: ");
        String s = sc.next();

        ArrayList<ArrayList<String>> ans = palinParts(s);

        System.out.println("Palindromic partitions: ");
        for (ArrayList<String> x : ans) {
            System.out.println(x);
        }
    }

    /// Solution
/*
----------------------------------------------------[Pre-computation]----------------------------------------------------
===> I am going to pre-compute the palindromic substrings and mark the starting and ending index of that substring in a
2D matrix Initially it takes O(n²) time but reduce the cost of checking palindrome at every recursive call. [Optimized]
*/
    static ArrayList<ArrayList<String>> palinParts(String s) {
        // potd.code.hub
        int n = s.length();
        ArrayList<ArrayList<String>> ans = new ArrayList<>();
        boolean[][] preCompute = compute(s);

        f(s, 0, n, new ArrayList<>(), ans, preCompute);

        return ans;
    }

    private static boolean[][] compute(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        // checking for size-1 and size-2 sub-strings.
        for (int x = 0; x < n; x++) {
            dp[x][x] = true;
            if (x > 0 && s.charAt(x) == s.charAt(x-1)) {
                dp[x-1][x] = true;
            }
        }
        // checking for size >= 3 sub-strings
        for (int i = n-3; i >= 0; i--) {
            for (int j = i+2; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i+1][j-1];
                }
            }
        }
        return dp;
    }

    private static void f(String s, int start, int n, ArrayList<String> list, ArrayList<ArrayList<String>> ans, boolean[][] dp) {
        // base case
        if (start >= n) {
            ans.add(new ArrayList<>(list));
            return;
        }

        // recursive call
        for (int idx = start; idx < n; idx++) {
            if (dp[start][idx]) {
                list.add(s.substring(start, idx + 1));
                f(s, idx + 1, n, list, ans, dp);
                list.remove(list.size() - 1);
            }
        }
    }
/*
------------------------------------------------------[Memoization]------------------------------------------------------
===> To avoid checking a substring is palindrome or not at every recursive call I use a 2D Boolean array to mark it initially.
*/
    static ArrayList<ArrayList<String>> palinParts2(String s) {
        // potd.code.hub
        int n = s.length();
        ArrayList<ArrayList<String>> ans = new ArrayList<>();
        f2(s, 0, n, new ArrayList<>(), ans, new Boolean[n][n]);

        return ans;
    }

    private static void f2(String s, int start, int n, ArrayList<String> list, ArrayList<ArrayList<String>> ans, Boolean[][] dp) {
        // base case
        if (start >= n) {
            ans.add(new ArrayList<>(list));
            return;
        }

        // recursive call
        for (int idx = start; idx < n; idx++) {
            if (isPalindrome2(s, start, idx, dp)) {
                list.add(s.substring(start, idx + 1));
                f2(s, idx + 1, n, list, ans, dp);
                list.remove(list.size() - 1);
            }
        }
    }

    private static boolean isPalindrome2(String s, int l, int r, Boolean[][] dp) {
        if (dp[l][r] != null) return dp[l][r];
        while (l < r) if (s.charAt(l++) != s.charAt(r--)) return dp[l][r] = false;
        return dp[l][r] = true;
    }
/*
------------------------------------------------------[Brute-force]------------------------------------------------------
===> At every recursive call I check a substring is palindrome or not, that takes O(k) time it can be avoidable.
*/
    static ArrayList<ArrayList<String>> palinParts3(String s) {
        // potd.code.hub
        ArrayList<ArrayList<String>> ans = new ArrayList<>();
        f3(s, 0, s.length(), new ArrayList<>(), ans);

        return ans;
    }

    private static void f3(String s, int start, int n, ArrayList<String> list, ArrayList<ArrayList<String>> ans) {
        // base case
        if (start >= n) {
            ans.add(new ArrayList<>(list));
            return;
        }

        // recursive call
        for (int idx = start; idx < n; idx++) {
            if (isPalindrome3(s, start, idx)) {
                list.add(s.substring(start, idx + 1));
                f3(s, idx + 1, n, list, ans);
                list.remove(list.size() - 1);
            }
        }
    }

    private static boolean isPalindrome3(String s, int l, int r) {
        while (l < r) if (s.charAt(l++) != s.charAt(r--)) return false;
        return true;
    }
}
