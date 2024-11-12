/*
 *   Q. Given an array of integers Arr of size N and a number K. Return the maximum sum of a sub-array
 *      of size K.
 *   Ex:-
 *      Input:  N = 4, K = 2
 *              Arr = [100, 200, 300, 400]
 *      output: 700
 */
package Sliding_Window;

import java.util.ArrayList;
import java.util.Scanner;

public class Q3_Max_Sum_SubArray_of_size_K {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Size :");
        int n = sc.nextInt();

        ArrayList<Integer>arr = new ArrayList<>();

        System.out.println("Elements :");
        for (int i = 0;i < n;i++)
            arr.add(sc.nextInt());

        System.out.println("K :");
        int k = sc.nextInt();

        System.out.println("Output :");
        System.out.println(maximumSumSubArray(k,arr,n));
    }
    static long maximumSumSubArray(int k, ArrayList<Integer> arr, int n){
        // potd.code.hub
        long sum = 0;
        for (int i = 0;i < n && i < k;i++)sum += arr.get(i);

        long max = sum;
        int i = 0, j = k;
        while (j < n) {
            sum += arr.get(j++) - arr.get(i++);
            max = Math.max(max,sum);
        }
        return max;
    }
}