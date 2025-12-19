package BinarySearch;/*
 *
 * https://www.geeksforgeeks.org/problems/search-insert-position-of-k-in-a-sorted-array/1
 *
 * # Search insert position of K in a sorted array
 *
 *   Q. Given a sorted array arr[] (0-index based) of distinct integers and an integer k, find the index of k if it is
 *      present in the arr[]. If not, return the index where k should be inserted to maintain the sorted order.
 *    Ex.
 *      Input : arr[] = [1, 3, 5, 6], k = 2
 *      Output: 1
 *      Explanation: The element 2 is not present in the array, but inserting it at index 1 will maintain the sorted order.
 *
 *  Constraints:
 *          1 ≤ arr.size() ≤ 10⁴
 *          -10³ ≤ arr[i] ≤ 10³
 *          -10³ ≤ k ≤ 10³
 */

import java.util.Scanner;

public class Searching_Search_insert_position_of_K_in_a_sorted_array {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Array Elements: (must be distinct and in sorted order)");
        String[] s = sc.nextLine().split(" ");

        int n = s.length;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(s[i]);
            if (i > 0 && arr[i] <= arr[i-1]) return;
        }

        System.out.print("K: ");
        int k = sc.nextInt();

        System.out.println("Insert position: " + searchInsertK(arr, k));
    }

    /// Solution
    static int searchInsertK(int[] arr, int k) {
        // code here
        int i = 0;
        int j = arr.length - 1;
        int ans = j + 1;

        while(i <= j) {
            int mid = i + (j - i) / 2;

            if(arr[mid] >= k) {
                ans = mid;
                j = mid - 1;
            } else i = mid + 1;
        }

        return ans;
    }
}
