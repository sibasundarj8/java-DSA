package Sorting;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Sorting_Quick_Sort {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

//        System.out.println("Size :");
//        int n = sc.nextInt();
//
        int[]arr = {9,2,8,9,9,7,7,7};
//
//        System.out.println("Elements :");
//        for (int i = 0;i < n;i++)
//            arr[i] = sc.nextInt();

        sort(arr,0,7);

        for (int i : arr)
            System.out.print(i + " ");
    }
    static void sort(int[]arr,int start,int end){
        // Base Case
        if (start >= end)return;

        // Self-Work
        int pivot = partition(arr,start,end);

        // Recursive Work
        sort(arr,start,pivot-1);
        sort(arr,pivot+1,end);
    }
    static int partition (int[]arr,int start,int end){

        int pivot = ThreadLocalRandom.current().nextInt(start,end);

        /// Counting elements smaller than pivot.
        int count = 0;
        for (int i = start;i <= end;i++) {
            if (i == pivot)continue;
            if (arr[i] <= arr[pivot]) count++;
        }

        /// Placing pivot to its correct position.
        count += start;
        int temp = arr[count];
        arr[count] = arr[pivot];
        arr[pivot] = temp;
        pivot = count;

        /// Swapping all elements smaller than pivot to left and greater elements to right.
        int i = start;
        int j = end;
        while(i < pivot && j > pivot){
            while (arr[i] <= arr[pivot]) i++;
            while (arr[j] > arr[pivot]) j--;
            if (i < j){
                temp = arr[i];
                arr[i++] = arr[j];
                arr[j--] = temp;
            }
        }

        return pivot;
    }
}