package GFG_160;/*
 *
 * https://www.geeksforgeeks.org/problems/longest-valid-parentheses5657/1
 *
 * # Longest valid Parentheses
 *
 *   Q. Given a string s consisting of opening and closing parenthesis '(' and ')'. Find the length of
 *      the longest valid parenthesis substring.
 *      
 *      A parenthesis string is valid if:
 *          ● For every opening parenthesis, there is a closing parenthesis.
 *          ● The closing parenthesis must be after its opening parenthesis.
 *    Ex. 
 *      Input : s = ")()())"
 *      Output: 4
 *      Explanation: The longest valid parenthesis substring is "()()".
 */
import java.util.Scanner;

public class GFG_100_Longest_valid_Parentheses {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Parenthesis String, must be contains only '(' & ')' : ");
        String s = sc.next();

        System.out.println(maxLength(s));
    }

    /// Solution
    static int maxLength(String s) {
        // potd.code.hub
        int ans = 0, o = 0, c = 0,maxL = 0, maxR = 0, n = s.length();

        for (int i = 0;i < n;i++){
            char ch = s.charAt(i);
            if (ch == '(') o++;
            else c++;
            if (c > o) o = c = 0;
            else if (c == o) maxL = Math.max(maxL, 2 * o);
        }

        ans = 2 * c;
        o = c = 0;

        for (int i = n-1;i >= 0;i--){
            char ch = s.charAt(i);
            if (ch == ')') o++;
            else c++;
            if (c > o) o = c = 0;
            else if (c == o) maxR = Math.max(maxR, 2 * o);
        }

        return Math.max(maxL, maxR);
    }
}
