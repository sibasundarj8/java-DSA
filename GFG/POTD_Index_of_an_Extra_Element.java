package GFG;

import java.util.Scanner;

public class POTD_Index_of_an_Extra_Element {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Size :");
        int n = sc.nextInt();

        int[]arr = new int[n];
        int[]arr1 = new int[n+1];

        System.out.println("Elements in increasing order :");
        for (int i = 0;i < n;i++)arr[i] = sc.nextInt();

        System.out.println("Enter same elements with an Extra Element :");
        for (int i = 0;i < n+1;i++)arr1[i] = sc.nextInt();

        System.out.println("Extra Element at Index : " + findExtra(n,arr,arr1));
    }
    static int findExtra(int n, int []arr1, int []arr2)
    {
        // add code here.
        for (int i = 0;i < n-1;i++)if(arr1[i] != arr2[i])return i;
        return n-1;
    }
}