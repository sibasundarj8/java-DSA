package Greedy;/*
 *
 * https://leetcode.com/problems/minimum-sum-of-squared-difference/
 *
 * # LC. 2333. Minimum Sum of Squared Difference
 *
 *   Q. You are given two positive 0-indexed integer arrays nums1 and nums2, both of length n.
 *
 *      The sum of squared difference of arrays nums1 and nums2 is defined as the sum of (nums1[i] - nums2[i])2 for
 *      each 0 <= i < n.
 *
 *      You are also given two positive integers k1 and k2. You can modify any of the elements of nums1 by +1 or -1
 *      at most k1 times. Similarly, you can modify any of the elements of nums2 by +1 or -1 at most k2 times.
 *
 *      Return the minimum sum of squared difference after modifying array nums1 at most k1 times and modifying array
 *      nums2 at most k2 times.
 *
 *      Note: You are allowed to modify the array elements to become negative integers.
 *
 *    Ex.
 *      Input : nums1 = [1, 4, 10, 12],
 *              nums2 = [5, 8, 6, 9],
 *              k1 = 1, k2 = 1
 *      Output: 43
 *      Explanation: One way to obtain the minimum sum of square difference is:
 *                      - Increase nums1[0] once.
 *                      - Increase nums2[2] once.
 *                   The minimum of the sum of square difference will be:
 *                   (2 - 5)2 + (4 - 8)2 + (10 - 7)2 + (12 - 9)2 = 43.
 *                   Note that, there are other ways to obtain the minimum of the sum of square difference, but there
 *                   is no way to obtain a sum smaller than 43.
 *
 *  Constraints:
 *        ◦ n == nums1.length == nums2.length
 *        ◦ 1 <= n <= 10⁵
 *        ◦ 0 <= nums1[i], nums2[i] <= 10⁵
 *        ◦ 0 <= k1, k2 <= 10⁹
 */

import java.util.Scanner;

public class G17_2333_Minimum_Sum_of_Squared_Difference {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("nums1[] : ");
        String[] s = sc.nextLine().split(" ");

        int n = s.length;
        int[] nums1 = new int[n];
        int[] nums2 = new int[n];

        System.out.print("nums2[] : ");
        for (int i = 0; i < n; i++) {
            nums1[i] = Integer.parseInt(s[i]);
            nums2[i] = sc.nextInt();
        }

        System.out.print("k1: ");
        int k1 = sc.nextInt();

        System.out.print("k2: ");
        int k2 = sc.nextInt();

        System.out.println("Minimum sum of squared difference after modifying both array:");
        System.out.println(minSumSquareDiff(nums1, nums2, k1, k2));
    }

    /// Solution
    static long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        long[] bucket = new long[100_001];
        int n = nums1.length;
        long total = 0;
        int max = 0;

        for (int i = 0; i < n; i++) {
            int diff = Math.abs(nums1[i] - nums2[i]);
            max = Math.max(max, diff);
            total += diff;
            bucket[diff]++;
        }

        long k = (long) k1 + k2;

        if (total <= k) {
            return 0;
        }

        boolean flag = false;
        long res = 0;

        for (int i = max; i >= 1; i--) {
            if (bucket[i] == 0) continue;

            if (!flag) {
                long min = Math.min(bucket[i], k);
                bucket[i] -= min;
                bucket[i - 1] += min;
                k -= min;

                if (bucket[i] > 0) flag = true;
            }

            if (flag) {
                res += bucket[i] * i * i;
            }
        }

        return res;
    }
}
