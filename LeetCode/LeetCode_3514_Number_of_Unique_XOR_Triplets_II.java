package LeetCode;/*
 *
 * https://leetcode.com/problems/number-of-unique-xor-triplets-ii/
 *
 * # LC. 3514. Number of Unique XOR Triplets II
 *
 *   Q. You are given an integer array nums.
 *
 *      An XOR triplet is defined as the XOR of three elements nums[i] XOR nums[j] XOR nums[k] where i <= j <= k.
 *
 *      Return the number of unique XOR triplet values from all possible triplets (i, j, k).
 *
 *    Ex.
 *      Input : nums = [6,7,8,9]
 *      Output: 4
 *      Explanation:
 *              The possible XOR triplet values are {6, 7, 8, 9}. Thus, the output is 4.
 *
 *  Constraints:
 *       ◦ 1 <= nums.length <= 1500
 *       ◦ 1 <= nums[i] <= 1500
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class LeetCode_3514_Number_of_Unique_XOR_Triplets_II {

    /// main Method
    public static void main(String[] args) throws IOException {
        System.out.println("Enter the elements of the array: ");
        StringTokenizer st = new StringTokenizer(new BufferedReader(new InputStreamReader(System.in)).readLine().trim());

        int n = st.countTokens();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println("Number of unique XOR triplet values: ");
        System.out.println(uniqueXorTriplets(nums));
    }

    /// Solution
    static int uniqueXorTriplets(int[] nums) {
        int n = nums.length;
        int m = 0;
        int max = 0;

        for (int num : nums) {
            m |= num;
            max = Math.max(max, num);
        }

        m++;
        int count = 0;
        boolean[] seenDuplex = new boolean[m];
        boolean[] seenTriplex = new boolean[m];

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int xor = nums[i] ^ nums[j];
                if (!seenDuplex[xor]) {
                    seenDuplex[xor] = true;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            if (seenDuplex[i]) {
                for (int val : nums) {
                    int xor = i ^ val;
                    if (!seenTriplex[xor]) {
                        seenTriplex[xor] = true;
                        count++;
                    }
                }
            }
        }

        return count;
    }
}
