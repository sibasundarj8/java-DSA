package Hashing;/*
 * https://www.geeksforgeeks.org/problems/find-distinct-elements2054/1
 * 
 * # Find distinct elements
 * 
 *   Q. Given an N x N matrix M. Write a program to find count of all the distinct elements common to all rows of 
 *      the matrix. Print count of such elements.
 *   Ex.
 *      Input : N = 4
 *              M = {{2, 1, 4, 3},
 *                   {1, 2, 3, 2},
 *                   {3, 6, 2, 3},
 *                   {5, 2, 5, 3}}
 *      Output: 2
 *      Explanation: Only 2 and 3 are common in all rows.
 * 
 *   Constraints:
 *          1 ≤ N ≤ 100
 *          1 ≤ M[i][j] ≤ 1000
 */

import java.util.HashSet;
import java.util.Scanner;

public class Find_distinct_elements {

    /// main Method
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter size: ");
        int n = sc.nextInt();

        int[][] mat = new int[n][n];

        System.out.println("Enter elements for " + n + " * " + n + " matrix: ");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                mat[i][i] = sc.nextInt();
            }
        }

        System.out.println("Number of elements common to every column: " + distinct(mat, n));
    }

    /// Solution
    static int distinct(int[][] mat, int n) {
        // potd.code.hub
        HashSet<Integer> set = new HashSet<>();

        for (int i : mat[0]) set.add(i);

        for (int i = 1; i < n; i++) {
            HashSet<Integer> temp = new HashSet<>();

            for (int j = 0; j < n; j++)
                if (set.contains(mat[i][j])) temp.add(mat[i][j]);

            set = temp;
        }

        return set.size();
    }
}
