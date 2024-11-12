package Array;

import java.util.Scanner;

public class Array_Smaller_Sum
{
    static void printArray(int[] arr)
    {
        for (int i : arr)
        {
            System.out.print(i + " ");
        }
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Array size : ");
        int[] arr = new int[sc.nextInt()];

        System.out.print("Enter Array Elements : ");
        for(int i = 0; i < arr.length; ++i)
        {
            arr[i] = sc.nextInt();
        }

        int[] ans = new int[arr.length];

        for(int i = 0; i < arr.length; ++i)
        {
            int x = 0;

            for (int k : arr)
            {
                if (k < arr[i])
                {
                    x += k;
                }
            }

            ans[i] = x;
        }
        printArray(ans);
    }
}