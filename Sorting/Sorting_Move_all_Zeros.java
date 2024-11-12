package Sorting;/*
 *   Q. Given an integer array arr, move all 0's to the end of it while maintaining
 *      the relative order of the non-zero elements.
 *
 *      Input  : n = 5
 *            arr[]={0, 5, 0, 4, 3}
 *      Output : 5 4 3 0 0
 */
import java.util.Scanner;

public class Sorting_Move_all_Zeros {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Size :");
        int n = sc.nextInt();
        int[]arr = new int[n];
        System.out.println("Elements :");
        for (int i = 0;i < n;i++)
            arr[i] = sc.nextInt();
        moveZeros(arr,n);
        for (int i : arr) System.out.print(i + " ");
    }
    static void moveZeros(int[]arr,int n){
        for (int i = 0;i < n-1;i++)
            for (int j = 0;j < n-1-i;j++)
                if (arr[j] == 0 && arr[j+1] != 0){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
    }
}