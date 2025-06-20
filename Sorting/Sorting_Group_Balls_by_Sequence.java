package Sorting;/*
 *
 * https://www.geeksforgeeks.org/problems/group-balls-by-sequence/1
 *
 * # Group Balls by Sequence
 *
 *   Q. You are given an array arr[] of positive integers, where each element arr[i] represents the number written
 *      on the i-th ball, and a positive integer k.
 *
 *      Your task is to determine whether it is possible to rearrange all the balls into groups such that:
 *
 *      Each group contains exactly k balls.
 *      The numbers in each group are consecutive integers
 *    Ex.
 *      Input : arr[] = [10, 1, 2, 11], k = 2
 *      Output: true
 *      Explanation: The hand can be rearranged as [1, 2], [10, 11]. There are two groups of size 2. Each group
 *                   has 2 consecutive cards.
 */

import java.util.Scanner;
import java.util.TreeMap;

public class Sorting_Group_Balls_by_Sequence {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Array Elements: ");
        String[] s = sc.nextLine().split(" ");

        int n = s.length;
        int[] arr = new int[n];

        for (int i = 0;i < n;i++)
            arr[i] = Integer.parseInt(s[i]);

        System.out.println("K: ");
        int k = sc.nextInt();

        System.out.println("Valid group possible: " + validgroup(arr, k));
    }

    /// Solution
    static boolean validgroup(int[] arr, int k) {
        // potd.code.hub
        int n = arr.length;
        if (n % k != 0) return false;

        TreeMap<Integer, Integer> map = new TreeMap<>();

        for (int x : arr)
            map.put(x, map.getOrDefault(x, 0) + 2);

        for (var x : map.entrySet()) {
            int key = x.getKey();
            int val = x.getValue();

            if (val == 0) continue;

            for (int i = 0; i < k; i++) {
                int ele = key + i;
                int freq = map.getOrDefault(ele, 0);
                if (freq < val) return false;
                map.put(ele, freq - val);
            }
        }

        return true;
    }
}
