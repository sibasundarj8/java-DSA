package GFG_160;/*
 * https://www.geeksforgeeks.org/problems/max-circular-subarray-sum-1587115620/1
 *
 * # Max Circular SubArray Sum
 *
 *   Q. Given an array of integers arr[] in a circular fashion. Find the maximum sub-array sum that we
 *      can get if we assume the array to be circular.
 *    Ex.
 *      Input : arr[] = [10, -3, -4, 7, 6, 5, -4, -1]
 *      Output: 23
 *      Explanation: Maximum sum of the circular sub-array is 23. The sub-array is [7, 6, 5, -4, -1, 10].
 */
import java.util.Scanner;

public class GFG_12_Max_Circular_SubArray_Sum {

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

        System.out.println(circularSubArraySum(arr));
    }

    /// Solution
    static int circularSubArraySum(int[]arr) {
        // potd.code.hub
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int total = 0;
        int maxSum = 0;
        int minSum = 0;

        for (int i : arr) {
            total += i;
            maxSum += i;
            minSum += i;
            max = Math.max(max, maxSum);
            min = Math.min(min, minSum);
            if (maxSum < 0) maxSum = 0;
            if (minSum > 0) minSum = 0;
        }

        return Math.max(max, (total-min));
    }
}
