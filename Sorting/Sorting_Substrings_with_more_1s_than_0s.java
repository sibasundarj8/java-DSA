package Sorting;/*
 *
 * https://www.geeksforgeeks.org/problems/count-the-substring--170645/1
 *
 * # Substrings with more 1's than 0's
 *
 *   Q. Given a binary string s consists only of 0s and 1s. Calculate the number of substrings that have more 1s than 0s.
 *    Ex.
 *      Input : s = "011"
 *      Output: 4
 *      Explanation: There are 4 substring which has more 1s than 0s. i.e "011","1","11" and "1"
 *
 *  Constraints:
 *      1 < |s| <  6 * 10⁴
 */

import java.util.Scanner;

public class Sorting_Substrings_with_more_1s_than_0s {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the binary string: ");
        String s = sc.next();

        System.out.println("number of substrings that have more 1s than 0s: ");
        System.out.println(countSubstring(s));
    }

    /// Solution
    static int countSubstring(String s) {
        // potd.code.hub
        int n = s.length();
        int[] prefix = new int[n + 1];
        int[] temp = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            int cur = (s.charAt(i - 1) == '0') ? -1 : 1;
            prefix[i] = prefix[i - 1] + cur;
        }

        return (int) countInversions(0, n, prefix, temp);
    }

    private static long countInversions(int l, int r, int[] arr, int[] temp) {
        // base case
        if (l >= r) return 0;

        // recursive work
        int mid = l + (r - l) / 2;
        long left = countInversions(l, mid, arr, temp);
        long right = countInversions(mid + 1, r, arr, temp);

        // self work
        return left + right + merge(l, mid, r, arr, temp);
    }

    private static long merge(int l, int mid, int r, int[] arr, int[] temp) {
        int n = mid - l + 1;
        int m = r - mid;
        int i = 0;
        int j = 0;
        int idx = 0;
        long count = 0;

        while (i < n && j < m) {
            if (arr[l + i] < arr[mid + 1 + j]) {
                count += (m - j);
                temp[idx++] = arr[l + i++];
            } else temp[idx++] = arr[mid + 1 + j++];
        }

        while (i < n) temp[idx++] = arr[l + i++];
        while (j < m) temp[idx++] = arr[mid + 1 + j++];

        System.arraycopy(temp, 0, arr, l, n + m);

        return count;
    }
}
