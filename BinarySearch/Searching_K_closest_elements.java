package Binary_Search;/*
 *
 * https://www.geeksforgeeks.org/problems/k-closest-elements3619/1
 *
 * # K closest elements
 *
 *   Q. You are given a sorted array arr[] of unique integers, an integer k, and a target value x. Return exactly
 *      k elements from the array closest to x, excluding x if it exists.
 *
 *      An element 'a' is closer to 'x' than 'b' if:
 *            ▸  |a - x| < |b - x|, or
 *            ▸  |a - x| == |b - x| and a > b (i.e., prefer the larger element if tied)
 *
 *      Return the k closest elements in order of closeness.
 *   Ex.
 *      Input : arr[] = [12, 16, 22, 30, 35, 39, 42, 45, 48, 50, 53, 55, 56]
 *              k = 4
 *              x = 35
 *      Output: 39 30 42 45
 *      Explanation: First-closest element to 35 is 39.
 *                   Second-closest element to 35 is 30.
 *                   Third-closest element to 35 is 42.
 *                   And fourth-closest element to 35 is 45.
 */

import java.util.Scanner;

public class Searching_K_closest_elements {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Array Elements: ");
        String[] s = sc.nextLine().split(" ");

        int n = s.length;
        int[] arr = new int[n];

        for (int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(s[i]);

        System.out.println("Target: ");
        int x = sc.nextInt();

        System.out.println("K: ");
        int k = sc.nextInt();

        if (k > n) {
            System.out.println("k must be smaller or equals with n");
            return;
        }

        int[] ans = printKClosest(arr, k, x);

        for (int i : ans) System.out.print(i + " ");
        System.out.println();
    }

    /// Solution
    static int[] printKClosest(int[] arr, int k, int x) {
        // potd.code.hub
        int n = arr.length;
        int[] ans = new int[k];

        int find = binarySearch(arr, x);
        int l = find - 1;
        int r = find;
        int max = Integer.MAX_VALUE;

        if (arr[r] == x) {
            r++;
        }

        int z = 0;

        while (k > 0) { // two pointer to find closest k elements
            int dl = (l >= 0) ? x - arr[l] : max;
            int dr = (r < n) ? arr[r] - x : max;

            if (dl >= dr) {
                ans[z++] = arr[r];
                r++;
            } else {
                ans[z++] = arr[l];
                l--;
            }

            k--;
        }

        return ans;
    }

    private static int binarySearch(int[] arr, int x) {
        int n = arr.length;
        int i = 0, j = n - 1;
        int ans = n - 1;

        while (i <= j) { // binary search to find lower bound of target
            int mid = i + (j - i) / 2;
            if (arr[mid] >= x) {
                j = mid - 1;
                ans = mid;
            } else i = mid + 1;
        }

        return ans;
    }
}
