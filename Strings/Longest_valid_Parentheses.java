package Strings;/*
 *   Q. Given a string str consisting of opening and closing parenthesis '(' and ')'. Find the length of the
 *      longest valid parenthesis substring.
 *      A parenthesis string is valid if:
 *               → For every opening parenthesis, there is a closing parenthesis.
 *               → Opening parenthesis must be closed in the correct order.
 *      Example :
 *              Input: str = )())()()
 *             Output: 4
 *        Explanation: The longest valid parenthesis substring is "()()".
 */
import java.util.Scanner;

public class Longest_valid_Parentheses {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the String :");
        String s = sc.next();
        System.out.println("Output :");
        System.out.println(isPar(s));
    }
    static int isPar(String s){
        // potd.code.hub
        int n = s.length();
        int open = 0, close = 0;
        int max1 = 0, max2 = 0;

        // left to right
        for (int i = 0;i < n;i++){
            if (s.charAt(i) == '(') open++;
            else close++;
            if (close > open) open = close = 0;
            if (open == close) max1 = Math.max(max1, 2*open);
        }

        open = close = 0;

        // right to left
        for (int i = n-1;i >= 0;i--){
            if (s.charAt(i) == '(') open++;
            else close++;
            if (open > close) open = close = 0;
            if (open == close) max2 = Math.max(max2, 2*open);
        }

        return Math.max(max1, max2);
    }
}
