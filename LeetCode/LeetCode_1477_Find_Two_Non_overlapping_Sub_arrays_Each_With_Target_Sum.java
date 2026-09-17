package LeetCode;/*
 *
 * https://leetcode.com/problems/find-two-non-overlapping-sub-arrays-each-with-target-sum/
 *
 * # LC. 1477. Find Two Non-overlapping Sub-arrays Each With Target Sum
 *
 *   Q. You are given an array of integers arr and an integer target.
 *
 *      You have to find two non-overlapping sub-arrays of arr each with a sum equal target. There can be multiple
 *      answers so you have to find an answer where the sum of the lengths of the two sub-arrays is minimum.
 *
 *      Return the minimum sum of the lengths of the two required sub-arrays, or return -1 if you cannot find such two
 *      sub-arrays.
 *
 *    Ex.
 *      Input : arr = [3, 2, 2, 4, 3],
 *              target = 3
 *      Output: 2
 *      Explanation: Only two sub-arrays have sum = 3 ([3] and [3]).
 *                   The sum of their lengths is 2.
 *
 *  Constraints:
 *        ◦ 1 <= arr.length <= 10⁵
 *        ◦ 1 <= arr[i] <= 1000
 *        ◦ 1 <= target <= 10⁸
 */

import java.util.Arrays;
import java.util.Scanner;

public class LeetCode_1477_Find_Two_Non_overlapping_Sub_arrays_Each_With_Target_Sum {

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

        System.out.print("k: ");
        int k = sc.nextInt();

        System.out.println("Minimum sum of the lengths of the two non-overlapping sub-arrays with sum " + k + " : ");
        System.out.println(minSumOfLengths(arr, k));
    }

    /// Solution
    static int minSumOfLengths(int[] arr, int target) {
        int n = arr.length;
        int MAX = (Integer.MAX_VALUE >> 1);
        int[] pre = new int[n + 1]; // min sub-array length with target-sum till now.

        Arrays.fill(pre, MAX);

        int l = 0;
        int sum = 0;
        int res = MAX;
        int minSoFar = MAX;
        int len;

        for (int r = 0; r < n; r++) {
            sum += arr[r];

            while (sum > target) {
                sum -= arr[l++];
            }

            if (sum == target) {
                len = r - l + 1;
                res = Math.min(res, pre[l] + len);
                minSoFar = Math.min(minSoFar, len);
            }

            pre[r + 1] = minSoFar;
        }

        return (res == MAX) ? -1 : res;
    }
}
