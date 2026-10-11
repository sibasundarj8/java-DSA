package LeetCode;/*
 *
 * https://leetcode.com/problems/sum-of-squares-of-special-elements/
 *
 * # LC. 2778. Sum of Squares of Special Elements
 *
 *   Q. You are given a 1-indexed integer array nums of length n.
 *      An element nums[i] of nums is called special if 'i' divides n, i.e. n % i == 0.
 *      Return the sum of the squares of all special elements of nums.
 *
 *    Ex.
 *      Input : nums = [1,2,3,4]
 *      Output: 21
 *      Explanation: There are exactly 3 special elements in nums: nums[1] since 1 divides 4, nums[2] since 2 divides 4,
 *                   and nums[4] since 4 divides 4.
 *
 *                   Hence, the sum of the squares of all special elements of nums is nums[1] * nums[1] +
 *                   nums[2] * nums[2] + nums[4] * nums[4] = 1 * 1 + 2 * 2 + 4 * 4 = 21.
 *
 *  Constraints:
 *        ◦ 1 <= nums.length == n <= 50
 *        ◦ 1 <= nums[i] <= 50
 */

import java.util.Scanner;

public class LeetCode_2778_Sum_of_Squares_of_Special_Elements {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("nums[] : ");
        String[] s = sc.nextLine().split(" ");

        int n = s.length;
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(s[i]);
        }

        System.out.println("Sum of the squares of all special elements: ");
        System.out.println(sumOfSquares(nums));
    }

    /// Solution
    static int sumOfSquares(int[] nums) {
        int n = nums.length;
        int res = 0;

        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                int idx1 = i - 1;
                int idx2 = n / i - 1;
                res += nums[idx1] * nums[idx1];

                if (idx1 != idx2) {
                    res += nums[idx2] * nums[idx2];
                }
            }
        }

        return res;
    }
}
