package GFG;/*
 *
 * https://www.geeksforgeeks.org/problems/sum-of-all-sub-sequences-of-a-number3437/1
 *
 * # Sum of All Digit Subsequences
 *
 *   Q. Given a string s which consists of digits, find sum of all digits across all non-empty subsequences of s.
 *      Note: Since the answer can be very large, return it modulo 10⁹ + 7.
 *
 *    Ex.
 *      Input : s = "123"
 *      Output: 24
 *      Explanation: The non-empty subsequences are: [1], [2], [3], [1, 2], [1, 3], [2, 3], [1, 2, 3].
 *                   The sum of all digits in these subsequences is: 1 + 2 + 3 + (1 + 2) + (1 + 3) + (2 + 3) +
 *                                                                  (1 + 2 + 3) = 24.
 *
 *  Constraints:
 *        ◦ 1 ≤ s.size() ≤ 10⁵
 *        ◦ s consists only of digits(1 - 9).
 */

import java.util.Scanner;

public class POTD_Sum_of_All_Digit_Subsequences {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("number: ");
        String s = sc.next();

        System.out.println("Sum of all digits across all non-empty subsequences of s: ");
        System.out.println(subsequenceSum(s));
    }

    /// Solution
    private static final long MOD = (long) 1e9 + 7;

    static int subsequenceSum(String s) {
        // potd.code.hub
        int n = s.length();
        long mul = twoPow(n - 1);
        long digSum = 0;

        for (int i = 0; i < n; i++) {
            digSum += (s.charAt(i) - '0');
        }

        return (int) ((digSum % MOD * mul) % MOD);
    }

    private static long twoPow(long n) {
        // base case
        if (n == 0) return 1;

        // recursive work
        long half = twoPow(n / 2);
        half = (half * half) % MOD;

        // self work
        return ((n & 1) == 0) ? half : (half << 1L) % MOD;
    }
}
