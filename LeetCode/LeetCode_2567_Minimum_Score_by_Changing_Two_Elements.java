package LeetCode;/*
 *
 * https://leetcode.com/problems/minimum-score-by-changing-two-elements/
 *
 * # LC. 2567. Minimum Score by Changing Two Elements
 *
 *   Q. You are given an integer array nums.
 *
 *        ◦ The low score of nums is the minimum absolute difference between any two integers.
 *        ◦ The high score of nums is the maximum absolute difference between any two integers.
 *        ◦ The score of nums is the sum of the high and low scores.
 *
 *      Return the minimum score after changing two elements of nums.
 *
 *    Ex.
 *      Input : nums = [1, 4, 7, 8, 5]
 *      Output: 3
 *      Explanation:
 *              Change nums[0] and nums[1] to be 6 so that nums becomes [6,6,7,8,5].
 *              The low score is the minimum absolute difference: |6 - 6| = 0.
 *              The high score is the maximum absolute difference: |8 - 5| = 3.
 *              The sum of high and low score is 3.
 *
 *  Constraints:
 *        ◦ 3 <= nums.length <= 10⁵
 *        ◦ 1 <= nums[i] <= 10⁹
 */

import java.util.Scanner;

public class LeetCode_2567_Minimum_Score_by_Changing_Two_Elements {

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

        System.out.println("Minimum score after changing two elements: ");
        System.out.println(minimizeSum(nums));
    }

    /// Solution
    static int minimizeSum(int[] nums) {
        int l, l2, l3;
        int s, s2, s3;

        l = l2 = l3 = Integer.MIN_VALUE;
        s = s2 = s3 = Integer.MAX_VALUE;

        for (int ele : nums) {

            // largest calculation
            if (ele > l) {
                l3 = l2;
                l2 = l;
                l = ele;
            } else if (ele > l2) {
                l3 = l2;
                l2 = ele;
            } else if (ele > l3) {
                l3 = ele;
            }

            // smallest calculation
            if (ele < s) {
                s3 = s2;
                s2 = s;
                s = ele;
            } else if (ele < s2) {
                s3 = s2;
                s2 = ele;
            } else if (ele < s3) {
                s3 = ele;
            }
        }

        long score1 = l - s3;
        long score2 = l3 - s;
        long score3 = l2 - s2;

        return (int) Math.min(score1, Math.min(score2, score3));
    }
}
