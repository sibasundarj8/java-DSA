package LeetCode;/*
 *
 * https://leetcode.com/problems/smallest-missing-integer-greater-than-sequential-prefix-sum/
 *
 * # LC. 2996. Smallest Missing Integer Greater Than Sequential Prefix Sum
 *
 *   Q. You are given a 0-indexed array of integers nums.
 *
 *      A prefix nums[0..i] is sequential if, for all 1 <= j <= i, nums[j] = nums[j - 1] + 1. In particular, the prefix
 *      consisting only of nums[0] is sequential.
 *
 *      Return the smallest integer x missing from nums such that x is greater than or equal to the sum of the longest
 *      sequential prefix.
 *
 *    Ex.
 *      Input : nums = [3, 4, 5, 1, 12, 14, 13]
 *      Output: 15
 *      Explanation: The longest sequential prefix of nums is [3,4,5] with a sum of 12. 12, 13, and 14 belong to the
 *                   array while 15 does not. Therefore, 15 is the smallest missing integer greater than or equal to
 *                   the sum of the longest sequential prefix.
 *
 *  Constraints:
 *        ◦ 1 <= nums.length <= 50
 *        ◦ 1 <= nums[i] <= 50
 */

import java.util.Scanner;

public class LeetCode_2996_Smallest_Missing_Integer_Greater_Than_Sequential_Prefix_Sum {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("int[] nums: ");
        String[] s = sc.nextLine().split(" ");

        int n = s.length;
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(s[i]);
        }

        System.out.print("""
                Smallest integer x missing from nums such that x is greater than or equal to
                the sum of the longest sequential prefix:
                """);
        System.out.println(missingInteger(nums));
    }

    /// Solution
    static int missingInteger(int[] nums) {
        int n = nums.length;
        boolean[] seen = new boolean[51];

        seen[nums[0]] = true;
        int sum = nums[0];
        boolean flag = false;

        for (int i = 1; i < n; i++) {
            if (!flag) {
                if (nums[i - 1] + 1 == nums[i]) sum += nums[i];
                else flag = true;
            }

            seen[nums[i]] = true;
        }

        while (sum <= 50 && seen[sum]) {
            sum++;
        }

        return sum;
    }
}
