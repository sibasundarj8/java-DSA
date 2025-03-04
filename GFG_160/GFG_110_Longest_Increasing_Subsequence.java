package GFG_160;/*
 *
 * https://www.geeksforgeeks.org/problems/longest-increasing-subsequence-1587115620/1
 *
 * # Longest Increasing Subsequence
 *
 *   Q. Given an array arr[] of non-negative integers, the task is to find the length of the
 *      Longest Strictly Increasing Subsequence (LIS).
 *
 *      A subsequence is strictly increasing if each element in the subsequence is strictly
 *      less than the next element.
 *    Ex.
 *      Input : arr[] = [0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15]
 *      Output: 6
 *      Explanation: One of the possible longest strictly increasing subsequences is
 *                   [0, 2, 6, 9, 13, 15], which has a length of 6.
 */
import java.util.*;

public class GFG_110_Longest_Increasing_Subsequence {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Size: ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        System.out.println("Elements: ");
        for (int i = 0;i < n;i++)
            arr[i] = sc.nextInt();

        System.out.println(lis(arr));
    }

  
    /// Solution

/// Binary-Search
/// Time complexity : O(ⁿlogⁿ)
/// Space Complexity: O(n)
    static int lis(int[] arr){
        int n = arr.length;
        ArrayList<Integer> list = new ArrayList<>();
        list.add(arr[0]);

        for (int i = 1;i < n;i++){
            int cur = arr[i];
            if (list.get(list.size()-1) < cur) list.add(cur);
            else list.set(binarySearch(list, cur), cur);
        }

        return list.size();
    }
    private static int binarySearch(ArrayList<Integer> list, int tar){
        int i = 0, j = list.size(), ans = 0;
        while (i <= j){
            int mid = i + (j-i)/2;
            int num = list.get(mid);
            if (num >= tar){
                ans = mid;
                j = mid - 1;
            }
            else i = mid + 1;
        }
        return ans;
    }

/// Tabulation method
///  Time complexity: O(n²)
/// Space complexity: O(n)
    /*static int lis (int[] arr){
        int n = arr.length, ans = 1;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        for (int i = 0;i < n;i++){
            int temp = 1;
            for (int j = 0;j < i;j++)
                if (arr[j] < arr[i])
                    temp = Math.max(temp, dp[j]+dp[i]);
            dp[i] = temp;
            ans = Math.max(ans, temp);
        }

        return ans;
    }*/


/// Recursion and memoization
///  Time complexity: O(n²)
/// Space complexity: O(n²)
    /*static int lis(int[] arr) {
        // potd.code.hub
        int n = arr.length;
        int[][] dp = new int[n+1][n+1];
        for (int[] i : dp) Arrays.fill(i, -1);

        return solve(arr, 0, -1, 0, dp);
    }
    static int solve (int[]arr, int idx, int prev, int len, int[][] dp){
        if (idx >= arr.length) return 0;
        if (prev != -1 && dp[idx][prev] != -1) return dp[idx][prev];

        len = solve(arr, idx+1, prev, len, dp);
        if (prev == -1 || arr[idx] > arr[prev])
            len = Math.max(len, 1 + solve(arr, idx + 1, idx, len, dp));

        if (prev != -1) dp[idx][prev] = len;
        return len;
    }*/
}
