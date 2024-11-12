package Array;

import java.util.Scanner;

public class Array_Kth_smallest_element
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Array size : ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        System.out.println("Array Elements : ");
        int k;
        for(k = 0; k < n; ++k)
        {
            arr[k] = sc.nextInt();
        }
        System.out.print("k = ");
        k = sc.nextInt();
        System.out.println(k + " th smallest Element is : \n" + kthSmallest(arr, k));
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static int partition(int[] arr, int left, int right)
    {
        int pivot = arr[right];
        int i = left - 1;

        for(int j = left; j < right; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, right);
        return i + 1;
    }

    private static int kthSmallestHelper(int[] arr, int left, int right, int k)
    {
        int pivotIndex = partition(arr, left, right);
        if (pivotIndex == k - 1) {
            return arr[pivotIndex];
        } else {
            return pivotIndex < k - 1 ? kthSmallestHelper(arr, pivotIndex + 1, right, k) : kthSmallestHelper(arr, left, pivotIndex - 1, k);
        }
    }

    public static int kthSmallest(int[] arr, int k) {
        return kthSmallestHelper(arr, 0, arr.length - 1, k);
    }
}