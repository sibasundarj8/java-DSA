package LeetCode;/*
 *
 * https://leetcode.com/problems/the-two-sneaky-numbers-of-digitville/
 *
 * # 3289. The Two Sneaky Numbers of Digitville
 *
 *   Q. In the town of Digitville, there was a list of numbers called nums containing integers from 0 to n - 1.
 *      Each number was supposed to appear exactly once in the list, however, two mischievous numbers sneaked in
 *      an additional time, making the list longer than usual.
 *
 *      As the town detective, your task is to find these two sneaky numbers. Return an array of size two containing
 *      the two numbers (in any order), so peace can return to Digitville.
 *
 *   Ex.
 *      Input : nums = [7,1,5,4,3,4,6,0,9,5,8,2]
 *      Output: [4,5]
 *      Explanation: The numbers 4 and 5 each appear twice in the array.
 *
 *  Constraints:
 *      2 <= n <= 100
 *      nums.length == n + 2
 *      0 <= nums[i] < n
 *      The input is generated such that nums contains exactly two repeated elements.
 */

import java.util.Arrays;
import java.util.Scanner;

public class LeetCode_3289_The_Two_Sneaky_Numbers_of_Digitville {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter array elements: ");
        String[] s = sc.nextLine().split(" ");

        int n = s.length;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(s[i]);

        String ans = Arrays.toString(getSneakyNumbers(arr));
        System.out.println("Repeated numbers: " + ans);
    }

    /// Solution
    static int[] getSneakyNumbers(int[] nums) {
        int n = nums.length;
        int idx = 0;

        int[] ans = new int[2];
        int[] freq = new int[n - 2];

        for (int i : nums) {
            freq[i]++;
            if (freq[i] == 2) ans[idx++] = i;
        }

        return ans;
    }
}
