package Contest.weekly_505;/*
 *
 * https://leetcode.com/problems/sum-of-compatible-numbers-in-range-i/
 *
 * # Q1. Sum of Compatible Numbers in Range I
 *
 *   Q. You are given two integers n and k.
 *
 *      A positive integer x is called compatible if it satisfies both of the following conditions:
 *        ◦ abs(n - x) <= k
 *        ◦ (n & x) == 0
 *
 *      Return the sum of all compatible integers x.
 *
 *      Note:
 *        ◦ Here, & denotes the bitwise AND operator.
 *        ◦ The absolute difference between integers i and j is defined as abs(i - j).
 *
 *    Ex.
 *      Input : n = 2, k = 3
 *      Output: 10
 *      Explanation:
 *              The compatible integers are:
 *              x = 1, since abs(2 - 1) = 1 and 2 & 1 = 0.
 *              x = 4, since abs(2 - 4) = 2 and 2 & 4 = 0.
 *              x = 5, since abs(2 - 5) = 3 and 2 & 5 = 0.
 *              Thus, the answer is 1 + 4 + 5 = 10.
 *
 *  Constraints:
 *      1 <= n <= 100
 *      1 <= k <= 100
 */

public class Q1_Sum_of_Compatible_Numbers_in_Range_I {

    /// Solution
    public int sumOfGoodIntegers(int n, int k) {
        int lb = Math.max(1, n - k);
        int ub = n + k;
        int sum = 0;

        for (int i = lb; i <= ub; i++) {
            if ((i & n) == 0) {
                sum += i;
            }
        }

        return sum;
    }
}
