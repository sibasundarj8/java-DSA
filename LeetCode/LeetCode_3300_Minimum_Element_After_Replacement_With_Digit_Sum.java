package LeetCode;/*
 *
 * https://leetcode.com/problems/minimum-element-after-replacement-with-digit-sum/
 *
 * # LC 3300. Minimum Element After Replacement With Digit Sum
 *
 *   Q. You are given an integer array nums. You replace each element in nums with the sum of its digits.
 *      Return the minimum element in nums after all replacements.
 *
 *    Ex.
 *      Input : nums = [10,12,13,14]
 *      Output: 1
 *      Explanation: nums becomes [1, 3, 4, 5] after all replacements, with minimum element 1.
 *
 *  Constraints:
 *          1 <= nums.length <= 100
 *          1 <= nums[i] <= 10⁴
 */

import java.util.Scanner;

public class LeetCode_3300_Minimum_Element_After_Replacement_With_Digit_Sum {

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

        System.out.println("Minimum element in nums after all replacements : ");
        System.out.println(minElement(arr));
    }

    /// Solution
    static int minElement(int[] nums) {
        // potd.code.hub
        int min = Integer.MAX_VALUE;

        for (int ele : nums) {
            int sum = 0;

            while (ele > 0) {
                sum += ele % 10;
                ele /= 10;
            }

            min = Math.min(min, sum);
        }

        return min;
    }
}
