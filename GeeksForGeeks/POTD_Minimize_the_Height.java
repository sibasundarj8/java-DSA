package GFG;

import java.util.Scanner;

public class POTD_Minimize_the_Height
{
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter array size : ");
        int n = sc.nextInt();

        int []arr = new int[n];

        System.out.println("Enter Array Elements : ");
        for(int i = 0;i < arr.length;i++) arr[i] = sc.nextInt();

        System.out.println("Enter k to Minimize the height :");
        int k = sc.nextInt();

        System.out.println("Difference between Large and Small Element :\n" + Mh(arr,n,k));
    }
    static int Mh (int[]arr,int n,int k)
    {
        int l = Integer.MIN_VALUE;
        int s = Integer.MAX_VALUE;

        for(int i = 0;i < n;i++)
        {
            if(arr[i] < k) arr[i] += k;
            else if (arr[i] > k) arr[i] -= k;

            if(arr[i] < s) s = arr[i];
            if(arr[i] > l) l = arr[i];
        }
        return l-s;
    }
}
