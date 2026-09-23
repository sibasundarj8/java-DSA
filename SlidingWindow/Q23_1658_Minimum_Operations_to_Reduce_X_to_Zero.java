package SlidingWindow;/*
 *
 * https://leetcode.com/problems/minimum-operations-to-reduce-x-to-zero/
 *
 * # LC. 1658. Minimum Operations to Reduce X to Zero
 *
 *   Q. You are given an integer array nums and an integer x. In one operation, you can either remove the leftmost or
 *      the rightmost element from the array nums and subtract its value from x. Note that this modifies the array for
 *      future operations.
 *
 *      Return the minimum number of operations to reduce x to exactly 0 if it is possible, otherwise, return -1.
 *
 *    Ex.
 *      Input : nums = [1, 1, 4, 2, 3], x = 5
 *      Output: 2
 *      Explanation: The optimal solution is to remove the last two elements to reduce x to zero.
 *
 *  Constraints:
 *        ◦ 1 <= nums.length <= 10⁵
 *        ◦ 1 <= nums[i] <= 10⁴
 *        ◦ 1 <= x <= 10⁹
 */

import java.util.Scanner;

public class Q23_1658_Minimum_Operations_to_Reduce_X_to_Zero {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("nums: ");
        String[] s = sc.nextLine().split(" ");

        int n = s.length;
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(s[i]);
        }

        System.out.print("x: ");
        int x = sc.nextInt();

        System.out.println("minimum operations to reduce x to 0: ");
        System.out.println(minOperations(nums, x));
    }

    /// Solution
    static int minOperations(int[] nums, int x) {
        int n = nums.length;
        int total = 0;

        for (int val : nums) {
            total += val;
        }

        if (x > total) return -1;
        if (x == total) return n;

        // sliding window
        int l = 0;
        int maxLen = -1;
        int sum = 0;
        int target = total - x;

        for (int r = 0; r < n; r++) {
            sum += nums[r];

            while (sum > target) {
                sum -= nums[l++];
            }

            if (sum == target) {
                maxLen = Math.max(maxLen, r - l + 1);
            }
        }

        return (maxLen == -1) ? -1 : n - maxLen;
    }
}
