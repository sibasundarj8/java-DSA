package Binary_Search;/*
 *
 * https://www.geeksforgeeks.org/problems/maximize-the-minimum-difference-between-k-elements/1
 *
 * # Maximize the minimum difference between k elements
 *
 *   Q. Given an array arr[] of integers and an integer k, select k elements from the array such that the minimum
 *      absolute difference between any two of the selected elements is maximized. Return this maximum possible
 *      minimum difference.
 *   Ex.
 *      Input : arr[] = [1, 4, 9, 0, 2, 13, 3]
 *              k = 4
 *      Output: 4
 *      Explanation: Selecting 0, 4, 9, 13 will result in minimum difference of 4, which is the largest minimum
 *                   difference possible.
 *    Constraints:
 *          1 ≤ arr.size() ≤ 105
 *          0 ≤ arr[i] ≤ 106
 *          2 ≤ k ≤ arr.size()
 */

import java.util.Arrays;
import java.util.Scanner;

public class Searching_Maximize_the_minimum_difference_between_k_elements {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter elements: ");
        String[] s = sc.nextLine().split(" ");

        int n = s.length;
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(s[i]);
        }

        System.out.println("K: ");
        int k = sc.nextInt();

        System.out.println("Maximum minimum possible difference: ");
        System.out.println(maxMinDiff(arr, k));
    }

    /// Solution
    static int maxMinDiff(int[] arr, int k) {
        // potd.code.hub
        Arrays.sort(arr);

        int s = 0;              // minimum possible answer
        int e = arr[arr.length - 1]; // maximum possible answer
        int ans = s;

        while (s <= e) {
            int mid = s + (e - s) / 2;
            // try to maximize if it's a possible answer.
            if (isPossible(arr, mid, k)) {
                ans = mid;
                s = mid + 1;
            } else e = mid - 1;
        }

        return ans;
    }

    // checking: this is a possible answer or not
    private static boolean isPossible(int[] arr, int minDif, int k) {
        // suppose array is already sorted
        int n = arr.length;
        int count = 1;
        int pick = arr[0];

        for (int i = 1; i < n; i++) {
            if ((arr[i] - pick) >= minDif) {
                pick = arr[i];
                count++;
            }
            if (count >= k) return true;
        }

        return false;
    }
}
