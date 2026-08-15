package LeetCode;/*
 *
 * https://leetcode.com/problems/longest-subsequence-with-non-zero-bitwise-xor/
 *
 * LC. 3702. Longest Subsequence With Non-Zero Bitwise XOR
 *
 *   Q. You are given an integer array nums.
 *
 *      Return the length of the longest subsequence in nums whose bitwise XOR is non-zero. If no such subsequence
 *      exists, return 0.
 *
 *    Ex.
 *      Input : nums = [1, 2, 3]
 *      Output: 2
 *      Explanation:
 *              One longest subsequence is [2, 3]. The bitwise XOR is computed as 2 XOR 3 = 1, which is non-zero.
 *
 *  Constraints:
 *        ◦ 1 <= nums.length <= 10⁵
 *        ◦ 0 <= nums[i] <= 10⁹
 */

import java.util.Scanner;

public class LeetCode_3702_Longest_Subsequence_With_Non_Zero_Bitwise_XOR {

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

        System.out.println("Length of the longest subsequence in nums whose bitwise XOR is non-zero: ");
        System.out.println(longestSubsequence(nums));
    }

    /// Solution
    static int longestSubsequence(int[] nums) {
        int n = nums.length;
        int xor = 0;
        boolean allZero = true;

        for (int ele : nums) {
            xor ^= ele;
            if (allZero && ele > 0) allZero = false;
        }

        if (xor != 0) return n;
        else if (allZero) return 0;
        return n - 1;
    }
}
