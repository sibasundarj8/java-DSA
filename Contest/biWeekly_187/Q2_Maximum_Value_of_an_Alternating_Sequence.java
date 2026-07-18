package Contest.biWeekly_187;/*
 *
 * https://leetcode.com/contest/biweekly-contest-187/problems/maximum-value-of-an-alternating-sequence/
 *
 * # Q2. Maximum Value of an Alternating Sequence
 *
 *   Q. You are given three integers n, s, and m.
 *
 *      A sequence seq of integers of length n is considered valid if:
 *        ◦ seq[0] = s.
 *        ◦ The sequence is alternating, meaning that either:
 *            - seq[0] > seq[1] < seq[2] > ..., or
 *            - seq[0] < seq[1] > seq[2] < ....
 *        ◦ For every adjacent pair, |seq[i] - seq[i - 1]| <= m.
 *
 *      A sequence of length 1 is considered alternating.
 *
 *      Return the maximum possible element that can appear in any valid sequence.
 *
 *    Ex.
 *      Input : n = 4, s = 3, m = 5
 *      Output: 12
 *      Explanation:
 *              One valid sequence is [3, 8, 7, 12].
 *              The maximum element in the sequence is 12.
 *
 *  Constraints:
 *      1 <= n, s <= 10⁹
 *      1 <= m <= 10⁵
 */

public class Q2_Maximum_Value_of_an_Alternating_Sequence {

    /// Solution
    public long maximumValue(int n, int s, int m) {
        if (n == 1) return s;
        if ((n & 1) == 1) return maximumValue(n - 1, s, m);

        return (n / 2L) * m + s - (n / 2L - 1);
    }
}