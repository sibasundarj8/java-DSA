package GFG;/*
 *   Q. Given an array arr. The task is to find and return the maximum product possible
 *      with the subset of elements present in the array.
 *      Note:
 *          1) The maximum product can be a single element also.
 *          2) Since the product can be large, return it modulo 109 + 7.
 *      Example :
 *          Input: arr[] = [-1, 0, -2, 4, 3]
 *          Output: 24
 *          Explanation: Maximum product will be ( -1 * -2 * 4 * 3 ) = 24
 */

import java.util.Scanner;

public class POTD_Maximum_product_subset_of_an_array {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        System.out.println("Elements :");
        String[] s = sc.nextLine().split(" ");

        int n = s.length;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(s[i]);
        }

        System.out.println("Max product :");
        System.out.println(findMaxProduct(arr));
    }

    static int findMaxProduct(int[] arr) {
        // potd.code.hub
        int mod = (int) 1e9 + 7;
        long product = 1;
        int negCount = 0;
        int zeroCount = 0;
        int negMax = Integer.MIN_VALUE;
        int n = arr.length;

        if (1 == n) return arr[0];

        for (int ele : arr) {

            if (0 == ele) {
                zeroCount++;
                continue;
            }

            if (ele < 0) {
                negMax = Math.max(negMax, ele);
                negCount++;
            }

            product = (product * ele) % mod;
        }

        if ((negCount == 1 && zeroCount + negCount == n) || zeroCount == n) return 0;
        if (product < 0) return (int) (product / negMax);
        return (int) product;
    }
}
