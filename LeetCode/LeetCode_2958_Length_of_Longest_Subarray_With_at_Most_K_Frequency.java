package LeetCode;/*
 *
 * https://leetcode.com/problems/length-of-longest-subarray-with-at-most-k-frequency/
 *
 * # LC. 2958. Length of Longest Subarray With at Most K Frequency
 *
 *   Q. You are given an integer array nums and an integer k. The frequency of an element x is the number of times it
 *      occurs in an array.
 *
 *      An array is called good if the frequency of each element in this array is less than or equal to k.
 *
 *      Return the length of the longest good subarray of nums.
 *
 *      A subarray is a contiguous non-empty sequence of elements within an array.
 *
 *    Ex.
 *      Input : nums = [1, 2, 3, 1, 2, 3, 1, 2], k = 2
 *      Output: 6
 *      Explanation: The longest possible good subarray is [1,2,3,1,2,3] since the values 1, 2, and 3 occur at most
 *                   twice in this subarray. Note that the subarrays [2,3,1,2,3,1] and [3,1,2,3,1,2] are also good.
 *                   It can be shown that there are no good subarrays with length more than 6.
 *
 *  Constraints:
 *       ◦ 1 <= nums.length <= 10⁵
 *       ◦ 1 <= nums[i] <= 10⁹
 *       ◦ 1 <= k <= nums.length
 */

import java.util.HashMap;
import java.util.Scanner;

public class LeetCode_2958_Length_of_Longest_Subarray_With_at_Most_K_Frequency {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("int[] arr: ");
        String[] s = sc.nextLine().split(" ");

        int n = s.length;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(s[i]);
        }

        System.out.print("k: ");
        int k = sc.nextInt();

        System.out.println("Length of the longest good subarray: ");
        System.out.println(maxSubarrayLength(arr, k));
    }

    /// Solution
    static int maxSubarrayLength(int[] nums, int k) {
        int n = nums.length;
        HashMap<Integer, Counter> map = new HashMap<>();

        int i = 0;
        int max = 0;

        for (int j = 0; j < n; j++) {
            Counter counter = map.computeIfAbsent(nums[j], x -> new Counter());

            counter.count++;

            if (counter.count > k) {
                max = Math.max(max, j - i);
                while (counter.count > k) {
                    map.get(nums[i++]).count--;
                }
            }
        }

        max = Math.max(max, n - i);

        return max;
    }

    private static class Counter {
        int count = 0;
    }
}
