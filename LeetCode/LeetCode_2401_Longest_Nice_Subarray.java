package LeetCode;/*
 *
 * https://leetcode.com/problems/longest-nice-subarray/
 *
 * # 2401. Longest Nice Subarray
 *
 *   Q. You are given an array nums consisting of positive integers.
 *
 *      We call a subarray of nums nice if the bitwise AND of every pair of elements that are in
 *      different positions in the subarray is equal to 0.
 *
 *      Return the length of the longest nice subarray.
 *
 *         • A subarray is a contiguous part of an array.
 *         • Note that subarrays of length 1 are always considered nice.
 *   Ex.
 *      Input : nums = [1,3,8,48,10]
 *      Output: 3
 *      Explanation: The longest nice subarray is [3,8,48]. This subarray satisfies the conditions:
 *           - 3 AND 8 = 0.
 *           - 3 AND 48 = 0.
 *           - 8 AND 48 = 0.
 *           It can be proven that no longer a nice subarray can be obtained, so we return 3.
 */
import java.util.Scanner;

public class LeetCode_2401_Longest_Nice_Subarray {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Size: ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        System.out.println("Elements: ");
        for (int i = 0;i < n;i++)
            arr[i] = sc.nextInt();

        System.out.println(longestNiceSubarray(arr));
    }

    /// Solution
    static int longestNiceSubarray(int...arr) {
        int n = arr.length;
        int ans = 1, total = arr[0];

        int i = 0, j = 1;
        while (j < n){
            while (i < j && (total & arr[j]) != 0)
                total ^= arr[i++];
            total |= arr[j++];
            ans = Math.max(ans, j-i);
        }

        return ans;
    }
}
