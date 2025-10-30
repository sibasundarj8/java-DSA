package LeetCode;/*
 *
 * https://leetcode.com/problems/minimum-number-of-increments-on-subarrays-to-form-a-target-array/
 *
 * # 1526. Minimum Number of Increments on Subarrays to Form a Target Array
 *
 *   Q. You are given an integer array target. You have an integer array initial of the same size as target with all
 *      elements initially zeros.
 *      In one operation you can choose any subarray from initial and increment each value by one.
 *      Return the minimum number of operations to form a target array from initial.
 *      The test cases are generated so that the answer fits in a 32-bit integer.
 *
 *   Ex.
 *      Input : target = [3, 1, 5, 4, 2]
 *      Output: 7
 *      Explanation:   [0, 0, 0, 0, 0]
 *                  -> [1, 1, 1, 1, 1]
 *                  -> [2, 1, 1, 1, 1]
 *                  -> [3, 1, 1, 1, 1]
 *                  -> [3, 1, 2, 2, 2]
 *                  -> [3, 1, 3, 3, 2]
 *                  -> [3, 1, 4, 4, 2]
 *                  -> [3, 1, 5, 4, 2].
 *
 *  Constraints:
 *      1 <= target.length <= 105
 *      1 <= target[i] <= 105
 */

import java.util.Scanner;
import java.util.Stack;

public class LeetCode_1526_Minimum_Number_of_Increments_on_Subarrays_to_Form_a_Target_Array {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter target-array Elements: ");
        String[] s = sc.nextLine().split(" ");

        int n = s.length;
        int[] target = new int[n];
        for (int i = 0; i < n; i++) target[i] = Integer.parseInt(s[i]);

        System.out.println("min number of operation to make target: " + minNumberOperations(target));
    }

    /// Solution
/*......................................................Using-Stack......................................................*/
    static int minNumberOperations(int[] target) {
        int n = target.length;
        int ans = 0;
        int[] nse = nextSmallerEle(target);     // next strictly smaller element.
        int[] pse = prevSmallerEle(target);     // previous smaller or equal element.

        for (int i = 0; i < n; i++) {
            int need = target[i] - Math.max(nse[i], pse[i]);
            ans += need;
        }

        return ans;
    }

    // getting next strictly smaller element using stack
    private static int[] nextSmallerEle(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() >= arr[i]) stack.pop();
            ans[i] = (stack.isEmpty()) ? 0 : stack.peek();
            stack.push(arr[i]);
        }

        return ans;
    }

    // getting previous smaller or equal element using stack
    private static int[] prevSmallerEle(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && stack.peek() > arr[i]) stack.pop();
            ans[i] = (stack.isEmpty()) ? 0 : stack.peek();
            stack.push(arr[i]);
        }

        return ans;
    }
/*.....................................................without-stack.....................................................*/
    static int easy(int[] arr) {
        int n = arr.length;
        int min = arr[0];

        for(int i = 1; i < n; i++)
            min += Math.max((arr[i] - arr[i - 1]), 0);

        return min;
    }
}
