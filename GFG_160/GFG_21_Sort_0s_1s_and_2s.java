package GFG_160;/*
 * https://www.geeksforgeeks.org/problems/sort-an-array-of-0s-1s-and-2s4231/1
 *
 * # Sort 0s, 1s and 2s
 *
 *   Q. Given an array arr[] containing only 0s, 1s, and 2s. Sort the array in ascending order.
 *    Ex.
 *      Input : arr[] = [0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1]
 *      Output: [0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2]
 *      Explanation: 0s 1s and 2s are segregated into ascending order.
 */
import java.util.Scanner;

public class GFG_21_Sort_0s_1s_and_2s {

    // main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Size: ");
        int n = sc.nextInt();

        int[]arr = new int[n];

        System.out.println("Elements: ");
        for (int i = 0;i < n;i++){
            arr[i] = sc.nextInt();
        }

        sort012(arr);

        for (int i : arr)
            System.out.print(i + " ");
    }

    // Solution
    static void sort012(int[] arr) {
        // potd.code.hub
        int n = arr.length;
        int zero = 0, one = 0;

        for (int i : arr){
            if (i == 0) zero++;
            else if (i == 1) one++;
        }
        for (int i = 0;i < n;i++){
            if (i < zero) arr[i] = 0;
            else if (i < zero+one) arr[i] = 1;
            else arr[i] = 2;
        }
    }
}
