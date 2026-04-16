package Strings;/*
 *
 * https://www.geeksforgeeks.org/problems/implement-atoi/1
 *
 * # Implement Atoi
 *
 *   Q. Given a string s, convert it into a 32-bit signed integer (similar to the atoi() function) without using any built-in
 *      conversion functions.
 *
 *      The conversion follows these rules:
 *        ◦ Ignore Leading Whitespaces: Skip all leading whitespace characters.
 *
 *        ◦ Check Sign: If the next character is either '+' or '-', take it as the sign of the number. If no sign is present,
 *                      assume the number is positive.
 *
 *        ◦ Read Digits: Read the digits and ignore any leading zeros. Stop reading when a non-digit character is encountered
 *                       or the end of the string is reached. If no digits are found, return 0.
 *
 *        ◦ Handle Overflow: If the number exceeds the range of a 32-bit signed integer:
 *                  - Return 2³¹ − 1 (i.e., 2147483647) if it is greater than the maximum value.
 *                  - Return −2³¹ (i.e., -2147483648) if it is smaller than the minimum value.
 *                  - Return the final integer value.
 *    Ex.
 *      Input : s = "-123"
 *      Output: -123
 *      Explanation: It is possible to convert -123 into an integer so we returned in the form of an integer
 *
 *  Constraints:
 *      1 ≤ |s| ≤ 15
 */

import java.util.Scanner;

public class S15_Implement_Atoi {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the String: ");
        String s = sc.nextLine();

        System.out.print("Atoi: ");
        System.out.println(myAtoi(s));
    }

    /// Solution
    static int myAtoi(String s) {
        // potd.code.hub
        s = s.trim();
        int n = s.length();

        if (n == 0) return -1;

        int idx = 0;
        long num = 0;
        boolean negative = false;

        if (s.charAt(0) == '-') {
            negative = true;
            idx++;
        }
        if (s.charAt(0) == '+') idx++;

        while (idx < n) {
            char ch = s.charAt(idx);

            if (ch < '0' || '9' < ch) {
                break;
            }

            num *= 10;
            num += (ch - '0');
            idx++;

            if (num > Integer.MAX_VALUE) {
                return (negative) ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
        }

        if (negative) num = -num;

        return (int) num;
    }
}
