package LeetCode;/*
 *
 * https://leetcode.com/problems/smallest-divisible-digit-product-i/
 *
 * # LC. 3345. Smallest Divisible Digit Product I
 *
 *   Q. You are given two integers n and t. Return the smallest number greater than or equal to n such that the product
 *      of its digits is divisible by t.
 *
 *    Ex.
 *      Input : n = 15, t = 3
 *      Output: 16
 *      Explanation:
 *              The digit product of 16 is 6, which is divisible by 3, making it the smallest number greater than or
 *              equal to 15 that satisfies the condition.
 *
 *  Constraints:
 *        1 <= n <= 100
 *        1 <= t <= 10
 */

import java.util.Scanner;

public class LeetCode_3345_Smallest_Divisible_Digit_Product_I {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("n: ");
        int n = sc.nextInt();

        if (n < 1 || n > 100) {
            throw new IllegalArgumentException("n must be between 1 and 100");
        }

        System.out.print("t: ");
        int t = sc.nextInt();

        if (t < 1 || t > 10) {
            throw new IllegalArgumentException("t must be between 1 and 10");
        }

        System.out.println("Smallest number greater than or equal to " + n + " and divisible by " + t + ":");
        System.out.println(smallestNumber(n, t));
    }

    /// Solution
    static int smallestNumber(int n, int t) {
        int i = n;
        while (true) {
            int p = digitProduct(i);
            if (p % t == 0) return i;
            i++;
        }
    }

    private static int digitProduct(int n) {
        int p = 1;
        while (n > 0) {
            p *= (n % 10);
            n /= 10;
        }

        return p;
    }
}
