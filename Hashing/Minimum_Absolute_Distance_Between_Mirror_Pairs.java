package Hashing;/*
 *
 * https://leetcode.com/problems/minimum-absolute-distance-between-mirror-pairs/
 *
 * # 3761. Minimum Absolute Distance Between Mirror Pairs
 *
 *   Q. You are given an integer array nums.
 *
 *      A mirror pair is a pair of indices (i, j) such that:
 *        ◦ 0 <= i < j < nums.length, and
 *        ◦ reverse(nums[i]) == nums[j], where reverse(x) denotes the integer formed by reversing the digits of x. Leading
 *          zeros are omitted after reversing, for example reverse(120) = 21.
 *
 *      Return the minimum absolute distance between the indices of any mirror pair. The absolute distance between indices
 *      i and j is abs(i - j).
 *
 *      If no mirror pair exists, return -1.
 *
 *    Ex.
 *      Input : nums = [12, 21, 45, 33, 54]
 *      Output: 1
 *      Explanation:
 *              The mirror pairs are:
 *              (0, 1) since reverse(nums[0]) = reverse(12) = 21 = nums[1], giving an absolute distance abs(0 - 1) = 1.
 *              (2, 4) since reverse(nums[2]) = reverse(45) = 54 = nums[4], giving an absolute distance abs(2 - 4) = 2.
 *              The minimum absolute distance among all pairs is 1.
 *
 *  Constraints:
 *          1 <= nums.length <= 10⁵
 *          1 <= nums[i] <= 10⁹
 */

import java.util.HashMap;
import java.util.Scanner;

public class Minimum_Absolute_Distance_Between_Mirror_Pairs {

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

        System.out.println("Minimum absolute distance between the indices of any mirror pair : ");
        System.out.println(minMirrorPairDistance(arr));
    }

    /// Solution
    static int minMirrorPairDistance(int[] nums) {
        int n = nums.length;
        int minDist = Integer.MAX_VALUE;
        HashMap<Integer, Integer> map = new HashMap<>(n, 0.1f);

        for (int i = 0; i < n; i++) {
            if (map.containsKey(nums[i])) {
                minDist = Math.min(minDist, i - map.get(nums[i]));
            }
            int rev = reverse(nums[i]);

            map.put(rev, i);
        }

        return (minDist == Integer.MAX_VALUE) ? -1 : minDist;
    }

    private static int reverse(int num) {
        int rev = 0;

        while (num != 0) {
            rev = rev * 10 + num % 10;
            num /= 10;
        }

        return rev;
    }
}
