package LeetCode;/*
 *
 * https://leetcode.com/problems/largest-perimeter-triangle/
 *
 * # 976. Largest Perimeter Triangle
 *
 *   Q. Given an integer array nums, return the largest perimeter of a triangle with a non-zero area, formed
 *      from three of these lengths. If it is impossible to form any triangle of a non-zero area, return 0.
 *    Ex.
 *      Input : nums = [1,2,1,10]
 *      Output: 0
 *      Explanation:
 *              You cannot use the side lengths 1, 1, and 2 to form a triangle.
 *              You cannot use the side lengths 1, 1, and 10 to form a triangle.
 *              You cannot use the side lengths 1, 2, and 10 to form a triangle.
 *              As we cannot use any three side lengths to form a triangle of non-zero area, we return 0.
 *
 *  Constraints:
 *      3 <= nums.length <= 10⁴
 *      1 <= nums[i] <= 10⁶
 */

import java.util.Arrays;
import java.util.Scanner;

public class LeetCode_976_Largest_Perimeter_Triangle {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter sides: ");
        String[] s = sc.nextLine().split(" ");

        int n = s.length;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] =Integer.parseInt(s[i]);

        System.out.println("Largest possible tringle perimeter: ");
        System.out.println(largestPerimeter(arr));
    }

    /// Solution
    static int largestPerimeter(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);

        for (int i = n - 1; i >= 2; i--) {
            for (int j = i - 1; j >= 1; j--) {
                if (nums[j] + nums[j - 1] > nums[i])
                    return nums[i] + nums[j] + nums[j - 1];
            }
        }

        return 0;
    }
}
