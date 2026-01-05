package SlidingWindow;/*
 *
 * https://www.geeksforgeeks.org/problems/max-sum-subarray-of-size-k5313/1
 *
 * # Max Sum Subarray of size K
 *
 *   Q. Given an array of integers arr[]  and a number k. Return the maximum sum of a subarray of size k.
 *      Note: A subarray is a contiguous part of any given array.
 *    Ex.
 *      Input : arr[] = [100, 200, 300, 400], k = 2
 *      Output: 700
 *      Explanation: arr2 + arr3 = 700, which is maximum.
 *
 *  Constraints:
 *          1 ≤ arr.size() ≤ 10⁶
 *          1 ≤ arr[i] ≤ 10⁶
 *          1 ≤ k ≤ arr.size()
 */

import java.util.Scanner;

public class Q03_Max_Sum_SubArray_of_size_K {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter array elements: ");
        String[] s = sc.nextLine().split(" ");

        int n = s.length;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(s[i]);

        System.out.println("Enter K: ");
        int k = sc.nextInt();

        System.out.println("Output :");
        System.out.println(maxSubarraySum(arr,k));
    }

    /// Solution
    static int maxSubarraySum(int[] arr, int k) {
        int n = arr.length;
        int sum = 0;

        for(int i = 0; i < k; i++)
            sum += arr[i];

        int max = sum;

        for(int i = k; i < n; i++) {
            sum += (arr[i] - arr[i - k]);
            max = Math.max(max, sum);
        }

        return max;
    }
}
