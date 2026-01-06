package SlidingWindow;/*
 *
 * https://www.geeksforgeeks.org/problems/max-xor-subarray-of-size-k/1
 *
 * # Max Xor Subarray of size K
 *
 *   Q. Given an array of integers arr[]  and a number k. Return the maximum xor of a subarray of size k.
 *      Note: A subarray is a contiguous part of any given array.
 *    Ex.
 *      Input : arr[] = [2, 5, 8, 1, 1, 3], k = 3
 *      Output: 15
 *      Explanation: arr[0] ^ arr[1] ^ arr[2] = 15, which is maximum.
 *
 *  Constraints:
 *      1 ≤ arr.size() ≤ 10⁶
 *      0 ≤ arr[i] ≤ 10⁶
 *      1 ≤ k ≤ arr.size()
 */

import java.util.Scanner;

public class Q15_Max_Xor_Subarray_of_size_K {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter array elements: ");
        String[] s = sc.nextLine().split(" ");

        int n = s.length;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(s[i]);

        System.out.println("xor of Sub-array with max xor: ");
        System.out.println(maxSubarrayXOR(arr, n));
    }

    /// Solution
    static int maxSubarrayXOR(int[] arr, int k) {
        // code here
        int n = arr.length;
        int xor = 0;
        for (int i = 0; i < k; i++) xor ^= arr[i];

        int ans = xor;

        for (int i = k; i < n; i++) {
            xor ^= arr[i - k];
            xor ^= arr[i];

            ans = Math.max(ans, xor);
        }

        return ans;
    }
}
