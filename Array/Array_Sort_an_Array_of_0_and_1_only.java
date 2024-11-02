package Array;

import java.util.Scanner;

public class Array_Sort_an_Array_of_0_and_1_only {
    public Array_Sort_an_Array_of_0_and_1_only() {
    }

    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Array size : ");
        int[] arr = new int[sc.nextInt()];
        System.out.print("Array Elements : ");

        int i;
        for(i = 0; i < arr.length; ++i) {
            arr[i] = sc.nextInt();
        }

        i = 0;
        int j = arr.length - 1;

        while(i < j) {
            if (arr[i] == 1 && arr[j] == 0) {
                swap(arr, i, j);
                ++i;
                --j;
            }

            if (arr[i] == 0) {
                ++i;
            }

            if (arr[j] == 1) {
                --j;
            }
        }
        System.out.print("Sorted Array : ");

        for (int k : arr)
        {
            System.out.print(k + " ");
        }

    }
}