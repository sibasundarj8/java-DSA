package LeetCode;/*
 *
 * https://leetcode.com/problems/check-if-array-is-sorted-and-rotated/
 *
 * # 1752. Check if Array Is Sorted and Rotated
 *
 *   Q. Given an array nums, return true if the array was originally sorted in non-decreasing order, then rotated some number
 *      of positions (including zero). Otherwise, return false.
 *
 *      There may be duplicates in the original array.
 *
 *      Note: An array A rotated by x positions results in an array B of the same length such that B[i] == A[(i+x) % A.length]
 *            for every valid index i.
 *
 *    Ex.
 *      Input : nums = [3,4,5,1,2]
 *      Output: true
 *      Explanation: [1,2,3,4,5] is the original sorted array.
 *                   You can rotate the array by x = 2 positions to begin on the element of value 3: [3,4,5,1,2].
 *  Constraints:
 *          1 <= nums.length <= 100
 *          1 <= nums[i] <= 100
 */

import java.util.Scanner;

public class LeetCode_1752_Check_if_Array_Is_Sorted_and_Rotated {

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

        System.out.println("is it a sorted and rotated array: ");
        System.err.println(check(arr) ? "YES" : "NO");
    }

    /// Solution
/*
☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒-re-construct-☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒
TC : O(n)
SC : O(1)
*/
    static boolean approach_1(int[] nums) {
        int n = nums.length;
        int dist = 0;

        // getting the actual first element
        for (int i = 1; i < n; i++) {
            if (nums[i - 1] > nums[i]) {
                dist = i;
                break;
            }
        }

        // checking array is sorted or not
        for (int i = 1; i < n; i++) {
            int prvIdx = ((i - 1) + dist) % n;
            int curIdx = (i + dist) % n;

            if (nums[prvIdx] > nums[curIdx]) {
                return false;
            }
        }

        return true;
    }

/*
☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑-Mathematical-☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑
TC : O(n)
SC : O(1)
*/
    static boolean check(int[] nums) {
        int n = nums.length;
        int drops = 0;
    
        for (int i = 0; i < n; i++) {
            if (nums[(i - 1 + n) % n] > nums[i]) {
                drops++;
            }
        }
    
        return drops <= 1;
    }
}
