package Sorting;/*
 *    Q. WAP to sort an array of size n in increasing order using Insertion sort.
 *
 *      Time Complexity :  O(n²)
 *      Space Complexity : O(1)
 */
import java.util.Scanner;

public class Sorting_Insertion_Sort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("size :");
        int n = sc.nextInt();
        int[]arr = new int[n];
        System.out.println("Elements :");
        for (int i = 0;i < n;i++) arr[i] = sc.nextInt();
        sort(arr);
        for (int i : arr) System.out.print(i + " ");
    }
    static void sort(int[]arr){
        int n = arr.length;
        for (int i = 1;i < n;i++){
            int j = i;
            while (j > 0 && arr[j] < arr[j-1]){
                int temp = arr[j-1];
                arr[j-1] = arr[j];
                arr[j--] = temp;
            }
        }
    }
}