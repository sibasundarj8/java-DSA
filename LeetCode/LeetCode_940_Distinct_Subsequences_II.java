package LeetCode;/*
 *
 * https://leetcode.com/problems/distinct-subsequences-ii/
 *
 * # LC. 940. Distinct Subsequences II
 *
 *   Q. Given a string s, return the number of distinct non-empty subsequences of s. Since the answer may be very large,
 *      return it modulo 10⁹ + 7.
 *
 *      A subsequence of a string is a new string that is formed from the original string by deleting some (can be
 *      none) of the characters without disturbing the relative positions of the remaining characters. (i.e., "ace"
 *      is a subsequence of "abcde" while "aec" is not.
 *
 *    Ex.
 *      Input : s = "aba"
 *      Output: 6
 *      Explanation: The 6 distinct subsequences are "a", "b", "ab", "aa", "ba", and "aba".
 *
 *  Constraints:
 *        ◦ 1 <= s.length <= 2000
 *        ◦ s consists of lowercase English letters.
 */

import java.util.Scanner;

public class LeetCode_940_Distinct_Subsequences_II {

    /// Solution
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("word: ");
        String s = sc.next();

        System.out.println("Number of distinct non-empty subsequences of s: ");
        System.out.println(distinctSubseqII(s));
    }

    /// Solution
/*
-------------------------------------------------------tabulation-------------------------------------------------------
TC : O(n)
SC : O(n)
*/
    static int approach_1(String s) {
        char[] sa = s.toCharArray();
        int n = sa.length;
        int mod = (int) (1e9 + 7);
        int[] last = new int[26];
        long[] dp = new long[n + 1];

        dp[0] = 1;
        int lastSeen, idx;

        for (int i = 1; i <= n; i++) {
            idx = sa[i - 1] - 'a';
            lastSeen = last[idx];

             dp[i] = (dp[i - 1] << 1) % mod;
            if (lastSeen != 0) {
                 dp[i] = ( dp[i] - dp[lastSeen - 1] + mod) % mod;
            }

            last[idx] = i;
        }

        return (int) ((dp[n] - 1 + mod) % mod);
    }

/*
---------------------------------------------------space-optimization---------------------------------------------------
TC : O(n)
SC : O(1)
*/
    static int distinctSubseqII(String s) {
        char[] sa = s.toCharArray();
        int n = sa.length;
        int mod = (int) (1e9 + 7);
        long[] last = new long[26];
        long prev = 1;
        long curr = 0;
        int idx;

        for (int i = 1; i <= n; i++) {
            idx = sa[i - 1] - 'a';

            curr = (prev << 1) % mod;
            if (last[idx] != 0) {
                curr = (curr - last[idx] + mod) % mod;
            }

            last[idx] = prev;
            prev = curr;
        }

        return (int) ((prev - 1 + mod) % mod);
    }
}
