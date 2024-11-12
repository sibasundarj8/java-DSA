package Sorting;/*
 *     Q. Given an array of digits (values are from 0 to 9), the task is to find the minimum
 *        possible sum of two numbers formed from digits of the array. Please note that all
 *        digits of the given array must be used to form the two numbers.
 *
 *          Input : n = 6
 *                  arr[] = [6, 8, 4, 5, 2, 3]
 *          Output : 604
 */
import java.util.Scanner;

public class Sorting_Minimum_Possible_Sum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Size :");
        int n = sc.nextInt();
        int[]arr = new int[n];
        System.out.println("Elements :");
        for (int i = 0;i < n;i++)arr[i] = sc.nextInt();
        System.out.println("= " + findSum(arr,n));
    }
    static int findSum (int[]arr,int n){
        for (int i = 1;i < n;i++)
            for (int j = i;j > 0 && arr[j] < arr[j-1];j--){
                int temp = arr[j-1];
                arr[j-1] = arr[j];
                arr[j] = temp;
            }
        int n1 = 0;
        int n2 = 0;
        for (int i = 0;i < n;i++) {
            if (i % 2 == 0) n1 =n1*10 + arr[i];
            else n2 = n2*10 + arr[i];
        }
        System.out.println(n1 + " + " + n2);
        return n1+n2;
    }
}