package LeetCode;/*
 *
 * https://leetcode.com/problems/smallest-missing-multiple-of-k/
 *
 * # LC. 3718. Smallest Missing Multiple of K
 *
 *   Q. Given an integer array nums and an integer k, return the smallest positive multiple of k that is missing from
 *      nums. A multiple of k is any positive integer divisible by k.
 *
 *    Ex.
 *      Input: nums = [8, 2, 3, 4, 6], k = 2
 *      Output: 10
 *      Explanation:
 *              The multiples of k = 2 are 2, 4, 6, 8, 10, 12... and the smallest multiple missing from nums is 10.
 *
 *  Constraints:
 *        ◦ 1 <= nums.length <= 100
 *        ◦ 1 <= nums[i] <= 100
 */

import java.util.Scanner;

public class LeetCode_3718_Smallest_Missing_Multiple_of_K {

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

        System.out.println("smallest missing positive multiple of k: ");
        System.out.println(missingMultiple(nums, k));
    }

    /// Solution
    static int missingMultiple(int[] nums, int k) {
        int n = nums.length;
        boolean[] seen = new boolean[n];

        for (int ele : nums) {
            boolean isMultiple = ele % k == 0;

            if (isMultiple) {
                int idx = (ele / k) - 1;
                if (idx < n) seen[idx] = true;
            }
        }

        for (int i = 0; i < n; i++) {
            if (!seen[i]) {
                return k * (i + 1);
            }
        }

        return k * (n + 1);
    }
}
