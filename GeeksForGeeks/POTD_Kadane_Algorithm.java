/*
 *    Q. Given an integer array arr[]. Find the contiguous subArray(containing at least one number) that has
 *       the maximum sum and return its sum.
 *      Examples:
 *              Input: arr[] = [1, 2, 3, -2, 5]
 *              Output: 9
 *              Explanation: Max subArray sum is 9 of elements (1, 2, 3, -2, 5) which is a contiguous
 *                           subArray.
 */
package GFG;

import java.util.Scanner;

public class POTD_Kadane_Algorithm {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Size :");
        int n = sc.nextInt();
        int[]arr = new int[n];
        System.out.println("Elements :");
        for (int i = 0;i < n;i++) arr[i] = sc.nextInt();

        System.out.println("Output :");
        System.out.println(maxSubArraySum(arr));
    }
    static long maxSubArraySum(int[] arr) {
        // potd.code.hub
        int sum = 0;
        int max = Integer.MIN_VALUE;
        for (int i : arr){
            sum += i;
            max = Math.max(max, sum);
            if (sum < 0)sum = 0;
        }
        return max;
    }
}
