package Contest.biWeekly_184;/*
 *
 * https://leetcode.com/contest/biweekly-contest-184/problems/exactly-one-consecutive-set-bits-pair/
 *
 * # Q1. Exactly One Consecutive Set Bits Pair
 *
 *   Q. You are given an integer n. Return true if its binary representation contains exactly one adjacent pair of set
 *      bits, and false otherwise.
 *
 *    Ex.
 *      Input : n = 6
 *      Output: true
 *      Explanation:
 *              Binary representation of 6 is 110.
 *              There is exactly one adjacent pair of set bits ("11"). Thus, the answer is true.
 *
 *  Constraints:
 *        0 <= n <= 10⁵
 */

public class Q1_Exactly_One_Consecutive_Set_Bits_Pair {

    /// Solution
    public boolean consecutiveSetBits(int n) {
        String s = Integer.toBinaryString(n);
        int count = 0;

        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == '1' && s.charAt(i + 1) == '1') {
                count++;
                if (count > 1) return false;
            }
        }

        return count == 1;
    }
}
