package GFG;/*
 *
 * https://www.geeksforgeeks.org/problems/max-and-min-products3347/1
 *
 * # Min Product Subset
 *
 *   Q. Given an integer array arr[], find the minimum possible product that can be obtained by multiplying the elements
 *      of any non-empty subset of the array.
 *
 *    Ex.
 *      Input : arr[] = [4, -2, 5]
 *      Output: -40
 *      Explanation: The minimum product is -40, obtained by selecting the subset [4, -2, 5].
 *
 *  Constraints:
 *        ◦ 1 ≤ arr.size() ≤ 10
 *        ◦ -10 ≤ arr[i] ≤ 10
 */

import java.util.Scanner;

public class POTD_Min_Product_Subset {

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

        System.out.println("Minimum possible product: ");
        System.out.println(minProd(arr));
    }

    /// Solution
    static int minProd(int[] arr) {
        // potd.code.hub
        int ng = Integer.MIN_VALUE;
        int ps = Integer.MAX_VALUE;
        long prod = 1;

        for (int ele : arr) {
            if (ele < 0) ng = Math.max(ng, ele);
            if (ele >= 0) ps = Math.min(ps, ele);
            if (ele != 0) prod *= ele;
        }

        if (prod < 0) return (int) prod;
        if (ng != Integer.MIN_VALUE) return (int) prod / ng;
        return ps;
    }
}
