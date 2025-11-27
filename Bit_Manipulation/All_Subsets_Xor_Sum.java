package Bit_Manipulation;/*
 *
 * https://www.geeksforgeeks.org/problems/sum-of-xor-of-all-possible-subsets/1
 *
 * # All Subsets Xor Sum
 *
 *   Q. Given an array arr[], return the sum of the XOR of all elements for every possible subset of the array. Subsets
 *      with the same elements should be counted multiple times.
 *
 *      An array arr is a subset of an array brr if aaa can be obtained from brr by deleting some (possibly zero) elements
 *      of b.
 *
 *      Note: The answer is guaranteed to fit within a 32-bit integer.
 *
 *    Ex.
 *      Input : arr[] = [1, 2, 3]
 *      Output: 12
 *      Explanation: Subsets are: [[],
 *                                 [1],
 *                                 [2],
 *                                 [3],
 *                                 [1, 2],
 *                                 [1, 3],
 *                                 [2, 3],
 *                                 [1, 2, 3]]
 *      Sum of all XOR's = 1 + 2 + 3 + (1 ^ 2)  + (1 ^ 3) + (2 ^ 3) + (1 ^ 2 ^ 3) = 12.
 *
 *  Constraints:
 *          1 ≤ arr.size() ≤ 30
 *          1 ≤ arr[i] ≤ 10³
 */

import java.util.Scanner;

public class All_Subsets_Xor_Sum {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Elements: ");
        String[] s = sc.nextLine().split(" ");

        int n = s.length;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(s[i]);

        System.out.println("Sum of the XOR of all elements for every possible subset : ");
        System.out.println(subsetXORSum(arr));
    }

    /// Solution
    public static int subsetXORSum(int[] arr) {
        // potd.code.hub
        int n = arr.length;
        int setBits = 0;

        for (int i : arr) {
            setBits |= i;
        }

        return setBits << (n - 1);
    }
}
