package PrefixSum;/*
 *
 * https://www.geeksforgeeks.org/problems/difference-array/1
 *
 * # Difference Array
 *
 *   Q. You are given an array arr[] and a  2D array opr[][], where each opr[i] denotes an operation in the
 *      format [l, r, v].
 *
 *      For each operation [l, r, v], you need to add the value v to all elements of the array from index l
 *      to r (both inclusive).
 *
 *      Apply all operations sequentially in the given order, and return the final updated array.
 *    Ex.
 *      Input : arr[] = [4, 5, 7, 9]
 *              opr[][] = [[1, 3, 1],
 *                         [2, 3, -2]]
 *      Output: [4, 6, 6, 8]
 *      Explanation:
 *              Operation [1, 3, 1] : Add 1 to indices 1 to 3 → [4, 6, 8, 10]
 *              Operation [2, 3, -2] : Subtract 2 from indices 2 to 3 → [4, 6, 6, 8]
 *              Final array is [4, 6, 6, 8].
 */

import java.util.ArrayList;
import java.util.Scanner;

public class Q04_Difference_Array {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter elements: ");
        String[] s = sc.nextLine().split(" ");

        int n = s.length;
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(s[i]);
        }

        System.out.println("Enter number of operations: ");
        n = sc.nextInt();

        int[][] operations = new int[n][3];

        System.out.println("Enter operation like this (l, r, val)");
        for (int i = 0; i < n; i++) {
            operations[i][0] = sc.nextInt();
            operations[i][1] = sc.nextInt();
            operations[i][2] = sc.nextInt();
        }

        System.out.println("Array after operation: ");
        System.out.println(diffArray(arr, operations));
    }

    /// Solution
/*------------------------------------------------------Brute-Force------------------------------------------------------*/
    static ArrayList<Integer> bruteForce(int[] arr, int[][] opr) {
        // potd.code.hub
        for (int[] op : opr) {
            for (int i = op[0]; i < op[1]; i++) {
                arr[i] += op[2];
            }
        }

        ArrayList<Integer> list = new ArrayList<>();

        for (int i : arr) list.add(i);

        return list;
    }
    
/*---------------------------------------------------Difference-Array---------------------------------------------------*/
    static ArrayList<Integer> diffArray(int[] arr, int[][] opr) {
        // potd.code.hub
        int n = arr.length;
        ArrayList<Integer> list = new ArrayList<>();
        int[] dif = new int[n + 1];
    
        for (int[] x : opr) {
            dif[x[0]] += x[2];
            dif[x[1] + 1] -= x[2];
        }
    
        for (int i = 1; i <= n; i++) {
            dif[i] += dif[i - 1];
            list.add(arr[i - 1] + dif[i - 1]);
        }
    
        return list;
    }
}
