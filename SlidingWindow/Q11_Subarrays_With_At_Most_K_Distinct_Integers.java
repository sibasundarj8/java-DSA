package Sliding_Window;/*
 *
 * https://www.geeksforgeeks.org/problems/subarrays-with-at-most-k-distinct-integers/0
 *
 * # Sub-arrays With At Most K Distinct Integers
 *
 *   Q. You are given an array arr[] of positive integers and an integer k, find the number of
 *      sub-arrays in arr[] where the count of distinct integers is at most k.
 *
 *      Note: A sub-array is a contiguous part of an array.
 *    Ex.
 *      Input : arr[] = [1, 2, 2, 3], k = 2
 *      Output: 9
 *      Explanation: Sub-arrays with at most 2 distinct elements are:
 *                   [1], [2], [2], [3], [1, 2], [2, 2], [2, 3], [1, 2, 2] and [2, 2, 3].
 */

import java.util.HashMap;
import java.util.Scanner;

public class Q11_Subarrays_With_At_Most_K_Distinct_Integers {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter elements: ");
        String[] s = sc.nextLine().split(" ");

        int n = s.length;
        int[] arr = new int[n];

        for (int i = 0;i < n;i++) {
            arr[i] = Integer.parseInt(s[i]);
        }

        System.out.println("k: ");
        int k = sc.nextInt();

        System.out.println("number of subarrays: " + countAtMostK(arr, k));
    }

    /// Solution
    static int countAtMostK(int[] arr, int k) {
        // potd.code.hub
        int n = arr.length, ans = 0, i = 0, j = 0;
        HashMap<Integer, Integer> map = new HashMap<>(k + 1);
        
        while (j < n) {
            map.put(arr[j], map.getOrDefault(arr[j], 0) + 1);
        
            while (map.size() > k) {
                map.put(arr[i], map.get(arr[i]) - 1);
                if (map.get(arr[i]) <= 0) map.remove(arr[i]);
                i++;
            }
        
            ans += j - i + 1;
            j++;
        }
        
        return ans;
    }
}
