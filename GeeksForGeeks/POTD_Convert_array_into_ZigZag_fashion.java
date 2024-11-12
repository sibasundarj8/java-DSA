package GFG;/*
 *    Q.  Given an array arr of distinct elements of size n, the task is to rearrange the
 *        elements of the array in a zigzag fashion so that the converted array should be
 *        in the below form:
 *          arr[0] < arr[1] > arr[2] < arr[3] > arr[4] <.....arr[n-2] < arr[n-1] > arr[n].
 *      Ex.
 *          Input : n = 7, arr[] = {4, 3, 7, 8, 6, 2, 1}
 *          Output: 3 7 4 8 2 6 1
 *          Explanation: 3 < 7 > 4 < 8 > 2 < 6 > 1
 */
import java.util.Scanner;

public class POTD_Convert_array_into_ZigZag_fashion
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("size :");
        int n = sc.nextInt();

        int[]arr = new int[n];

        System.out.println("Elements :");
        for (int i = 0;i < n;i++)arr[i] = sc.nextInt();

        zigZag(n,arr);

        for (int i : arr) System.out.print(i + " ");
    }
    static void zigZag(int n, int[] arr) {
        // code here
        for(int i = 1;i < n-1;i+=2){
            if(arr[i-1] > arr[i]){
                int temp = arr[i-1];
                arr[i-1] = arr[i];
                arr[i] = temp;
            }
            if(arr[i] < arr[i+1]){
                int temp = arr[i];
                arr[i] = arr[i+1];
                arr[i+1] = temp;
            }
        }
        if(n%2 == 0 && arr[n-1] < arr[n-2]){
            int temp = arr[n-1];
            arr[n-1] = arr[n-2];
            arr[n-2] = temp;
        }
    }
}