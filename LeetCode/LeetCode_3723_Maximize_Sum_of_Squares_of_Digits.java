package LeetCode;/*
 *
 * https://leetcode.com/problems/maximize-sum-of-squares-of-digits/
 *
 * # LC. 3723. Maximize Sum of Squares of Digits
 *
 *   Q. You are given two positive integers num and sum.
 *
 *      A positive integer n is good if it satisfies both of the following:
 *        ◦ The number of digits in n is exactly num.
 *        ◦ The sum of digits in n is exactly sum.
 *
 *      The score of a good integer n is the sum of the squares of digits in n.
 *
 *      Return a string denoting the good integer n that achieves the maximum score. If there are multiple possible
 *      integers, return the maximum one. If no such integer exists, return an empty string.
 *
 *    Ex.
 *      Input : num = 2, sum = 3
 *      Output: "30"
 *      Explanation:
 *              There are 3 good integers: 12, 21, and 30.
 *                ◦ The score of 12 is 12 + 22 = 5.
 *                ◦ The score of 21 is 22 + 12 = 5.
 *                ◦ The score of 30 is 32 + 02 = 9.
 *              The maximum score is 9, which is achieved by the good integer 30. Therefore, the answer is "30".
 *
 *  Constraints:
 *        ◦ 1 <= num <= 2 * 10⁵
 *        ◦ 1 <= sum <= 2 * 10⁶
 */

import java.util.Scanner;

public class LeetCode_3723_Maximize_Sum_of_Squares_of_Digits {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("num: ");
        int num = sc.nextInt();

        System.out.print("sum: ");
        int sum = sc.nextInt();

        System.out.println("Good integer with maximum score: ");
        System.out.println(maxSumOfSquares(num, sum));
    }

    /// Solution
    static String maxSumOfSquares(int num, int sum) {
        // potd.code.hub
        if (num * 9 < sum) return "";
        char[] number = new char[num];

        int i = 0;
        int nines = sum / 9;

        while (i < nines) {
            number[i++] = '9';
        }

        if (i < num) number[i++] = (char) (sum % 9 + '0');

        while (i < num) {
            number[i++] = '0';
        }

        return String.valueOf(number);
    }
}
