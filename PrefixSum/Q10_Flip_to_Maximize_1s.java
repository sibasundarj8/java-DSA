package PrefixSum;/*
 *
 * https://www.geeksforgeeks.org/problems/flip-bits0240/1
 *
 * # Flip to Maximize 1s
 *
 *    Q. Given an array arr[] consisting of 0’s and 1’s. A flip operation involves changing all 0's to 1's and all 1's to 0's
 *       within a contiguous subarray. Formally, select a range (l, r) in the array arr[], such that (0 ≤ l ≤ r < n) holds and
 *       flip the elements in this range.
 *
 *      Return the maximum number of 1's you can get in the array after doing at most 1 flip operation.
 *
 *    Ex.
 *      Input : arr[] = [1, 0, 0, 1, 0, 0, 1]
 *      Output: 6
 *      Explanation: By flipping the subarray from index 1 to 5, the array becomes [1, 1, 1, 0, 1, 1, 1]. This results in a
 *                   total of 6 ones, which is the maximum possible after at most one flip.
 *
 *  Constraints:
 *          1 ≤ n ≤ 10⁶
 *          0 ≤ arr[i] ≤ 1
 */

import java.util.Scanner;

public class Q10_Flip_to_Maximize_1s {

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

        System.out.println("Maximum number of 1's you can get in the array after doing at most 1 flip: ");
        System.out.println(maxOnes(arr));
    }

    /// Solution
    static int maxOnes(int[] arr) {
        // pod.code.hub
        int total_1 = 0;
        int currGain = 0;
        int maxGain = 0;

        for (int val : arr) {
            if (val == 1) {
                total_1++;
                currGain--;
            } else {
                currGain++;
            }

            currGain = Math.max(currGain, 0);
            maxGain = Math.max(maxGain, currGain);
        }

        return total_1 + maxGain;
    }
}
