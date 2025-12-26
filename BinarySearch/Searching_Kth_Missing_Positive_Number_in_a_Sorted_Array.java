package BinarySearch;/*
 *
 * https://www.geeksforgeeks.org/problems/kth-missing-positive-number-in-a-sorted-array/1
 *
 * # Kth Missing Positive Number in a Sorted Array
 *
 *   Q. Given a sorted array of distinct positive integers arr[], You need to find the kth positive number that is missing
 *      from the arr[].
 *    Ex.
 *      Input : arr[] = [2, 3, 4, 7, 11], k = 5
 *      Output: 9
 *      Explanation: Missing are 1, 5, 6, 8, 9, 10… and 5th missing number is 9.
 *
 *  Constraints:
 *          1 ≤ arr.size() ≤ 10⁵
 *          1 ≤ k ≤ 10⁵
 *          1 ≤ arr[i] ≤ 10⁶
 */

import java.util.Scanner;

public class Searching_Kth_Missing_Positive_Number_in_a_Sorted_Array {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter  elements: ");
        String[] s = sc.nextLine().split(" ");

        int n = s.length;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(s[i]);

        System.out.print("K: ");
        int k = sc.nextInt();

        System.out.println("Kth positive missing number: " + kthMissing(arr, k));
    }

    /// Solution
    static int kthMissing(int[] arr, int k) {
        return lowerBound(arr, k) + k;
    }

    private static int lowerBound(int[] arr, int k) {
        int ans = arr.length;
        int i = 0;
        int j = ans - 1;

        while (i <= j) {
            int mid = i + (j - i) / 2;
            int missing = arr[mid] - mid - 1;

            if (missing >= k) {
                ans = mid;
                j = mid - 1;
            } else i = mid + 1;
        }

        return ans;
    }
}
