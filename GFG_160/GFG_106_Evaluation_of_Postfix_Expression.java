package GFG_160;/*
 *
 * https://www.geeksforgeeks.org/problems/evaluation-of-postfix-expression1735/1
 *
 * # Evaluation of Postfix Expression
 *
 *   Q. You are given an array of string arr that represents a valid arithmetic expression written
 *      in Reverse Polish Notation (Postfix Notation). Your task is to evaluate the expression and
 *      return an integer representing its value.
 *
 *      Key Details:
 *
 *      The valid operators are '+', '-', '*', and '/'.
 *
 *      Each operand is guaranteed to be a valid integer or another expression.
 *
 *      The division operation between two integers always rounds the result towards zero,
 *      discarding any fractional part.
 *
 *      No division by zero will occur in the input.
 *
 *      The input is a valid arithmetic expression in Reverse Polish Notation.
 *
 *      The result of the expression and all intermediate calculations will fit in a 32-bit
 *      signed integer.
 *    Ex.
 *      Input : arr = ["100", "200", "+", "2", "/", "5", "*", "7", "+"]
 *      Output: 757
 *      Explanation: If the expression is converted into an infix expression, it will be
 *                   ((100 + 200) / 2) * 5 + 7  = 150 * 5 + 7 = 757.
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
        for (int i = 0;i < n;i++)
            postExpression[i] = sc.next();

        System.out.println(evaluate(postExpression));
    }

    /// Solution
    static int evaluate(String[] arr) {
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
                    case "/" -> stack.push(x / y);
                }
            } else stack.push(Integer.parseInt(s));
        }

        return stack.peek();
    }
}
