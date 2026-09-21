package LeetCode;/*
 *
 * https://leetcode.com/problems/find-x-value-of-array-i/
 *
 * # LC. 3524. Find X Value of Array I
 *
 *   Q. You are given an array of positive integers nums, and a positive integer k.
 *
 *      You are allowed to perform an operation once on nums, where in each operation you can remove any non-overlapping
 *      prefix and suffix from nums such that nums remains non-empty.
 *
 *      You need to find the x-value of nums, which is the number of ways to perform this operation so that the product
 *      of the remaining elements leaves a remainder of x when divided by k.
 *
 *      Return an array result of size k where result[x] is the x-value of nums for 0 <= x <= k - 1.
 *
 *      A prefix of an array is a subarray that starts from the beginning of the array and extends to any point within
 *      it.
 *
 *      A suffix of an array is a subarray that starts at any point within the array and extends to the end of the
 *      array.
 *
 *      Note that the prefix and suffix to be chosen for the operation can be empty.
 *
 *    Ex.
 *      Input : nums = [1,2,3,4,5], k = 3
 *      Output: [9,2,4]
 *      Explanation:
 *              For x = 0, the possible operations include all possible ways to remove non-overlapping prefix/suffix
 *              that do not remove nums[2] == 3.
 *
 *              For x = 1, the possible operations are:
 *                ◦ Remove the empty prefix and the suffix [2, 3, 4, 5]. nums becomes [1].
 *                ◦ Remove the prefix [1, 2, 3] and the suffix [5]. nums becomes [4].
 *
 *              For x = 2, the possible operations are:
 *                ◦ Remove the empty prefix and the suffix [3, 4, 5]. nums becomes [1, 2].
 *                ◦ Remove the prefix [1] and the suffix [3, 4, 5]. nums becomes [2].
 *                ◦ Remove the prefix [1, 2, 3] and the empty suffix. nums becomes [4, 5].
 *                ◦ Remove the prefix [1, 2, 3, 4] and the empty suffix. nums becomes [5].
 *
 *  Constraints:
 *        ◦ 1 <= nums[i] <= 10⁹
 *        ◦ 1 <= nums.length <= 10⁵
 *        ◦ 1 <= k <= 5
 */

import java.util.Arrays;
import java.util.Scanner;

public class LeetCode_3524_Find_X_Value_of_Array_I {

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

        System.out.print("result[]: ");
        System.out.println(Arrays.toString(resultArray(nums, k)));
    }

    /// Solution
    static long[] resultArray(int[] nums, int k) {
        int n = nums.length;
        long[] res = new long[k];
        long[] prev = new long[k];
        long[] curr = new long[k];

        int rem = nums[0] % k;
        prev[rem] = res[rem] = 1L;

        for (int i = 1; i < n; i++) {
            curr[nums[i] % k] = 1;

            for (int x = 0; x < k; x++) {
                if (prev[x] == 0) continue;

                rem = (x * (nums[i] % k)) % k;
                curr[rem] += prev[x];
            }

            for (int x = 0; x < k; x++) {
                res[x] += prev[x] = curr[x];
                curr[x] = 0L;
            }
        }

        return res;
    }
}
