package GFG_160;/*
 * https://www.geeksforgeeks.org/problems/number-of-occurrence2259/1
 *
 * # Number of occurrence
 *
 *   Q. Given a sorted array, arr[] and a number target, you need to find the number of occurrences of
 *      target in arr[].
 *    Ex.
 *      Input : arr[] = [1, 1, 2, 2, 2, 2, 3]
 *              target = 2
 *      Output: 4
 *      Explanation: target = 2 occurs 4 times in the given array so the output is 4.
 */

import java.util.Scanner;

public class GFG_28_Number_of_occurrence {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Size: ");
        int n = sc.nextInt();

        int[]arr = new int[n];

        System.out.println("Elements: ");
        for (int i = 0;i < n;i++)
            arr[i] = sc.nextInt();

        System.out.println("Target: ");
        int target = sc.nextInt();

        System.out.println(countFreq(arr, target));
    }

    /// Solution
    static int countFreq(int[] arr, int target) {
        // potd.code.hub
        int n = arr.length;

        int i = 0, j = n-1;
        int first = -1, last = -1;
        while (i <= j){
            int mid = i + (j-i)/2;
            if (arr[mid] == target) first = mid;
            if (arr[mid] < target){
                i = mid+1;
            }
            else j = mid-1;
        }
        i = 0;j = n-1;
        while (i <= j){
            int mid = i + (j-i)/2;
            if (arr[mid] == target) last = mid;
            if (arr[mid] > target){
                j = mid-1;
            }
            else i = mid+1;
        }

        return (last == -1 || first == -1) ? 0 : last-first+1;
    }
}
