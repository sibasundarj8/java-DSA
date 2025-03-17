package LeetCode;/*
 *
 * https://leetcode.com/problems/divide-array-into-equal-pairs/
 *
 * #2206. Divide Array Into Equal Pairs
 *
 *   Q. You are given an integer array nums consisting of 2 * n integers.
 *
 *      You need to divide nums into n pairs such that:
 *        • Each element belongs to exactly one pair.
 *        • The elements present in a pair are equal.
 *
 *      Return true if nums can be divided into n pairs, otherwise return false.
 *   Ex.
 *      Input : nums = [3,2,3,2,2,2]
 *      Output: true
 *      Explanation: There are 6 elements in nums, so they should be divided into 6 / 2 = 3 pairs.
 *              If nums is divided into the pairs (2, 2), (3, 3), and (2, 2), it will satisfy all
 *              the conditions.
 */
import java.util.Scanner;

public class LeetCode_2206_Divide_Array_Into_Equal_Pairs {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Size: ");
        int n = sc.nextInt();

        int[]nums = new int[n];

        System.out.println("Elements: ");
        for (int i = 0;i < n;i++)
            nums[i] = sc.nextInt();

        System.out.println(divideArray(nums));
    }

    /// Solution
    static boolean divideArray(int[] nums) {
        int[]freq = new int[501];
        for (int i : nums)
            freq[i]++;
        for (int i : freq)
            if (i % 2 != 0) return false;

        return true;
    }
}
