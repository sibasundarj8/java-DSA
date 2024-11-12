package Sorting;/*
 *      Q. WAP to sort an Array using merge sort in O(n log n) time Complexity.
 */
import java.util.Scanner;

public class Sorting_Merge_Sort
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Size :");
        int n = sc.nextInt();

        int[]arr = new int[n];

        System.out.println("Elements :");
        for (int i = 0;i < n;i++)
            arr[i] = sc.nextInt();

        mergeSort(arr,0,n-1);

        for (int i : arr)
            System.out.print(i + " ");
    }
    static void mergeSort(int[]arr,int l,int r){
        // Base Case
        if (l >= r)return;

        // Recursive Work
        int mid = (l+r)/2;
        mergeSort(arr,l,mid);
        mergeSort(arr,mid+1,r);

        // Self Work
        merge(arr,l,r,mid);
    }
    static void merge(int[]arr,int l,int r,int mid){
        int n1 = mid - l + 1;
        int n2 = r - mid;
        int[]left = new int[n1];
        int[]right = new int[n2];
        int i,j,k;
        for (i = 0;i < n1;i++)
            left[i] = arr[l+i];
        for (i = 0;i < n2;i++)
            right[i] = arr[mid+1+i];

        i = 0;
        j = 0;
        k = l;
        while (i < n1 && j < n2){
            if (left[i] <= right[j]) arr[k++] = left[i++];
            else arr[k++] = right[j++];
        }
        while(i < n1) arr[k++] = left[i++];
        while(j < n2) arr[k++] = right[j++];
    }
}