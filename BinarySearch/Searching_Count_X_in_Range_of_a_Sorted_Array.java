package BinarySearch;/*
 *
 * https://www.geeksforgeeks.org/problems/count-x-in-range-of-a-sorted-array/1
 *
 * # Count X in Range of a Sorted Array
 *
 *   Q. You are given a sorted array arr[] and a 2D array queries[][], where queries[i] represents a query in the form
 *      [l, r, x]. For each query, count how many times the number x appears in the subarray arr[l...r] (inclusive).
 *    Ex.
 *      Input : arr[] = [1, 2, 2, 4, 5, 5, 5, 8],
 *              queries[][] = [[0, 7, 5],
 *                             [1, 2, 2],
 *                             [0, 3, 7]]
 *      Output: [3, 2, 0]
 *      Explanation: Query [0, 7, 5] → elements from index 0 to 7 are [1, 2, 2, 4, 5, 5, 5, 8].
 *                   Number 5 occurs 3 times.
 *                   Query [1, 2, 2] → subarray is [2, 2], and 2 occurs 2 times.
 *                   Query [0, 3, 7] → subarray is [1, 2, 2, 4], and 7 is not present.
 *
 *  Constraints:
 *          1 ≤ arr.size(), queries.size() ≤ 10⁵
 *          1 ≤ arr[i], x ≤ 10⁶
 *          0 ≤ l ≤ r < arr.size()
 */

import java.util.ArrayList;
import java.util.Scanner;

public class Searching_Count_X_in_Range_of_a_Sorted_Array {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Array Elements: ");
        String[] s = sc.nextLine().split(" ");

        int n = s.length;
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(s[i]);
            if (i > 0 && arr[i] < arr[i - 1]) return;
        }

        System.out.println("Enter number of queries: ");
        n = sc.nextInt();

        int[][] queries = new int[n][3];

        System.out.println("Enter Queries : (l  r  x)");
        for (int i = 0; i < n; i++) {
            queries[i][0] = sc.nextInt();
            queries[i][1] = sc.nextInt();
            queries[i][2] = sc.nextInt();
        }

        System.out.println("x appears per query: ");
        System.out.println(countXInRange(arr, queries));
    }

    ///  Solution
    static ArrayList<Integer> countXInRange(int[] arr, int[][] queries) {
        ArrayList<Integer> list = new ArrayList<>();

        for(int[] q : queries) {
            int l = q[0];
            int r = q[1];
            int x = q[2];

            int upper = upperBound(arr, x);
            int lower = lowerBound(arr, x);

            int right = Math.min(upper, r);
            int left = Math.max(lower, l);

            int val = right - left + 1;
            list.add(Math.max(val, 0));
        }

        return list;
    }

    private static int upperBound(int[] arr, int x) {
        int i = 0;
        int j = arr.length - 1;
        int ans = -1;

        while(i <= j) {
            int mid = i + (j - i) / 2;

            if(arr[mid] <= x) {
                ans = mid;
                i = mid + 1;
            } else j = mid - 1;
        }

        return ans;
    }

    private static int lowerBound(int[] arr, int x) {
        int i = 0;
        int j = arr.length - 1;
        int ans = j + 1;

        while(i <= j) {
            int mid = i + (j - i) / 2;

            if(arr[mid] >= x) {
                ans = mid;
                j = mid - 1;
            } else i = mid + 1;
        }

        return ans;
    }
}
