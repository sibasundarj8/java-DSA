package Deque;/*
 *
 * https://www.geeksforgeeks.org/problems/maximum-subarray-sum--110820/1
 *
 * # Maximum subarray sum 2 (Hard)
 *
 *   Q. You are given an array arr[] of integers and two integers a and b, You have to find the maximum possible
 *      sum of a contiguous subarray whose length is at least a and at most b.
 *    Ex.
 *      Input : arr[] = [-1, 3, -1, -2, 5, 3, -5, 2, 2],
 *              a = 3,
 *              b = 5
 *      Output: 8
 *      Explanation: The subarray [3, -1, -2, 5, 3] has length 5 and sum 8, which is the maximum among all
 *                   subarrays of length between 3 and 5.
 *  Constraints:
 *      1 ≤ arr.size() ≤ 10⁵
 *      -10⁵ ≤ arr[i] ≤ 10⁵
 *      1 ≤ a ≤ b ≤ arr.size()
 */

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class DQ_04_Maximum_subarray_sum_2 {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter elements: ");
        String[] s = sc.nextLine().split(" ");

        int n = s.length;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(s[i]);

        System.out.print("a: ");
        int a = sc.nextInt();

        System.out.print("b: ");
        int b = sc.nextInt();

        System.out.println("Maximum subarray sum of size " + a + " to " + b + ": ");
        System.out.println(maxSubarrSum(arr, a, b));
    }

    /// Solution
/*.............................................Brute-force--(Sliding-window).............................................*/
    static int slidingWindow(int[] arr, int a, int b) {
        int n = arr.length;
        int max = Integer.MIN_VALUE;
        int windowSum = 0;

        // first a-length window
        for (int i = 0; i < a; i++) windowSum += arr[i];

        for (int i = 0; i <= n - a; i++) {      // TC : O(n²)
            if (i > 0) {                        // sliding the current window
                windowSum -= arr[i - 1];
                windowSum += arr[i + a - 1];
            }
            int sum = windowSum;

            for (int j = a; j <= b; j++) {      // expand window from length 'a' up to 'b'
                max = Math.max(max, sum);
                int idx = i + j;
                if (idx >= n) break;
                sum += arr[idx];
            }
        }

        return max;
    }

/*...............................................Brute-Force--(Prefix-Sum)...............................................*/
    static int prefixSum(int[] arr, int a, int b) {
        // potd.code.hub
        int n = arr.length;
        int ans = Integer.MIN_VALUE;
        int[] prefix = new int[n + 1];

        // prefix-sum calculation
        for (int i = 0; i < n; i++)
            prefix[i + 1] = arr[i] + prefix[i];

        // checking for every possible window
        for (int i = 0; i <= n - a; i++) {      // O(n²)
            int max = ans;
            for (int j = a; j <= b; j++) {
                int idx = j + i;
                if (idx > n) break;
                max = Math.max(max, prefix[idx]); // here we are finding the largest prefix sum in O(b - a) time
            }                                     // think how can we get it in O(1), Is it possible ??
            ans = Math.max(ans, max - prefix[i]);
        }

        return ans;
    }

/*.....................................Optimized--(Sliding-Window, Prefix-Sum, Deque)....................................*/
    static int maxSubarrSum(int[] arr, int a, int b) {
        // potd.code.hub
        int n = arr.length;
        int dif = b - a;

        int[] prefix = new int[n];
        int[] windowMax = new int[n];
        Deque<Integer> dq = new LinkedList<>();

        // prefix-sum calculation
        for (int i = 0; i < n; i++)
            prefix[i] = (i > 0) ? arr[i] + prefix[i - 1] : arr[i];

        // updating max for every window of size b - a
        for (int i = n - 1; i >= 0; i--) {
            while (!dq.isEmpty() && prefix[dq.peekFirst()] <= prefix[i]) dq.pollFirst();
            dq.addFirst(i);
            windowMax[i] = prefix[dq.peekLast()];
            if (dq.peekLast() >= i + dif) dq.pollLast();
        }

        // checking for every possible window
        int ans = windowMax[a - 1];
        for (int i = a; i < n; i++) {
            ans = Math.max(ans, windowMax[i] - prefix[i - a]);
        }

        return ans;
    }
}
