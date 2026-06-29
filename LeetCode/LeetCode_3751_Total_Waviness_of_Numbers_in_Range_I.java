package LeetCode;/*
 *
 * https://leetcode.com/problems/total-waviness-of-numbers-in-range-i/
 *
 * # 3751. Total Waviness of Numbers in Range I
 *
 *   Q. You are given two integers num1 and num2 representing an inclusive range [num1, num2].
 *
 *      The waviness of a number is defined as the total count of its peaks and valleys:
 *        ◦ A digit is a peak if it is strictly greater than both of its immediate neighbors.
 *        ◦ A digit is a valley if it is strictly less than both of its immediate neighbors.
 *        ◦ The first and last digits of a number cannot be peaks or valleys.
 *        ◦ Any number with fewer than 3 digits has a waviness of 0.
 *
 *      Return the total sum of waviness for all numbers in the range [num1, num2].
 *
 *    Ex.
 *      Input : num1 = 120, num2 = 130
 *      Output: 3
 *      Explanation:
 *              In the range [120, 130]:
 *                ◦ 120: middle digit 2 is a peak, waviness = 1.
 *                ◦ 121: middle digit 2 is a peak, waviness = 1.
 *                ◦ 130: middle digit 3 is a peak, waviness = 1.
 *                ◦ All other numbers in the range have a waviness of 0.
 *
 *              Thus, total waviness is 1 + 1 + 1 = 3.
 *
 *  Constraints:
 *          1 <= num1 <= num2 <= 10⁵
 */

import java.util.Scanner;

public class LeetCode_3751_Total_Waviness_of_Numbers_in_Range_I {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter two numbers n and m, (n <= m) : ");
        int num1 = sc.nextInt();
        int num2 = sc.nextInt();

        System.out.println("Total sum of waviness for all numbers in the range [" + num1 + ", " + num2 + "]");
        System.out.println(totalWaviness(num1, num2));
    }

    /// Solution
    static int totalWaviness(int num1, int num2) {
        // potd.code.hub
        if (num2 < 100) return 0;

        int totalWaviness = 0;
        num1 = Math.max(num1, 100);

        for (int num = num1; num <= num2; num++) {
            totalWaviness += countWaviness(num);
        }

        return totalWaviness;
    }

    private static int countWaviness(int n) {
        int i = 10;
        int count = 0;

        while (n / i >= 10) {
            int cur = (n / i) % 10;
            int prv = (n / (i * 10)) % 10;
            int nxt = (n / (i / 10)) % 10;

            if ((prv > cur && cur < nxt) || (prv < cur && cur > nxt)) {
                count++;
            }

            i *= 10;
        }

        return count;
    }
}
