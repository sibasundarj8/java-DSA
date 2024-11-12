/*
 *   Q. Given an array arr containing the lengths of the different ropes, we need to connect these
 *      ropes to form one rope. The cost to connect two ropes is equal to a sum of their lengths. The
 *      task is to connect the ropes with minimum cost.
 *   Ex.
 *      Input: arr[] = [4, 2, 7, 6, 9]
 *      Output: 62
 *      Explanation: First, connect ropes 4 and 2, which makes the array [6, 7, 6, 9]. Cost of this
 *                   operation 4 + 2 = 6. Next, add ropes 6 and 6, which results in [12, 7, 9]. Cost
 *                   of this operation 6 + 6 = 12. Then, add 7 and 9, which makes the array [12,16].
 *                   Cost of this operation 7 + 9 = 16. And finally, add these two that give [28].
 *                   Hence, the total cost is 6 + 12 + 16 + 28 = 62.
 */
package GFG;

import java.util.PriorityQueue;
import java.util.Scanner;

public class POTD_Minimum_Cost_of_Ropes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Size :");
        int n = sc.nextInt();
        long[] arr = new long[n];
        System.out.println("Elements :");
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextLong();
        System.out.println(minCost(arr));
    }

    static long minCost(long[] arr) {
        // potd.code.hub
        long ans = 0;
        PriorityQueue<Long> pq = new PriorityQueue<>();
        for (long i : arr) pq.add(i);
        while (pq.size() > 1) {
            long s1 = pq.poll();
            long s2 = pq.poll();
            long sum = s1 + s2;
            ans += sum;
            pq.add(sum);
        }
        return ans;
    }
}