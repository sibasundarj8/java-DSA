package Greedy;/*
 *
 * https://www.geeksforgeeks.org/problems/count-always-found/1
 *
 * # Successful Binary Searches Irrespective of Pivot
 *
 *   Q. Given an array arr[] of n distinct integers (not necessarily sorted), consider the following search for a target:
 *        ◦ Maintain a range [lo, hi], initially [0, n-1].
 *        ◦ At each step, pick any index p in [lo, hi] (not necessarily the middle) as pivot. If arr[p] == target,
 *          stop - found.
 *        ◦ If target < arr[p], set hi = p - 1; if target > arr[p], set lo = p + 1. If lo > hi, stop - not found.
 *
 *      Count the number of indices i such that searching for target = arr[i] succeeds no matter which pivot is chosen
 *      at every step (i.e., for every possible sequence of pivot choices).
 *
 *    Ex.
 *      Input : arr[] = [9, 4, 1, 10, 22, 23, 20]
 *      Output: 1
 *      Explanation: Only 10 (index 3) is always found — every pivot, left or right, happens to steer toward it.
 *                   Everything else can fail on some pivot order: e.g. picking 4 first pushes a search for 9 away
 *                   permanently, and picking 20 first makes a search for 22 run off the end of the array entirely.
 *
 *  Constraints:
 *        ◦ 1 ≤ arr.size() ≤ 10⁵
 *        ◦ 1 ≤ arr[i] ≤ 10⁶
 */

import java.util.Scanner;

public class G18_Successful_Binary_Searches_Irrespective_of_Pivot {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("arr[]: ");
        String[] s = sc.nextLine().split(" ");

        int n = s.length;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(s[i]);
        }

        System.out.println("number of indices i such that searching for arr[i] succeeds irrespective of pivot: ");
        System.out.println(countAlwaysFound(arr));
    }

    /// Solution
    static int countAlwaysFound(int[] arr) {
        int n = arr.length;
        int[] rightMin = new int[n];
        rightMin[n - 1] = arr[n - 1];

        for (int i = n - 2; i >= 0; i--) {
            rightMin[i] = Math.min(arr[i], rightMin[i + 1]);
        }

        int leftMax = -1;
        int count = 0;

        for (int i = 0; i < n; i++) {
            leftMax = Math.max(leftMax, arr[i]);

            if (leftMax > arr[i] || rightMin[i] < arr[i]) {
                continue;
            }

            count++;
        }

        return count;
    }
}
