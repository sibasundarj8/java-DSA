package LeetCode;/*
 *
 * https://leetcode.com/problems/count-subarrays-with-majority-element-ii/
 *
 * # LC. 3739. Count Subarrays With Majority Element II
 *
 *   Q. You are given an integer array nums and an integer target. Return the number of subarrays of nums in which target
 *      is the majority element. The majority element of a subarray is the element that appears strictly more than half
 *      of the times in that subarray.
 *
 *    Ex.
 *      Input : nums = [1, 2, 2, 3],
 *              target = 2
 *      Output: 5
 *      Explanation:
 *              Valid subarrays with target = 2 as the majority element:
 *                ⎯> nums[1..1] = [2]
 *                ⎯> nums[2..2] = [2]
 *                ⎯> nums[1..2] = [2, 2]
 *                ⎯> nums[0..2] = [1, 2, 2]
 *                ⎯> nums[1..3] = [2, 2, 3]
 *              So there are 5 such subarrays.
 *
 *  Constraints:
 *      1 <= nums.length <= 10⁵
 *      1 <= nums[i] <= 10⁹
 *      1 <= target <= 10⁹
 */

import java.util.Scanner;

public class LeetCode_3739_Count_Subarrays_With_Majority_Element_II {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the array elements: ");
        String[] s = sc.nextLine().split(" ");

        int n = s.length;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(s[i]);
        }

        System.out.println("Enter target: ");
        int target = sc.nextInt();

        System.out.println("Number of sub-arrays in which target is the majority element: ");
        System.out.println(countMajoritySubarrays(arr, target));
    }

    /// Solution
/*
⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯-brute-force-⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯
TC : O(n²)
TC : O(1)
*/
    static int approach_1(int[] nums, int target) {
        int n = nums.length;
        int count = 0;

        for (int i = 0; i < n; i++) {
            int freq = 0;
            for (int j = i; j < n; j++) {
                int len = j - i + 1;
                if (nums[j] == target) freq++;
                if ((freq << 1) > len) count++;
            }
        }

        return count;
    }

/*
⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯--using--Merge-Sort--⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯
TC : O(n log n)
SC : O(n)
*/
    static long countMajoritySubarrays(int[] nums, int target) {
        // potd.code.hub
        int n = nums.length;
        int[] prefixSum = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            prefixSum[i] = prefixSum[i - 1] + ((nums[i - 1] == target) ? 1 : -1);
        }

        return countStrictlyIncreasingPairs(0, n, prefixSum);
    }

    private static long countStrictlyIncreasingPairs(int i, int j, int[] arr) {
        // base case
        if (i >= j) return 0;

        // recursive case
        int mid = i + (j - i) / 2;
        long leftCount = countStrictlyIncreasingPairs(i, mid, arr);
        long rightCount = countStrictlyIncreasingPairs(mid + 1, j, arr);

        // self work
        return leftCount + rightCount + merge(i, mid, j, arr);
    }

    private static long merge(int i, int mid, int j, int[] arr) {
        int n = mid - i + 1;
        int m = j - mid;
        int[] left = new int[n];
        int[] right = new int[m];

        System.arraycopy(arr, i, left, 0, n);
        System.arraycopy(arr, mid + 1, right, 0, m);

        int l = 0;
        int r = 0;
        int idx = i;
        long count = 0;

        while (l < n && r < m) {
            if (right[r] > left[l]) {
                count += (m - r);
                arr[idx++] = left[l++];
            } else arr[idx++] = right[r++];
        }

        while (l < n) arr[idx++] = left[l++];
        while (r < m) arr[idx++] = right[r++];

        return count;
    }
}
