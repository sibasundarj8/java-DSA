package Array;/*
 *  https://practice.geeksforgeeks.org/contest/gfg-weekly-185-rated-contest/problems
 *
 * # Array Balancing Cost
 *
 *   Q. You are given an array arr[] of integers of length n. An array is considered as a balanced if:
 *
 *      • Elements at odd indices (I-based indexing) are odd integers.
 *      • Elements at even indices (I-based indexing) are even integers.
 *
 *    To achieve a balanced array, you are allowed to perform the following operation any number
 *    of times:
 *
 *      • Select any two indices (i, j) in the array and swap their elements arr[i] and arr[j]
 *        with cost arr[i]+arr[j].
 *
 *    Your task is to find minimum cost possible to achieve a balanced array from given array if is
 *    possible, otherwise return -1.
 *  Ex.
 *      Input : arr[] = [4, 3, 2, 1]
 *      Output: 10
 *      Explanation: Swap becomes balanced, 4 with 3 and the total 2 with cost is 1. After these swaps,
 *                  the array 7+3 - 10.
 */

import java.util.Scanner;

public class Array_Balancing_Cost {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Size: ");
        int n = sc.nextInt();
        
        int[]arr = new int[n];

        System.out.println("Elements: ");
        for (int i = 0;i < n;i++){
            arr[i] = sc.nextInt();
        }

        System.out.println(minCost(arr));
    }

    /// Solution
    static int minCost(int[]arr) {
        // potd.ode.hub
        int n = arr.length;
        int count = 0;
        for (int i : arr) if (i % 2 == 0) count++;
        if (count != n/2) return -1;

        int ans = 0;
        int i = 0;
        int j = 1;
        while (i < n && j < n){
            while (i < n && arr[i]%2 == 1)i += 2;
            while (j < n && arr[j]%2 == 0)j += 2;
            if (i < n && j < n){
                int temp = arr[i];
                arr[i] =arr[j];
                arr[j] = temp;
                ans += arr[i] + arr[j];
            }
        }
        return ans;
    }
}
