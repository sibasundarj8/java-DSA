package Math_;/*
 *
 * https://www.geeksforgeeks.org/problems/max-sum-in-the-configuration/1
 *
 * # Max sum in the configuration
 *
 *   Q. Given an integer array arr[]. Find the maximum value of the sum of i*arr[i] for all 0 ≤ i ≤ arr.size()-1. The only
 *      operation allowed is to rotate(clockwise or counterclockwise) the array any number of times.
 *    Ex.
 *      Input : arr[] = [3, 1, 2, 8]
 *      Output: 29
 *      Explanation: Out of all the possible configurations by rotating the elements: arr[] = [3, 1, 2, 8] here (3*0) +
 *                   (1*1) + (2*2) + (8*3) = 29 is maximum.
 *
 *  Constraints:
 *          1 ≤ arr.size() ≤ 10⁴
 *          1 ≤ arr[i] ≤ 20
 */

import java.util.Scanner;

public class Math_Max_sum_in_the_configuration {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter elements of the array");
        String[] s = sc.nextLine().split(" ");

        int n = s.length;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(s[i]);
        }

        System.out.println("Max sum in the configuration: " + maxSum(arr));
    }

    /// Solution
    static int maxSum(int[] arr) {
        // potd.code.hub
        int n = arr.length;
        int currSumConfiguration = 0; // value of the configuration
        int currFrame = 0; // elements which contributing in the configuration.

        // getting the initial configuration sum & current frame sum
        for (int i = 1; i < n; i++) {
            currSumConfiguration += (arr[i] * i);
            currFrame += arr[i];
        }

        // it gonna store the final answer.
        int maxSumConfiguration = currSumConfiguration;

        // calculating the next configurations according to rotation
        for (int outIndex = n - 1; outIndex >= 0; outIndex--) {
            int inIndex = (outIndex + 1) % n;

            // next frame -> means after rotation which elements gonna contribute
            currFrame -= arr[outIndex];
            currFrame += arr[inIndex];

            // Calculating the configuration for x th rotation (anti-clockwise) -> removing the last element contribution
            // completely and increasing the frequency of every element by 1
            currSumConfiguration -= (arr[outIndex] * (n - 1));
            currSumConfiguration += currFrame;

            maxSumConfiguration = Math.max(maxSumConfiguration, currSumConfiguration);
        }

        return maxSumConfiguration;
    }
}
