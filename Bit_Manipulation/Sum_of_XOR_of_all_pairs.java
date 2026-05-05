package Bit_Manipulation;/*
 *
 * https://www.geeksforgeeks.org/problems/sum-of-xor-of-all-pairs0723/1
 *
 * # Sum of XOR of all pairs
 *
 *   Q. Given an integer array arr[] of size n, compute the sum of the bitwise XOR for all distinct pairs of elements.
 *      That is, consider every pair of indices (i, j) such that 0 ≤ i < j < n, and calculate the total sum of (arr[i] XOR
 *      arr[j]) over all such pairs.
 *
 *    Ex.
 *      Input : arr[] = [7, 3, 5]
 *      Output: 12
 *      Explanation:
 *              All pairs (i, j) such that i < j and their XOR values are:
 *                7 ^ 3 = 4
 *                7 ^ 5 = 2
 *                3 ^ 5 = 6
 *
 *              Sum of all XOR values = 4 + 2 + 6 = 12.
 *
 *  Constraints
 *          1 ≤ n ≤ 10⁵
 *          1 ≤ arr[i] ≤ 10⁵
 */

import java.util.Scanner;

public class Sum_of_XOR_of_all_pairs {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter array elements: ");
        String[] s = sc.nextLine().split(" ");

        int n = s.length;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(s[i]);
        }

        System.out.println("Sum of the bitwise XOR for all distinct pairs: ");
        System.out.println(sumXOR(arr));
    }

    /// Solution
    static long sumXOR(int[] arr) {
        // potd.code.hub
        int[] count = new int[2];
        long result = 0;

        // checking each and every bit contribution.
        for (int i = 0; i < 32; i++) {
            count[0] = count[1] = 0;

            for (int ele : arr) {
                count[(ele >> i) & 1]++;
            }

            long totalContribution = (long) count[0] * count[1];
            result += totalContribution * (1L << i);
        }

        return result;
    }
}
