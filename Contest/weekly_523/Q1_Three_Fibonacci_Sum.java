package Contest.weekly_523;/*
 *
 * https://leetcode.com/contest/weekly-contest-523/problems/three-fibonacci-sum/
 *
 * # Q1. Three Fibonacci Sum
 *
 *   Q. You are given an integer n.
 *
 *      The Fibonacci sequence starts with 0 and 1, and each subsequent number is the sum of the previous
 *      two numbers. Its first few terms are 0, 1, 1, 2, 3, 5, 8, 13, ....
 *
 *      Return true if n can be expressed as the sum of three consecutive terms in the Fibonacci sequence,
 *      and false otherwise.
 *
 *    Ex.
 *      Input : n = 16
 *      Output: true
 *      Explanation:
 *              The three consecutive terms 3, 5, and 8 have a sum of 3 + 5 + 8 = 16.
 *
 *  Constraints:
 *        ◦ 1 <= n <= 10⁹
 */

public class Q1_Three_Fibonacci_Sum {

    /// Solution
    public boolean threeFibonacciSum(int n) {
        // potd.code.hub
        if (n < 2) return false;
        if (n == 2 || n == 4) return true;

        int a = 2;
        int b = 4;

        while (b < n) {
            int next = a + b;
            a = b;
            b = next;
        }

        return b == n;
    }
}
