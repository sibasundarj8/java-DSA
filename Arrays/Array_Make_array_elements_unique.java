package Array;/*
 * https://www.geeksforgeeks.org/problems/make-array-elements-unique--170645/1
 *
 * # Make array elements unique
 *
 *   Q. Given an array arr[ ], your task is to find the minimum number of increment operations
 *      required to make all the elements of the array unique. i.e.- no value in the array should
 *      occur more than once. In one operation, a value can be incremented by 1 only.
 *    Ex.
 *      Input : arr[] = [1, 3, 1, 2]
 *      Output: 3
 *      Explanation: step-1 : [1,  3,  1,  2]   Number of Operation = 0
 *                   step-2 : [1,  3, <2>, 2]   Number of Operation = 1
 *                   step-3 : [1,  3,  2, <3>]  Number of Operation = 2
 *                   step-4 : [1, <4>, 2,  3]   Number of Operation = 3
 */
import java.util.Arrays;
import java.util.Scanner;

public class Array_Make_array_elements_unique {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Size: ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        System.out.println("Elements: ");
        for (int i = 0;i < n;i++){
            arr[i] = sc.nextInt();
        }

        System.out.print("Minimum Increment: ");
        System.out.println(minIncrements(arr));
    }

    /// Solution
    static int minIncrements(int[] arr) {
        // potd.code.hub
        int n = arr.length;
        int count = 0;
        Arrays.sort(arr);
        for (int i = 1;i < n;i++){
            if (arr[i] <= arr[i-1]){
                int temp = arr[i-1] - arr[i] + 1;
                count += temp;
                arr[i] = arr[i-1]+1;
            }
        }
        return count;
    }
}