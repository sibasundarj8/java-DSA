package Sorting;/*
 *
 * https://www.geeksforgeeks.org/problems/shop-in-candy-store1145/1
 *
 * # Shop in Candy Store
 *
 *   Q. In a candy store, there are different types of candies available and prices[i] represent the price of
 *      ith types of candies. You are now provided with an attractive offer.
 *
 *      For every candy you buy from the store, you can get up to k other different candies for free. Find the
 *      minimum and maximum amount of money needed to buy all the candies.
 *
 *      Note: In both cases, you must take the maximum number of free candies possible during each purchase.
 *   Ex.
 *      Input : prices[] = [3, 2, 1, 4]
 *              k = 2
 *      Output: [3, 7]
 *      Explanation: As according to the offer if you buy one candy you can take at most two more for free.
 *                   So in the first case, you buy the candy worth 1 and takes candies worth 3 and 4 for free,
 *                   also you need to buy candy worth 2. So min cost: 1+2 = 3. In the second case, you can buy
 *                   the candy worth 4 and takes candies worth 1 and 2 for free, also you need to buy candy
 *                   worth 3. So max cost: 3+4 = 7.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Sorting_Shop_in_Candy_Store {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the price of candies type: ");
        String[] s = sc.next().split(" ");

        int n = s.length;
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(s[i]);
        }

        System.out.println("Number of candies free with one: ");
        int k = sc.nextInt();

        System.out.println("Minimum & Maximum cost: " + minMaxCandy(arr, k));
    }

    /// Solution
    static ArrayList<Integer> minMaxCandy(int[] prices, int k) {
        // code here
        int n = prices.length;
        int size = n;
        Arrays.sort(prices);

        int min = 0;
        int max = 0;

        for (int i = 0; i < n; i++) {
            min += prices[i];
            max += prices[size - i - 1];
            n -= k;
        }

        ArrayList<Integer> list = new ArrayList<>();
        list.add(min);
        list.add(max);

        return list;
    }
}
