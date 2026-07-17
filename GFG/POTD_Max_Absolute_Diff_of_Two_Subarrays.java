package GFG;/*
 *
 * https://www.geeksforgeeks.org/problems/max-absolute-difference4114/1
 *
 * # Max Absolute Diff of Two Subarrays
 *
 *   Q. Given an array of integers arr[], find two non-overlapping contiguous sub-arrays such that the absolute
 *      difference between the sum of two sub-arrays is maximum.
 *
 *    Ex.
 *      Input : arr[] = [-2, -3, 4, -1, -2, 1, 5, -3]
 *      Output: 12
 *      Explanation: Two subarrays are [-2, -3] and [4, -1, -2, 1, 5]
 *
 *  Constraints:
 *        2 ≤ arr.size() ≤ 10⁵
 *        -10³ ≤ arr[i] ≤ 10³
 */

import java.util.Scanner;

public class POTD_Max_Absolute_Diff_of_Two_Subarrays {

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

        System.out.println("result: ");
        System.out.println(maxDiffSubArrays(arr));
    }

    /// Solution
    static int maxDiffSubArrays(int[] arr) {
        // potd.code.hub
        int n = arr.length;

        int[] rightMinSubarraySum = new int[n];
        int[] rightMaxSubarraySum = new int[n];

        int rMinSum = rightMinSubarraySum[n - 1] = arr[n - 1];
        int rMaxSum = rightMaxSubarraySum[n - 1] = arr[n - 1];

        for (int i = 1; i < n; i++) {
            int j = n - 1 - i;

            rMinSum = Math.min(rMinSum, 0) + arr[j];
            rMaxSum = Math.max(rMaxSum, 0) + arr[j];

            rightMinSubarraySum[j] = Math.min(rightMinSubarraySum[j + 1], rMinSum);
            rightMaxSubarraySum[j] = Math.max(rightMaxSubarraySum[j + 1], rMaxSum);
        }

        int maxDiff = Integer.MIN_VALUE;

        int lMinSum = arr[0];
        int lMaxSum = arr[0];
        int leftMinSubarraySum = arr[0];
        int leftMaxSubarraySum = arr[0];

        for (int i = 1; i < n; i++) {
            maxDiff = Math.max(maxDiff, Math.abs(leftMinSubarraySum - rightMaxSubarraySum[i]));
            maxDiff = Math.max(maxDiff, Math.abs(leftMaxSubarraySum - rightMinSubarraySum[i]));

            lMinSum = Math.min(lMinSum, 0) + arr[i];
            lMaxSum = Math.max(lMaxSum, 0) + arr[i];

            leftMinSubarraySum = Math.min(leftMinSubarraySum, lMinSum);
            leftMaxSubarraySum = Math.max(leftMaxSubarraySum, lMaxSum);
        }

        return maxDiff;
    }
}
