package LeetCode;/*
 *
 * https://leetcode.com/problems/number-of-sub-arrays-with-odd-sum/
 *
 * # LC. 1524. Number of Sub-arrays With Odd Sum
 *
 *   Q. Given an array of integers arr, return the number of subarrays with an odd sum.
 *      Since the answer can be very large, return it modulo 10⁹ + 7.
 *
 *    Ex.
 *      Input: arr = [1, 3, 5]
 *      Output: 4
 *      Explanation: All subarrays are [[1], [1, 3], [1, 3, 5], [3], [3, 5], [5]]
 *                   All sub-arrays sum are [1, 4, 9, 3, 8, 5].
 *                   Odd sums are [1,9,3,5] so the answer is 4.
 *
 *  Constraints:
 *        ◦ 1 <= arr.length <= 10⁵
 *        ◦ 1 <= arr[i] <= 100
 */

import java.util.Scanner;

public class LeetCode_1524_Number_of_Sub_arrays_With_Odd_Sum {

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

        System.out.println("Number of subarrays with an odd sum: ");
        System.out.println(numOfSubarrays(arr));
    }

    /// Solution
    static int numOfSubarrays(int[] arr) {
        int oddCount = 0;
        int evenCount = 1;
        boolean odd = false;
        long mod = (long) 1e9 + 7;
        long count = 0;

        for (int ele : arr) {
            odd = odd ^ (ele & 1) == 0;

            if (odd) {
                count = (count + evenCount) % mod;
                oddCount++;
            } else {
                count = (count + oddCount) % mod;
                evenCount++;
            }
        }

        return (int) count;
    }
}
