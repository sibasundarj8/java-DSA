package Sorting;/*
 *   Q. Given an array of n elements, the task is to find the elements that are greater than half
 *      of elements in an array. In case of odd elements, we need to print elements larger than
 *      floor(n/2) elements where n is total number of elements in array.
 *
 *       Input :    n = 4
 *                  arr[] = [1, 6, 3, 4]
 *      Output :    4 6
 */
import java.util.Scanner;

public class Sorting_Ceil_Elements {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Size :");
        int n = sc.nextInt();
        int[]arr = new int[n];
        System.out.println("Elements :");
        for (int i = 0;i < n;i++)
            arr[i] = sc.nextInt();
        printCeil(arr,n);
    }
    static void printCeil(int[]arr,int n){
        for (int i = 1;i < n;i++)
            for (int j = i;j < n;j++)
                while(j > 0 && arr[j] < arr[j-1]){
                    int temp = arr[j-1];
                    arr[j-1] = arr[j];
                    arr[j--] = temp;
                }
        int ceil = n-n/2;
        for (int i = ceil;i < n;i++)
            System.out.print(arr[i] + " ");
    }
}