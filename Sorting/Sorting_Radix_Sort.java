package Sorting;/*
 *   Q. WAP to sort an Array of length n using Radix Sort.
 */
import java.util.Scanner;

public class Sorting_Radix_Sort {
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
    static void sort(int[]arr){
        int max = arr[0];
        for (int i : arr)max = Math.max(max,i);
        // Sort elements on the basis of digits.
        int place = 1;
        while(max > 0){
            count_Sort(arr,place);
            place*=10;
            max/=10;
        }
    }
    static void count_Sort(int[]arr,int place){
        int n = arr.length;
        // Frequency Array
        int[]count = new int[10];
        for (int i : arr) count[(i/place)%10]++;
        // prefix sum
        for (int i = 1;i < 10;i++)
            count[i] += count[i-1];
        int[]ans = new int[n];
        for (int i = n-1;i >= 0;i--){
            int idx = count[(arr[i]/place)%10]-1;
            ans[idx] = arr[i];
            count[(arr[i]/place)%10]--;
        }
        System.arraycopy(ans,0,arr,0,n);
    }
}