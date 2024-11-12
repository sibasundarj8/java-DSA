package Sorting;/*
 *    Q. WAP to sort an Array of n size using bubble sort Algorithm.
 *      input :   n = 5
 *            arr[] = {1, 2, 5, 3, 4}
 *     output : 1 2 3 4 5
 *
 *     Time complexity  ->>
 *          best case   : O(n)
 *          Worst Case  : O(n²)
 *     Space Complexity ->>
 *          Every case  : O(1)
 */
import java.util.Scanner;

public class Sorting_Bubble_Sort {
    static void sort(int[]arr){
        int n = arr.length;
        for (int i = 0;i < n-1;i++) {
            // to check the array is sorted or not before next iteration.
            boolean flag = true;
            // no need to check last i elements bcz they are already sorted
            for (int j = 0; j < n - 1 - i; j++)
                // moving the largest element to end
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    flag = false;
                }
            if (!flag)return;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Size :");
        int n = sc.nextInt();

        int[]arr = new int[n];

        System.out.println("Elements :");
        for (int i = 0;i < n;i++)
            arr[i] = sc.nextInt();

        sort(arr);

        for (int i : arr)
            System.out.print(i + " ");
    }
}