package DP;/*
 *
 * https://www.geeksforgeeks.org/problems/maximum-product-subarray3604/1
 *
 * # Maximum Product Subarray
 *
 *   Q. Given an array arr[] that contains positive and negative integers (may contain 0 as well). Find the maximum product
 *      that we can get in a subarray of arr[].
 *
 *      Note: It is guaranteed that the answer fits in a 32-bit integer.
 *
 *    Ex:
 *      Input : arr[] = [-2, 6, -3, -10, 0, 2]
 *      Output: 180
 *      Explanation: The subarray with maximum product is [6, -3, -10] with product = 6 * (-3) * (-10) = 180.
 *
 *  Constraints:
 *          1 ≤ arr.size() ≤ 10⁶
 *          -10  ≤  arr[i]  ≤  10
 */

import java.util.Scanner;

public class Dynamic_Programming_Maximum_Product_Subarray {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Array Elements: ");
        String[] s = sc.nextLine().split(" ");

        int n = s.length;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(s[i]);
        }

        System.out.println("Product of Maximum product sub-array elements: \n" + maxProduct(arr));
    }

    /// Solution
    static int maxProduct(int[] arr) {
        // potd.code.hub
        int n = arr.length;
        int left = 1;
        int right = 1;
        int maxLeft = Integer.MIN_VALUE;
        int maxRight = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            left *= arr[i];
            right *= arr[n - 1 - i];

            maxLeft = Math.max(maxLeft, left);
            maxRight = Math.max(maxRight, right);

            if (left == 0) left = 1;
            if (right == 0) right = 1;
        }

        return Math.max(maxLeft, maxRight);
    }
}
