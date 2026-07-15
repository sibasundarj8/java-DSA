package LeetCode;/*
 *
 * https://leetcode.com/problems/gcd-of-odd-and-even-sums/
 *
 * # LC. 3658. GCD of Odd and Even Sums
 *
 *   Q. You are given an integer n. Your task is to compute the GCD (greatest common divisor) of two values:
 *        ◦ sumOdd: the sum of the smallest n positive odd numbers.
 *        ◦ sumEven: the sum of the smallest n positive even numbers.
 *
 *      Return the GCD of sumOdd and sumEven.
 *
 *    Ex.
 *      Input : n = 4
 *      Output: 4
 *      Explanation:
 *                ◦ Sum of the first 4 odd numbers sumOdd = 1 + 3 + 5 + 7 = 16
 *                ◦ Sum of the first 4 even numbers sumEven = 2 + 4 + 6 + 8 = 20
 *              Hence, GCD(sumOdd, sumEven) = GCD(16, 20) = 4.
 *
 *  Constraints:
 *        1 <= n <= 1000
 */

import java.util.Scanner;

public class LeetCode_3658_GCD_of_Odd_and_Even_Sums {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("n: ");
        int n = sc.nextInt();

        System.out.println("GCD of first n odd and even numbers: ");
        System.out.println(gcdOfOddEvenSums(n));
    }

    /// Solution
/*
⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯-brute-force-⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯
TC : O(log n)
SC : O(1)
*/
    static int approach_1(int n) {
        int a = n * n;
        int b = n * (n + 1);

        return gcd(a, b);
    }

    private static int gcd(int a, int b) {
        return (b == 0) ? a : gcd(b, a % b);
    }

/*
⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯--Using-Math--⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯
TC : O(1)
SC : O(1)
*/
    static int gcdOfOddEvenSums(int n) {
        return n;
    }
}
