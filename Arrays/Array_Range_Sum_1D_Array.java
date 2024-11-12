package Array;

import java.util.Scanner;

public class Array_Range_Sum_1D_Array {
    public Array_Range_Sum_1D_Array() {
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Array size : ");
        int n = sc.nextInt();
        int[] arr = new int[n + 1];
        System.out.print("Array Elements : ");

        int q;
        for(q = 1; q <= n; ++q) {
            arr[q] = sc.nextInt();
        }

        makePrefixSum(arr);
        System.out.print("Number of queries : ");
        q = sc.nextInt();

        for(int i = 0; i < q; ++i) {
            System.out.print("Set range :\nx = ");
            int x = sc.nextInt();
            System.out.print("y = ");
            int y = sc.nextInt();
            System.out.print("Sum : ");
            System.out.println(arr[y] - arr[x - 1]);
        }

    }

    static void makePrefixSum(int[] arr) {
        for(int i = 1; i < arr.length; ++i) {
            arr[i] += arr[i - 1];
        }

    }
}