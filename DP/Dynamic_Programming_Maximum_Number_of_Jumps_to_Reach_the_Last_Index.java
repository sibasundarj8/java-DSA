package DP;/*
 *
 * https://leetcode.com/problems/maximum-number-of-jumps-to-reach-the-last-index/
 *
 * # 2770. Maximum Number of Jumps to Reach the Last Index
 *
 *   Q. You are given a 0-indexed array nums of n integers and an integer target.
 *
 *      You are initially positioned at index 0. In one step, you can jump from index i to any index j such that:
 *        ◦ 0 <= i < j < n
 *        ◦ -target <= nums[j] - nums[i] <= target
 *        ◦ Return the maximum number of jumps you can make to reach index n - 1.
 *
 *      If there is no way to reach index n - 1, return -1.
 *
 *    Ex.
 *      Input: nums = [1,3,6,4,1,2], target = 2
 *      Output: 3
 *      Explanation: To go from index 0 to index n - 1 with the maximum number of jumps, you can perform the following
 *                   jumping sequence:
 *                     - Jump from index 0 to index 1.
 *                     - Jump from index 1 to index 3.
 *                     - Jump from index 3 to index 5.
 *
 *                  It can be proven that there is no other jumping sequence that goes from 0 to n - 1 with more than 3
 *                  jumps. Hence, the answer is 3.
 *
 *  Constraints:
 *          2 <= nums.length == n <= 1000
 *          -10⁹ <= nums[i] <= 10⁹
 *          0 <= target <= 2 * 10⁹
 */

import java.util.Arrays;
import java.util.Scanner;

public class Dynamic_Programming_Maximum_Number_of_Jumps_to_Reach_the_Last_Index {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Array elements: ");
        String[] s = sc.nextLine().split(" ");

        int n = s.length;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(s[i]);
        }

        System.out.print("K : ");
        int k = sc.nextInt();

        System.out.println("Maximum jump to reach last from first:");
        System.out.println(maximumJumps(arr, k));
    }

    /// Solution
    static int maximumJumps(int[] nums, int target) {
        // potd.code.hub
        int n = nums.length;
        int[] dp = new int[n];

        Arrays.fill(dp, -1);
        dp[n - 1] = 0;

        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                if (Math.abs(nums[j] - nums[i]) <= target && dp[j] != -1) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        return dp[0];
    }
}
