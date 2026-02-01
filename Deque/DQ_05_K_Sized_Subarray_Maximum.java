package Deque;/*
 *
 * https://www.geeksforgeeks.org/problems/maximum-of-all-subarrays-of-size-k3101/1
 *
 * # K Sized Subarray Maximum
 *
 *   Q. Given an array arr[] of positive integers and an integer k. You have to find the maximum value for each contiguous
 *      subarray of size k. Return an array of maximum values corresponding to each contiguous subarray.
 *    Ex.
 *      Input : arr[] = [1, 2, 3, 1, 4, 5, 2, 3, 6], k = 3
 *      Output: [3, 3, 4, 5, 5, 5, 6]
 *      Explanation:
 *              1st contiguous subarray [1, 2, 3], max = 3
 *              2nd contiguous subarray [2, 3, 1], max = 3
 *              3rd contiguous subarray [3, 1, 4], max = 4
 *              4th contiguous subarray [1, 4, 5], max = 5
 *              5th contiguous subarray [4, 5, 2], max = 5
 *              6th contiguous subarray [5, 2, 3], max = 5
 *              7th contiguous subarray [2, 3, 6], max = 6
 *
 *  Constraints:
 *          1 ≤ arr.size() ≤ 10⁶
 *          1 ≤ k ≤ arr.size()
 *          0 ≤ arr[i] ≤ 10⁹
 */

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Scanner;

public class DQ_05_K_Sized_Subarray_Maximum {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter array Elements: ");
        String[] s = sc.nextLine().split(" ");

        int n = s.length;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(s[i]);
        }

        System.out.print("K: ");
        int k = sc.nextInt();

        System.out.println("Maximum ele at every " + k + " sized sub-array: ");
        System.out.println(maxOfSubarrays(arr, k));
    }

    /// Solution
    static ArrayList<Integer> maxOfSubarrays(int[] arr, int k) {
        int n = arr.length;
        ArrayList<Integer> ans = new ArrayList<>();
        ArrayDeque<Integer> dq = new ArrayDeque<>();

        // adding first k elements to the deque
        for (int i = 0; i < k; i++) {
            // clean the deque until smaller or equal elements in top
            while (!dq.isEmpty() && arr[dq.peekLast()] <= arr[i]) {
                dq.pollLast();
            }
            // add the current index
            dq.addLast(i);
        }
        // update the answer for first k elements
        int max = dq.isEmpty() ? -1 : arr[dq.peekFirst()];
        ans.add(max);

        // add remaining elements and update the answer.
        for (int i = k; i < n; i++) {

            // remove the element which is going out from window
            if (dq.peekFirst() <= i - k) dq.pollFirst();

            // clean the deque until smaller or equal elements in top
            while (!dq.isEmpty() && arr[dq.peekLast()] <= arr[i]) {
                dq.pollLast();
            }

            // add the current index
            dq.addLast(i);

            // update the answer
            max = dq.isEmpty() ? -1 : arr[dq.peekFirst()];
            ans.add(max);
        }

        return ans;
    }
}
