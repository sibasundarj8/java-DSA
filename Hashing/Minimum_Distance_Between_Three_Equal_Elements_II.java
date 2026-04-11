package Hashing;/*
 *
 * https://leetcode.com/problems/minimum-distance-between-three-equal-elements-ii/
 *
 * # 3741. Minimum Distance Between Three Equal Elements II
 *
 *   Q. You are given an integer array nums. A tuple (i, j, k) of 3 distinct indices is good if nums[i] == nums[j] == nums[k].
 *      The distance of a good tuple is abs(i - j) + abs(j - k) + abs(k - i), where abs(x) denotes the absolute value of x.
 *      Return an integer denoting the minimum possible distance of a good tuple. If no good tuples exist, return -1.
 *
 *    Ex.
 *      Input : nums = [1, 2, 1, 1, 3]
 *      Output: 6
 *      Explanation:
 *              The minimum distance is achieved by the good tuple (0, 2, 3).
 *              (0, 2, 3) is a good tuple because nums[0] == nums[2] == nums[3] == 1.
 *              Its distance is abs(0 - 2) + abs(2 - 3) + abs(3 - 0) = 2 + 1 + 3 = 6.
 *
 *  Constraints:
 *          1 <= n == nums.length <= 10⁵
 *          1 <= nums[i] <= n
 */

import java.util.Scanner;

public class Minimum_Distance_Between_Three_Equal_Elements_II {

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

        System.out.println("Minimum possible distance of a good tuple :");
        System.out.println(minimumDistance(arr));
    }

    /// Solution
    static int minimumDistance(int[] nums) {
        // potd.code.hub
        int n = nums.length;
        int result = Integer.MAX_VALUE;
        int[] prev1 = new int[n];
        int[] prev2 = new int[n];

        for (int i = 0; i < n; i++) {
            prev1[i] = prev2[i] = -1;
        }

        for (int i = 0; i < n; i++) {
            int idx = nums[i] - 1;

            if (prev2[idx] != -1) {
                result = Math.min(result, i - prev2[idx]);
            }

            prev2[idx] = prev1[idx];
            prev1[idx] = i;
        }

        return (result == Integer.MAX_VALUE) ? -1 : result * 2;
    }
}
