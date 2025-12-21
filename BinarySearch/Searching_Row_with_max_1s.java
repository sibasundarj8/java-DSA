package BinarySearch;/*
 *
 * https://www.geeksforgeeks.org/problems/row-with-max-1s0023/1
 *
 * # Row with max 1s
 *
 *   Q. You are given a 2D binary array arr[][] consisting of only 1s and 0s. Each row of the array is sorted in non-decreasing
 *      order. Your task is to find and return the index of the first row that contains the maximum number of 1s. If no such row
 *      exists, return -1.
 *
 *      Note:   The array follows 0-based indexing.
 *              The number of rows and columns in the array are denoted by n and m respectively.
 *    Ex.
 *      Input : arr[][] = [[0,1,1,1],
 *                         [0,0,1,1],
 *                         [1,1,1,1],
 *                         [0,0,0,0]]
 *      Output: 2
 *      Explanation: Row 2 contains the most number of 1s (4 1s). Hence, the output is 2.
 *
 *  Constraints:
 *          1 ≤ arr.size(), arr[i].size() ≤ 10³
 *          0 ≤ arr[i][j] ≤ 1
 */

import java.util.Scanner;

public class Searching_Row_with_max_1s {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter dimension of matrix: ");
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[][] arr = new int[n][m];

        System.out.println("Enter matrix elements: (Must be 0 or 1 and in sorted order)");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        System.out.println("Row with most 1s : " + rowWithMax1s(arr));
    }

    /// Solution
/*
☞☞☞☞☞☞☞☞☞☞☞☞☞☞☞☞☞☞☞☞☞☞☞☞☞☞☞☞☞☞☞☞☞☞☞☞☞☞☞☞☞☞☞☞☞☞☞☞☞☞-using-BinarySearch-☜☜☜☜☜☜☜☜☜☜☜☜☜☜☜☜☜☜☜☜☜☜☜☜☜☜☜☜☜☜☜☜☜☜☜☜☜☜☜☜☜☜☜☜☜☜☜☜☜☜
TC : O(n log m)
SC : O(1)
*/
    static int usingBinarySearch(int[][] arr) {
        int n = arr.length;
        int m = arr[0].length;
        int ans = -1;
        int ones = 0;

        for(int i = 0; i < n; i++) {
            int lower = lowerBound(arr[i], 1);
            int one = m - lower;

            if(one > ones) {
                ans = i;
                ones = one;
            }
        }

        return ans;
    }

    // helper
    private static int lowerBound(int[] arr, int x) {
        int i = 0;
        int j = arr.length - 1;
        int ans = j + 1;

        while(i <= j) {
            int mid = i + (j - i) / 2;

            if(arr[mid]  >= x) {
                ans = mid;
                j = mid - 1;
            } else i = mid + 1;
        }

        return ans;
    }

/*
☞☞☞☞☞☞☞☞☞☞☞☞☞☞☞☞☞☞☞☞☞☞☞☞☞☞☞☞☞☞☞☞☞☞☞☞☞☞☞☞☞☞☞☞☞☞☞☞☞☞☞-StairCase-Search-☜☜☜☜☜☜☜☜☜☜☜☜☜☜☜☜☜☜☜☜☜☜☜☜☜☜☜☜☜☜☜☜☜☜☜☜☜☜☜☜☜☜☜☜☜☜☜☜☜☜☜
TC : O(n + m)
SC : O(1)
*/
    static int rowWithMax1s(int[][] arr) {
        // code here
        int n = arr.length;
        int m = arr[0].length;
        int ans = -1;

        int i = 0;
        int j = m - 1;

        while(i < n && j >= 0) {
            if(arr[i][j] == 1) {
                j--;
                ans = i;
            }
            else i++;
        }

        return ans;
    }
}
