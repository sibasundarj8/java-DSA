package Array;

import java.util.Scanner;

public class Array_3_Pointers_Approach {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Size :");
        int[]arr = new int[sc.nextByte()];
        System.out.println("Elements : (must be 0 or 1 or 2)");
        for (int i = 0;i < arr.length;i++)
            arr[i] = sc.nextInt();
        sort(arr);
        printArray(arr);
    }
    static void sort(int[]arr){
        int n = arr.length;
        int low = 0;
        int mid = 0;
        int high = n-1;
        while (mid <= high){
            if (arr[mid] == 0){
                swap(arr,mid,low);
                mid++;
                low++;
            }
            if (arr[mid] == 2){
                swap(arr,mid,high);
                high--;
            }
            if (arr[mid] == 1) mid++;
        }
    }
    static void swap(int[]arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    static void printArray(int[]arr){
        for (int i : arr) System.out.print(i + " ");
        System.out.println();
    }
}