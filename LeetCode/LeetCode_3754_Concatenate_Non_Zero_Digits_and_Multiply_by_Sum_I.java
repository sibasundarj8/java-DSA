package LeetCode;/*
 *
 * https://leetcode.com/problems/concatenate-non-zero-digits-and-multiply-by-sum-i/
 *
 * # LC. 3754. Concatenate Non-Zero Digits and Multiply by Sum I
 *
 *   Q. You are given an integer n.
 *
 *      Form a new integer x by concatenating all the non-zero digits of n in their original order.
 *      If there are no non-zero digits, x = 0.
 *
 *      Let sum be the sum of digits in x.
 *      Return an integer representing the value of x * sum.
 *
 *    Ex.
 *      Input : n = 10203004
 *      Output: 12340
 *      Explanation:
 *              The non-zero digits are 1, 2, 3, and 4. Thus, x = 1234.
 *              The sum of digits is sum = 1 + 2 + 3 + 4 = 10.
 *              Therefore, the answer is x * sum = 1234 * 10 = 12340.
 *
 *  Constraints:
 *      0 <= n <= 10⁹
 */

import java.util.Scanner;

public class LeetCode_3754_Concatenate_Non_Zero_Digits_and_Multiply_by_Sum_I {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number: ");
        int n = sc.nextInt();

        System.out.println("Answer: ");
        System.out.println(sumAndMultiply(n));
    }

    /// Solution
    static long sumAndMultiply(int n) {
        // potd.code.hub
        long multiplier = 1;
        long newNumber = 0;
        long digitSum = 0;

        for (int num = n; num > 0; num /= 10) {
            int digit = num % 10;
            if (digit == 0) continue;

            newNumber += multiplier * digit;
            multiplier *= 10;
            digitSum += digit;
        }

        return newNumber * digitSum;
    }
}
