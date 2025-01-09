package GFG_160;/*
 *
 * https://www.geeksforgeeks.org/problems/subarray-with-given-sum-1587115621/1
 *
 * # Indexes of Sub-array Sum
 *
 *   Q. Given an array arr[] containing only non-negative integers, your task is to find a continuous
 *      sub-array (a contiguous sequence of elements) whose sum equals a specified value target. You
 *      need to return the 1-based indices of the leftmost and rightmost elements of this sub-array.
 *      You need to find the first sub-array whose sum is equal to the target.
 *
 *      Note: If no such array is possible then, return [-1].
 *    Ex.
 *      Input : arr[] = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
 *              target = 15
 *      Output: [1, 5]
 *      Explanation: The sum of elements from 1st to 5th position is 15.
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class GFG_56_Indexes_of_SubArray_Sum {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Size: ");
        int n = sc.nextInt();

        int[]arr = new int[n];

        System.out.println("Elements: ");
        for (int i = 0;i < n;i++) arr[i] = sc.nextInt();

        System.out.println("Target: ");
        int target = sc.nextInt();

        System.out.println(subArraySum(arr, target));
    }

    /// Solution
    static ArrayList<Integer> subArraySum(int[] arr, int target) {
        // potd.code.hub
        int n = arr.length, sum = 0;
        int i = 0, j = 0;
        while (j < n){
            sum += arr[j++];
            while (sum > target && i < j) sum -= arr[i++];
            if (sum == target) return new ArrayList<>(Arrays.asList(i+1, j));
        }

        return new ArrayList<>(List.of(-1));
    }
}
