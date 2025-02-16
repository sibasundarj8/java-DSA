package GFG_160;/*
 *
 * https://www.geeksforgeeks.org/problems/k-largest-elements4206/1
 *
 * # k largest elements
 *
 *   Q. Given an array arr[] of positive integers and an integer k, Your task is to
 *      return k largest elements in decreasing order.
 *    Ex.
 *      Input : arr[] = [1, 23, 12, 9, 30, 2, 50]
 *              k = 3
 *      Output: [50, 30, 23]
 *      Explanation: Three Largest elements in the array are 50, 30 and 23.
 */
import java.util.*;

public class GFG_95_k_largest_elements {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Size: ");
        int n = sc.nextInt();

        int[]arr = new int[n];

        System.out.println("Elements: ");
        for (int i = 0;i < n;i++)
            arr[i] = sc.nextInt();

        System.out.println("k:");
        int k = sc.nextInt();
        sc.close();

        System.out.println(kLargest(arr, k));
    }

    /// Solution
    static ArrayList<Integer> kLargest(int[] arr, int k) {
        // potd.code.hub
        List<Integer> ans = new LinkedList<>();
        PriorityQueue<Integer> q = new PriorityQueue<>(k+1);
        for (int i : arr) {
            if (q.size() < k) q.offer(i);
            else if (!q.isEmpty() && q.peek() < i) q.add(i);
            if (q.size() > k) q.poll();
        }
        while (!q.isEmpty()) ans.add(0, q.poll());
        
        return new ArrayList<>(ans);
    }
}
