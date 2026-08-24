package GFG;/*
 *
 * https://www.geeksforgeeks.org/problems/geek-and-his-binary-strings1951/1
 *
 * # Count Prefix-Balanced Binary Strings
 *
 *   Q. Given an integer n, count the number of binary strings of length 2 * n that contain exactly n ones and n zeros
 *      such that every prefix of the string contains at least as many ones as zeros. Since the answer can be very large,
 *      return it modulo 10⁹ + 7.
 *
 *    Ex.
 *      Input : n = 3
 *      Output: 5
 *      Explanation: "111000", "101100", "101010", "110010", "110100" are such 5 strings which have exactly three 1's
 *                   in each.
 *
 *  Constraints:
 *      1 ≤ n ≤ 1000
 */

import java.util.Scanner;

public class POTD_Count_Prefix_Balanced_Binary_Strings {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("n: ");
        int n = sc.nextInt();

        if (n > 1000) throw new IllegalArgumentException("n must be <= 1000");

        System.out.println("Number of binary strings:");
        System.out.println(prefixStrings(n));
    }

    /// Solution
    static int prefixStrings(int n) {
        // potd.code.hub
        int mod = (int) (1e9 + 7);
        long count = 1;
        int m = n << 1;

        for (int i = 0; i < n; i++) {
            count = (count * (m - i)) % mod;
            count = (count * modInverse(i + 1, mod - 2, mod)) % mod;
        }

        return (int) ((count * modInverse(n + 1, mod - 2, mod)) % mod);
    }

    private static long modInverse(int a, int b, int mod) {
        // base case
        if (b == 0) return 1;
        if (b == 1) return a;

        // recursive work
        long half = modInverse(a, b >> 1, mod);
        long res = half * half % mod;

        // self work
        return ((b & 1) == 1) ? (res * a) % mod : res;
    }
}
