package LeetCode;/*
 *
 * https://leetcode.com/problems/find-the-largest-almost-missing-integer/
 *
 * # LC. 3471. Find the Largest Almost Missing Integer
 *
 *   Q. You are given an integer array nums and an integer k. An integer x is almost missing from nums if x appears in
 *      exactly one subarray of size k within nums.
 *
 *      Return the largest almost missing integer from nums. If no such integer exists, return -1.
 *
 *      A subarray is a contiguous sequence of elements within an array.
 *
 *    Ex.
 *      Input : nums = [3, 9, 2, 1, 7], k = 3
 *      Output: 7
 *      Explanation:
 *              1 appears in 2 subarrays of size 3: [9, 2, 1] and [2, 1, 7].
 *              2 appears in 3 subarrays of size 3: [3, 9, 2], [9, 2, 1], [2, 1, 7].
 *              3 appears in 1 subarray of size 3: [3, 9, 2].
 *              7 appears in 1 subarray of size 3: [2, 1, 7].
 *              9 appears in 2 subarrays of size 3: [3, 9, 2], and [9, 2, 1].
 *              We return 7 since it is the largest integer that appears in exactly one subarray of size k.
 *
 *  Constraints:
 *        ◦ 1 <= nums.length <= 50
 *        ◦ 0 <= nums[i] <= 50
 *        ◦ 1 <= k <= nums.length
 */

import java.util.Scanner;

public class LeetCode_3471_Find_the_Largest_Almost_Missing_Integer {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("nums[]: ");
        String[] s = sc.nextLine().split(" ");

        int n = s.length;
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(s[i]);
        }

        System.out.print("k: ");
        int k = sc.nextInt();

        System.out.println("Largest almost missing integer for k sized sub-arrays: ");
        System.out.println(largestInteger(nums, k));
    }

    /// Solution
    static int largestInteger(int[] nums, int k) {
        int n = nums.length;
        int[] frq = new int[51];

        for (int ele : nums) {
            frq[ele]++;
        }

        int l = -1;
        int lf = -1;

        for (int i = 50; i >= 0; i--) {
            if (l == -1 && frq[i] != 0) l = i;
            if (lf == -1 && frq[i] == 1) lf = i;
            if (lf != -1 && l != -1) break;
        }

        if (k == n) return l;
        if (k == 1) return lf;

        if (frq[nums[0]] == 1 && frq[nums[n - 1]] == 1) return Math.max(nums[0], nums[n - 1]);
        if (frq[nums[0]] == 1) return nums[0];
        if (frq[nums[n - 1]] == 1) return nums[n - 1];

        return -1;
    }
}
