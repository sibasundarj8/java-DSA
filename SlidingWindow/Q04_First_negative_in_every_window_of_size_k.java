/*
 *   Q. Given an array A[] of size N and a positive integer K, find the first negative integer
 *      for each and every window(contiguous sub-array) of size K.
 *    Ex:-
 *      Input:  N = 5
 *              A[] = {-8, 2, 3, -6, 10}
 *              K = 2
 *      Output: -8 0 -6 -6
 *      Explanation : First negative integer for each window of size k
 *                    {-8, 2} = -8
 *                    { 2, 3} =  0 (does not contain a negative integer)
 *                    { 3,-6} = -6
 *                    {-6,10} = -6
 */
package Sliding_Window;

import java.util.ArrayDeque;
import java.util.Scanner;

public class Q04_First_negative_in_every_window_of_size_k {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Size :");
        int n = sc.nextInt();

        long[]arr = new long[n];

        System.out.println("Elements :");
        for (int i = 0;i < n;i++)
            arr[i] = sc.nextInt();

        System.out.println("K :");
        int k = sc.nextInt();

        System.out.println("Output :");
        for (long i : printFirstNegativeInteger(arr,n,k))
            System.out.print(i + " ");
        System.out.println();
    }
    static long[] printFirstNegativeInteger(long[]arr, int n, int k){
        // potd.code.hub
        long[]ans = new long[n-k+1];
        ArrayDeque<Long>temp = new ArrayDeque<>();

        // First Window
        for (int i = 0;i < k;i++)
            if (arr[i] < 0) temp.addLast(arr[i]);

        ans[0] = temp.isEmpty() ? 0 : temp.peekFirst();

        // Remaining elements
        int i = 0, j = i+k;
        while (j < n){
            if (arr[i] < 0) temp.pollFirst();
            if (arr[j] < 0) temp.addLast(arr[j]);
            ans[i+1] = temp.isEmpty() ? 0 : temp.peekFirst();
            j++;
            i++;
        }

        return ans;
    }
}