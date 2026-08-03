package SlidingWindow;/*
 *
 * https://www.geeksforgeeks.org/problems/largest-sum-subarray-of-size-at-least-k3121/1
 *
 * # Max Sum Subarray of Size at least K
 *
 *   Q. Given an array arr[] and an integer k, find the maximum sum among all contiguous subarrays having a length
 *      greater than or equal to k.
 *
 *    Ex.
 *      Input : arr[] = [1, -2, 2, -3], k = 3
 *      Output: 1
 *      Explanation: The sub-array of length at least 3 that produces greatest sum is [1, -2, 2]
 *
 *  Constraints:
 *        1 ≤ arr.size() ≤ 10⁵
 *        -104 ≤ arr[i] ≤ 10⁴
 *        1 ≤ k ≤ arr.size()
 */

import java.util.Scanner;

public class Q21_Max_Sum_Subarray_of_Size_at_least_K {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("int[] arr: ");
        String[] s = sc.nextLine().split(" ");

        System.out.print("k: ");
        int k = sc.nextInt();

        int n = s.length;
        if (k > n) throw new IllegalArgumentException("K must be less than n");

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(s[i]);
        }

        System.out.println("Max sum of subarray with greater length then k: ");
        System.out.println(maxSumWithK(arr, k));
    }

    /// Solution
    static int maxSumWithK(int[] arr, int k) {
        // potd.code.hub
        int n = arr.length;
        int max = Integer.MIN_VALUE;
        int kSum = 0;
        int left = 0;

        for (int i = 0; i < n; i++) {
            kSum += arr[i];

            if (i >= k) {
                kSum -= arr[i - k];
                left += arr[i - k];
                left = Math.max(left, 0);
            }

            if (i >= k - 1) {
                max = Math.max(max, left + kSum);
            }
        }

        return max;
    }
}
