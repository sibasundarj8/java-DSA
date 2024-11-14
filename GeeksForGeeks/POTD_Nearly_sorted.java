package GFG;/*
 * https://www.geeksforgeeks.org/problems/nearly-sorted-1587115620/1
 *
 * # Nearly sorted
 *
 *   Q. Given an array arr[], where each element is at most k away from its target position, you need
 *      to sort the array optimally.
 *      Note: You need to change the given array arr[] in place.
 *    Ex.
 *      Input : arr[] = [6, 5, 3, 2, 8, 10, 9]
 *              k = 3
 *      Output: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
 *      Explanation: The sorted array will be 1 2 3 4 5 6 7 8 9 10
 */
import java.util.PriorityQueue;
import java.util.Scanner;

public class POTD_Nearly_sorted {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Size: ");
        int n = sc.nextInt();

        int[]arr = new int[n];

        System.out.println("Elements: ");
        for (int i = 0;i < n;i++){
            arr[i] = sc.nextInt();
        }

        System.out.println("Enter K: ");
        int k = sc.nextInt();

        nearlySorted(arr, k);

        for (int i : arr){
            System.out.print(i + " ");
        }
        System.out.println();
    }

    /// Solution
    static void nearlySorted(int[] arr, int k) {
        // potd.code.hub
        int n = arr.length;
        PriorityQueue<Integer> q = new PriorityQueue<>();

        for (int i = 0;i < k && i < n;i++){
            q.offer(arr[i]);
        }

        int i = k, idx = 0;
        while (i < n){
            q.offer(arr[i++]);
            arr[idx++] = q.poll();
        }

        while(!q.isEmpty()){
            arr[idx++] = q.poll();
        }
    }
}
