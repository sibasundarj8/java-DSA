package Priority_Queue;/*
 *
 * https://www.geeksforgeeks.org/problems/k-th-largest-sum-contiguous-subarray/1
 *
 * # K-th Largest Sum Contiguous Subarray
 *
 *   Q. Given an array arr[] of size n, find the sum of the K-th largest sum among all contiguous
 *      subarrays. In other words, identify the K-th largest sum from all possible subarrays and
 *      return it.
 *   Ex.
 *      Input : arr[] = [2, 6, 4, 1]
 *              k = 3
 *      Output: 11
 *      Explanation: The different subarray sums we can get from the array are
 *                   = [13, 12, 11, 10, 8, 6, 5, 4, 2, 1].
 *                   Where 11 is the 3rd largest.
 */

import java.util.PriorityQueue;
import java.util.Scanner;

public class PQ_K_th_Largest_Sum_Contiguous_Subarray {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Elements: ");
        String[] s = sc.nextLine().split(" ");

        int n = s.length;
        int[] arr = new int[n];

        for (int i = 0;i < n;i++){
            arr[i] = Integer.parseInt(s[i]);
        }

        System.out.println("k: ");
        int k = sc.nextInt();

        System.out.println("Kth largest: " + kthLargest(arr, k));
    }

    /// Solution
    static int kthLargest(int[] arr, int k) {
        // code here
        int n = arr.length;
        PriorityQueue<Integer> q = new PriorityQueue<>((a, b) -> b - a);

        for (int i = 0;i < n;i++){
            int sum = 0;
            for (int j = i;j < n;j++){
                sum += arr[j];
                q.offer(sum);
            }
        }

        while (!q.isEmpty() && k != 1){
            q.poll();
            k--;
        }

        return q.peek();
    }
}
