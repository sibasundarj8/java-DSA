package Contest.weekly_522;/*
 *
 * https://leetcode.com/contest/weekly-contest-522/problems/minimum-rotations-to-dial-a-number-ii/
 *
 * # Q2. Minimum Rotations to Dial a Number II
 *
 *   Q. You are given an integer n and a string s of length n consisting of digits.
 *
 *      The dial contains the digits 0 through 9 in order and is circular, so 0 and 9 are adjacent. The pointer
 *      initially points to 0.
 *
 *      To dial each digit of s in order, rotate the pointer until it points to that digit. Each rotation moves the
 *      pointer to an adjacent digit, and you may rotate in either direction. Dialing a digit that the pointer already
 *      points to requires no rotations.
 *
 *      Before dialing, you may perform the following operation at most once:
 *        ◦ Choose an index k such that 0 <= k < n and reverse the suffix s[k..n - 1].
 *
 *      Return the minimum total number of rotations needed to dial the string after optimally choosing whether to
 *      perform the operation and which suffix to reverse.
 *
 *    Ex.
 *      Input : n = 4, s = "1502"
 *      Output: 9
 *      Explanation:
 *              Reverse the suffix starting at k = 1 to obtain "1205", then dial it.
 *                  +-----+-----+-----+---------+
 *                  | Step| From| To  |Rotations|
 *                  +=====+=====+=====+=========+
 *                  |  1  |  0  |  1  |    1    |
 *                  +-----+-----+-----+---------+
 *                  |  2  |  1  |  2  |    1    |
 *                  +-----+-----+-----+---------+
 *                  |  3  |  2  |  0  |    2    |
 *                  +-----+-----+-----+---------+
 *                  |  4  |  0  |  5  |    5    |
 *                  +-----+-----+-----+---------+
 *
 *              The total is 1 + 1 + 2 + 5 = 9, which is the minimum total number of rotations.
 *
 *  Constraints:
 *      ◦ 1 <= n == s.length <= 10⁵
 *      ◦ s consists only of digits '0' to '9'
 */

public class Q2_Minimum_Rotations_to_Dial_a_Number_II {

    /// Solution
    public int minRotations(int n, String s1) {
        char[] s = s1.toCharArray();
        int lst = s[n - 1] - '0';

        int baseCost = 0;
        int maxSaving = 0;
        int prev = 0;

        for (int i = 0; i < n; i++) {
            int curr = s[i] - '0';

            int oldCost = getDiff(prev, curr);
            int newCost = getDiff(prev, lst);

            maxSaving = Math.max(maxSaving, oldCost - newCost);

            baseCost += oldCost;
            prev = curr;
        }

        return baseCost - maxSaving;
    }

    private int getDiff(int a, int b) {
        int diff = Math.abs(a - b);
        return Math.min(diff, 10 - diff);
    }
}