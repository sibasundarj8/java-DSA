package GFG_160;/*
 *
 * https://www.geeksforgeeks.org/problems/find-repetitive-element-from-1-to-n-1/1
 *
 * # Find Only Repetitive Element from 1 to n-1
 *
 *   Q. Given an array arr[] of size n, filled with numbers from 1 to n-1 in random order. The
 *      array has only one repetitive element. Your task is to find the repetitive element.
 *
 *      Note: It is guaranteed that there is a repeating element present in the array.
 *   Ex.
 *      Input : arr[] = [1, 3, 2, 3, 4]
 *      Output: 3
 *      Explanation: The number 3 is the only repeating element.
 */

import java.util.Scanner;

public class GFG_157_Find_Only_Repetitive_Element_from_1_to_n_minus_1 {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Array Elements: ");
        String[] s = sc.nextLine().split(" ");

        int n = s.length;

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(s[i]);
        }

        System.out.println(findDuplicate(arr));
    }

    /// Solution
    static int findDuplicate(int[] arr) {
        // potd.code.hub
        int n = arr.length;
        int xor = 0;

        for (int i = 0; i < n; i++) {
            xor ^= (i + 1) ^ arr[i];
        }

        return xor ^ n;
    }
}
