package Array;/*
 *
 * https://leetcode.com/problems/separate-the-digits-in-an-array/
 *
 * # 2553. Separate the Digits in an Array
 *
 *   Q. Given an array of positive integers nums, return an array answer that consists of the digits of each integer in nums
 *      after separating them in the same order they appear in nums.
 *
 *      To separate the digits of an integer is to get all the digits it has in the same order.
 *
 *      For example, for the integer 10921, the separation of its digits is [1,0,9,2,1].
 *
 *    Ex.
 *      Input : nums = [13, 25, 83, 77]
 *      Output: [1, 3, 2, 5, 8, 3, 7, 7]
 *      Explanation:
 *              - The separation of 13 is [1,3].
 *              - The separation of 25 is [2,5].
 *              - The separation of 83 is [8,3].
 *              - The separation of 77 is [7,7].
 *              answer = [1,3,2,5,8,3,7,7]. Note that answer contains the separations in the same order.
 *
 *  Constraints:
 *          1 <= nums.length <= 1000
 *          1 <= nums[i] <= 10⁵
 */

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Array_Separate_the_Digits_in_an_Array {

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

        System.out.println("All the digits in order: ");
        System.out.println(Arrays.toString(separateDigits(arr)));
    }

    /// Solution
/*
-------------------------------------------------------Approach-1-------------------------------------------------------
Time: O(d)
Space: O(d)
*/
    static int[] approach_1(int[] nums) {
        StringBuilder sb = new StringBuilder();

        for (int ele : nums) {
            sb.append(ele);
        }

        String[] d = sb.toString().split("");

        int n = d.length;
        int[] ans = new int[n];

        for (int i = 0; i < n; i++) {
            ans[i] = Integer.parseInt(d[i]);
        }

        return ans;
    }

/*
-------------------------------------------------------Approach-2-------------------------------------------------------
Time: O(d)
Space: O(d)
*/
    static int[] approach_2(int[] nums) {
        int n = nums.length;
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int i = n - 1; i >= 0; i--) {
            int num = nums[i];

            while (num > 0) {
                int dig = num % 10;
                stack.push(dig);
                num /= 10;
            }
        }

        n = stack.size();
        int[] ans = new int[n];

        for (int i = 0; i < n; i++) {
            ans[i] = stack.pop();
        }

        return ans;
    }

/*
-------------------------------------------------------Approach-3-------------------------------------------------------
Time: O(d)
Space: O(d)
*/
    static int[] approach_4(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();

        for (int ele : nums) {
            addDigits(ele, list);
        }

        int n = list.size();
        int[] res = new int[n];

        for (int i = 0; i < n; i++) {
            res[i] = list.get(i);
        }

        return res;
    }

    private static void addDigits(int num, ArrayList<Integer> list) {
        // base case
        if (num == 0) return;

        // recursive case
        addDigits(num / 10, list);

        // self work
        list.add(num % 10);
    }

/*
-------------------------------------------------------Approach-4-------------------------------------------------------
Time: O(d)
Space: O(1)
*/
    static int[] separateDigits(int[] nums) {
        int len = 0;
        int n = nums.length;

        for (int ele : nums) {
            while (ele != 0) {
                ele /= 10;
                len++;
            }
        }

        int[] res = new int[len];
        int idx = len - 1;

        for (int i = n - 1; i >= 0; i--) {
            int ele = nums[i];

            while (ele != 0) {
                res[idx--] = ele % 10;
                ele /= 10;
            }
        }

        return res;
    }
}
