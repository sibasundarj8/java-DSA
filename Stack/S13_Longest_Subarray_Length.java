package Stack;/*
 *
 * https://www.geeksforgeeks.org/problems/longest-subarray-length--202010/1
 *
 * # Longest Subarray Length
 *
 *   Q. You are given an array of integers arr[]. Your task is to find the length of the longest subarray
 *      such that all the elements of the subarray are smaller than or equal to the length of the subarray.
 *    Ex.
 *      Input : arr[] = [1, 2, 3]
 *      Output: 3
 *      Explanation: The longest subarray is the entire array itself, which has a length of 3. All elements
 *                   in the subarray are less than or equal to 3.
 *   Constraints:
 *      1 ≤ arr.size() ≤ 10⁵
 *      1 ≤ arr[i] ≤ 10⁹
 */

import java.util.Scanner;
import java.util.Stack;

public class S13_Longest_Subarray_Length {

    /// main Method
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter array elements: ");
        String[] s = sc.nextLine().split(" ");

        int n = s.length;
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(s[i]);

        System.out.println("Longest sub-array length: " + longestSubarray(arr));
    }

    /// Solution
    static int longestSubarray(int[] arr) {
        // potd.code.hub
        int n = arr.length;
        int ans = 0;

        int[] nge = nextGreater(arr);
        int[] pge = prevGreater(arr);

        for (int i = 0; i < n; i++) {
            int len = nge[i] - pge[i] - 1;
            if (len >= arr[i] && len > ans) ans = len;
        }

        return ans;
    }

    // Next greater element
    private static int[] nextGreater(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];
        Stack<Integer> stack = new Stack<>();

        ans[n - 1] = n;
        stack.push(n - 1);

        for (int i = n - 2; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] <= arr[i]) stack.pop();
            ans[i] = (stack.isEmpty()) ? n : stack.peek();
            stack.push(i);
        }

        return ans;
    }

    // previous greater element
    private static int[] prevGreater(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];
        Stack<Integer> stack = new Stack<>();

        ans[0] = -1;
        stack.push(0);

        for (int i = 1; i < n; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] <= arr[i]) stack.pop();
            ans[i] = (stack.isEmpty()) ? -1 : stack.peek();
            stack.push(i);
        }

        return ans;
    }
}
