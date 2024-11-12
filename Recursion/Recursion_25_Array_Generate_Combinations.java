package Recursion;/*
*   Q.   Given an array of size n, generate and print all possible combinations
*        of r elements in array.
*
*        Input : n = 4
*                arr[] = {1, 2, 3, 4}
*                r = 2
*
*       Output : {1, 2}
*                {1, 3}
*                {1, 4}
*                {2, 3}
*                {2, 4}
*                {3, 4}
*/

import java.util.Arrays;
import java.util.Scanner;

public class Recursion_25_Array_Generate_Combinations
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Array Size :");
        int[]arr = new int[sc.nextInt()];

        System.out.println("Enter Array Elements :");
        for (int i = 0;i < arr.length;i++)arr[i] = sc.nextInt();

        System.out.println("Enter R : ");
        int r = sc.nextInt();

        int n = arr.length;

        printCombination(arr, n, r);
    }
    public static void printCombination(int[] arr, int n, int r) {
        // A temporary array to store all combination one by one
        int[]data=new int[r];
        // Print all combination using temporary array 'data[]'
        combination(arr, n, r, 0, data, 0);
    }
    public static void combination(int[] arr, int n, int r, int index, int[] data, int i) {
        // Current combination is ready to be printed, print it
        if (index == r) {
            System.out.println(Arrays.toString(data));
            return;
        }

        // When no more elements are there to put in data[]
        if (i >= n) return;

        // current is included, put next at next location
        data[index] = arr[i];

        combination(arr, n, r, index+1, data, i+1);

        // current is excluded, replace it with next (Note that i+1 is passed, but index is not changed)
        combination(arr, n, r, index, data, i+1);
    }
}