package Array;

import java.util.Scanner;

public class Array_Sorting_the_Square_of_Elements {
    public Array_Sorting_the_Square_of_Elements() {
    }
    static void printArray(int[] arr) {

        for (int i : arr)
        {
            System.out.print(i + " ");
        }
        System.out.println();
    }
    static int[] sortSquares(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        int k = arr.length - 1;
        int[] ans = new int[arr.length];

        while(left <= right) {
            if (Math.abs(arr[left]) > Math.abs(arr[right])) {
                ans[k--] = arr[left] * arr[left];
                left++;
            } else {
                ans[k--] = arr[right] * arr[right];
                right--;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Array size : ");
        int[] arr = new int[sc.nextInt()];
        System.out.println("Note : Elements must be in increasing order order.\nArray Elements : ");

        for(int i = 0; i < arr.length; ++i) {
            arr[i] = sc.nextInt();
        }

        printArray(sortSquares(arr));
    }
}