package Sorting;/*
 *
 * https://www.geeksforgeeks.org/problems/count-reverse-pairs/1
 *
 * # Count Reverse Pairs
 *
 *   Q. You are given an array arr[] of positive integers, find the count of reverse pairs. A pair of indices
 *      (i, j) is said to be a reverse pair if both the following conditions are met:
 *
 *          • 0 ≤ i < j < arr.size()
 *          • arr[i] > 2 * arr[j]
 *    Ex.
 *      Input : arr[] = [3, 2, 4, 5, 1, 20]
 *      Output: 3
 *      Explanation: The Reverse pairs are
 *                   (0, 4), arr[0] = 3, arr[4] = 1, 3 > 2*1
 *                   (2, 4), arr[2] = 4, arr[4] = 1, 4 > 2*1
 *                   (3, 4), arr[3] = 5, arr[4] = 1, 5 > 2*1
 *    Constraints:
 *                1 ≤ arr.size() ≤ 5*104
 *                1 ≤ arr[i] ≤ 109
 */

import java.util.Scanner;

public class Sorting_Count_Reverse_Pairs {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter elements: ");
        String[] s = sc.nextLine().split(" ");

        int n = s.length;
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(s[i]);
        }

        System.out.println("Number of Reversed pairs: " + countRevPairs(arr));
    }

    /// Solution
    static int countRevPairs(int[] arr) {
        // potd.code.hub
        int[] count = {0};
        mergeSort(0, arr.length - 1, arr, count);

        return count[0];
    }

    private static void mergeSort(int l, int r, int[] arr, int[] count) {
        // base case
        if (l >= r) return;

        // recursive work
        int mid = l + (r - l) / 2;
        mergeSort(l, mid, arr, count);
        mergeSort(mid + 1, r, arr, count);

        // self work
        merge(l, mid, r, arr, count);
    }

    private static void merge(int l, int mid, int r, int[] arr, int[] count) {
        int n = mid - l + 1;
        int m = r - mid;

        int[] left = new int[n];
        int[] right = new int[m];

        for (int i = l; i <= r; i++) {
            if (i <= mid) left[i - l] = arr[i];
            else right[i - mid - 1] = arr[i];
        }

        // counting reverse pairs before pairing
        int i = 0, j = 0;

        for (; j < m; j++) {
            while (i < n && left[i] <= 2 * right[j]) i++;
            count[0] += n - i;
        }

        // merging
        i = j = 0;
        int idx = l;

        while (i < n && j < m) {
            if (left[i] <= right[j]) arr[idx] = left[i++];
            else arr[idx] = right[j++];
            idx++;
        }

        while (i < n) arr[idx++] = left[i++];
        while (j < m) arr[idx++] = right[j++];
    }
}
