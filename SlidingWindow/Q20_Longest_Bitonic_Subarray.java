package SlidingWindow;/*
 *
 * https://www.geeksforgeeks.org/problems/maximum-length-bitonic-subarray5730/1
 *
 * # Longest Bitonic Subarray
 *
 *   Q. Given an array arr[] of size n containing positive integers, return the maximum length of the bitonic subarray.
 *
 *      A subarray arr[i...j] is considered bitonic if its elements first monotonically increase, and then monotonically
 *      decrease. Formally, there exists and index k (where i <= k <= j) such that:
 *        ◦ arr[i] <= arr[i+1] <= . . . <= arr[k]
 *        ◦ arr[k] >= arr[k+1] >= . . . >= arr[j]
 *
 *    Ex.
 *      Input : arr[] = [12, 4, 78, 90, 45, 23]
 *      Output: 5
 *      Explanation: The longest bitonic subarray is [4, 78, 90, 45, 23], it starts increasing at 4, peaks at 90, and
 *                   decreases to 23, giving length of 5.
 *
 *  Constraints:
 *        1 ≤  n ≤ 10⁶
 *        1 ≤ arr[i] ≤ 10⁶
 */

import java.util.Scanner;

public class Q20_Longest_Bitonic_Subarray {

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

        System.out.println("\n--- Results ---");
        System.out.println("Approach 1 (Pre-Calculation DP) Max Length: " + approach_1(arr));
        System.out.println("Approach 2 (Sliding Window O(1) Space) Max Length: " + bitonic(arr));
    }

    /// Solution
/*
⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯-Pre-Calculation-⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯
TC : O(n)
SC : O(n)
*/
    static int approach_1(int[] arr) {
        // potd.code.hub
        int n = arr.length;
        int max = 1;
        int[] asc = new int[n];
        int[] desc = new int[n];

        asc[0] = desc[n - 1] = 1;

        for (int i = 1; i < n; i++) {
            if (arr[i] >= arr[i - 1]) asc[i] = asc[i - 1] + 1;
            else asc[i] = 1;

            int j = n - 1 - i;

            if (arr[j] >= arr[j + 1]) desc[j] = desc[j + 1] + 1;
            else desc[j] = 1;
        }

        for (int i = 0; i < n; i++) {
            max = Math.max(max, asc[i] + desc[i] - 1);
        }

        return max;
    }
/*
⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯-Sliding-Window-⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯
TC : O(n)
SC : O(1)
*/
    static int bitonic(int[] arr) {
        // potd.code.hub
        int n = arr.length;
        int i = 0;
        int j = 0;
        int max = 1;

        while (j < n - 1) {
            while (j < n - 1 && arr[j] <= arr[j + 1]) j++; // climbing j to the peak
            while (j < n - 1 && arr[j] >= arr[j + 1]) j++; // sliding down the valley

            max = Math.max(max, j - i + 1);

            while (i < j && arr[i] <= arr[i + 1]) i++;     // squizzing the window without getting trapped
            while (i < j && arr[i] > arr[j]) i++;
        }

        return max;
    }
}
