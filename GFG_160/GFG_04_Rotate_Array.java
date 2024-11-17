package GFG_160;

import java.util.Scanner;

public class GFG_04_Rotate_Array {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Size: ");
        int n = sc.nextInt();

        int[]arr = new int[n];

        System.out.println("Elements: ");
        for (int i = 0;i < n;i++){
            arr[i] = sc.nextInt();
        }

        System.out.println("K : ");
        int k = sc.nextInt();

        rotateArr(arr, k);

        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    /// Solution
    static void rotateArr(int[] arr, int d) {
        // potd.code.hub
        int n = arr.length;
        d %= n;

        reverse(arr, 0, d - 1);
        reverse(arr, d, n - 1);
        reverse(arr, 0, n - 1);
    }

    static void reverse(int[] arr, int i, int j) {
        while (i < j) {
            int temp = arr[i];
            arr[i++] = arr[j];
            arr[j--] = temp;
        }
    }
}