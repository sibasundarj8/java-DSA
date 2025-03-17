package GFG_160;/*
 *
 * https://www.geeksforgeeks.org/problems/subset-sum-problem-1611555638/1
 *
 * # Subset Sum Problem
 *
 *   Q. Given an array of positive integers arr[] and a value sum, determine if there is a subset of arr[]
 *      with the sum equal to the given sum.
 *    Ex.
 *      Input : arr[] = [3, 34, 4, 12, 5, 2]
 *              sum = 9
 *      Output: true
 *      Explanation: Here there exists a subset with target sum = 9, 4+3+2 = 9.
 */

import java.util.Scanner;

public class GFG_123_Subset_Sum_Problem {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Size: ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        System.out.println("Elements: ");
        for (int i = 0;i < n;i++)
            arr[i] = sc.nextInt();

        System.out.println("Target: ");
        int sum = sc.nextInt();

        System.out.println(isSubsetSum(arr, sum));
    }

    /// Solution
    static Boolean isSubsetSum(int[] arr, int sum) {
        // potd.code.hub
        int n = arr.length;
        return isPos(arr, n-1, sum);
    }
    private static boolean isPos(int[]arr, int idx, int target){
        // base Case
        System.out.println("Hello");
        if (target == 0) return true;
        if (idx < 0 || target < 0) return false;

        return isPos(arr, idx-1, target-arr[idx]) || isPos(arr, idx-1, target);
    }
}
