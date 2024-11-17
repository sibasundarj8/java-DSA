package GFG_160;/*
 * https://www.geeksforgeeks.org/problems/move-all-zeroes-to-end-of-array0751/1
 *
 * # Move All Zeroes to End
 *
 *   Q. Given an array arr[]. Push all the zeros of the given array to the right end of the array while
 *      maintaining the order of non-zero elements. Do the mentioned change in the array in place.
 *    Ex.
 *      Input : arr[] = [1, 2, 0, 4, 3, 0, 5, 0]
 *      Output: arr[] = [1, 2, 4, 3, 5, 0, 0, 0]
 *      Explanation: There are three 0s that are moved to the end.
 */
import java.util.Scanner;

public class GFG_02_Move_All_Zeroes_to_End {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Array size :");
        int n = sc.nextInt();

        int[] arr = new int[n];

        System.out.println("Enter Array Elements :");
        for(int i = 0; i < n; ++i) {
            arr[i] = sc.nextInt();
        }

        pushZerosToEnd(arr);

        for (int i : arr){
            System.out.print(i + " ");
        }
        System.out.println();
    }

    /// Solution
    static void pushZerosToEnd(int[] arr) {
        // potd.code.hub
        int n = arr.length;
        int idx = 0;

        for(int i = 0;i < n;i++){
            if(arr[i] != 0){
                arr[idx] = arr[i];
                idx++;
            }
        }

        while(idx < n){
            arr[idx] = 0;
            idx++;
        }
    }
}