package Sliding_Window;/*
 *
 * https://www.geeksforgeeks.org/problems/coin-piles5152/1
 *
 * # Coin Piles
 *
 *   Q. You are given an array arr[] of integers, where each element represents the number of coins
 *      in a pile. You are also given an integer k.
 *
 *      Your task is to remove the minimum number of coins such that the absolute difference between
 *      the number of coins in any two remaining piles is at most k.
 *
 *      Note: You can also remove a pile by removing all the coins of that pile.
 *    Ex.
 *      Input : arr[] = [1, 5, 1, 2, 5, 1]
 *              k = 3
 *      Output : 2
 *      Explanation: If we remove one coin each from both the piles containing 5 coins, then for any
 *                   two piles the absolute difference in the number of coins is <= 3.
 */

import java.util.Arrays;
import java.util.Scanner;

public class Q07_Coin_Piles {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Elements (number of coins in Ith pile): ");
        String[] s = sc.nextLine().split(" ");

        int n = s.length;
        int[] coins = new int[n];

        for (int i = 0; i < n; i++) {
            coins[i] = Integer.parseInt(s[i]);
        }

        System.out.println("K: ");
        int k = sc.nextInt();

        System.out.println("Minimum coin need to remove to balance: " + minimumCoins(coins, k));
    }

    /// Solution
/*----------------------------------------------Prefix-Sum & Binary-Search----------------------------------------------*/
// TC : O(n log n)
// SC : O(n)
    static int minimumCoins2(int[] arr, int k) {
        // potd.code.hub
        int n = arr.length;
        int totalCoin = 0;
        int[] prefix = new int[n];
        int ans = Integer.MAX_VALUE;

        Arrays.sort(arr);

        for (int i = 0; i < n; i++) {
            totalCoin += arr[i];
            prefix[i] = totalCoin;
        }

        for (int i = 0; i < n; i++) {

            int range = arr[i] + k;
            int idx = lowerBound(arr, range + 1, i, n - 1);
            int removedPile = (i > 0) ? prefix[i - 1] : 0;
            int remove = totalCoin - (prefix[idx - 1] + (n - idx) * range) + removedPile;
            ans = Math.min(ans, remove);
        }

        return ans;
    }

    private static int lowerBound(int[] arr, int target, int i, int j) {
        int ans = j + 1;
        while (i <= j) {
            int mid = i + (j - i) / 2;
            if (arr[mid] < target) i = mid + 1;
            else {
                ans = mid;
                j = mid - 1;
            }
        }
        return ans;
    }

/*----------------------------------------------------Sliding-Window----------------------------------------------------*/
// TC : O(n log n)
// SC : O(n)
    static int minimumCoins(int[] arr, int k) {
        // potd.code.hub
        int n = arr.length, ans = Integer.MAX_VALUE, totalCoin = 0;

        Arrays.sort(arr);

        for (int coins : arr) 
            totalCoin += coins;

        int j = 0, windowCoin = 0;

        for (int coins : arr) {
            int range = coins + k;

            while (j < n && arr[j] <= range)
                windowCoin += arr[j++];
    
            int remove = totalCoin - (windowCoin + (n - j) * range);
            ans = Math.min(ans, remove);
            windowCoin -= coins;
        }

        return ans;
    }
}
