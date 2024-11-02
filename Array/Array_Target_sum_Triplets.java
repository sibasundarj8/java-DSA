package Array;

import java.util.Scanner;

public class Array_Target_sum_Triplets
{
    static void pairSum(int[] arr, int target)
    {
        int ans = 0;

        for(int i = 0; i < arr.length; ++i)
        {
            for(int j = i + 1; j < arr.length; ++j)
            {
                for(int k = j + 1; k < arr.length; ++k)
                {
                    if (arr[i] + arr[j] + arr[k] == target)
                    {
                        System.out.print(arr[i] + " " + arr[j] + " " + arr[k] + "\n");
                        ++ans;
                    }
                }
            }
        }
        System.out.println("There are " + ans + " Triplets.");
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Array size :");
        int[] num = new int[sc.nextInt()];

        System.out.println("Enter Array Elements :");
        int t;
        for(t = 0; t < num.length; ++t)
        {
            num[t] = sc.nextInt();
        }

        System.out.println("Enter Target Sum :");
        t = sc.nextInt();
        pairSum(num, t);
    }
}