package Array;

import java.util.Scanner;

public class Array_Sort_even_odd
{
    static void swap(int[] arr, int i, int j)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
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
        int n = sc.nextInt();

        int[] arr = new int[n];

        System.out.print("Array elements : ");
        int i;
        for(i = 0; i < n; ++i)
        {
            arr[i] = sc.nextInt();
        }

        i = 0;
        int j = n - 1;
        while(i < j)
        {
            if (arr[i] % 2 == 1 && arr[j] % 2 == 0)
            {
                swap(arr, i, j);
                ++i;
                --j;
            }

            if (arr[i] % 2 == 0)
            {
                ++i;
            }

            if (arr[j] % 2 == 1)
            {
                --j;
            }
        }
        printArray(arr);
    }
}