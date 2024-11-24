package GFG_160;/*
 * https://www.geeksforgeeks.org/problems/maximum-product-subarray3604/1
 *
 * # Maximum Product SubArray
 *
 *   Q. Given an array arr[] that contains positive and negative integers (may contain 0 as well).
 *      Find the maximum product that we can get in a sub-array of arr.
 *
 *      Note: It is guaranteed that the output fits in a 32-bit integer.
 *    Ex.
 *      Input : arr[] = [-2, 6, -3, -10, 0, 2]
 *      Output: 180
 *      Explanation: The sub-array with maximum product is {6, -3, -10} with product = 6*(-3)*(-10) = 180.
 */

import java.util.Scanner;

public class GFG_11_Maximum_Product_SubArray {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Size: ");
        int n = sc.nextInt();

        int[]arr = new int[n];

        System.out.println("Elements: ");
        for (int i = 0;i < n;i++){
            arr[i] = sc.nextInt();
        }

        System.out.println(maxProduct(arr));
    }

    /// Solution
    static int maxProduct(int[] arr) {
        // potd.code.hub
        int n = arr.length;
        int prefix = 1;
        int suffix = 1;
        int ans = Integer.MIN_VALUE;

        for (int i = 0;i < n;i++){
            if (prefix == 0) prefix = 1;
            if (suffix == 0) suffix = 1;

            prefix *= arr[i];
            suffix *= arr[n-i-1];
            ans = Math.max(ans, Math.max(prefix, suffix));
        }

        return ans;
    }
}
