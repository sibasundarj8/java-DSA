package Recursion;/*
 *
 * https://www.geeksforgeeks.org/problems/n-digit-numbers-with-digits-in-increasing-order5903/1
 *
 * # N-Digit Numbers with Increasing Digits
 *
 *   Q. Given an integer n, return all the n digit numbers in increasing order, such that their digits are in strictly
 *      increasing order(from left to right).
 *
 *    Ex.
 *      Input : n = 2
 *      Output: [12, 13, 14, 15, 16, 17, 18, 19, 23....79, 89]
 *      Explanation: For n = 2, the correct sequence is 12 13 14 15 16 17 18 19 23 and so on up to 89.
 *
 *  Constraints:
 *        1 ≤ n ≤ 10⁵
 */

import java.util.ArrayList;
import java.util.Scanner;

public class Recursion_61_N_Digit_Numbers_with_Increasing_Digits {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Size of number: ");
        int n = sc.nextInt();

        System.out.println("All the n digit numbers in increasing order: ");
        System.out.println(increasingNumbers(n));
    }

    /// Solution
    static ArrayList<Integer> increasingNumbers(int n) {
        // potd.code.hub
        ArrayList<Integer> ans = new ArrayList<>();

        if (n > 9) return ans;
        if (n == 1) ans.add(0)
                ;
        solve(0, 0, n, ans);
        return ans;
    }

    private static void solve(int prevDigit, int number, int n, ArrayList<Integer> ans) {
        // base case
        if (n == 0) {
            ans.add(number);
            return;
        }

        // recursion
        for (int i = prevDigit + 1; i <= 9; i++) {
            solve(i, number * 10 + i, n - 1, ans);
        }
    }
}
