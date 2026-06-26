package LeetCode;/*
 *
 * https://leetcode.com/problems/count-subarrays-with-majority-element-i/
 *
 * # LC. 3737. Count Subarrays With Majority Element I
 *
 *   Q. You are given an integer array nums and an integer target.
 *      Return the number of subarrays of nums in which target is the majority element.
 *      The majority element of a subarray is the element that appears strictly more than half of the times in that subarray.
 *
 *    Ex.
 *      Input : nums = [1, 2, 2, 3]
 *              target = 2
 *      Output: 5
 *      Explanation:
 *              Valid subarrays with target = 2 as the majority element:
 *                ∘ nums[1..1] = [2]
 *                ∘ nums[2..2] = [2]
 *                ∘ nums[1..2] = [2, 2]
 *                ∘ nums[0..2] = [1, 2, 2]
 *                ∘ nums[1..3] = [2, 2, 3]
 *              So there are 5 such subarrays.
 *
 *  Constraints:
 *        ◦ 1 <= nums.length <= 1000
 *        ◦ 1 <= nums[i] <= 10⁹
 *        ◦ 1 <= target <= 10⁹
 */

import java.util.Scanner;

public class LeetCode_3737_Count_Subarrays_With_Majority_Element_I {

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

        System.out.println("Enter target: ");
        int target = sc.nextInt();

        System.out.println("Number of sub-array in which " + target + " is the majority element : ");
        System.out.println(approach_1(arr, target));
    }

    /// Solution
    static int approach_1(int[] nums, int target) {
        int n = nums.length;
        int count = 0;

        for (int i = 0; i < n; i++) {
            int freq = 0;
            for (int j = i; j < n; j++) {
                int len = j - i + 1;
                if (nums[j] == target) freq++;
                if ((freq << 1) > len) count++;
            }
        }

        return count;
    }
}
