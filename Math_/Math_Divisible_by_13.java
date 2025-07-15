package Math_;/*
 *
 * https://www.geeksforgeeks.org/problems/divisible-by-13/1
 *
 * # Divisible by 13
 *
 *   Q. Given a number represented as a string s (which may be very large), check whether it is divisible by
 *      13 or not.
 *   Ex.
 *      Input : s = "2911285"
 *      Output : true
 *      Explanation: 2911285 ÷ 13 = 223945, which is a whole number with no remainder.
 */

import java.util.Scanner;

public class Math_Divisible_by_13 {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the Number: ");
        String s = sc.next();

        System.out.println("Divisible by 13: " + divby13(s));
    }

    /// Solution
    static boolean divby13(String s) {
        // potd.code.hub
        int n = s.length();
        int rem = 0;

        for (int i = 0;i < n;i++) {
            int cur = s.charAt(i) - '0';
            rem *= 10;
            rem += cur;
            if (rem >= 13) rem %= 13;
        }

        return rem == 0;
    }
}
