package Array;

import java.util.Scanner;

public class Array_Prefix_Sum
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Array size : ");
        int[] arr = new int[sc.nextInt()];

        System.out.println("Array Elements : ");
        for(int i = 0; i < arr.length; ++i)
        {
            arr[i] = sc.nextInt();
        }

        printArray(MakePrefixSum(arr));
    }
    static int[] MakePrefixSum(int[] arr)
    {
        for(int i = 1; i < arr.length; ++i)
        {
            arr[i] += arr[i - 1];
        }
        return arr;
    }
    static void printArray(int[] arr)
    {
        for (int i : arr)
        {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}