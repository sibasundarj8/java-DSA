package DP;/*
 *
 * https://www.geeksforgeeks.org/problems/number-of-distinct-subsequences0909/1
 *
 * # Number of distinct subsequences
 *
 *   Q. Given a string str consisting of lowercase english alphabets, the task is to find the number of distinct subsequences
 *      of the string
 *
 *      Note: Answer can be very large, so, output will be answer modulo 10⁹+7.
 *
 *    Ex.
 *      Input : str = "gfg"
 *      Output: 7
 *      Explanation: The seven distinct subsequences are "", "g", "f", "gf", "fg", "gg" and "gfg" .
 *
 *    Constraints:
 *          1 ≤ |str| ≤ 10⁵
 *          str contains lower case English alphabets
 */

import java.util.HashSet;
import java.util.Scanner;

public class Dynamic_Programming_Number_of_distinct_subsequences {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the String: ");
        String s = sc.next();

        System.out.println("Number of unique subsequences: " + recursion(s));
    }

    ///  Solution
/*
✦✦✦✦✦✦✦✦✦✦✦✦✦✦✦✦✦✦✦✦✦✦✦✦✦✦✦✦✦✦✦✦✦✦✦✦✦✦✦✦✦✦✦✦✦✦✦✦✦✦✦✦✦✦✦-Recursion-✦✦✦✦✦✦✦✦✦✦✦✦✦✦✦✦✦✦✦✦✦✦✦✦✦✦✦✦✦✦✦✦✦✦✦✦✦✦✦✦✦✦✦✦✦✦✦✦✦✦✦✦✦✦✦
TC : O(2ⁿ)
SC : O(2ⁿ)
*/
    static int recursion(String str) {
        // potd.code.hub
        int n = str.length();
        StringBuilder sb = new StringBuilder();
        HashSet<String> set = new HashSet<>();

        f(0, n, str, sb, set);

        return set.size() % 1000000007;
    }

    private static void f(int i, int n, String s,StringBuilder sb, HashSet<String> set) {
        // base case
        if (i == n) {
            set.add(sb.toString());
            return;
        }

        // recursive case
        f(i + 1, n, s, sb, set);       // not pick

        sb.append(s.charAt(i));
        f(i + 1, n, s, sb, set);       // pick
        sb.deleteCharAt(sb.length() - 1);
    }
/*
✦✦✦✦✦✦✦✦✦✦✦✦✦✦✦✦✦✦✦✦✦✦✦✦✦✦✦✦✦✦✦✦✦✦✦✦✦✦✦✦✦✦✦✦✦✦✦✦✦✦✦✦✦✦✦-using-DP-✦✦✦✦✦✦✦✦✦✦✦✦✦✦✦✦✦✦✦✦✦✦✦✦✦✦✦✦✦✦✦✦✦✦✦✦✦✦✦✦✦✦✦✦✦✦✦✦✦✦✦✦✦✦✦
TC : O(n)
SC : O(n)
*/
    static int dp(String str) {
        // potd.code.hub
        int mod = 1000000007;
        int n = str.length();
        int[] last = new int[26];
        long[] dp = new long[n + 1];
        dp[0] = 1;

        for (int i = 1; i <= n; i++) {
            int pos = str.charAt(i - 1) - 'a';
            int lastIndex = last[pos];

            // calculating the current number of subsequences
            dp[i] = dp[i - 1] * 2 % mod;

            // removing the number of subsequences which are already counted.
            if (lastIndex != 0) dp[i] = (dp[i] - dp[lastIndex - 1] + mod) % mod;

            // updating the previous occurrence
            last[pos] = i;
        }

        return (int) dp[n];
    }

/*
✦✦✦✦✦✦✦✦✦✦✦✦✦✦✦✦✦✦✦✦✦✦✦✦✦✦✦✦✦✦✦✦✦✦✦✦✦✦✦✦✦✦✦✦✦✦✦✦✦✦-Space-Optimization-✦✦✦✦✦✦✦✦✦✦✦✦✦✦✦✦✦✦✦✦✦✦✦✦✦✦✦✦✦✦✦✦✦✦✦✦✦✦✦✦✦✦✦✦✦✦✦✦✦✦
TC : O(n)
SC : O(1)
*/
    static int distinctSubseq(String str) {
        // potd.code.hub
        int mod = 1000000007;
        int n = str.length();
        long[] dp = new long[26];
        long count = 1;

        for (int i = 1; i <= n; i++) {
            int pos = str.charAt(i - 1) - 'a';

            // calculating the current number of subsequences
            long newCount = count * 2 % mod;

            // removing the number of subsequences which are already counted.
            newCount = (newCount - dp[pos] + mod) % mod;

            // updating the previous occurrence
            dp[pos] = count;
            count = newCount;
        }

        return (int) count;
    }
}
