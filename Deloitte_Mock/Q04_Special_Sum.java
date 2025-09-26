package Deloitte_Mock;/*
 *
 * ## Problem Statement (medium)
 *
 *      You are given an array Arr of integers of size N. Your task is to compute a special sum defined as
 *      follows:
 *
 *      1) First, sort the array in non-decreasing order.
 *      2) Let mid be the middle index of the sorted array (i.e., mid = N / 2).
 *      3) Add all elements from index mid to the end of the array to the sum.
 *      4) Then, for each pair of elements symmetrically placed around the middle:
 *           •  If the array size is even, start with the two middle elements at indices (mid - 1) and mid.
 *           •  If the array size is odd, start with the elements at (mid - 1) and (mid + 1).
 *           •  Move outward from the center, and for each valid pair (i, j), compute the average:
 *                 avg = (Arr[i] + Arr[j]) / 2
 *                 Add this average to the sum.
 *      5) Output the final sum as an integer (use integer division for averaging).
 *
 *   Ex.
 *      Input : n = 5
 *              arr[] = 1 2 3 4 5
 *      Output: 18
 *      Explanation:
 *              The median of [1, 2, 3, 4, 5] is 3, so the sum = 3 and ‘3’ is deleted.
 *              The median of [1, 2, 4, 5] is (2 + 4) / 2, so sum = 3 + 3 and ‘2’ is deleted.
 *              The Median of [1, 4, 5] is 4, so sum = 3 + 3 + 4 and ‘4’ is deleted.
 *              The median of [1, 5] is (1 + 5) / 2, so sum = 3 + 3 + 4 + 3, and ‘1’ is deleted.
 *              The median of [5] is 5, so sum = 3 + 3 + 4 + 3 + 5, and ‘5’ is deleted.
 *              The array becomes empty, so the final sum is 18.
 *
 *  Constraints:
 *          1 <= N <= 10⁶
 *          0 <= arr[i] <= 10⁶
 */

import java.util.Arrays;
import java.util.Scanner;

public class Q04_Special_Sum {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        System.out.println(userLogic(n, arr));
    }

    /// Solution
    static int userLogic(int n, int[] arr) {
        Arrays.sort(arr);
        int sum = 0;

        for (int i = 0; i < n; i++) {
            if (i < n / 2) sum += (arr[i] + arr[n - 1 - i]) / 2;
            else sum += arr[i];
        }

        return sum;
    }
}