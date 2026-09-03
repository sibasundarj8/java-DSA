package LeetCode;/*
 *
 * https://leetcode.com/problems/construct-uniform-parity-array-ii/
 *
 * # LC. 3876. Construct Uniform Parity Array II
 *
 *   Q. You are given an array nums1 of n distinct integers.
 *
 *      You want to construct another array nums2 of length n such that the elements in nums2 are either all odd or
 *      all even.
 *
 *      For each index i, you must choose exactly one of the following (in any order):
 *        ◦ nums2[i] = nums1[i]
 *        ◦ nums2[i] = nums1[i] - nums1[j], for an index j != i, such that nums1[i] - nums1[j] >= 1
 *
 *      Return true if it is possible to construct such an array, otherwise return false.
 *
 *    Ex.
 *      Input : nums1 = [1,4,7]
 *      Output: true
 *      Explanation:
 *                ◦ Set nums2[0] = nums1[0] = 1.
 *                ◦ Set nums2[1] = nums1[1] - nums1[0] = 4 - 1 = 3.
 *                ◦ Set nums2[2] = nums1[2] = 7.
 *                ◦ nums2 = [1, 3, 7], and all elements are odd. Thus, the answer is true.
 *
 *  Constraints:
 *        ◦ 1 <= n == nums1.length <= 10⁵
 *        ◦ 1 <= nums1[i] <= 10⁹
 *        ◦ nums1 consists of distinct integers.
 */

import java.util.Scanner;

public class LeetCode_3876_Construct_Uniform_Parity_Array_II {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("int[] nums1: ");
        String[] s = sc.nextLine().split(" ");

        int n = s.length;
        int[] nums1 = new int[n];
        for (int i = 0; i < n; i++) {
            nums1[i] = Integer.parseInt(s[i]);
        }

        System.out.println("is it possible to construct nums2[]: ");
        System.out.println(uniformArray(nums1));
    }

    /// Solution
    static boolean uniformArray(int[] nums1) {
        int smallest = nums1[0];
        boolean allEven = true;

        for (int ele : nums1) {
            if (ele < smallest) smallest = ele;
            if ((ele & 1) == 1) allEven = false;
        }

        return allEven || (smallest & 1) == 1;
    }
}
