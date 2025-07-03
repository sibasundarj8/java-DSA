package Sliding_Window;/*
 *
 * https://www.geeksforgeeks.org/problems/fruit-into-baskets-1663137462/1
 *
 * # Longest subarray with Atmost two distinct integers
 *
 *   Q. Given an array arr[] consisting of positive integers, your task is to find the length of the longest
 *      subarray that contains at most two distinct integers.
 *    Ex.
 *      Input : arr[] = [3, 1, 2, 2, 2, 2]
 *      Output: 5
 *      Explanation: The longest subarray containing at most two distinct integers is [1, 2, 2, 2, 2], which
 *                   has a length of 5.
 */

import java.util.HashMap;
import java.util.Scanner;

public class Q09_Longest_subarray_with_Atmost_two_distinct_integers {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Array Elements: ");
        String[] s = sc.nextLine().split(" ");

        int n = s.length;
        int[] arr = new int[n];

        for (int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(s[i]);

        System.out.println("Size of largest subarray: " + totalElements(arr));
    }

    /// Solution
    static int totalElements(int[] arr) {
        // potd.code.hub
        int n = arr.length;
        int ans = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        int p = 0;

        for (int i = 0; i < n; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
            while (map.size() > 2) {
                map.put(arr[p], map.get(arr[p]) - 1);
                if (map.get(arr[p]) == 0) map.remove(arr[p]);
                p++;
            }
            ans = Math.max(ans, i - p + 1);
        }

        return ans;
    }
}
