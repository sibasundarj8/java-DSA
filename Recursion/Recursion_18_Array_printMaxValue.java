package Recursion;

import java.util.Scanner;

public class Recursion_18_Array_printMaxValue
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Array size :");
        int[]arr = new int[sc.nextInt()];

        if (arr.length == 0)return;

        System.out.println("Enter Array Elements :");
        for (int i = 0;i < arr.length;i++)arr[i] = sc.nextInt();

        System.out.println("Max Value is : " + recMaxElement(arr,0));
    }
    static int recMaxElement(int[]arr,int idx)
    {
        // base Case
        if (idx == arr.length-1)return arr[idx];

        // Recursive Work
        int smallAns = recMaxElement(arr,idx+1);

        // Self Work
        return Math.max(smallAns,arr[idx]);
    }
}