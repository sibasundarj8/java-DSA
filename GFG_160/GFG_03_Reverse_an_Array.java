package GFG_160;
/*
 * https://www.geeksforgeeks.org/problems/reverse-an-array/1
 *
 * # Reverse an Array
 *
 *   Q. You are given an array of integers arr[]. Your task is to reverse the given array.
 *    Ex.
 *      Input : arr = [1, 4, 3, 2, 6, 5]
 *      Output: arr = [5, 6, 2, 3, 4, 1]
 *      Explanation: The elements of the array are 1 4 3 2 6 5. After reversing the array, the first element
 *                   goes to the last position, the second element goes to the second last position and so on.
 *                   Hence, the answer is 5 6 2 3 4 1.
 */
import java.util.Scanner;

public class GFG_03_Reverse_an_Array {

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

        reverseArray(arr);

        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    /// Solution
    static void reverseArray(int[]arr) {
        // potd.code.hub
        int i = 0;
        int j = arr.length-1;

        while (i < j){
            int temp = arr[i];
            arr[i++] = arr[j];
            arr[j--] = temp;
        }
    }
}