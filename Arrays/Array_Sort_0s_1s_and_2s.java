package Array;/*
 *
 * https://www.geeksforgeeks.org/problems/sort-an-array-of-0s-1s-and-2s4231/1
 *
 * # Sort 0s, 1s and 2s
 *
 *   Q. Given an array arr[] containing only 0s, 1s, and 2s. Sort the array in ascending order.
 *      Note: You need to solve this problem without utilizing the built-in sort function.
 *    Ex.
 *      Input : arr[] = [0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1]
 *      Output: [0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2]
 *      Explanation: 0s, 1s and 2s are segregated into ascending order.
 *
 *  Constraints:
 *          1 ≤ arr.size() ≤ 10⁶
 *          0 ≤ arr[i] ≤ 2
 */

import java.util.Arrays;
import java.util.Scanner;

public class Array_Sort_0s_1s_and_2s {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter array elements: ");
        String[] s = sc.nextLine().split(" ");

        int n = s.length;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(s[i]);

        sort012(arr);

        System.out.println("Sorted array elements: ");
        System.out.println(Arrays.toString(arr));
    }

    /// Solution
    static void sort012(int[] arr) {
        int zero = 0, one = 0, n = arr.length;

        for (int i : arr) {
            if (i == 0) zero++;
            else if (i == 1) one++;
        }

        for (int i = 0; i < n; i++) {
            if (zero-- > 0) arr[i] = 0;
            else if (one-- > 0) arr[i] = 1;
            else arr[i] = 2;
        }
    }
}
