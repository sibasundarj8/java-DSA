package Array;

import java.util.Scanner;

public class Array_Rotation {
    public Array_Rotation() {
    }

    static int[] rotate(int[] arr, int k) {
        int n = arr.length;
        k %= n;
        int[] ans = new int[n];
        int j = 0;

        int i;
        for(i = n - k; i < n; ++i) {
            ans[j++] = arr[i];
        }

        for(i = 0; i < n - k; ++i) {
            ans[j++] = arr[i];
        }

        return ans;
    }

    static void printArray(int[] arr) {
        System.out.print("[");

        for (int i : arr) {
            System.out.print(i + ", ");
        }

        System.out.println("]");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("    Enter Array size : ");
        int[] num = new int[sc.nextInt()];
        System.out.print("Enter Array Elements : ");

        int k;
        for(k = 0; k < num.length; ++k) {
            num[k] = sc.nextInt();
        }

        System.out.print("k = ");
        k = sc.nextInt();
        System.out.print("Original Array is : ");
        printArray(num);
        System.out.print("Rotated Array is  : ");
        printArray(rotate(num, k));
    }
}