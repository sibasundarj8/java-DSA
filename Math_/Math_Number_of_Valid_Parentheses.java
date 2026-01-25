package Math_;/*
 *
 * https://www.geeksforgeeks.org/problems/valid-number-of-parenthesis/1
 *
 * # Number of Valid Parentheses
 *
 *   Q. You are given a number n, your task is to find the number of all the valid parentheses expressions of that length
 *      using only "(" and ")" brackets.
 *
 *      An input string of parentheses is valid if :
 *          Open brackets must be closed in correct order.
 *          Every close bracket has a corresponding open bracket.
 *
 *      For example - "()()" or "(())" are valid while ")()(" or "))((" are invalid parentheses expressions.
 *   Ex.
 *      Input : n = 6
 *      Output: 5
 *      Explanation: Possible valid expressions of length 6 are "((()))", "(())()", "()(())", "()()()" and "(()())".
 *
 *  Constraints:
 *      1 ≤ n ≤ 20
 */

import java.util.Scanner;

public class Math_Number_of_Valid_Parentheses {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the length of String : ");
        int n = sc.nextInt();

        System.out.println("Number of valid parentheses possible : ");
        System.out.println(findWays(n));
    }

    /// Solution
    static int findWays(int n) {
        if ((n & 1) == 1) return 0;

        int m = n / 2 - 1;
        double ans = 1;

        for (int i = 0; i < m; i++) {
            ans = ans * (n - i) / (i + 2);
        }

        return (int) ans;
    }
}
