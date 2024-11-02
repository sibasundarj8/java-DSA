package Array;

import java.util.Scanner;

public class Array_TwoSum {
    public Array_TwoSum() {
    }

    static int[] twoSum(int[] arr, int target) {
        for(int i = 0; i < arr.length; ++i) {
            for(int j = i + 1; j < arr.length; ++j) {
                if (arr[i] + arr[j] == target) {
                    return new int[]{i+1, j+1};
                }
            }
        }

        throw new RuntimeException("Pair not found!!");
    }

    static void printInfo(int[] arr) {

        for (int j : arr)
        {
            System.out.print(j + " ");
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Array size : ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.print("Array Elements : ");

        int t;
        for(t = 0; t < n; ++t) {
            arr[t] = sc.nextInt();
        }

        System.out.print("Target : ");
        t = sc.nextInt();
        printInfo(twoSum(arr, t));
    }
}