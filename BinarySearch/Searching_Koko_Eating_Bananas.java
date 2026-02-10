package BinarySearch;/*
 *
 * https://www.geeksforgeeks.org/problems/koko-eating-bananas/1
 *
 * # Koko Eating Bananas
 *
 *   Q. Koko is given an array arr[], where each element represents a pile of bananas. She has exactly k hours to eat all
 *      the bananas.
 *
 *      Each hour, Koko can choose one pile and eat up to s bananas from it.
 *
 *      If the pile has at-least s bananas, she eats exactly s bananas.
 *      If the pile has fewer than s bananas, she eats the entire pile in that hour.
 *
 *      Koko can only eat from one pile per hour.
 *
 *      Your task is to find the minimum value of s (bananas per hour) such that Koko can finish all the piles within k
 *      hours.
 *
 *    Ex.
 *      Input : arr[] = [5, 10, 3], k = 4
 *      Output: 5
 *      Explanation: If Koko eats at the rate of 5 bananas per hour:
 *                   First pile of 5 bananas will be finished in 1 hour.
 *                   Second pile of 10 bananas will be finished in 2 hours.
 *                   Third pile of 3 bananas will be finished in 1 hour.
 *                   Therefore, Koko can finish all piles of bananas in 1 + 2 + 1 = 4 hours.
 *
 *  Constraint:
 *          1 ≤ arr.size() ≤ k ≤ 10⁶
 *          1 ≤ arr[i] ≤ 10⁶
 */

import java.util.Scanner;

public class Searching_Koko_Eating_Bananas {

    ///  main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter array elements: ");
        String[] s = sc.nextLine().split(" ");

        int n = s.length;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(s[i]);
        }

        System.out.print("K : ");
        int k = sc.nextInt();

        System.out.println("Minimum value of s (bananas per hour): ");
        System.out.println(kokoEat(arr, k));
    }

    /// Solution
    static int kokoEat(int[] arr, int k) {
        // potd.code.hub
        int low = 1;
        int high = (int) 1e6;
        int s = Integer.MIN_VALUE;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (canEatable(arr, mid, k)) {
                s = mid;
                high = mid - 1;
            } else low = mid + 1;
        }

        return s;
    }

    private static boolean canEatable(int[] arr, int s, int k) {
        for (int bananas : arr) {
            int time = (bananas % s == 0) ? bananas / s : bananas / s + 1;
            k -= time;
            if (k < 0) return false;
        }

        return true;
    }
}
