package Recursion;

import java.util.Scanner;

public class Recursion_17_Array_printElements
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Array size :");
        int[]arr = new int[sc.nextInt()];

        System.out.println("Enter Array Elements :");
        for (int i = 0;i < arr.length;i++) arr[i] = sc.nextInt();

        System.out.println("Printing array using Recursion :");
        recPrint(arr,0);
    }
    static void recPrint(int[]arr,int idx)
    {
        // Base Case
        if (idx == arr.length)return;

        // Self Work
        System.out.print(arr[idx] + " ");

        // Recursive work
        recPrint(arr,idx+1);
    }
}