package Two_Pointers;/*
 *
 * https://leetcode.com/problems/minimum-distance-to-the-target-element/
 *
 * # LC 1848. Minimum Distance to the Target Element
 *
 *   Q. Given an integer array nums (0-indexed) and two integers target and start, find an index i such that nums[i] == target
 *      and abs(i - start) is minimized. Note that abs(x) is the absolute value of x.
 *      Return abs(i - start).
 *      It is guaranteed that target exists in nums.
 *
 *    Ex.
 *      Input : nums = [1,2,3,4,5], target = 5, start = 3
 *      Output: 1
 *      Explanation: nums[4] = 5 is the only value equal to target, so the answer is abs(4 - 3) = 1.
 *
 *  Constraints:
 *          1 <= nums.length <= 1000
 *          1 <= nums[i] <= 10⁴
 *          0 <= start < nums.length
 *          target is in nums.
 */

import java.util.Scanner;

public class Q04_Minimum_Distance_to_the_Target_Element {

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

        System.out.println("Target: ");
        int target = sc.nextInt();

        System.out.println("Start: ");
        int start = sc.nextInt();

        System.out.println("Min distance from start: ");
        System.out.println(getMinDistance(arr, target, start));
    }

    /// Solution
    static int getMinDistance(int[] nums, int target, int start) {
        // potd.code.hub
        int n = nums.length;
        int dist = 0;

        while (dist < n) {
            int l = start - dist;
            int r = start + dist;

            if (l >= 0 && nums[l] == target) break;
            if (r < n && nums[r] == target) break;

            dist++;
        }

        return dist;
    }
}
