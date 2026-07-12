package PriorityQueue;/*
 *
 * https://www.geeksforgeeks.org/problems/ticket-sellers3241/1
 *
 * # Max Amount by Selling K Tickets
 *
 *   Q. Given an integer array arr[], where arr[i] denotes the number of tickets available with the i-th ticket seller.
 * 
 *      ◦ The price of each ticket is equal to the number of tickets remaining with that seller at the time of sale.
 *
 *      ◦ A seller can sell at most one ticket at a time, and after each sale, the price of the next ticket from that
 *        seller decreases by 1.
 *
 *      ◦ All sellers are allowed to sell at most k tickets in total.
 *
 *      Find the maximum amount that can be earned by selling k tickets. Return the answer modulo 109+7.
 *
 *    Ex.
 *      Input : arr[] = [4, 3, 6, 2, 4], k = 3
 *      Output: 15
 *      Explanation: One optimal sequence is to sell two tickets from the seller with 6 tickets (the price of first
 *                   would be 6 and second 5) and one ticket from a seller with 4 tickets. This gives a total earning
 *                   of 6 + 5 + 4 = 15.
 *
 *  Constraints:
 *        1 ≤ arr.size() ≤ 10⁵
 *        1 ≤ arr[i], k ≤ 10⁶
 */

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class PQ_Max_Amount_by_Selling_K_Tickets {

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

        System.out.println("K: ");
        int k = sc.nextInt();
    }

    /// Solution
    static int maxAmount(int[] arr, int k) {
        // potd.code.hub
        int mod = (int) (1e9 + 7);
        long earning = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.comparingInt(a -> -a));

        for (int ele : arr) {
            pq.offer(ele);
        }

        while (!pq.isEmpty() && k > 0) {
            int ele = pq.poll();
            earning = (earning + ele) % mod;

            if (ele == 0) {
                break;
            }

            pq.offer(ele - 1);
            k--;
        }

        return (int) earning;
    }
}
