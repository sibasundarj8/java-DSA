package LeetCode;/*
 *
 * https://leetcode.com/problems/number-of-unique-xor-triplets-i/
 *
 * # LC. 3513. Number of Unique XOR Triplets I
 *
 *   Q. You are given an integer array nums of length n, where nums is a permutation of the numbers in the range [1, n].
 *
 *      An "XOR triplet" is defined as the XOR of three elements nums[i] XOR nums[j] XOR nums[k] where i <= j <= k.
 *
 *      Return the number of unique XOR triplet values from all possible triplets (i, j, k).
 *
 *    Ex.
 *      Input : nums = [3, 1, 2]
 *      Output: 4
 *      Explanation:
 *              The possible XOR triplet values include:
 *                ◦ (0, 0, 0) → 3 XOR 3 XOR 3 = 3
 *                ◦ (0, 0, 1) → 3 XOR 3 XOR 1 = 1
 *                ◦ (0, 0, 2) → 3 XOR 3 XOR 2 = 2
 *                ◦ (0, 1, 2) → 3 XOR 1 XOR 2 = 0
 *
 *              The unique XOR values are {0, 1, 2, 3}, so the output is 4.
 *
 *  Constraints:
 *        ◦ 1 <= n == nums.length <= 10⁵
 *        ◦ 1 <= nums[i] <= n
 *        ◦ nums is a permutation of integers from 1 to n.
 */

import java.util.Scanner;

public class LeetCode_3513_Number_of_Unique_XOR_Triplets_I {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter array elements: (permutation of 1 to n)");
        String[] s = sc.nextLine().split(" ");

        int n = s.length;
        int[] arr = new int[n];
        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            int ele = Integer.parseInt(s[i]);

            if (ele < 1 || ele > n) throw new IllegalArgumentException("Elements must be in range [1 - N]");
            if (visited[ele - 1]) throw new IllegalArgumentException("Elements must be unique");

            arr[i] = ele;
            visited[ele - 1] = true;
        }

        System.out.println("Number of unique XOR triplet values: ");
        System.out.println(uniqueXorTriplets(arr));
    }

    /// Solution
    static int uniqueXorTriplets(int[] nums) {
        int n = nums.length;
        if (n <= 2) return n;

        int msb = 31;
        while ((n & (1 << msb)) == 0) {
            msb--;
        }

        return 1 << (msb + 1);
    }
}
