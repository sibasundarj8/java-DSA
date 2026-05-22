package BinarySearch;/*
 *
 * https://leetcode.com/problems/search-in-rotated-sorted-array/
 *
 * # 33. Search in Rotated Sorted Array
 *
 *   Q. There is an integer array nums sorted in ascending order (with distinct values).
 *
 *      Prior to being passed to your function, nums is possibly left rotated at an unknown index k (1 <= k < nums.length)
 *      such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed).
 *      For example, [0,1,2,4,5,6,7] might be left rotated by 3 indices and become [4,5,6,7,0,1,2].
 *
 *      Given the array nums after the possible rotation and an integer target, return the index of target if it is in nums,
 *      or -1 if it is not in nums.
 *
 *      You must write an algorithm with O(log n) runtime complexity.
 *
 *    Ex.
 *      Input : nums = [4, 5, 6, 7, 0, 1, 2],
 *              target = 0
 *      Output: 4
 *
 *  Constraints:
 *        ◦ 1 <= nums.length <= 5000
 *        ◦ -10⁴ <= nums[i] <= 10⁴
 *        ◦ All values of nums are unique.
 *        ◦ nums is an ascending array that is possibly rotated.
 *        ◦ -10⁴ <= target <= 10⁴
 */

import java.util.Scanner;

public class Searching_Search_in_Rotated_Sorted_Array {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Array elements: (must be rotated and sorted)");
        String[] s = sc.nextLine().split(" ");

        int n = s.length;
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(s[i]);
        }

        System.out.println("Enter the target: ");
        int target = sc.nextInt();

        System.out.print("target found at index: ");
        System.out.println(search(arr, target));
    }

    /// Solution
/*
☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒-Target-Tracking-☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒☒
TC : O(log n)
SC : O(1)
*/
    static int approach_1(int[] nums, int target) {
        int i = 0;
        int j = nums.length - 1;

        while (i <= j) {
            int mid = i + (j - i) / 2;

            if (nums[mid] == target) return mid;

            // target belongs to the first half
            if (target >= nums[i]) {
                if (nums[mid] < nums[i] || target < nums[mid]) j = mid - 1;
                else i = mid + 1;
            }
            // target belongs to the second half
            else {
                if (nums[mid] > nums[j] || target > nums[mid]) i = mid + 1;
                else j = mid - 1;
            }
        }

        return -1;
    }

/*
☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑-Sorted-Half_Tracking-☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑☑
TC : O(log n)
SC : O(1)
*/
    static int search(int[] nums, int target) {
        int i = 0;
        int j = nums.length - 1;

        while (i <= j) {
            int mid = i + (j - i) / 2;

            if (nums[mid] == target) return mid;

            // if left half is sorted
            if (nums[i] <= nums[mid]) {
                if (nums[i] <= target && target < nums[mid]) j = mid - 1;
                else i = mid + 1;
            }
            // else right half is sorted
            else {
                if (nums[mid] < target && target <= nums[j]) i = mid + 1;
                else j = mid - 1;
            }
        }

        return -1;
    }
}
