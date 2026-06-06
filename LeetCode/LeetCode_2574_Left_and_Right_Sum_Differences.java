package LeetCode;/*
 *
 * https://leetcode.com/problems/left-and-right-sum-differences/
 *
 * # LC. 2574. Left and Right Sum Differences
 *
 *   Q. You are given a 0-indexed integer array nums of size n.
 *
 *      Define two arrays leftSum and rightSum where:
 *
 *        ◦ leftSum[i] is the sum of elements to the left of the index i in the array nums. If there is no such element,
 *          leftSum[i] = 0.
 *
 *        ◦ rightSum[i] is the sum of elements to the right of the index i in the array nums. If there is no such element,
 *          rightSum[i] = 0.
 *
 *      Return an integer array answer of size n where answer[i] = |leftSum[i] - rightSum[i]|.
 *
 *    Ex.
 *      Input : nums = [10, 4, 8, 3]
 *      Output: [15, 1, 11, 22]
 *      Explanation: The array leftSum is [0, 10, 14, 22] and the array rightSum is [15, 11, 3, 0].
 *                   The array answer is [|0 - 15|, |10 - 11|, |14 - 3|, |22 - 0|] = [15, 1, 11, 22].
 *
 *  Constraints:
 *          1 <= nums.length <= 1000
 *          1 <= nums[i] <= 10⁵
 */

import java.util.Arrays;
import java.util.Scanner;

public class LeetCode_2574_Left_and_Right_Sum_Differences {

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

        System.out.println("|left_sum - right_sum| for every position: ");
        System.out.println(Arrays.toString(leftRightDifference(arr)));
    }

    /// Solution
    static int[] leftRightDifference(int[] nums) {
        int n = nums.length;
        int right = 0;
        int left = 0;
        int[] res = new int[n];

        for (int ele : nums) {
            right += ele;
        }

        for (int i = 0; i < n; i++) {
            right -= nums[i];
            res[i] = Math.abs(left - right);
            left += nums[i];
        }

        return res;
    }
}
