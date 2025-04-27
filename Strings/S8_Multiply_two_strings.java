package Strings;/*
 *
 * https://www.geeksforgeeks.org/problems/multiply-two-strings/1
 *
 * # Multiply two strings
 *
 *   Q. Given two numbers as strings s1 and s2. Calculate their Product.
 *
 *      Note: The numbers can be negative, and You are not allowed to use any built-in function
 *            or convert the strings to integers. There can be zeros at the beginning of the
 *            numbers. You don't need to specify '+' sign at the beginning of positive numbers.
 *   Ex.
 *      Input : s1 = "0033"
 *              s2 = "2"
 *      Output: "66"
 *      Explanation: 33 * 2 = 66
 */

import java.util.Scanner;

public class S8_Multiply_two_strings {

    /// main Method
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Num1: ");
        String s1 = sc.next();

        System.out.println("Num2: ");
        String s2 = sc.next();

        System.out.println(multiplyStrings(s1, s2));
    }

    /// Solution

/****************************************************************************_Built-in Method_***************************************************************************/
    /*
    static String multiplyStrings(String s1, String s2) {
        // potd.code.hub.
        BigInteger a = new BigInteger(s1);
        BigInteger b = new BigInteger(s2);
        BigInteger result = a.multiply(b);

        return result.toString();
    }
    */
/*****************************************************************_Classical digit-by-digit multiplication_**************************************************************/
    /// Solution
    static String multiplyStrings(String s_1, String s_2) {
        // potd.code.hub.
        char[] s1 = s_1.toCharArray();
        char[] s2 = s_2.toCharArray();
        int n = s1.length, m = s2.length;
        int len = m + n - 1, carry;
        int[] mul = new int[len + 1];

        // Chacking signs
        int sign = 1;
        if (s1[0] == '-') {
            s1[0] = '0';
            sign *= -1;
        }
        if (s2[0] == '-') {
            s2[0] = '0';
            sign *= -1;
        }

        // Checking if one number is zero
        if (isZero(s1) || isZero(s2)) {
            return "0";
        }

        // digit by digit multiplication
        for (int i = 0; i < m; i++) {
            carry = 0;
            int d1 = s2[m - 1 - i] - '0';
            if (d1 == 0) continue;
            for (int j = 0; j < n; j++) {
                int d2 = s1[n - 1 - j] - '0';
                int pos = len - i - j;
                int total = d1 * d2 + mul[pos] + carry;
                mul[pos] = total % 10;
                carry = total / 10;
            }
            mul[m - 1 - i] += carry;
        }

        // Removing leading zeros
        String res = remove0(mul);
        // if answer is null
        if (res.isEmpty()) return "0";
        // Updating sign
        if (sign == -1) res = "-" + res;

        return res;
    }

    private static String remove0(int[] s) {
        int n = s.length, i = 0;
        StringBuilder temp = new StringBuilder();

        while (i < n && s[i] == 0) {
            i++;
        }

        for (; i < n; i++) {
            temp.append(s[i]);
        }

        return temp.toString();
    }

    private static boolean isZero(char[] arr) {
        for (char c : arr) {
            if (c != '0') {
                return false;
            }
        }

        return true;
    }
}
