package Array;

import java.util.Scanner;

public class Array_Rotate_from_Kth_Element
{
    static void swapArray(int[] arr, int i, int j)
    {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    static void reverseArray(int[] arr, int i, int j)
    {
        while(i < j)
        {
            swapArray(arr, i, j);
            ++i;
            --j;
        }
    }
    static int[] rotateInplace(int[] arr, int k)
    {
        int n = arr.length;
        k %= n;
        reverseArray(arr, 0, n - k - 1);
        reverseArray(arr, n - k, n - 1);
        reverseArray(arr, 0, n - 1);
        return arr;
    }
    static void printArray(int[] arr)
    {
        for (int i : arr)
            System.out.print(i + " ");
        System.out.println();
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Array size : ");
        int[] num = new int[sc.nextInt()];

        System.out.println("Array Elements  : ");
        int k;
        for(k = 0; k < num.length; ++k)
        {
            num[k] = sc.nextInt();
        }

        System.out.print("k = ");
        k = sc.nextInt();

        System.out.println("Original Array is : ");
        printArray(num);

        System.out.println("Rotated Array is : ");
        printArray(rotateInplace(num, k));
    }
}