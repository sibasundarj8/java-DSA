package Array;/*
 *
 * https://www.geeksforgeeks.org/problems/sum-of-subarrays2229/1
 *
 * # Sum of Subarrays
 *
 *   Q. Given an array arr[], find the sum of all the subarrays of the given array.
 *
 *      Note: It is guaranteed that the total sum will fit within a 32-bit integer range.
 *    Ex.
 *      Input : arr[] = [1, 2, 3]
 *      Output: 20
 *      Explanation: All subarray sums are: [1] = 1,
 *                   [2] = 2,
 *                   [3] = 3,
 *                   [1, 2] = 3,
 *                   [2, 3] = 5,
 *                   [1, 2, 3] = 6.
 *                  Thus total sum is 1 + 2 + 3 + 3 + 5 + 6 = 20.
 */

import java.util.Scanner;

public class Array_Sum_of_Subarrays {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Elements: ");
        String[] s = sc.nextLine().split(" ");

        int n = s.length;
        int[] arr = new int[n];

        for (int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(s[i]);

        System.out.println("Total subarrays sum: " + subarraySum(arr));
    }

    /// Solution
    static int subarraySum(int[] arr) {
        // potd.code.hub
        int n = arr.length;
        int ans = 0;

        for (int i = 1; i <= n; i++)
            ans += (i * (n - i + 1)) * arr[i - 1];

        return ans;
    }
}
