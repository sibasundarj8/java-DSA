package GFG_160;/*
 *
 * https://www.geeksforgeeks.org/problems/aggressive-cows/0
 *
 * # Aggressive Cows
 *
 *   Q. You are given an array with unique elements of stalls[], which denote the position of a stall.
 *      You are also given an integer k which denotes the number of aggressive cows. Your task is to
 *      assign stalls to k cows such that the minimum distance between any two of them is the maximum
 *      possible.
 *    Ex.
 *      Input : stalls[] = [10, 1, 2, 7, 5]
 *              k = 3
 *      Output: 4
 *      Explanation: The first cow can be placed at stalls[0], the second cow can be placed at
 *                   stalls[1] and the third cow can be placed at stalls[4]. The minimum distance
 *                   between cows, in this case, is 4, which also is the largest among all possible
 *                   ways.
 */

import java.util.Arrays;
import java.util.Scanner;

public class GFG_33_Aggressive_Cows {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Size: ");
        int n = sc.nextInt();

        int[]stalls = new int[n];

        System.out.println("Enter position of stalls: ");
        for (int i = 0;i < n;i++){
            stalls[i] = sc.nextInt();
        }

        System.out.println("Number of Aggressive: ");
        int k = sc.nextInt();

        System.out.println(aggressiveCows(stalls, k));
    }

    /// Solution
    static int aggressiveCows(int[]stalls, int k) {
        // potd.code.hub
        int n = stalls.length;
        Arrays.sort(stalls);

        int i = 0, j = stalls[n-1] - stalls[0];
        while (i <= j) {
            int mid = i + (j-i)/2;
            if (canWePlace(stalls, n, k, mid)) i = mid+1;
            else j = mid-1;
        }

        return j;
    }
    private static boolean canWePlace(int[]arr, int n, int k, int dist){
        int count = 1;
        int last = arr[0];
        for (int i = 1;i < n;i++) {
            if (arr[i] - last >= dist) {
                count++;
                last = arr[i];
            }
        }
        return count >= k;
    }
}
