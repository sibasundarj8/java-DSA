package DP;/*
 *
 * https://leetcode.com/problems/maximum-number-of-non-overlapping-palindrome-substrings/
 *
 * # LC. 2472. Maximum Number of Non-overlapping Palindrome Substrings
 *
 *   Q. You are given a string s and a positive integer k.
 *
 *      Select a set of non-overlapping substrings from the string s that satisfy the following conditions:
 *        ◦ The length of each substring is at least k.
 *        ◦ Each substring is a palindrome.
 *
 *      Return the maximum number of substrings in an optimal selection.
 *
 *      A substring is a contiguous sequence of characters within a string.
 *
 *    Ex.
 *      Input : s = "abaccdbbd", k = 3
 *      Output: 2
 *      Explanation: We can select the substrings underlined in s = "abaccdbbd". Both "aba" and "dbbd" are palindromes
 *                   and have a length of at least k = 3.
 *
 *                   It can be shown that we cannot find a selection with more than two valid substrings.
 *
 *  Constraints:
 *        ◦ 1 <= k <= s.length <= 2000
 *        ◦ s consists of lowercase English letters.
 */

import java.util.Arrays;
import java.util.Scanner;

public class Dynamic_Programming_2472_Maximum_Number_of_Non_overlapping_Palindrome_Substrings {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("s: ");
        String s = sc.next();

        System.out.print("k: ");
        int k = sc.nextInt();

        System.out.println("Maximum number of substrings in an optimal selection:");
        System.out.println(maxPalindromes(s, k));
    }

    /// Solution
/*
-------------------------------------------------common-part-of-DP-solⁿs-------------------------------------------------
*/
    private static boolean[][] isPalindrome;

    private static void initialize(char[] s) {
        int n = s.length;
        isPalindrome = new boolean[n][n];

        for (int len = 1; len <= n; len++) {
            for (int j = len - 1; j < n; j++) {
                int i = j - len + 1;

                if (i == j) {
                    isPalindrome[i][i] = true;
                } else if (i + 1 == j) {
                    isPalindrome[i][j] = (s[i] == s[j]);
                } else {
                    isPalindrome[i][j] = (s[i] == s[j] && isPalindrome[i + 1][j - 1]);
                }
            }
        }
    }

    private static int blackBox(int j, int k) {
        for (int i = j - k + 1; i >= 0; i--) {
            if (isPalindrome[i][j]) {
                return j - i + 1;
            }
        }

        return 0;
    }

/*
-------------------------------------------------------memoization-------------------------------------------------------
TC : O(n²)
SC : O(n²) + extra n recursive depth
*/
    static int approach_1(String s1, int k) {
        char[] s = s1.toCharArray();
        int n = s.length;

        initialize(s);

        int[] dp = new int[n];
        Arrays.fill(dp, -1);

        return solve(n - 1, k, dp);
    }

    private static int solve(int i, int k, int[] dp) {
        // base case
        if (i < k - 1 || i < 0) return 0;
        if (dp[i] != -1) return dp[i];

        // self work
        int pLen = blackBox(i, k);

        // skip
        int max = solve(i - 1, k, dp);

        // pick only id at least k sized palindrome found
        if (pLen >= k) {
            max = Math.max(max, 1 + solve(i - pLen, k, dp));
        }

        return dp[i] = max;
    }

/*
-------------------------------------------------------tabulation-------------------------------------------------------
TC: O(n²)
SC: O(n²)
*/
    static int approach_2(String s1, int k) {
        char[] s = s1.toCharArray();
        int n = s.length;

        initialize(s);

        int[] dp = new int[n + 1];

        for (int i = k; i <= n; i++) {
            int pLen = blackBox(i - 1, k);
            int max = dp[i - 1];

            if (pLen >= k) {
                max = Math.max(max, 1 + dp[i - pLen]);
            }

            dp[i] = max;
        }

        return dp[n];
    }

/*
---------------------------------------------------------greedy---------------------------------------------------------
TC : O(n × k)
TC : O(1)
*/
    static int maxPalindromes(String s1, int k) {
        char[] s = s1.toCharArray();
        int n = s.length;
        int start = -1;
        int count = 0;

        for (int j = k - 1; j < n; j++) {
            int i = j - k + 1;

            if (isPalindrome(i, j, s) || (i - 1 > start && isPalindrome(i - 1, j, s))) {
                count++;
                start = j;
                j += k - 1;
            }
        }

        return count;
    }

    private static boolean isPalindrome(int i, int j, char[] s) {
        while (i < j) {
            if (s[i] != s[j]) return false;
            i++;
            j--;
        }

        return true;
    }
}
