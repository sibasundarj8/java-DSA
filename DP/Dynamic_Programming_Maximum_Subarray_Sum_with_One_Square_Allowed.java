package DP;/*
 *
 * https://www.geeksforgeeks.org/problems/maximum-sum-subarray--143510/1
 *
 * # Maximum Subarray Sum with One Square Allowed
 *
 *   Q. Given an integer array arr[], find the maximum subarray sum by squaring at most one element.
 *
 *    Ex.
 *      Input: arr[] =  [-1, -2, 3, -2, 3]
 *      Output: 10
 *      Explanation: The subarray {3, -2, 3} with squaring -2 will give the maximum sum as 3 + 4 + 3 = 10.
 *
 *  Constraints:
 *        ◦ 1 ≤ arr.size() ≤ 10⁵
 *        ◦ -10³ ≤ arr[i] ≤ 10³
 */

import java.util.Scanner;

public class Dynamic_Programming_Maximum_Subarray_Sum_with_One_Square_Allowed {

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

        System.out.println("maximum subarray sum by squaring at most one element : ");
        System.out.println(maximumSubarray(arr));
    }

    /// Solution
    static int maximumSubarray(int[] arr) {
        // potd.code.hub
        int noSq = 0;
        int withSq = 0;
        int max = Integer.MIN_VALUE;

        for (int ele : arr) {
            withSq = Math.max(noSq + ele * ele, withSq + ele);
            noSq += ele;

            if (noSq < 0) noSq = 0;
            if (withSq < 0) withSq = 0;

            max = Math.max(max, withSq);
        }

        return max;
    }
}
