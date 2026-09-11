package LeetCode;/*
 *
 * https://leetcode.com/problems/unique-3-digit-even-numbers/
 *
 * # LC. 3483. Unique 3-Digit Even Numbers
 *
 *   Q. You are given an array of digits called digits. Your task is to determine the number of distinct three-digit
 *      even numbers that can be formed using these digits.
 *
 *      Note: Each copy of a digit can only be used once per number, and there may not be leading zeros.
 *
 *    Ex.
 *      Input : digits = [1, 2, 3, 4]
 *      Output: 12
 *      Explanation:
 *                ◦ The 12 distinct 3-digit even numbers that can be formed are:
 *                  124, 132, 134, 142, 214, 234, 312, 314, 324, 342, 412, and 432.
 *                ◦ Note that 222 cannot be formed because there is only 1 copy of the digit 2.
 *
 *  Constraints:
 *        ◦ 3 <= digits.length <= 10
 *        ◦ 0 <= digits[i] <= 9
 */

import java.util.Scanner;

public class LeetCode_3483_Unique_3_Digit_Even_Numbers {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter digits[]: ");
        String[] s = sc.nextLine().split(" ");

        int n = s.length;

        if (n < 3 || 10 < n) {
            throw new IllegalArgumentException("Invalid input");
        }

        int[] digits = new int[n];

        for (int i = 0; i < n; i++) {
            digits[i] = Integer.parseInt(s[i]);

            if (digits[i] < 0 || 9 < digits[i]) {
                throw new IllegalArgumentException("Invalid digits");
            }
        }

        System.out.println("Number of distinct 3-digit even numbers that can be formed using these digits: ");
        System.out.println(totalNumbers(digits));
    }

    /// Solution
    static int totalNumbers(int[] digits) {
        int n = digits.length;
        int num, count = 0;
        boolean[] seen = new boolean[1000];

        for (int i = 0; i < n; i++) {
            if (digits[i] == 0) continue;

            for (int j = 0; j < n; j++) {
                if (j == i) continue;

                for (int k = 0; k < n; k++) {
                    if (k == j || k == i) continue;

                    if ((digits[k] & 1) != 1) {
                        num = digits[i] * 100 + digits[j] * 10 + digits[k];

                        if (!seen[num]) {
                            seen[num] = true;
                            count++;
                        }
                    }
                }
            }
        }

        return count;
    }
}
