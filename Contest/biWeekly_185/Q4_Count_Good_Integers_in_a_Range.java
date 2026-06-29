package Contest.biWeekly_185;/*
 *
 * https://leetcode.com/contest/biweekly-contest-185/problems/count-good-integers-in-a-range/
 *
 * # Q4. Count Good Integers in a Range
 *
 *   Q. You are given three integers l, r and k.
 *      A number is considered good if the absolute difference between every pair of adjacent digits is at most k.
 *      Return the number of good integers in the range [l, r] (inclusive).
 *      The absolute difference between values x and y is defined as abs(x - y).
 *
 *    Ex.
 *      Input : l = 10, r = 15, k = 1
 *      Output: 3
 *      Explanation:
 *              ◦ The good integers in the range are 10, 11, and 12.
 *              ◦ For 10, abs(1 - 0) = 1.
 *              ◦ For 11, abs(1 - 1) = 0.
 *              ◦ For 12, abs(1 - 2) = 1.
 *              ◦ All these differences are at most k = 1. Thus, the answer is 3.
 *
 *  Constraints:
 *      10 <= l <= r <= 10¹⁵
 *      0 <= k <= 9
 */

import java.util.Arrays;

public class Q4_Count_Good_Integers_in_a_Range {

    /// Solution
    public long goodIntegers(long l, long r, int k) {
        // potd.code.hub
        String s1 = String.valueOf(l - 1);
        String s2 = String.valueOf(r);

        long[][][][] dp = new long[s1.length() + 1][11][2][2];
        initialize(dp);
        long left = solve(0, -1, 1, 1, s1.length(), s1, k, dp);

        dp = new long[s2.length() + 1][11][2][2];
        initialize(dp);
        long right = solve(0, -1, 1, 1, s2.length(), s2, k, dp);

        return right - left;
    }

    private long solve(int idx, int prev, int tight, int leadingZeros, int n, String number, int k, long[][][][] dp) {
        // base case
        if (idx == n) return (leadingZeros == 1) ? 0 : 1;
        if (prev != -1 && dp[idx][prev][tight][leadingZeros] != -1) return dp[idx][prev][tight][leadingZeros];

        // recursive work
        int z = (tight == 1) ? number.charAt(idx) - '0' : 9;
        int up = (leadingZeros == 1) ? z : Math.min(prev + k, z);
        int down = Math.max(prev - k, 0);
        long total = 0;

        for (int i = down; i <= up; i++) {
            total += solve(idx + 1, i, (tight == 1 && i == z) ? 1 : 0, (leadingZeros == 1 && i == 0) ? 1 : 0, n, number, k, dp);
        }

        if (prev != -1) dp[idx][prev][tight][leadingZeros] = total;
        return total;
    }

    private void initialize(long[][][][] dp) {
        for (long[][][] a : dp) {
            for (long[][] b : a) {
                for (long[] c : b) {
                    Arrays.fill(c, -1);
                }
            }
        }
    }
}