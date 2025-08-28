package Sliding_Window;/*
 *
 * https://www.geeksforgeeks.org/problems/maximize-number-of-1s0905/1
 *
 * # Maximize Number of 1's
 *
 *   Q. Given a binary array arr[] (containing only 0s and 1s) and an integer k, you are allowed to
 *      flip at most k 0s to 1s. Find the maximum number of consecutive 1's that can be obtained in
 *      the array after performing the operation at most k times.
 *    Ex.
 *      Input : arr[] = [1, 0, 0, 1, 0, 1, 0, 1]
 *              k = 2
 *      Output: 5
 *      Explanation: By flipping the zeroes at indices 4 and 6, we get the longest sub-array from
 *                   index 3 to 7 containing all 1’s.
 */

import java.util.Scanner;

public class Q13_Maximize_Number_of_1s {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Size: ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        System.out.println("Elements: ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println("k: ");
        int k = sc.nextInt();
        System.out.println(maxOnes(arr, k));
    }

    /// Solution
    static int maxOnes(int[] arr, int k) {
        // potd.code.hub
        int n = arr.length;
        int ans = 0;

        int count = 0;
        int i = 0, j = 0;
        while (j < n) {
            if (arr[j] == 0) count++;
            if (count > k) {
                if (arr[i] == 0) count--;
                i++;
            }
            j++;
            ans = Math.max(ans, j - i);
        }

        return ans;
    }
}
