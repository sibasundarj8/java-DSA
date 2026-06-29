package Contest.weekly_506;/*
 *
 * https://leetcode.com/contest/weekly-contest-506/problems/check-good-integer/
 *
 * # Q1. Check Good Integer
 *
 *   Q. You are given a positive integer n.
 *      Let digitSum be the sum of the digits of n, and let squareSum be the sum of the squares of the digits of n.
 *      An integer is called good if squareSum - digitSum >= 50.
 *      Return true if n is good. Otherwise, return false.
 *
 *    Ex.
 *      Input : n = 19
 *      Output: true
 *      Explanation:
 *              The digits of 19 are 1 and 9.
 *              The digitSum is 1 + 9 = 10.
 *              The squareSum is 12 + 92 = 1 + 81 = 82.
 *              The squareSum - digitSum is 82 - 10 = 72. As 72 is greater than or equal to 50, the output is true.
 *
 *  Constraints:
 *      1 <= n <= 10⁹
 */

public class Q1_Check_Good_Integer {

    /// Solution
    public boolean checkGoodInteger(int n) {
        int total = 0;

        while (n > 0) {
            int d = n % 10;
            total += (d * d) - d;
            n /= 10;
        }

        return total >= 50;
    }
}
