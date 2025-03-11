package LeetCode;/*
 *
 * https://leetcode.com/problems/maximum-sum-of-distinct-subarrays-with-length-k/
 *
 * #2461. Maximum Sum of Distinct Subarrays With Length K
 *
 *   Q. You are given an integer array nums and an integer k. Find the maximum subarray sum of all
 *      the subarrays of nums that meet the following conditions:
 *
 *       • The length of the subarray is k, and
 *
 *       • All the elements of the subarray are distinct.
 *
 *      Return the maximum subarray sum of all the subarrays that meet the conditions. If no
 *      subarray meets the conditions, return 0.
 *
 *      A subarray is a contiguous non-empty sequence of elements within an array.
 *   Ex.
 *      Input : nums = [1,5,4,2,9,9,9]
 *              k = 3
 *      Output: 15
 *      Explanation: The subarrays of nums with length 3 are:
 *              - [1,5,4] which meets the requirements and has a sum of 10.
 *              - [5,4,2] which meets the requirements and has a sum of 11.
 *              - [4,2,9] which meets the requirements and has a sum of 15.
 *              - [2,9,9] which does not meet the requirements because the element 9 is repeated.
 *              - [9,9,9] which does not meet the requirements because element 9 is repeated.
 *              We return 15 because it is the maximum subarray sum of all the subarrays that meet
 *              the conditions
 */
import java.util.HashMap;
import java.util.Scanner;

public class LeetCode_2461_Maximum_Sum_of_Distinct_Subarrays_With_Length_K {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Size: ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        System.out.println("Elements: ");
        for (int i = 0;i < n;i++)
            arr[i] = sc.nextInt();

        System.out.println("k: ");
        int k = sc.nextInt();

        System.out.println(maximumSubarraySum(arr, k));
    }

    /// Solution
    static long maximumSubarraySum(int[] nums, int k) {
        int n = nums.length;
        long sum = 0;
        long ans = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0;i < n;i++){
            // adding
            sum += nums[i];
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
            // subtracting
            if(i >= k){
                sum -= nums[i-k];
                map.put(nums[i-k], map.get(nums[i-k])-1);
                if (map.get(nums[i-k]) == 0)
                    map.remove(nums[i-k]);
            }
            // updating
            if (i >= k-1 && map.size() == k)
                ans = Math.max(ans, sum);
        }

        return ans;
    }
}
