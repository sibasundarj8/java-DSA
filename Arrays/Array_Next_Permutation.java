package Array;/*
 *
 * https://www.geeksforgeeks.org/problems/next-permutation5226/1
 *
 * # Next Permutation (Medium)
 *
 *   Q. Given an array of integers arr[] representing a permutation, implement the next permutation that
 *      rearranges the numbers into the lexicographically next greater permutation. If no such permutation
 *      exists, rearrange the numbers into the lowest possible order (i.e., sorted in ascending order).
 *
 *      Note:  A permutation of an array of integers refers to a specific arrangement of its elements in a
 *             sequence or linear order.
 *   Ex.
 *      Input : arr[] = [2, 4, 1, 7, 5, 0]
 *      Output: [2, 4, 5, 0, 1, 7]
 *      Explanation: The next permutation of the given array is [2, 4, 5, 0, 1, 7].
 *
 *   Constraints:
 *          1 ≤ arr.size() ≤ 10⁵
 *          0 ≤ arr[i] ≤ 10⁵
 */

import java.util.Arrays;
import java.util.Scanner;

public class Array_Next_Permutation {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Elements: ");
        String[] s = sc.nextLine().split(" ");

        int n = s.length;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(s[i]);

        nextPermutation(arr);

        System.out.println("Next permutation: ");
        System.out.println(Arrays.toString(arr));
    }

    /// Solution
    static void nextPermutation(int[] arr) {
        // potd.code.hub
        int n = arr.length;
        int beg = 0;

        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] < arr[i + 1]) {
                beg = i;
                break;
            }
        }

        for (int i = n - 1; i > beg; i--) {
            if (arr[i] > arr[beg]) {
                arr[i] ^= arr[beg];
                arr[beg] ^= arr[i];
                arr[i] ^= arr[beg++];
                break;
            }
        }

        reverse(arr, beg);
    }

    private static void reverse(int[] arr, int start) {
        int end = arr.length - 1;

        while (start < end) {
            arr[start] ^= arr[end];
            arr[end] ^= arr[start];
            arr[start++] ^= arr[end--];
        }
    }
}
