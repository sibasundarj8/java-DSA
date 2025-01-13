package GFG_160;/*
 *
 * https://www.geeksforgeeks.org/problems/equilibrium-point-1587115620/1
 *
 * # Equilibrium Point
 *
 *   Q. Given an array arr[] of non-negative numbers. The task is to find the first equilibrium
 *      point in the array.
 *
 *      The equilibrium point in an array is an index (0-based indexing) such that the sum of all
 *      elements before that index is the same as the sum of elements after it. Return -1 if no
 *      such point exists.
 *    Ex.
 *      Input : arr[] = [1, 2, 0, 3]
 *      Output: 2
 *      Explanation: The sum of left  of index 2 is 1 + 2 = 3
 *                   and sum on right of index 2 is 0 + 3 = 3.
 */
import java.util.Scanner;

public class GFG_61_Equilibrium_Point {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Size: ");
        int n = sc.nextInt();

        int[]arr = new int[n];

        System.out.println("Elements: ");
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();

        System.out.println(findEquilibrium(arr));
    }

    /// Solution
    static int findEquilibrium(int...arr) {
        // potd.code.hub
        int suffix = 0, prefix = 0, n = arr.length;
        for (int i : arr) suffix += i;
        for (int i = 0;i < n;i++){
            suffix -= arr[i];
            if (prefix == suffix) return i;
            prefix += arr[i];
        }

        return -1;
    }
}
