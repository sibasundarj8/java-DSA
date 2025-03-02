package GFG_160;/*
 *
 * https://www.geeksforgeeks.org/problems/maximum-of-all-subarrays-of-size-k3101/1
 *
 * # K Sized Subarray Maximum
 *
 *   Q. Given an array arr[] of integers and an integer k, your task is to find the maximum value
 *      for each contiguous subarray of size k. The output should be an array of maximum values
 *      corresponding to each contiguous subarray.
 *    Ex.
 *      Input : arr[] = [1, 2, 3, 1, 4, 5, 2, 3, 6]
 *              k = 3
 *      Output: [3, 3, 4, 5, 5, 5, 6]
 *      Explanation:
 *              1st contiguous subarray = [1 2 3] max = 3
 *              2nd contiguous subarray = [2 3 1] max = 3
 *              3rd contiguous subarray = [3 1 4] max = 4
 *              4th contiguous subarray = [1 4 5] max = 5
 *              5th contiguous subarray = [4 5 2] max = 5
 *              6th contiguous subarray = [5 2 3] max = 5
 *              7th contiguous subarray = [2 3 6] max = 6
 */
import java.util.*;

public class GFG_108_K_Sized_Subarray_Maximum {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Size: ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        System.out.println("Elements: ");
        for (int i = 0;i < n;i++)
            arr[i] = sc.nextInt();

        System.out.println("k: ");
        int k = sc.nextInt();

        System.out.println(maxOfSubarrays(arr, k));
    }

    /// Solution
    static ArrayList<Integer> maxOfSubarrays(int[] arr, int k) {
        // potd.code.hub
        int n = arr.length;
        ArrayDeque<Integer> deque = new ArrayDeque<>(k+1);
        ArrayList<Integer> list = new ArrayList<>(n);
        for (int i = 0;i < n;i++){
            while (!deque.isEmpty() && arr[deque.peekLast()] <= arr[i]) deque.pollLast();
            deque.addLast(i);
            if (deque.peekFirst() < i-k+1) deque.pollFirst();
            if (i >= k-1)list.add(arr[deque.peekFirst()]);
        }

        return list;
    }
}
