package LeetCode;/*
 *
 * https://leetcode.com/problems/minimum-moves-to-equal-array-elements/
 *
 * # LC. 453. Minimum Moves to Equal Array Elements
 *
 *   Q. Given an integer array nums of size n, return the minimum number of moves required to make all array elements
 *      equal.
 *
 *      In one move, you can increment n - 1 elements of the array by 1.
 *
 *    Ex.
 *      Input : nums = [1, 2, 3]
 *      Output: 3
 *      Explanation: Only three moves are needed (remember each move increments two elements):
 *                   [1,2,3]  =>  [2,3,3]  =>  [3,4,3]  =>  [4,4,4]
 *
 *  Constraints:
 *        ◦ n == nums.length
 *        ◦ 1 <= nums.length <= 10⁵
 *        ◦ -10⁹ <= nums[i] <= 10⁹
 *        ◦ The answer is guaranteed to fit in a 32-bit integer.
 */

import java.util.Scanner;

public class LeetCode_453_Minimum_Moves_to_Equal_Array_Elements {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("nums[]: ");
        String[] s = sc.nextLine().split(" ");

        int n = s.length;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(s[i]);
        }

        System.out.println("minimum number of moves required to make all array elements equal: ");
        System.out.println(minMoves(arr));
    }

    /// Solution
    static int minMoves(int[] nums) {
        int n = nums.length;
        int min = Integer.MAX_VALUE;
        long sum = 0;

        for (int ele : nums) {
            sum += ele;
            min = Math.min(min, ele);
        }

        return (int) (sum - (long) min * n);
    }
}
