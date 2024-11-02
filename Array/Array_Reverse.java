package Array;

import java.util.Scanner;

public class Array_Reverse {
    public Array_Reverse() {
    }

    static void swapElements(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static int[] reverseArray(int[] arr) {
        int i = 0;

        for(int j = arr.length - 1; i < j; --j) {
            swapElements(arr, i, j);
            ++i;
        }

        return arr;
    }

    static void printArray(int[] arr) {
        System.out.print("[");
        int var2 = arr.length;

        for (int i : arr) {
            System.out.print(" " + i + ",");
        }

        System.out.println("]");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("    Enter Array size : ");
        int[] num = new int[sc.nextInt()];
        System.out.print("Enter Array Elements : ");

        for(int i = 0; i < num.length; ++i) {
            num[i] = sc.nextInt();
        }

        System.out.print("Original Array is : ");
        printArray(num);
        System.out.print("Reverse  Array is : ");
        printArray(reverseArray(num));
    }
}