package LeetCode;/*
 *
 * https://leetcode.com/problems/remove-k-digits/
 *
 * # LC. 402. Remove K Digits
 *
 *   Q. Given string num representing a non-negative integer num, and an integer k, return the smallest possible integer
 *      after removing k digits from num.
 *
 *    Ex.
 *      Input : num = "10200", k = 1
 *      Output: "200"
 *      Explanation: Remove the leading 1 and the number is 200. Note that the output must not contain leading zeroes.
 *
 *  Constraints:
 *        ◦ 1 <= k <= num.length <= 10⁵
 *        ◦ num consists of only digits.
 *        ◦ num does not have any leading zeros except for the zero itself.
 */

import java.util.Scanner;

public class LeetCode_402_Remove_K_Digits {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number: ");
        String num = sc.next();

        System.out.print("K: ");
        int k = sc.nextInt();

        System.out.println("Smallest possible integer after removing " + k + " digits: ");
        System.out.println(removeKdigits(num, k));
    }

    /// Solution
    static String removeKdigits(String num, int k) {
        int n = num.length();

        if (n == k) return "0";

        StringBuilder stack = new StringBuilder();
        int targetLength = n - k;

        for (int i = 0; i < n; i++) {
            char ch = num.charAt(i);

            while (!stack.isEmpty()
                    && stack.charAt(stack.length() - 1) > ch
                    && n - i > targetLength - stack.length()) {

                stack.deleteCharAt(stack.length() - 1);
            }

            if (stack.length() < targetLength) stack.append(ch);
        }

        int leadingZero = 0;
        while (leadingZero < targetLength && stack.charAt(leadingZero) == '0') {
            leadingZero++;
        }

        return leadingZero == targetLength ? "0" : stack.substring(leadingZero);
    }
}
