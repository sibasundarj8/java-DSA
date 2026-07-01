package DP;/*
 *
 * https://www.geeksforgeeks.org/problems/max-sum-subarray-by-removing-at-most-one-element/1
 *
 * # Max sum subarray by removing at most one element
 *
 *   Q. Given an array arr[], find the maximum sum of a non-empty subarray. You are allowed to skip at most one element
 *      in the subarray.
 *
 *      Note: After skipping the element, the subarray must still be non-empty.
 *
 *    Ex.
 *      Input : arr[] = [-2, -3, 4, -1, -2, 1, 5, -3]
 *      Output: 9
 *      Explanation: We can get maximum sum subarray by skipping -2 as [4,-1,1,5] sums to 9, which is the maximum
 *                   achievable sum.
 *
 *  Constraints:
 *      1 ≤ arr.size() ≤ 10⁶
 *      -10³ ≤ arr[i] ≤ 10³
 */

import java.util.Scanner;

public class Dynamic_Programming_Max_sum_subarray_by_removing_at_most_one_element {

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

        System.out.println("Maximum sum of a non-empty subarray: ");
        System.out.println(maxSumSubarray(arr));
    }

    /// Solution
/*
⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯-prefix-suffix-+-kadane-⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯
TC : O(n)
SC : O(n)
*/
    static int approach_1(int[] arr) {
        // potd.code.hub
        int n = arr.length;
        int max = arr[0];
        int[] leftSum = new int[n];
        int[] rightSum = new int[n];

        for (int i = 1; i < n; i++) {
            max = Math.max(max, arr[i]);

            // left to right
            leftSum[i] = Math.max(leftSum[i - 1] + arr[i - 1], 0);

            // right to left
            int idx = n - 1 - i;
            rightSum[idx] = Math.max(rightSum[idx + 1] + arr[idx + 1], 0);
        }

        if (max < 0) return max;
        max = 0;

        for (int i = 0; i < n; i++) {
            int sum = leftSum[i] + rightSum[i];
            if (arr[i] > 0) sum += arr[i];
            max = Math.max(max, sum);
        }

        return max;
    }

/*
⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯-bottom-up-2D-dp-⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯
TC : O(n)
SC : O(n)
*/
    static int approach_2(int[] arr) {
        // potd.code.hub
        int n = arr.length;
        int maxSum = arr[0];
        int maxEle = arr[0];
        int[][] dp = new int[n + 1][2];

        // 0 --> No Delete
        // 1 --> One Delete
        for (int i = 1; i <= n; i++) {
            int curr = arr[i - 1];
            maxEle = Math.max(maxEle, curr);

            // cur no_delete = max(prev no_delete + cur, cur)
            dp[i][0] = Math.max(dp[i - 1][0] + curr, 0);

            // cur one_delete = max(curr_delete, prev_delete) => max(prev_no_delete, prev_one_delete + curr)
            dp[i][1] = Math.max(dp[i - 1][0], dp[i - 1][1] + curr);

            // maximize
            maxSum = Math.max(maxSum, Math.max(dp[i][0], dp[i][1]));
        }

        return (maxEle < 0) ? maxEle : maxSum;
    }

/*
⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯-space-optimized-⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯
TC : O(n)
SC : O(1)
*/
    static int maxSumSubarray(int[] arr) {
        // potd.code.hub
        int n = arr.length;
        int maxSum = arr[0];
        int maxEle = arr[0];
        int prevNoDelete = 0;
        int prevOneDelete = 0;

        for (int i = 1; i <= n; i++) {
            int ele = arr[i - 1];
            maxEle = Math.max(maxEle, ele);

            // cur no_delete = max(prev_no_delete + cur, cur)
            int currNoDelete = Math.max(prevNoDelete + ele, 0);

            // cur one_delete = max(curr delete, prev delete) => max(prev_no_delete, prev_one_delete + curr)
            int currOneDelete = Math.max(prevNoDelete, prevOneDelete + ele);

            // maximize
            maxSum = Math.max(maxSum, Math.max(currNoDelete, currOneDelete));

            prevNoDelete = currNoDelete;
            prevOneDelete = currOneDelete;
        }

        // if maxEle is negative then that is our answer.
        return (maxEle < 0) ? maxEle : maxSum;
    }
}
