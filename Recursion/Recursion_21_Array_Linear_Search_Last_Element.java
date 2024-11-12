package Recursion;

import java.util.Scanner;

public class Recursion_21_Array_Linear_Search_Last_Element
{
    public static void main(String[]args)
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Array Size : ");
        int n = sc.nextInt();

        int[]arr = new int[n];

        System.out.println("Enter Array Elements :");
        for (int i = 0;i < n;i++)arr[i] = sc.nextInt();

        System.out.println("Enter the target : ");
        int x = sc.nextInt();

        System.out.println(x + " is present at index : " + recLast(arr,n,0,x,0));
    }
    static int recLast(int[]arr,int n,int idx,int x,int p)
    {
        // base case
        if (idx >= n) return p;

        // recursive work
        if (arr[idx] == x) return recLast(arr,n,idx+1,x,idx);
        return recLast(arr,n,idx+1,x,p);
    }
}