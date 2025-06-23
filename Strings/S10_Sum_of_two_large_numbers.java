package Strings;/*
 *
 * https://www.geeksforgeeks.org/problems/sum-of-numbers-or-number1219/1
 *
 * # Sum of two large numbers
 *
 *   Q. Given two strings denoting non-negative numbers s1 and s2. Calculate the sum of s1 and s2.
 *    Ex.
 *      Input : s1 = "25";
 *              s2 = "23";
 *      Output: "48"
 *      Explanation: The sum of 25 and 23 is 48.
 */

import java.util.Scanner;

public class S10_Sum_of_two_large_numbers {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("num1: ");
        String n1 = sc.next();

        System.out.println("num2: ");
        String n2 = sc.next();

        System.out.println("Sum: " + findSum(n1, n2));
    }

    /// Solution
    static String findSum(String s1, String s2) {
        // potd.code.hub
        int n = s1.length();
        int m = s2.length();
        int len = Math.max(n, m);
        StringBuilder ans = new StringBuilder();

        int idx1, idx2, d1, d2, sum, carry = 0;

        for (int i = 0;i < len;i++) {
            idx1 = n-1-i;
            idx2 = m-1-i;
            d1 = (idx1 >= 0) ? s1.charAt(idx1) -'0' : 0;
            d2 = (idx2 >= 0) ? s2.charAt(idx2) -'0' : 0;

            sum = d1 + d2 + carry;

            ans.append(sum % 10);
            carry = sum / 10;
        }
        ans.append(carry);

        int idx = ans.length()-1;
        while (idx > 0 && ans.charAt(idx) == '0') {
            idx--;
        }

        ans.delete(idx+1, ans.length());

        return ans.reverse().toString();
    }
}
