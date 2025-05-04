package Binary_Search;/*
 *
 * https://www.geeksforgeeks.org/problems/search-in-an-almost-sorted-array/1
 *
 * # Search in an almost Sorted Array
 *
 *   Q. Given a sorted integer array arr[] consisting of distinct elements, where some elements of
 *      the array are moved to either of the adjacent positions, i.e., arr[i] may be present at
 *      arr[i-1] or arr[i+1].
 *
 *      Given an integer target.  You have to return the index (0-based) of the target in the array.
 *      If the target is not present, return -1.
 *   Ex.
 *      Input : arr[] = [10, 3, 40, 20, 50, 80, 70]
 *              target = 40
 *      Output: 2
 *      Explanation: Index of 40 in the given array is 2.
 */

import java.util.Scanner;

public class Searching_Search_in_an_almost_Sorted_Array {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Elements: ");
        String[] s = sc.nextLine().split(" ");

        int n = s.length;
        int[] arr = new int[n];

        for (int i = 0;i < n;i++){
            arr[i] = Integer.parseInt(s[i]);
        }

        System.out.println("Target: ");
        int target = sc.nextInt();

        System.out.println("Index: " + findTarget(arr, target));
    }

    /// Solution
    static int findTarget(int[] arr, int target) {
        // potd.code.hub
        int l = 1, r = arr.length - 2;

        if (arr[0] == target) return 0;
        if (arr[r + 1] == target) return r + 1;

        while (l <= r) {
            int mid = l + (r - l) / 2;
            // check
            if (arr[mid] == target) return mid;
            else if (arr[mid - 1] == target) return mid - 1;
            else if (arr[mid + 1] == target) return mid + 1;
            // dividing the array
            if (arr[mid] < target) {
                l = mid + 2;
            } else {
                r = mid - 2;
            }
        }

        return -1;
    }
}
