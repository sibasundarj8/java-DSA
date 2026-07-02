package cses.Q002_Missing_Number;/*
 *
 * https://cses.fi/problemset/task/1083
 *
 * # Missing Number
 *
 *   Q. You are given all numbers between 1,2,...,n except one. Your task is to find the missing number.
 *
 *      Input:-
 *          The first input line contains an integer n.
 *          The second line contains n-1 numbers. Each number is distinct and between 1 and n (inclusive).
 *
 *      Output:-
 *          Print the missing number.
 *
 *      Constraints:-
 *          2 <= n <= 2 * 10⁵
 *
 *      Example:
 *
 *          Input:
 *              5
 *              2 3 1 5
 *
 *          Output:
 *              4
 */

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        // Start XOR with n, then XOR with all numbers from 1 to n-1
        // and all input numbers provided.
        int xor = n;

        for (int i = 1; i < n; i++) {
            xor ^= i ^ sc.nextInt();
        }

        System.out.println(xor);
    }
}
