package Recursion;/*
 *    Q.  WAP to recursive program to sort an Array of length n.
 *   Ex.
 *      Input  : n = 5
 *              arr[] = {5,4,2,3,1}
 *      Output : 1 2 3 4 5
 *
 */
import java.util.Scanner;

public class Recursion_47_Insertion_Sort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Size :");
        int n = sc.nextInt();
        int[]arr = new int[n];
        System.out.println("Elements :");
        for (int i = 0;i < n;i++)
            arr[i] = sc.nextInt();
        recSort(arr,n);
        for (int i : arr)
            System.out.print(i + " ");
        System.out.println();
    }
    static void recSort(int[]arr,int n){
        // Base Case
        if (n <= 0) return;

        // Recursive Work
        recSort(arr,n-1);

        // Self Work
        int last = arr[n-1];
        int j = n-2;
        while (j >= 0 && arr[j] > last)
            arr[j+1] = arr[j--];
        arr[j+1] = last;
    }
}