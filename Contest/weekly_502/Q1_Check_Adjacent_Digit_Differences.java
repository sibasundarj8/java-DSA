package Contest.weekly_502;/*
 *
 * https://leetcode.com/contest/weekly-contest-502/problems/check-adjacent-digit-differences/
 *
 * # Q1. Check Adjacent Digit Differences
 *
 *   Q. You are given a string s consisting of digits. Return true if the absolute difference between every pair of adjacent
 *      digits is at most 2, otherwise return false.
 *
 *      The absolute difference between a and b is defined as abs(a - b).
 *
 *    Ex.
 *      Input : s = "129"
 *      Output: false
 *      Explanation:
 *              The absolute difference between digits at s[0] and s[1] is abs(1 - 2) = 1.
 *              The absolute difference between digits at s[1] and s[2] is abs(2 - 9) = 7, which is greater than 2.
 *              Therefore, the answer is false.©leetcode
 *
 *  Constraints:
 *          2 <= s.length <= 100
 *          s consists only of digits.
 */

public class Q1_Check_Adjacent_Digit_Differences {

    /// Solution
    public boolean isAdjacentDiffAtMostTwo(String s) {
        // potd.code.hub
        int n = s.length();

        for (int i = 1; i < n; i++) {
            int prev = s.charAt(i - 1) - '0';
            int curr = s.charAt(i) - '0';

            if (Math.abs(curr - prev) > 2) {
                return false;
            }
        }

        return true;
    }
}
