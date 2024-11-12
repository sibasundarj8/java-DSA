package Array;

import java.util.Arrays;
import java.util.Scanner;

public class Array_Second_Largest_Element
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Array size :");
        int n = sc.nextInt();

        int[] arr = new int[n];

        System.out.println("Enter Array Elements :");
        for(int i = 0; i < n; ++i)
        {
            arr[i] = sc.nextInt();
        }

        System.out.println(print2largest(arr, n));
    }
    static int print2largest(int[] arr, int n)
    {
        changeArray(arr, n);
        Arrays.sort(arr);

        if (arr[n - 1] == Integer.MIN_VALUE)
        {
            System.out.print("No element found !!");
            return 1;
        } else {
            System.out.print("2nd Largest element is : ");
            return arr[n - 1];
        }
    }

    static void changeArray(int[] arr, int n)
    {
        int largest = arr[0];

        int i;
        for(i = 0; i < n; ++i)
        {
            if (arr[i] > largest)
            {
                largest = arr[i];
            }
        }

        for(i = 0; i < n; ++i)
        {
            if (arr[i] == largest)
            {
                arr[i] = Integer.MIN_VALUE;
            }
        }
    }
}