package Hashing;/*
 *
 * https://www.geeksforgeeks.org/problems/count-pairs-in-array-divisible-by-k/1
 *
 * # Count Pairs Divisible By K
 *
 *   Q. Given an array arr[] and positive integer k, count total number of pairs in the array whose sum is divisible by k.
 *    Ex.
 *      Input : arr[] = [5, 9, 36, 74, 52, 31, 42], k = 3
 *      Output: 7
 *      Explanation:
 *              There are seven pairs whose sum is divisible by 3, i.e, (9, 36), (9,42), (74, 52), (36, 42), (74, 31),
 *              (31, 5) and (5, 52).
 *
 *  Constraints:
 *      1 ≤ |arr| ≤ 5 * 10⁴
 *      1 ≤ arr[i] ≤ 10⁶
 *      1 ≤ k ≤ 5 * 10⁴
 */

import java.util.Scanner;

public class Count_Pairs_Divisible_By_K {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter array elements: ");
        String[] s = sc.nextLine().split(" ");

        int n = s.length;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(s[i]);
        }

        System.out.println("Enter k: ");
        int k = sc.nextInt();

        System.out.println("Number of pairs in the array whose sum is divisible by k: ");
        System.out.println(countKdivPairs(arr, k));
    }

    /// Solution
    static int countKdivPairs(int[] arr, int k) {
        // potd.code.hub
        int[] freqMap = new int[k];

        for (int ele : arr) {
            int mod = ele % k;
            freqMap[mod]++;
        }

        long count = 0;

        for (int i = 0; i * 2 <= k; i++) {
            if (i == 0 || i * 2 == k)
                count += ((long) freqMap[i] * (freqMap[i] - 1)) >> 1;
            else count += (long) freqMap[i] * freqMap[k - i];
        }

        return (int) count;
    }
}
