package Contest.weekly_522;/*
 *
 * https://leetcode.com/contest/weekly-contest-522/problems/minimum-rotations-to-dial-a-number-i/
 *
 * # Q1. Minimum Rotations to Dial a Number I
 *
 *   Q. You are given a string s of length 10 consisting of digits.
 *
 *      The dial contains the digits 0 through 9 in order and is circular, so 0 and 9 are adjacent. The pointer
 *      initially points to 0.
 *
 *      To dial each digit of s in order, rotate the pointer until it points to that digit. Each rotation moves
 *      the pointer to an adjacent digit, and you may rotate in either direction. Dialing a digit that the pointer
 *      already points to requires no rotations.
 *
 *      Return the minimum total number of rotations needed to dial every digit of s.
 *
 *    Ex.
 *      Input : s = "0192837465"
 *      Output: 25
 *      Explanation:
 *                 +-----+-----+-----+---------+
 *                 | Step| From| To  |Rotations|
 *                 +=====+=====+=====+=========+
 *                 |  1  |  0  |  0  |   0     |
 *                 +-----+-----+-----+---------+
 *                 |  2  |  0  |  1  |   1     |
 *                 +-----+-----+-----+---------+
 *                 |  3  |  1  |  9  |   2     |
 *                 +-----+-----+-----+---------+
 *                 |  4  |  9  |  2  |   3     |
 *                 +-----+-----+-----+---------+
 *                 |  5  |  2  |  8  |   4     |
 *                 +-----+-----+-----+---------+
 *                 |  6  |  8  |  3  |   5     |
 *                 +-----+-----+-----+---------+
 *                 |  7  |  3  |  7  |   4     |
 *                 +-----+-----+-----+---------+
 *                 |  8  |  7  |  4  |   3     |
 *                 +-----+-----+-----+---------+
 *                 |  9  |  4  |  6  |   2     |
 *                 +-----+-----+-----+---------+
 *                 |  10 |  6  |  5  |   1     |
 *                 +-----+-----+-----+---------+
 *
 *              The total is 0 + 1 + 2 + 3 + 4 + 5 + 4 + 3 + 2 + 1 = 25, which is the minimum total number of rotations.
 *
 *  Constraints:
 *        ◦ s.length == 10
 *        ◦ s consists only of digits '0' to '9'
 */

public class Q1_Minimum_Rotations_to_Dial_a_Number_I {

    /// Solution
    public int minRotations(String s1) {
        char[] s = s1.toCharArray();
        int a = 0;
        int res = 0;

        for (char dig : s) {
            int b = dig - '0';
            int min = Math.min(a, b);
            int max = Math.max(a, b);
            int diff = max - min;

            res += Math.min(diff, 10 - diff);
            a = b;
        }

        return res;
    }
}
