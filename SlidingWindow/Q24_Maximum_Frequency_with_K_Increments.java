package SlidingWindow;/* 
 *
 * https://www.geeksforgeeks.org/problems/maximum-frequency-1662528911/1
 *
 * # Maximum Frequency with K Increments
 *
 *   Q. Given an integer array arr[]. In one operation, you can choose an index and increment its value by 1.
 *      Find the maximum possible frequency of any element after performing at most k operations.
 *
 *    Ex.
 *      Input : arr[] = [2, 2, 4], k = 4
 *      Output: 3
 *      Explanation: Apply two increment operations on index 0 and two operations on index 1 to make arr[]= [4, 4, 4].
 *                   Frequency of 4 is 3.
 *
 *  Constraints:
 *        ◦ 1 ≤ arr.size() ≤ 10⁵
 *        ◦ 1 ≤ arr[i] ≤ 10⁶
 *        ◦ 0 ≤ k ≤ 10⁵
 */

import java.util.Arrays;
import java.util.Scanner;

public class Q24_Maximum_Frequency_with_K_Increments {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("arr[]: ");
        String[] s = sc.nextLine().split(" ");

        int n = s.length;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(s[i]);
        }

        System.out.print("k: ");
        int k = sc.nextInt();

        System.out.println("Maximum frequency possible after performing at most k operations: ");
        System.out.println(maxFrequency(arr, k));
    }

    /// Solution
    static int maxFrequency(int[] arr, int k) {
        // potd.code.hub
        Arrays.sort(arr);

        int n = arr.length;
        int maxLen = 0;
        long sum = 0;
        int l = 0;

        for (int r = 0; r < n; r++) {
            sum += arr[r];

            while ((r - l + 1L) * arr[r] - sum > k) {
                sum -= arr[l++];
            }

            maxLen = Math.max(maxLen, r - l + 1);
        }

        return maxLen;
    }
}
