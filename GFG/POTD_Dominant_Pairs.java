package GFG;/*
 *
 * https://www.geeksforgeeks.org/problems/dominant-pairs/1
 *
 * # Dominant Pairs
 *
 *   Q. Given an even-sized integer array arr[], count the number of dominant pairs. A pair of indices (i, j) is called
 *      dominant if all the following conditions hold:
 *
 *    Ex.
 *      Input : arr[] = [10, 2, 2, 1]
 *      Output: 2
 *      Explanation: First half: [10, 2], Second half: [2, 1]. So valid two pairs are:
 *                      {0, 2}: 10 >= 5 × 2
 *                      {0, 3}: 10 >= 5 × 1
 *
 *  Constraints:
 *        ◦ 1 ≤ arr.size() ≤ 10⁴
 *        ◦ -10⁴ ≤ arr[i] ≤ 10⁴
 *        ◦ arr.size() is even.
 *        ◦ The sum of arr.size() over all test cases won't exceed 10⁶.
 */

import java.util.Arrays;
import java.util.Scanner;

public class POTD_Dominant_Pairs {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("arr[] : ");
        String[] s = sc.nextLine().split(" ");

        int n = s.length;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(s[i]);
        }

        System.out.print("number of dominant pairs: ");
        System.out.println(dominantPairs(arr));
    }

    /// Solution
    static int dominantPairs(int[] arr) {
        // potd.code.hub
        int n = arr.length;
        int half = n >> 1;

        Arrays.sort(arr, 0, half);
        Arrays.sort(arr, half, n);

        int count = 0;
        int i = 0;
        int j = half;

        while (i < half && j < n) {
            if (arr[i] >= arr[j] * 5) {
                count += (half - i);
                j++;
            } else i++;
        }

        return count;
    }
}
