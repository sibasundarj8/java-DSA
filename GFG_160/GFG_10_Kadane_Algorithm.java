package GFG_160;/*
 * https://www.geeksforgeeks.org/problems/kadanes-algorithm-1587115620/1
 *
 * # Kadane's Algorithm
 *
 *   Q. Given an integer array arr[]. You need to find the maximum sum of a sub-array.
 *    Ex.
 *      Input : arr[] = [2, 3, -8, 7, -1, 2, 3]
 *      Output: 11
 *      Explanation: The sub-array {7, -1, 2, 3} has the largest sum 11.
 */
import java.util.Scanner;

public class GFG_10_Kadane_Algorithm {

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

        System.out.println(maxSubarraySum(arr));
    }

    /// Solution
    static int maxSubarraySum(int[] arr) {
        // potd.code.hub
        int sum = 0;
        int ans = Integer.MIN_VALUE;

        for (int i : arr){
            sum += i;
            ans = Math.max(ans, sum);
            if (sum < 0) sum = 0;
        }

        return ans;
    }
}
