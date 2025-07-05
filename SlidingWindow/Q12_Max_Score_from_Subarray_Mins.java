package Sliding_Window;/*
 *
 * https://www.geeksforgeeks.org/problems/max-sum-in-sub-arrays0824/1
 * 
 * # Max Score from Subarray Mins
 * 
 *   Q. You are given an array arr[] of integers. Your task is to select any two indices i and j such that i < j. 
 *      From the subarray arr[i...j], find the smallest and second-smallest elements. Add these two numbers to get 
 *      the score of that subarray.
 * 
 *      Your goal is to return the maximum score that can be obtained from any subarray of arr[] with length at 
 *      least 2.
 *    Ex.
 *      Input : arr[] = [4, 3, 5, 1]
 *      Output: 8
 *      Explanation: All subarrays with at least 2 elements and find the two smallest numbers in each:
 *                     [4, 3] → 3 + 4 = 7
 *                     [4, 3, 5] → 3 + 4 = 7
 *                     [4, 3, 5, 1] → 1 + 3 = 4
 *                     [3, 5] → 3 + 5 = 8
 *                     [3, 5, 1] → 1 + 3 = 4
 *                     [5, 1] → 1 + 5 = 6
 *                   Maximum Score is 8.
 */

import java.util.Scanner;

public class Q12_Max_Score_from_Subarray_Mins {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter elements: ");
        String[] s = sc.nextLine().split(" ");
        
        int n = s.length;
        int [] arr = new int[n];
        
        for (int i = 0; i < n; i++) 
            arr[i] = Integer.parseInt(s[i]);

        System.out.println("Maximum Score: " + maxSum(arr));
    }

    /// Solution
    static int maxSum(int[] arr) {
        // potd.code.hub
        int n = arr.length;
        int ans = 0;

        for (int i = 1; i < n; i++)
            ans = Math.max(ans, arr[i] + arr[i-1]);

        return ans;
    }
}
