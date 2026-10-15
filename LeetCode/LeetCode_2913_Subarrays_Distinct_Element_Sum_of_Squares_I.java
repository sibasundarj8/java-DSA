package LeetCode;/*
 *
 * https://leetcode.com/problems/subarrays-distinct-element-sum-of-squares-i/
 *
 * # LC. 2913. Subarrays Distinct Element Sum of Squares I
 *
 *   Q. You are given a 0-indexed integer array nums.
 *
 *      The distinct count of a subarray of nums is defined as:
 *        ◦ Let nums[i..j] be a subarray of nums consisting of all the indices from i to j such that
 *          0 <= i <= j < nums.size().Then the number of distinct values in nums[i..j] is called the
 *          distinct count of nums[i..j].
 *
 *      Return the sum of the squares of distinct counts of all subarrays of nums.
 *
 *      A subarray is a contiguous non-empty sequence of elements within an array.
 *
 *    Ex.
 *      Input : nums = [1, 2, 1]
 *      Output: 15
 *      Explanation: Six possible subarrays are:
 *                   [1] : 1 distinct value
 *                   [2] : 1 distinct value
 *                   [1] : 1 distinct value
 *                   [1, 2] : 2 distinct values
 *                   [2, 1] : 2 distinct values
 *                   [1, 2, 1] : 2 distinct values
 *                  The sum of the squares of the distinct counts in all subarrays is equal to
 *                  12 + 12 + 12 + 22 + 22 + 22 = 15.
 *
 *  Constraints:
 *        ◦ 1 <= nums.size <= 100
 *        ◦ 1 <= nums[i] <= 100
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class LeetCode_2913_Subarrays_Distinct_Element_Sum_of_Squares_I {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("nums[] : ");
        String[] s = sc.nextLine().split(" ");
        List<Integer> list = new ArrayList<>();

        for (String ele : s) {
            list.add(Integer.parseInt(ele));
        }

        System.out.println("Sum of the squares of distinct counts of all subarrays: ");
        System.out.println(sumCounts(list));
    }

    /// Solution
    static int sumCounts(List<Integer> nums) {
        // potd.code.hub
        int n = nums.size();
        int res = 0;
        int[] seen = new int[101];

        Arrays.fill(seen, -1);

        for (int i = 0; i < n; i++) {
            int unq = 0;

            for (int j = i; j < n; j++) {
                int idx = nums.get(j);

                if (seen[idx] != i) {
                    seen[idx] = i;
                    unq++;
                }

                res += unq * unq;
            }
        }

        return res;
    }
}
