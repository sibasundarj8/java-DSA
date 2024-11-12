package Recursion;

import java.util.Scanner;

public class Recursion_19_Array_sumOfElements
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Array size :");
        int[]arr = new int[sc.nextInt()];

        System.out.println("Enter Array Elements :");
        for (int i = 0;i < arr.length;i++)arr[i] = sc.nextInt();

        System.out.println("Sum of All elements : " + printSum(arr,0));
    }
    static int printSum(int[]arr,int idx)
    {
        // Base Case
        if (idx == arr.length)return 0;

        // Recursive Work
        return arr[idx] + printSum(arr,idx+1);
    }
}
