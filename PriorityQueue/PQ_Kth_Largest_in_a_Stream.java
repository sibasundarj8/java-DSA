package PriorityQueue;/*
 *
 * https://www.geeksforgeeks.org/problems/kth-largest-element-in-a-stream2220/1
 *
 * # Kth Largest in a Stream
 *
 *   Q. Given an input stream arr[] of n integers. Find the Kth largest element (not Kth the largest unique element) after
 *      insertion of each element in the stream and if the Kth largest element doesn't exist, the answer will be -1 for that
 *      insertion.
 *
 *      Return a list of size n, where each element represents the Kth largest value after the corresponding insertion.
 *
 *    Ex.
 *      Input : arr[] = [1, 2, 3, 4, 5, 6], k = 4
 *      Output: [-1, -1, -1, 1, 2, 3]
 *      Explanation:
 *              After 1, the steam is [1]. The 4th largest does not exist. Output is -1.
 *              After 2, the stream is [1, 2]. The 4th largest does not exist. Output is -1.
 *              After 3, the stream is [1, 2, 3]. The 4th largest does not exist. Output is -1.
 *              After 4, the stream is [1, 2, 3, 4]. The 4th largest is 1.
 *              After 5, the stream is [1, 2, 3, 4, 5]. The 4th largest is 2.
 *              After 6, the stream is [1, 2, 3, 4, 5, 6]. The 4th largest is 3.
 *
 *  Constraints:
 *          1 ≤ k ≤ n ≤ 10⁵
 *          1 ≤ arr[i] ≤ 10⁵
 */

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class PQ_Kth_Largest_in_a_Stream {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter array elements: ");
        String[] s = sc.nextLine().split(" ");

        int n = s.length;
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(s[i]);
        }

        System.out.println("Enter k: ");
        int k = sc.nextInt();

        System.out.println("Kth largest at insertion: ");
        System.out.println(kthLargest(arr, k));
    }

    /// solution
    static ArrayList<Integer> kthLargest(int[] arr, int k) {
        // potd.code.hub
        ArrayList<Integer> res = new ArrayList<>();
        Queue<Integer> pq = new PriorityQueue<>();

        for (int ele : arr) {
            pq.add(ele);

            if (pq.size() > k) pq.poll();

            if (pq.size() < k) res.add(-1);
            else res.add(pq.peek());
        }

        return res;
    }
}
