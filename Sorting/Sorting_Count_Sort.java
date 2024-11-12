package Sorting;

import java.util.Scanner;

public class Sorting_Count_Sort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Size :");
        int[]arr = new int[sc.nextInt()];
        System.out.println("Elements :");
        for (int i = 0;i < arr.length;i++)
            arr[i] = sc.nextInt();
        sort(arr);
        for (int i : arr) System.out.print(i + " ");
    }
    static void sort (int[]arr){
        int n = arr.length;

        // Getting Maximum
        int max = arr[0];
        for (int i : arr) max = Math.max(max,i);

        // Frequency Array
        int[]count = new int[max+1];
        for (int i : arr) count[i]++;

        // Prefix Sum Array
        for (int i = 1;i <= max;i++)count[i] += count[i-1];

        // Sorting with Stability
        int[]ans = new int[n];
        for (int i = n-1;i >= 0;i--){
            int idx = count[arr[i]]-1;
            ans[idx] = arr[i];
            count[arr[i]]--;
        }
        System.arraycopy(ans, 0, arr, 0, n);
    }
}