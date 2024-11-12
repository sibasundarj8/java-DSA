/*
 *   Q. There is an array arr of heights of stone and Geek is standing at the first stone and can
 *      jump to one of the following: Stone i+1, i+2, ... i+k stone, where k is the maximum number
 *      of steps that can be jumped and cost will be |hi-hj| is incurred, where j is the stone to
 *      land on. Find the minimum possible total cost incurred before the Geek reaches the last stone.
 *    Ex.
 *      Input:  k = 3
 *              arr[]= [10, 30, 40, 50, 20]
 *      Output: 30
 *      Explanation: Geek will follow the path 1->2->5, the total cost would be |10-30| + |30-20| = 30,
 *                   which is minimum.
 */
package GFG;

import java.util.Arrays;
import java.util.Scanner;

public class POTD_Minimal_Cost {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Size :");
        int n = sc.nextInt();

        int[]arr = new int[n];

        System.out.println("Elements :");
        for (int i = 0;i < n;i++)
            arr[i] = sc.nextInt();

        System.out.println("K :");
        int k = sc.nextInt();

        System.out.println(minimizeCost(n, k, arr));
    }
    static int minimizeCost(int n, int k, int[]arr) {
        // potd.code.hub
        int[]dp = new int[n];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 0;i < n;i++){
            for (int j = 1;j <= k;j++){
                if (i+j < n) {
                    int currCost = dp[i] + Math.abs(arr[i] - arr[i + j]);
                    dp[i + j] = Math.min(dp[i + j], currCost);
                }
            }
        }

        return dp[n-1];
    }
}