package Greedy;/*
 *
 * https://leetcode.com/problems/maximum-element-after-decreasing-and-rearranging/
 *
 * # LC. 1846. Maximum Element After Decreasing and Rearranging
 *
 *   Q. You are given an array of positive integers' arr. Perform some operations (possibly none) on arr so that it
 *      satisfies these conditions:
 *        ◦ The value of the first element in arr must be 1.
 *        ◦ The absolute difference between any 2 adjacent elements must be less than or equal to 1. In other words,
 *          abs(arr[i] - arr[i - 1]) <= 1 for each 'i' where 1 <= i < arr.length (0-indexed). abs(x) is the absolute value
 *          of x.
 *
 *      There are 2 types of operations that you can perform any number of times:
 *        ◦ Decrease the value of any element of arr to a smaller positive integer.
 *        ◦ Rearrange the elements of arr to be in any order.
 *
 *      Return the maximum possible value of an element in arr after performing the operations to satisfy the conditions.
 *
 *    Ex.
 *      Input : arr = [2, 2, 1, 2, 1]
 *      Output: 2
 *      Explanation:
 *              We can satisfy the conditions by rearranging arr so it becomes [1,2,2,2,1].
 *              The largest element in arr is 2.
 *
 *  Constraints:
 *          1 <= arr.length <= 10⁵
 *          1 <= arr[i] <= 10⁹
 */

import java.util.Arrays;
import java.util.Scanner;

public class G15_Maximum_Element_After_Decreasing_and_Rearranging {

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

        System.out.println("Maximum possible element in arr after performing the operations to satisfy the conditions: ");
        System.out.println(maximumElementAfterDecrementingAndRearranging(arr));
    }

    /// Solution
/*
⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯-normal-sorting-⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯
TC : O(n log n)
SC : O(1)
*/
    static int approach_1(int[] arr) {
        Arrays.sort(arr);
        int x = 0;

        for (int ele : arr) {
            if (ele > x) {
                x++;
            }
        }

        return x;
    }

/*
⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯--counting-sort--⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯
TC : O(n)
SC : O(n)
*/
    static int approach_2(int[] arr) {
        int n = arr.length;
        int[] count = new int[n + 1];

        for (int ele : arr) {
            count[Math.min(ele, n)]++;
        }

        int x = 0;

        for (int i = 1; i <= n; i++) {
            x = Math.min(x + count[i], i);
        }

        return x;
    }

/*
⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯-cyclic-sort-⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯
TC : O(n)
SC : O(1)
*/
    static int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            int pos = arr[i] - 1;
            while (0 <= pos && pos < n && arr[pos] != arr[i]) {
                arr[i] ^= arr[pos];
                arr[pos] ^= arr[i];
                arr[i] ^= arr[pos];
                pos = arr[i] - 1;
            }
        }

        int x = 0;

        for (int ele : arr) {
            if (ele > x) {
                x++;
            }
        }

        return x;
    }
}
