package DP;/*
 *
 * https://www.geeksforgeeks.org/problems/brackets-in-matrix-chain-multiplication1024/1
 *
 * # Brackets in Matrix Chain Multiplication
 *
 *   Q. Given an array arr[] of length n used to denote the dimensions of a series of matrices such that the dimension of
 *      i'th matrix is arr[i] * arr[i+1]. There are a total of n-1 matrices. Find the most efficient way to multiply these
 *      matrices together.
 *
 *      Your task is to return the string which is formed of A - Z (only Uppercase) denoting matrices & Brackets( "(" ")" )
 *      denoting multiplication symbols. For example, if n = 11, the matrices can be denoted as A - K as n <= 26 &
 *      multiplication of A and B is denoted as (AB).
 *
 *      NOTE:
 *         1) Each multiplication is denoted by putting open & closed brackets to the matrices multiplied & also, please
 *            note that the order of matrix multiplication matters, as matrix multiplication is non-commutative A*B != B*A
 *         2) As there can be multiple possible answers, the console would print "true" for the correct string and "false"
 *            for the incorrect string. You need to only return a string that performs a minimum number of multiplications.
 *
 *    Ex.
 *      Input : arr[] = [40, 20, 30, 10, 30]
 *      Output: true
 *      Explanation: Let's divide this into matrix(only 4 are possible)
 *                   [ [40, 20] -> A,
 *                     [20, 30] -> B,
 *                     [30, 10] -> C,
 *                     [10, 30] -> D ]
 *
 *                   First we perform multiplication of B & C -> (BC), then we multiply A to (BC) -> (A(BC)), then we
 *                   multiply D to (A(BC)) -> ((A(BC))D)
 *
 *                   So the solution returned the string ((A(BC))D), which performs minimum multiplications. The total
 *                   number of multiplications are 20*30*10 + 40*20*10 + 40*10*30 = 26,000.
 *
 *  Constraints:
 *      2 ≤ arr.size() ≤ 50
 *      1 ≤ arr[i] ≤ 100
 */

import java.util.Scanner;

public class Dynamic_Programming_Brackets_in_Matrix_Chain_Multiplication {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter MCM array elements: ");
        String[] s = sc.nextLine().split(" ");

        int n = s.length;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(s[i]);

        System.out.println("Optimized way: " + matrixChainOrder(arr));
    }

    /// Solution
/*
✦> ✦> ✦> ✦> ✦> ✦> ✦> ✦> ✦> ✦> ✦> ✦> ✦> ✦> ✦> ✦> ✦> ✦> -Memoization- <✦ <✦ <✦ <✦ <✦ <✦ <✦ <✦ <✦ <✦ <✦ <✦ <✦ <✦ <✦ <✦ <✦ <✦
TC : O(n³)
SC : O(n²)
*/
    private static class Pair {
        int value;
        String expression;

        public Pair(int val, String exp) {
            this.value = val;
            this.expression = exp;
        }
    }

    static String matrixChainOrder(int[] arr) {
        // potd.code.hub
        int n = arr.length;
        Pair[][] dp = new Pair[n][n];

        return f(0, n - 1, arr, dp).expression;
    }

    private static Pair f(int l, int r, int[] arr, Pair[][] dp) {
        Pair ans = new Pair(Integer.MAX_VALUE, "");
        if (dp[l][r] != null) return dp[l][r];

        for (int i = l + 1; i < r; i++) {
            Pair left = f(l, i, arr, dp);
            Pair right = f(i, r, arr, dp);
            int total = left.value + right.value + arr[l] * arr[i] * arr[r];

            if (total < ans.value) {
                ans.value = total;
                ans.expression = "(" + left.expression + right.expression + ")";
            }
        }

        return dp[l][r] = (ans.value == Integer.MAX_VALUE) ? new Pair(0, (char) (65 + l) + "") : ans;
    }
}
