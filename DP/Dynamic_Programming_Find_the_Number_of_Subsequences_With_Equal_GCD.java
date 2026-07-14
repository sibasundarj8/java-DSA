package DP;/*
 *
 * https://leetcode.com/problems/find-the-number-of-subsequences-with-equal-gcd/
 *
 * # LC. 3336. Find the Number of Subsequences With Equal GCD
 *
 *   Q. You are given an integer array nums.
 *
 *      Your task is to find the number of pairs of non-empty subsequences (seq1, seq2) of nums that satisfy the
 *      following conditions:
 *        ◦ The subsequences seq1 and seq2 are disjoint, meaning no index of nums is common between them.
 *        ◦ The GCD of the elements of seq1 is equal to the GCD of the elements of seq2.
 *
 *      Return the total number of such pairs.
 *      Since the answer may be very large, return it modulo 10⁹ + 7.
 *
 *    Ex.
 *      Input : nums = [1, 2, 3, 4]
 *      Output: 10
 *      Explanation:
 *              The subsequence pairs which have the GCD of their elements equal to 1 are:
 *                  ([୧, 2, 3, 4], [1, ୨, ୩, 4])
 *                  ([୧, 2, 3, 4], [1, ୨, ୩, ୪])
 *                  ([୧, 2, 3, 4], [1, 2, ୩, ୪])
 *                  ([୧, ୨, 3, 4], [1, 2, ୩, ୪])
 *                  ([୧, 2, 3, ୪], [1, ୨, ୩, 4])
 *                  ([1, ୨, ୩, 4], [୧, 2, 3, 4])
 *                  ([1, ୨, ୩, 4], [୧, 2, 3, ୪])
 *                  ([1, ୨, ୩, ୪], [୧, 2, 3, 4])
 *                  ([1, 2, ୩, ୪], [୧, 2, 3, 4])
 *                  ([1, 2, ୩, ୪], [୧, ୨, 3, 4])
 *
 *  Constraints:
 *        1 <= nums.length <= 200
 *        1 <= nums[i] <= 200
 */

import java.util.Arrays;
import java.util.Scanner;

public class Dynamic_Programming_Find_the_Number_of_Subsequences_With_Equal_GCD {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter array elements: ");
        String[] s = sc.nextLine().split(" ");

        int n = s.length;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(s[i]);
        }

        System.out.println("Number of sub-sequences with equal GCD are: ");
        System.out.println(subsequencePairCount(arr));
    }

    /// Solution
    private static final int MOD = (int) (1e9 + 7);

/*
⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯-Top-Down--Memoization-⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯
TC : O(O(N × M² + M² log M))
SC : O(N × M²) + extra recursive call stack
*/
    static int approach_1(int[] nums) {
        // potd.code.hub
        int n = nums.length;
        int max = Integer.MIN_VALUE;

        for (int ele : nums) {
            max = Math.max(max, ele);
        }

        int[][] gcdTable = new int[max + 1][max + 1];
        long[][][] dp = new long[n][max + 1][max + 1];

        for (long[][] a : dp) {
            for (long[] b : a) {
                Arrays.fill(b, -1);
            }
        }

        // pre-calculating gcd for all possible combinations
        for (int i = 0; i <= max; i++) {
            for (int j = i; j <= max; j++) {
                gcdTable[i][j] = gcdTable[j][i] = gcd(i, j);
            }
        }

        return (int) solve(0, 0, 0, n, nums, gcdTable, dp);
    }

    private static long solve(int i, int g1, int g2, int n, int[] nums, int[][] gcdTable, long[][][] dp) {
        // base case
        if (i == n) return (g1 == g2 && g1 != 0) ? 1 : 0;
        if (dp[i][g1][g2] != -1) return dp[i][g1][g2];

        // recursive work
        long skip = solve(i + 1, g1, g2, n, nums, gcdTable, dp);
        long pickSeq1 = solve(i + 1, gcdTable[g1][nums[i]], g2, n, nums, gcdTable, dp);
        long pickSeq2 = solve(i + 1, g1, gcdTable[g2][nums[i]], n, nums, gcdTable, dp);

        return dp[i][g1][g2] = ((skip + pickSeq1) % MOD + pickSeq2) % MOD;
    }

    private static int gcd1(int a, int b) {
        if (a == 0) return b;
        if (b == 0) return a;

        while (b != 0) {
            int t = b;
            b = a % b;
            a = t;
        }

        return a;
    }

/*
⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯-Bottom-Up--Tabulation-⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯
TC : O(O(N × M² + M² log M))
SC : O(N × M²)
*/
    static int approach_2(int[] nums) {
        // potd.code.hub
        int n = nums.length;
        int max = Integer.MIN_VALUE;

        for (int ele : nums) {
            max = Math.max(max, ele);
        }

        int[][] gcdTable = new int[max + 1][max + 1];
        long[][][] dp = new long[n + 1][max + 1][max + 1];

        // simulating base case
        for (int i = 1; i <= max; i++) {
            dp[n][i][i] = 1;
        }

        // pre-calculating gcd for all possible combinations
        for (int i = 0; i <= max; i++) {
            for (int j = i; j <= max; j++) {
                gcdTable[i][j] = gcdTable[j][i] = gcd(i, j);
            }
        }

        for (int i = n - 1; i >= 0; i--) {
            for (int g1 = 0; g1 <= max; g1++) {
                for (int g2 = 0; g2 <= max; g2++) {

                    // simulating recursive work
                    long skip = dp[i + 1][g1][g2];
                    long pickSeq1 = dp[i + 1][gcdTable[g1][nums[i]]][g2];
                    long pickSeq2 = dp[i + 1][g1][gcdTable[g2][nums[i]]];

                    dp[i][g1][g2] = ((skip + pickSeq1) % MOD + pickSeq2) % MOD;
                }
            }
        }


        return (int) dp[0][0][0];
    }

    private static int gcd2(int a, int b) {
        if (a == 0) return b;
        if (b == 0) return a;

        while (b != 0) {
            int t = b;
            b = a % b;
            a = t;
        }

        return a;
    }

/*
⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯-Space-Optimized--Tabulation-⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯
TC : O(O(N × M² + M² log M))
SC : O(M²)
*/
    static int subsequencePairCount(int[] nums) {
        // potd.code.hub
        int n = nums.length;
        int max = Integer.MIN_VALUE;

        for (int ele : nums) {
            max = Math.max(max, ele);
        }

        int[][] gcdTable = new int[max + 1][max + 1];
        long[][] curr = new long[max + 1][max + 1];
        long[][] next = new long[max + 1][max + 1];

        // simulating base case
        for (int i = 1; i <= max; i++) {
            next[i][i] = 1;
        }

        // pre-calculating gcd for all possible combinations
        for (int i = 0; i <= max; i++) {
            for (int j = i; j <= max; j++) {
                gcdTable[i][j] = gcdTable[j][i] = gcd(i, j);
            }
        }

        for (int i = n - 1; i >= 0; i--) {
            for (int g1 = 0; g1 <= max; g1++) {
                for (int g2 = 0; g2 <= max; g2++) {

                    // simulating recursive work
                    long skip = next[g1][g2];
                    long pickSeq1 = next[gcdTable[g1][nums[i]]][g2];
                    long pickSeq2 = next[g1][gcdTable[g2][nums[i]]];

                    curr[g1][g2] = ((skip + pickSeq1) % MOD + pickSeq2) % MOD;
                }
            }
            long[][] temp = curr;
            curr = next;
            next = temp;
        }


        return (int) next[0][0];
    }

    private static int gcd(int a, int b) {
        if (a == 0) return b;
        if (b == 0) return a;

        while (b != 0) {
            int t = b;
            b = a % b;
            a = t;
        }

        return a;
    }
}
