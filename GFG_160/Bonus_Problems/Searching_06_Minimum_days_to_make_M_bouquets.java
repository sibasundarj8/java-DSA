package GFG_160.Bonus_Problems;/*
 *
 * https://www.geeksforgeeks.org/problems/minimum-days-to-make-m-bouquets/1
 *
 * # Minimum days to make M bouquets
 *
 *   Q. You have a row of flowers, where each flower blooms after a specific day. The array arr represents
 *      the blooming schedule: arr[i] is the day the flower at position 'i' will bloom. To create a bouquet,
 *      you need to collect k adjacent bloomed flowers. Each flower can only be used in one bouquet.
 *
 *      Your goal is to find the minimum number of days required to make exactly m bouquets. If it is not
 *      possible to make m bouquets with the given arrangement, return -1.
 *    Ex.
 *      Input : m = 3
 *              k = 2
 *              arr[] = [3, 4, 2, 7, 13, 8, 5]
 *      Output: 8
 *      Explanation: We need 3 bouquets and each bouquet should have 2 flowers.
 *                   After day 8: [x, x, x, x, _, x, x], we can make first bouquet from the first 2 flowers,
 *                   second bouquet from the next 2 flowers and the third bouquet from the last 2 flowers.
 */

import java.util.Scanner;

public class Searching_06_Minimum_days_to_make_M_bouquets {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Number of Flowers: ");
        int n = sc.nextInt();

        int[]arr = new int[n];

        System.out.println("Day of blooming of i-th flower: ");
        for (int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }

        System.out.println("Required Bouquets: ");
        int m = sc.nextInt();

        System.out.println("Number of flower needed to make a Bouquet: ");
        int k = sc.nextInt();

        System.out.println(minDaysBloom(m, k, arr));
    }

    /// Solution
    static int minDaysBloom(int m, int k, int[] arr) {
        // potd.code.hub
        int n = arr.length;
        if (m*k > n) return -1;
        int i = Integer.MAX_VALUE;
        int j = Integer.MIN_VALUE;
        for (int e : arr){
            i = Math.min(i, e);
            j = Math.max(j, e);
        }
        while (i <= j){
            int mid = i + (j-i)/2;
            if (checkPossible(arr, m, k, mid)) j = mid-1;
            else i = mid+1;
        }

        return i;
    }
    private static boolean checkPossible(int[]arr, int m, int k, int day){
        int count = 0;
        for (int i : arr){
            if (i <= day){
                count++;
                if (count == k) {
                    count = 0;
                    m--;
                }
            }
            else count = 0;
        }
        return m <= 0;
    }
}
