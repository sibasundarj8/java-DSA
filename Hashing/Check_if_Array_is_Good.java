package Hashing;/*
 *
 * https://leetcode.com/problems/check-if-array-is-good/
 *
 * # 2784. Check if Array is Good
 *
 *   Q. You are given an integer array nums. We consider an array good if it is a permutation of an array base[n].
 *
 *      base[n] = [1, 2, ..., n - 1, n, n] (in other words, it is an array of length n + 1 which contains 1 to n - 1
 *      exactly once, plus two occurrences of n). For example, base[1] = [1, 1] and base[3] = [1, 2, 3, 3].
 *
 *      Return true if the given array is good, otherwise return false.
 *
 *      Note: A permutation of integers represents an arrangement of these numbers.
 *
 *    Ex.
 *      Input :  nums = [1, 3, 3, 2]
 *      Output: true
 *      Explanation: Since the maximum element of the array is 3, the only candidate n for which this array could be a
 *                   permutation of base[n], is n = 3. It can be seen that nums is a permutation of base[3] = [1, 2, 3, 3]
 *                   (by swapping the second and fourth elements in nums, we reach base[3]). Therefore, the answer is true.
 *
 *  Constraints:
 *          1 <= nums.length <= 100
 *          1 <= num[i] <= 200
 */

import java.util.Scanner;

public class Check_if_Array_is_Good {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter array elements: ");
        String[] s = sc.nextLine().split(" ");

        int n = s.length;
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(s[i]);

            if (arr[i] < 1 || arr[i] > 200) {
                throw new IllegalArgumentException("Array element " + arr[i] + " is invalid");
            }
        }

        System.out.print("Good array: ");
        System.out.println(isGood(arr));
    }

    /// Solution
    static boolean isGood(int[] nums) {
        int n = nums.length;

        for (int ele : nums) {
            if (ele < 1 || ele >= n) {
                return false;
            }
        }

        for (int i = 0; i < n; i++) {
            int curr = nums[i] % n;
            nums[curr - 1] += n;
        }

        for (int i = 0; i < n - 2; i++) {
            if (nums[i] / n != 1) return false;
        }

        return nums[n - 2] / n == 2;
    }
}
