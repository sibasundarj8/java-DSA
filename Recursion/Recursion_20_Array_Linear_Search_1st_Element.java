package Recursion;
//  Linear Search using Recursion

import java.util.Scanner;

public class Recursion_20_Array_Linear_Search_1st_Element
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Array Size :");
        int[]arr = new int[sc.nextInt()];

        System.out.println("Enter Elements :");
        for (int i = 0;i < arr.length;i++)arr[i] = sc.nextInt();

        System.out.println("Enter Your Target : ");
        int x = sc.nextInt();

        System.out.println("Present at Index : " + recLinear(arr,0,x));
    }
    static int  recLinear(int[]arr,int idx,int target)
    {
        // Self Work
        if (arr[idx] == target)return idx;

        // Base case
        if (idx == arr.length-1)return -1;

        // Recursive Work
        return recLinear(arr,idx+1,target);
    }
}