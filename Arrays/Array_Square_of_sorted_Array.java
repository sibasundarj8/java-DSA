package Array;

import java.util.Scanner;

public class Array_Square_of_sorted_Array {
    public Array_Square_of_sorted_Array() {
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Array Size : ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.print("Array Elements : ");

        for(int i = 0; i < n; ++i) {
            arr[i] = sc.nextInt();
        }

        printArray(squareOfAllElements(arr, n));
    }

    static void printArray(int[] arr) {
        System.out.print("Square of this Array is : ");

        for (int i : arr) {
            System.out.print(i + " ");
        }

    }

    static int[] squareOfAllElements(int[] arr, int n) {
        int[] ans = new int[n];
        int t = 0;
        int posIndex = n;

        int negIndex;
        for(negIndex = 0; negIndex < n; ++negIndex) {
            if (arr[negIndex] >= 0) {
                posIndex = negIndex;
                break;
            }
        }

        negIndex = posIndex - 1;

        while(posIndex < n && negIndex >= 0) {
            int posSquare = arr[posIndex] * arr[posIndex];
            int negSquare = arr[negIndex] * arr[negIndex];
            if (posSquare > negSquare) {
                ans[t++] = negSquare;
                --negIndex;
            }

            if (negSquare >= posSquare) {
                ans[t++] = posSquare;
                ++posIndex;
            }
        }

        while(negIndex >= 0) {
            ans[t++] = arr[negIndex] * arr[negIndex];
            --negIndex;
        }

        while(posIndex < n) {
            ans[t++] = arr[posIndex] * arr[posIndex];
            ++posIndex;
        }

        return ans;
    }
}