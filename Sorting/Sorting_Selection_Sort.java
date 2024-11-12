package Sorting;/*
 *      Q. WAP to sort an array of given size N using selection sort.
 *
 *      Time Complexity.
 *                      O(n²)
 *      Space Complexity.
 *                      O(n)
 */
import java.util.Scanner;

public class Sorting_Selection_Sort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Size :");
        int n = sc.nextInt();

        int[]arr = new int[n];

        System.out.println("Elements :");
        for (int i = 0;i < n;i++)
            arr[i] = sc.nextInt();
        sort(arr);
        for (int i : arr) System.out.print(i + " ");
    }
    static void sort(int[]arr){
        int n = arr.length;
        for (int i = 0;i < n-1;i++){
            int min = i;
            for (int j = i+1;j < n;j++)
                if (arr[j] < arr[min])
                    min = j;
            if (min != i){
                int temp = arr[i];
                arr[i] = arr[min];
                arr[min] = temp;
            }
        }
    }
}