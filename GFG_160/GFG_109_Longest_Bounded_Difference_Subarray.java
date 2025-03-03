package GFG_160;/*
 *
 * https://www.geeksforgeeks.org/problems/longest-bounded-difference-subarray/0
 *
 * # Longest Bounded-Difference Subarray
 *
 *   Q. Given an array of positive integers arr[] and a non-negative integer x, the task is to
 *      find the longest subarray where the absolute difference between any two elements is not
 *      greater than x.
 *
 *      If multiple such subarrays exist, return the one that starts at the smallest index.
 *    Ex.
 *      Input : arr[] = [15, 10, 1, 2, 4, 7, 2]
 *              x = 5
 *      Output: [2, 4, 7, 2]
 *      Explanation: The sub-array described by indexes [3..6], i.e. [2, 4, 7, 2]
 *                   contains no such difference of two elements which is greater than 5.
 */
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Scanner;

public class GFG_109_Longest_Bounded_Difference_Subarray {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Size: ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        System.out.println("Elements: ");
        for (int i = 0;i < n;i++) arr[i] = sc.nextInt();

        System.out.println("X: ");
        int x = sc.nextInt();

        System.out.println(longestSubarray(arr, x));
    }

    /// Solution
    static ArrayList<Integer> longestSubarray(int[] arr, int x) {
        // potd.code.hub
        int n = arr.length, ansF = 0, ansL = 0;
        ArrayList<Integer> ans = new ArrayList<>();
        ArrayDeque<Integer> max = new ArrayDeque<>();
        ArrayDeque<Integer> min = new ArrayDeque<>();

        int start = 0;
        for (int i = 0;i < n;i++) {
            int ele = arr[i];

            while (!max.isEmpty() && arr[max.peekLast()] < ele)
                max.pollLast();
            max.offerLast(i);

            while (!min.isEmpty() && arr[min.peekLast()] > ele)
                min.pollLast();
            min.offerLast(i);

            while (!max.isEmpty() && !min.isEmpty() && arr[max.peekFirst()] - arr[min.peekFirst()] > x){
                int demo = arr[start];
                if (arr[max.peekFirst()] == demo) max.pollFirst();
                if (arr[min.peekFirst()] == demo) min.pollFirst();
                start++;
            }

            if (i - start > ansL - ansF){
                ansF = start;
                ansL = i;
            }
        }

        while (ansF <= ansL) ans.add(arr[ansF++]);

        return ans;
    }
}
