package LeetCode;/*
 *
 * https://leetcode.com/problems/find-triangular-sum-of-an-array/
 *
 * # 2221. Find Triangular Sum of an Array
 *
 *   Q. You are given a 0-indexed integer array nums, where nums[i] is a digit between 0 and 9 (inclusive).
 *
 *      The triangular sum of nums is the value of the only element present in nums after the following
 *      process terminates:
 *
 *          1. Let nums consist of n elements. If n == 1, end the process. Otherwise,
 *             create a new 0-indexed integer array newNums of length n - 1.
 *
 *          2. For each index i, where 0 <= i < n - 1, assign the value of newNums[i] as
 *             (nums[i] + nums[i+1]) % 10, where % denotes modulo operator.
 *
 *          3. Replace the array nums with newNums.
 *
 *          4. Repeat the entire process starting from step 1.
 *
 *      Return the triangular sum of nums.
 *   Ex.
 *      Input: nums = [1,2,3,4,5]               1   2   3   4   5
 *      Output: 8                                \ / \ / \ / \ /
 *                                                3   5   7   9
 *                                                 \ / \ / \ /
 *                                                  8   2   6
 *                                                   \ / \ /
 *                                                    0   8
 *                                                     \ /  
 *                                                      8
 *      Explanation: The above diagram depicts the process from which we obtain the
 *                   triangular sum of the array.
 *
 *  Constraints:
 *          1 <= nums.length <= 1000
 *          0 <= nums[i] <= 9
 */

import java.util.Scanner;

public class LeetCode_2221_Find_Triangular_Sum_of_an_Array {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter elements: ");
        String[] s = sc.nextLine().split(" ");

        int n = s.length;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(s[i]) % 10;
         
        System.out.println("Triangular Sum: " + triangularSum(arr));
    }

    /// Solution
    static int triangularSum(int[] nums) {
        int n = nums.length;
        int[] arr = nums.clone();

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n - i; j++) {
                arr[j] = (arr[j] + arr[j + 1]) % 10;
            }
        }

        return arr[0];
    }
}
