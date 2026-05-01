package SlidingWindow;/*
 *
 * https://leetcode.com/problems/rotate-function/
 *
 * # 396. Rotate Function
 *
 *   Q. You are given an integer array nums of length n.
 *
 *      Assume arr-k to be an array obtained by rotating nums by k positions clock-wise. We define the rotation function
 *      F on nums as follow:
 *        ◦ F(k) = 0 * arrk[0] + 1 * arrk[1] + ... + (n - 1) * arrk[n - 1].
 *
 *      Return the maximum value of F(0), F(1), ..., F(n-1).
 *
 *      The test cases are generated so that the answer fits in a 32-bit integer.
 *
 *    Ex.
 *      Input: nums = [4, 3, 2, 6]
 *      Output: 26
 *      Explanation:
 *              F(0) = (0 * 4) + (1 * 3) + (2 * 2) + (3 * 6) = 0 + 3 + 4 + 18 = 25
 *              F(1) = (0 * 6) + (1 * 4) + (2 * 3) + (3 * 2) = 0 + 4 + 6 + 6 = 16
 *              F(2) = (0 * 2) + (1 * 6) + (2 * 4) + (3 * 3) = 0 + 6 + 8 + 9 = 23
 *              F(3) = (0 * 3) + (1 * 2) + (2 * 6) + (3 * 4) = 0 + 2 + 12 + 12 = 26
 *              So the maximum value of F(0), F(1), F(2), F(3) is F(3) = 26.
 *
 *  Constraints:
 *          n == nums.length
 *          1 <= n <= 10⁵
 *          -100 <= nums[i] <= 100
 */

import java.util.Scanner;

public class Q19_Rotate_Function {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter array elements: ");
        String[] s = sc.nextLine().split(" ");

        int n = s.length;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(s[i]);
        }

        System.out.println("Maximum value of F(0), F(1), ..., F(n-1): ");
        System.out.println(maxRotateFunction(arr));
    }

    /// Solution
    static int maxRotateFunction(int[] nums) {
        // potd.code.hub
        int n = nums.length;
        int totalSum = 0;
        int fun = 0;

        // first window
        for (int i = 0; i < n; i++) {
            totalSum += nums[i];
            fun += nums[i] * i;
        }

        int maxFun = fun;

        // remaining rotations
        for (int i = 1; i < n; i++) {
            fun -= (totalSum - nums[i - 1]);
            fun += nums[i - 1] * (n - 1);
            maxFun = Math.max(maxFun, fun);
        }

        return maxFun;
    }
}
