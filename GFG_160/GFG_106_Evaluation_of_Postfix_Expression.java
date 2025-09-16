package GFG_160;/*
 *
 * https://www.geeksforgeeks.org/problems/evaluation-of-postfix-expression1735/1
 *
 * # Evaluation of Postfix Expression
 *
 *   Q. You are given an array of strings arr[] that represents a valid arithmetic expression written in
 *      Reverse Polish Notation (Postfix Notation). Your task is to evaluate the expression and return an
 *      integer representing its value.
 *
 *      Note: A postfix expression is of the form operand1 operand2 operator (e.g., "a b +").
 *            And the division operation between two integers always computes the floor value,
 *            i.e floor(5 / 3) = 1 and floor(-5 / 3) = -2.
 *
 *            It is guaranteed that the result of the expression and all intermediate calculations will
 *            fit in a 32-bit signed integer.
 *      Ex.
 *          Input : arr[] = ["2", "3", "^", "1", "+"]
 *          Output: 9
 *          Explanation: If the expression is converted into an infix expression, it will be
 *                       2 ^ 3 + 1 = 8 + 1 = 9.
 */

import java.util.Scanner;
import java.util.Stack;

public class GFG_106_Evaluation_of_Postfix_Expression {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Size: ");
        int n = sc.nextInt();

        String[] postExpression = new String[n];

        System.out.println("Enter Expression: ");
        for (int i = 0; i < n; i++)
            postExpression[i] = sc.next();

        System.out.println(evaluatePostfix(postExpression));
    }

    /// Solution
    static int evaluatePostfix(String[] arr) {
        // potd.code.hub
        Stack<Integer> stack = new Stack<>();

        for (String s : arr) {
            if (!Character.isDigit(s.charAt(0)) && s.length() == 1) {
                int y = stack.pop();
                int x = stack.pop();

                switch (s) {
                    case "+" -> stack.push(x + y);
                    case "-" -> stack.push(x - y);
                    case "*" -> stack.push(x * y);
                    case "^" -> stack.push((int) Math.pow(x, y));
                    case "/" -> stack.push(((float) x / y < 0 && (x % y) != 0) ? x / y - 1 : x / y);
                }
            } else stack.push(Integer.parseInt(s));
        }

        return stack.peek();
    }
}
