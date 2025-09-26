package LeetCode;/*
 *
 * https://leetcode.com/problems/valid-triangle-number/
 *
 * # 611. Valid Triangle Number
 *
 *   Q. Given an integer array nums, return the number of triplets chosen from the array that can make triangles
 *      if we take them as side lengths of a triangle.
 *    Ex.
 *      Input : nums = [2,2,3,4]
 *      Output: 3
 *      Explanation: Valid combinations are:
 *                   2,3,4 (using the first 2)
 *                   2,3,4 (using the second 2)
 *                   2,2,3
 *
 *  Constraints:
 *          1 <= nums.length <= 10³
 *          0 <= nums[i] <= 10³
 */

import java.util.Arrays;
import java.util.Scanner;

public class LeetCode_611_Valid_Triangle_Number {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter lengths of sides: ");
        String[] s = sc.nextLine().split(" ");

        int n = s.length;
        int[] arr = new int[n];

        for (int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(s[i]);

        System.out.println("Number of triangle possible: " + triangleNumber(arr));
    }

    /// Solution
    static int triangleNumber(int[] nums) {
        int n = nums.length;
        int count = 0;
        Arrays.sort(nums);

        for (int z = n - 1; z >= 2; z--) {
            int x = 0;
            int y = z - 1;
            // two pointer
            while (x < y) {
                if (nums[x] + nums[y] > nums[z]) {
                    count += (y - x);
                    y--;
                } else x++;
            }
        }

        return count;
    }
}
