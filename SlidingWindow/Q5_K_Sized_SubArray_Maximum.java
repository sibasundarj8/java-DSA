/*
 *   Q. Given an array arr[] and an integer k. Find the maximum for each and every contiguous
 *      sub-array of size k.
 *    Ex:-
 *      Input:  N = 9
 *              k = 3
 *              arr[] = [1, 2, 3, 1, 4, 5, 2, 3, 6]
 *      Output: [3, 3, 4, 5, 5, 5, 6]
 *      Explanation:
 *           1st contiguous sub-array = [1 2 3], max = 3
 *           2nd contiguous sub-array = [2 3 1], max = 3
 *           3rd contiguous sub-array = [3 1 4], max = 4
 *           4th contiguous sub-array = [1 4 5], max = 5
 *           5th contiguous sub-array = [4 5 2], max = 5
 *           6th contiguous sub-array = [5 2 3], max = 5
 *           7th contiguous sub-array = [2 3 6], max = 6
 */
package Sliding_Window;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Scanner;

public class Q5_K_Sized_SubArray_Maximum {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Size :");
        int n = sc.nextInt();

        int[]arr = new int[n];

        System.out.println("Elements :");
        for (int i = 0;i < n;i++)
            arr[i] = sc.nextInt();

        System.out.println("K :");
        int k = sc.nextInt();

        System.out.println(max_of_subArrays(n, k, arr));
    }
    static ArrayList<Integer> max_of_subArrays(int n, int k, int[]arr) {
        // potd.code.hub
        ArrayList<Integer>ans = new ArrayList<>();
        Deque<Integer> temp = new ArrayDeque<>();

        for (int i = 0;i < n;i++){
            // remove out of range elements
            if (!temp.isEmpty() && temp.peekFirst() == i-k) temp.pollFirst();
            // remove all smaller
            while(!temp.isEmpty() && arr[temp.peekLast()] < arr[i]) temp.pollLast();
            // add next elements
            temp.add(i);
            // updating answer
            if (i >= k-1 && !temp.isEmpty()) ans.add(arr[temp.peek()]);
        }

        return ans;
    }
}