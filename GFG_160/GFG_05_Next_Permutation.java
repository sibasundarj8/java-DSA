package GFG_160;/*
 * https://www.geeksforgeeks.org/problems/next-permutation5226/1
 *
 * # Next Permutation
 *
 *   Q. Given an array of integers arr[] representing a permutation, implement the next permutation that
 *      rearranges the numbers into the lexicographically next greater permutation. If no such permutation
 *      exists, rearrange the numbers into the lowest possible order (i.e., sorted in ascending order).
 *
 *      Note - A permutation of an array of integers refers to a specific arrangement of its elements in a sequence or linear order.
 *    Ex.
 *      Input : arr = [2, 4, 1, 7, 5, 0]
 *      Output: arr = [2, 4, 5, 0, 1, 7]
 *      Explanation: The next permutation of the given array is {2, 4, 5, 0, 1, 7}.
 */
import java.util.Scanner;

public class GFG_05_Next_Permutation {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Size: ");
        int n = sc.nextInt();

        int[]arr = new int[n];

        System.out.println("Elements: ");
        for (int i = 0;i < n;i++){
            arr[i] = sc.nextInt();
        }

        nextPermutation(arr);

        for (int i : arr) System.out.print(i + " ");
        System.out.println();
    }

    /// Solution
    static void nextPermutation(int[] arr) {
        // potd.code.hub
        int n = arr.length;
        int ptr;

        // consider the whole array as a number
        for (ptr = n-2;ptr >= 0;ptr--){
            if (arr[ptr] < arr[ptr+1]){
                break;
            }
        }
        if (ptr == -1){
            reverse(arr, 0, n-1);
            return;
        }
        for (int i = n-1;i >= 0;i--){
            if (arr[i] > arr[ptr]){
                int temp = arr[i];
                arr[i] = arr[ptr];
                arr[ptr] = temp;
                break;
            }
        }

        reverse(arr, ptr+1, n-1);
    }
    static void reverse(int[]arr, int i, int j){
        while(i < j){
            int temp = arr[i];
            arr[i++] = arr[j];
            arr[j--] = temp;
        }
    }
}
