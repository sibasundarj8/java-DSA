package Deque;/*
 *
 * https://www.geeksforgeeks.org/problems/longest-bounded-difference-subarray/1
 *
 * # Longest Bounded-Difference Subarray
 *
 *   Q. Given an array of positive integers arr[] and a non-negative integer x, the task is to find the
 *      longest sub-array where the absolute difference between any two elements is not greater than x.
 *
 *      If multiple such subarrays exist, return the one that starts at the smallest index.
 *   Ex.
 *      Input : arr[] = [8, 4, 5, 6, 7]
 *              x = 3
 *      Output: [4, 5, 6, 7]
 *      Explanation: The sub-array described by index [1..4], i.e. [4, 5, 6, 7]
 *                   contains no two elements whose absolute difference is greater than 3.
 *
 *  Constraints:
 *          1 ≤ arr.size() ≤ 10⁵
 *          1 ≤ arr[i] ≤ 10⁹
 *          0 ≤ x ≤ 10⁹
 */

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class DQ_03_Longest_Bounded_Difference_Subarray {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Elements: ");
        String[] s = sc.nextLine().split(" ");

        int n = s.length;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(s[i]);

        System.out.print("K: ");
        int k = sc.nextInt();

        System.out.println("Longest sub-array with abs difference smaller than " + k + " : ");
        System.out.println(longestSubarray(arr, k));
    }

    /// Solution
/*......................................................brute-force......................................................*/
// TC : O(n²)
// SC : O(1)
    static ArrayList<Integer> bruteForce(int[] arr, int x) {
        // potd.code.hub
        int n = arr.length;
        ArrayList<Integer> ans = new ArrayList<>();
        int start = 0;
        int end = 0;

        for (int i = 0; i < n; i++) {    // checking every possible sub-array
            int min = arr[i];
            int max = arr[i];

            for (int j = i; j < n; j++) {
                min = Math.min(min, arr[j]);
                max = Math.max(max, arr[j]);

                if (max - min <= x) {
                    if (j - i > end - start) {
                        start = i;
                        end = j;
                    }
                } else break;            // break if abs difference exceeds x
            }
        }

        // updating answer
        while (start <= end) ans.add(arr[start++]);

        return ans;
    }

/*............................................using Dequeue && Sliding Window............................................*/
// TC : O(n)
// SC : O(n)
    static ArrayList<Integer> longestSubarray(int[] arr, int x) {
        // potd.code.hub
        int n = arr.length;
        int start = 0;
        int end = 0;

        ArrayList<Integer> ans = new ArrayList<>();
        Deque<Integer> max = new LinkedList<>();    // keep the track of max elements
        Deque<Integer> min = new LinkedList<>();    // keep the track of min elements

        int i = 0;
        int j = 0;

        while (i < n) {     // two pointer -> sliding window

            // expanding sub-array
            if (max.isEmpty() || min.isEmpty() || max.peekFirst() - min.peekFirst() <= x) {

                // updating max element
                while (!max.isEmpty() && max.peekLast() < arr[i]) max.pollLast();
                max.addLast(arr[i]);

                // updating min element
                while (!min.isEmpty() && min.peekLast() > arr[i]) min.pollLast();
                min.addLast(arr[i]);

                i++;
            }

            // compressing sub-array
            while (!min.isEmpty() && !max.isEmpty() && max.peekFirst() - min.peekFirst() > x) {
                if (arr[j] == min.peekFirst()) min.pollFirst();
                if (arr[j] == max.peekFirst()) max.pollFirst();
                j++;
            }

            // updating answer starting and ending positions
            if (i - 1 - j > end - start) {
                end = i - 1;
                start = j;
            }
        }

        // updating answer
        while (start <= end) ans.add(arr[start++]);

        return ans;
    }
}
