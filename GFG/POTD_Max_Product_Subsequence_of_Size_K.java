package GFG;/*
 *
 * https://www.geeksforgeeks.org/problems/maximum-product4633/1
 *
 * # Max Product Subsequence of Size K
 *
 *   Q. Given an array arr[] of integers and an integer k, find a subsequence of size k whose product is maximum among
 *      all possible subsequences of size k. Return the maximum product that can be obtained.
 *
 *    Ex.
 *      Input : arr[] = [1, 2, -1, -3, -6, 4], k = 4
 *      Output: 144
 *      Explanation: Subsequence containing {2, -3, -6, 4} gives maximum product: 2*(-3)*(-6)*4 = 144
 *
 *  Constraints:
 *        ◦ arr.size() ≤ 30
 *        ◦ -10 ≤ arr[i] ≤ 10
 *        ◦ 1 ≤ k ≤ arr.size()
 */

import java.util.Arrays;
import java.util.Scanner;

public class POTD_Max_Product_Subsequence_of_Size_K {

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

        System.out.print("k: ");
        int k = sc.nextInt();

        System.out.println("Maximum product of a k sized sub-sequence: ");
        System.out.println(maxProduct(arr, k));
    }

    /// Solution
    static int maxProduct(int[] arr, int k) {
        // potd.code.hub
        Arrays.sort(arr);

        int n = arr.length;
        long product = 1;

        if (n == k || (arr[n - 1] < 0 && (k & 1) == 1)) {
            for (int i = 0; i < k; i++) {
                product *= arr[n - 1 - i];
            }

            return (int) product;
        }

        int l = 0;
        int r = n - 1;
        long left, right;

        if ((k & 1) == 1) {
            product *= arr[r--];
        }

        while (k > 0) {
            left = (long) arr[l] * arr[l + 1];
            right = (long) arr[r - 1] * arr[r];

            if (left > right) {
                product *= left;
                l += 2;
            } else {
                product *= right;
                r -= 2;
            }

            k -= 2;
        }

        return (int) product;
    }
}
