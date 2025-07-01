package PrefixSum;

import java.util.Scanner;/*
 *
 * https://www.geeksforgeeks.org/problems/max-min-height--170647/1
 *
 * # Max min Height
 *
 *   Q. Given a garden with n flowers planted in a row, that is represented by an array arr[], where arr[i] denotes
 *      the height of the ith flower.You will water them for k days. In one day you can water w continuous flowers.
 *      Whenever you water a flower its height increases by 1 unit. You have to maximize the minimum height of all
 *      flowers after  k days of watering.
 *   Ex.
 *      Input : arr[] = [2, 3, 4, 5, 1]
 *              k = 2
 *              w = 2
 *      Output: 2
 *      Explanation: The minimum height after watering is 2.
 *            Day 1: Water the last two flowers -> arr becomes [2, 3, 4, 6, 2]
 *            Day 2: Water the last two flowers -> arr becomes [2, 3, 4, 7, 3]
 */
public class Q02_Max_min_Height {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter array elements: ");
        String[] s = sc.nextLine().split(" ");

        int n = s.length;
        int[] arr = new int[n];

        for (int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(s[i]);

        System.out.println("Number of days (k) : ");
        int k = sc.nextInt();

        System.out.println("window size (w) : ");
        int w = sc.nextInt();

        System.out.println("Min height : " + maxMinHeight(arr, k, w));
    }

    /// Solution
    static int maxMinHeight(int[] arr, int k, int w) { // hard
        // potd.code.hub
        int i = Integer.MAX_VALUE, j;
        int ans = 0;
        for (int val : arr) i = Math.min(i, val);
        j = i + k;

        while (i <= j) { // O(log n)
            int mid = i + (j-i)/2;
            int actual = calculate(arr, mid, w);
            if (actual <= k) {
                ans = mid;
                i = mid+1;
            }
            else j = mid-1;
        }

        return ans;
    }
    private static int calculate (int[] arr, int avgHeight, int window) {
        int n = arr.length;
        int days = 0;
        int[] prefix = new int[n];

        for (int i = 0; i < n; i++) { // O(n)
            prefix[i] += (i > 0) ? prefix[i-1] : 0;

            int currHeight = arr[i] + prefix[i];

            if (currHeight < avgHeight) {
                int requiredHeight = avgHeight - currHeight;

                prefix[i] += requiredHeight;
                if (i + window < n) prefix[i+window] -= requiredHeight;

                days += requiredHeight;
            }
        }

        return days;
    }
}
