package Two_Pointers;/*
 *
 * https://leetcode.com/problems/maximum-distance-between-a-pair-of-values/
 *
 * # 1855. Maximum Distance Between a Pair of Values
 *
 *   Q. You are given two non-increasing 0-indexed integer arrays nums1 and nums2.
 *
 *      A pair of indices (i, j), where 0 <= i < nums1.length and 0 <= j < nums2.length, is valid if both i <= j and
 *      nums1[i] <= nums2[j]. The distance of the pair is j - i.
 *
 *      Return the maximum distance of any valid pair (i, j). If there are no valid pairs, return 0.
 *
 *      An array arr is non-increasing if arr[i-1] >= arr[i] for every 1 <= i < arr.length.
 *
 *    Ex.
 *      Input : nums1 = [55, 30, 5, 4, 2], nums2 = [100, 20, 10, 10, 5]
 *      Output: 2
 *      Explanation: The valid pairs are (0,0), (2,2), (2,3), (2,4), (3,3), (3,4), and (4,4).
 *              The maximum distance is 2 with pair (2,4).
 *
 *  Constraints:
 *          1 <= nums1.length, nums2.length <= 10⁵
 *          1 <= nums1[i], nums2[j] <= 10⁵
 *          Both nums1 and nums2 are non-increasing.
 */

import java.util.Scanner;

public class Q05_Maximum_Distance_Between_a_Pair_of_Values {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter nums1[] elements: ");
        String[] s1 = sc.nextLine().split(" ");

        System.out.println("Enter nums2[] elements: ");
        String[] s2 = sc.nextLine().split(" ");

        int n1 = s1.length;
        int n2 = s2.length;
        int[] nums1 = new int[n1];
        int[] nums2 = new int[n2];

        for (int i = 0; i < n1; i++) nums1[i] = Integer.parseInt(s1[i]);
        for (int i = 0; i < n2; i++) nums2[i] = Integer.parseInt(s2[i]);

        System.out.println("Maximum distance of any valid pair (i, j): ");
        System.out.println(maxDistance(nums1, nums2));
    }

    /// Solution
    static int maxDistance(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int i = 0;
        int j = 0;
        int max = 0;

        while (i < n && j < m) {
            if (nums1[i] > nums2[j]) i++;
            else {
                if (i < j) max = Math.max(max, j - i);
                j++;
            }
        }

        return max;
    }
}
