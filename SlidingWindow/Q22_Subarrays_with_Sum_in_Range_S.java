package SlidingWindow;/*
 *
 * https://www.geeksforgeeks.org/problems/count-the-number-of-subarrays/1
 *
 * # Subarrays with Sum in Range
 *
 *   Q. Given an integer array arr[] and two integers l and r, find the number of subarrays whose sum lies in the range
 *      [l, r] (inclusive).
 *
 *      A subarray is a contiguous sequence of elements within the array.
 *
 *    Ex.
 *      Input : l = 4, r = 13,
 *              arr[] = [2, 3, 5, 8]
 *      Output: 6
 *      Explanation: The subarrays are [2, 3], [2, 3, 5], [3, 5], [5], [5, 8] and [8].
 *                   Therefor answer for this test case is 6.
 *
 *  Constraints:
 *        ◦ 1 ≤ arr.size() ≤ 10⁵
 *        ◦ 1 ≤ arr[i] ≤ 10⁴
 *        ◦ 1 ≤ l ≤ r ≤ 10⁹
 */

import java.util.Scanner;

public class Q22_Subarrays_with_Sum_in_Range_S {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("int[] arr: ");
        String[] s = sc.nextLine().split(" ");

        int n = s.length;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(s[i]);
        }

        System.out.print("l: ");
        int l = sc.nextInt();

        System.out.print("r: ");
        int r = sc.nextInt();

        System.out.println("Number of subarrays whose sum lies in the range [" + l + ", " + r + "]:");
        System.out.println(countSubarray(arr, l, r));
    }

    /// Solution
/*
⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯--binary-search--⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯
TC : O(n log n)
SC : O(1)
*/
    static int approach_1(int[] arr, int l, int r) {
        // potd.code.hub
        int n = arr.length;
        int count = 0;

        for (int i = 1; i < n; i++) {
            arr[i] += arr[i - 1];
        }

        // now array is sorted we can apply binary search to find next point where subarray sum is x.
        for (int i = 0; i < n; i++) {
            int start = lb(i, n - 1, l, arr);
            int end = up(i, n - 1, r, arr);
            count += (end - start + 1);
        }

        return count;
    }

    private static int lb(int i, int j, int tarSum, int[] arr) {
        int prevSum = (i == 0) ? 0 : arr[i - 1];

        while (i <= j) {
            int mid = i + ((j - i) >> 1);
            int sum = arr[mid] - prevSum;
            if (sum >= tarSum) j = mid - 1;
            else i = mid + 1;
        }

        return i;
    }

    private static int up(int i, int j, int tarSum, int[] arr) {
        int prevSum = (i == 0) ? 0 : arr[i - 1];

        while (i <= j) {
            int mid = i + ((j - i) >> 1);
            int sum = arr[mid] - prevSum;
            if (sum <= tarSum) i = mid + 1;
            else j = mid - 1;
        }

        return j;
    }

/*
⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯-sliding-window-⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯
TC : O(n)
SC : O(1)
*/
    static int countSubarray(int[] arr, int l, int r) {
        return countSubarrayWithSmallerSum(arr, r) - countSubarrayWithSmallerSum(arr, l - 1);
    }

    private static int countSubarrayWithSmallerSum(int[] arr, int tar) {
        int n = arr.length;
        int l = 0;
        int sum = 0;
        int count = 0;

        for (int r = 0; r < n; r++) {
            sum += arr[r];

            while (sum > tar) {
                sum -= arr[l++];
            }

            count += (r - l + 1);
        }

        return count;
    }
}
