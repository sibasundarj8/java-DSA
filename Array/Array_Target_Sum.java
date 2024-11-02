package Array;

import java.util.Scanner;

public class Array_Target_Sum
{
    static void pairSum(int[] arr, int target)
    {                                                       //  big_O(n^2)
        int ans = 0;

        for(int i = 0; i < arr.length; ++i)
        {
            for(int j = i + 1; j < arr.length; ++j)
            {
                if (arr[i] + arr[j] == target)
                {
                    System.out.print(arr[i] + "," + arr[j] + "\n");
                    ++ans;
                }
            }
        }
        System.out.println("There are " + ans + " Pairs.");
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Array size : ");
        int[] num = new int[sc.nextInt()];

        System.out.print("Enter Array Elements : ");
        int t;
        for(t = 0; t < num.length; ++t)
        {
            num[t] = sc.nextInt();
        }

        System.out.print("Enter Target Sum : ");
        t = sc.nextInt();

        pairSum(num, t);
    }
}