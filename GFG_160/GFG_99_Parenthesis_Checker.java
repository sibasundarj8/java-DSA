package GFG_160;/*
 *
 * https://www.geeksforgeeks.org/problems/parenthesis-checker2744/0
 *
 * # Parenthesis Checker
 *
 *   Q. Given a string s, composed of different combinations of '(' , ')', '{', '}', '[', ']',
 *      verify the validity of the arrangement.
 *
 *      An input string is valid if:
 *          1. Open brackets must be closed by the same type of brackets
 *          2. Open brackets must be closed in the correct order.
 *    Ex.
 *      Input : s = "[()()]{}"
 *      Output: true
 *      Explanation: All the brackets are well-formed.
 */
import java.util.Scanner;
import java.util.Stack;

public class GFG_99_Parenthesis_Checker {
    
    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("enter parenthesis string: ");
        String s = sc.next();

        System.out.println(isBalanced(s));
    }
    
    /// Solution
    static boolean isBalanced(String s) {
        // potd.code.hub
        int n = s.length();
        Stack<Character> stack = new Stack<>();
        for (int i = 0;i < n;i++){
            char ch = s.charAt(i);
            if (ch == '[' || ch == '{' || ch == '(') stack.push(ch);
            else {
                if (stack.isEmpty()) return false;
                char c = stack.pop();
                if ((ch==']' && c!='[') || (ch=='}' && c!='{') || (ch==')' && c!='('))
                    return false;
            }
        }
        
        return stack.isEmpty();
    }
}
