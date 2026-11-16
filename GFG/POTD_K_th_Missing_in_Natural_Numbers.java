package GFG;/*
 *
 * https://www.geeksforgeeks.org/problems/k-th-missing-element-in-natural-numbers/1
 *
 * # K-th Missing in Natural Numbers
 *
 *   Q. Given an array arr[] of distinct positive integers and a positive integer k. Consider an infinite sequence of
 *      natural numbers starting from 1. The task is to remove all elements present in arr[] from this sequence.
 *
 *      Find the k-th smallest number in the remaining sequence.
 *
 *      Note: Your solution must run in O(1) auxiliary space.
 *
 *    Ex.
 *      Input : arr[] = [1, 9, 5, 2], k = 6
 *      Output: 10
 *      Explanation: After removing [1, 2, 5, 9] from the natural numbers, the remaining sequence is: 3, 4, 6, 7, 8,
 *                   10, 11, .... and so on. The 6th number in this sequence is 10, so the answer is 10.
 *
 *  Constraints:
 *        ◦ 1 ≤ arr.size() ≤ 10⁵
 *        ◦ 1 ≤ arr[i], k ≤ 10⁶
 *        ◦ All elements of arr are distinct.
 */

import java.util.Arrays;
import java.util.Scanner;

public class POTD_K_th_Missing_in_Natural_Numbers {

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

        System.out.println("k-th smallest number in the remaining sequence: ");
        System.out.println(findKthSmall(arr, k));
    }

    /// Solution
    static int findKthSmall(int[] arr, int k) {
        // potd.code.hub
        int prev = 0;
        Arrays.sort(arr);

        for (int curr : arr) {
            int diff = curr - prev - 1;

            if (diff >= k) break;
            else k -= diff;

            prev = curr;
        }

        return prev + k;
    }
}
