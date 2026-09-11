package GFG;/*
 *
 * https://www.geeksforgeeks.org/problems/k-modulus-array-element0255/1
 *
 * # Values with Equal Array Remainders
 *
 *   Q. Given an integer array arr[], count the number of positive integers k such that all elements of the array
 *      leave the same remainder when divided by k.
 *
 *      If there are infinitely many such values of k, return -1.
 *
 *    Ex.
 *      Input : arr[] = [38, 6, 34]
 *      Output: 3
 *      Explanation:
 *              The values of k for which all elements leave the same remainder when divided by k are 1, 2, and 4.
 *
 *                ◦ For k = 1, all elements leave remainder 0.
 *                ◦ For k = 2, all elements leave remainder 0.
 *                ◦ For k = 4, all elements leave remainder 2.
 *
 *              No other positive integer satisfies the required condition. Hence, the answer is 3.
 *
 *  Constraints:
 *        ◦ 1 ≤ arr.size(), arr[i] ≤ 10⁵
 */

import java.util.Scanner;

public class POTD_Values_with_Equal_Array_Remainders {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("arr[]: ");
        String[] s = sc.nextLine().split(" ");

        int n = s.length;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(s[i]);
        }

        System.out.println("Number of +ve integers such that all elements leave the same remainder with k: ");
        System.out.println(sameMod(arr));
    }

    /// Solution
    static int sameMod(int[] arr) {
        // potd.code.hub
        int n = arr.length;

        // GCD
        int gcd = 0;

        for (int i = 1; i < n; i++) {
            gcd = gcd(gcd, Math.abs(arr[i] - arr[i - 1]));
        }

        // BASE_CASE
        if (gcd == 0) {
            return -1;
        }

        // FACTORS
        int count = 0;
        int i = 1;

        while (i * i < gcd) {
            if (gcd % i == 0) count += 2;
            i++;
        }

        if (i * i == gcd) count++;

        return count;
    }

    private static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
