package Stack;/*
 *
 * https://www.geeksforgeeks.org/problems/min-add-to-make-parentheses-valid/1
 *
 * # Min Add to Make Parentheses Valid
 *
 *   Q. You are given a string s consisting only of the characters '(' and ')'. Your task is to determine
 *      the minimum number of parentheses (either '(' or ')') that must be inserted at any positions to
 *      make the string s a valid parentheses string.
 *
 *      A parentheses string is considered valid if:
 *         • Every opening parenthesis '(' has a corresponding closing parenthesis ')'.
 *         • Every closing parenthesis ')' has a corresponding opening parenthesis '('.
 *         • Parentheses are properly nested.
 *
 *    Ex.
 *      Input : s = "(()("
 *      Output: 2
 *      Explanation: There are two unmatched '(' at the end, so we need to add two ')' to make the string
 *                   valid.
 *   Constraints:
 *          1 ≤ s.size() ≤ 10⁵
 *          s[i] ∈ { '(' , ')' }
 */

import java.util.Scanner;
import java.util.Stack;

public class S12_Min_Add_to_Make_Parentheses_Valid {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("∑ = {'(', ')'}\nEnter String: ");
        String s = sc.next();

        System.out.println("Parenthesis required to make it valid: " + minParentheses(s));
    }

    /// Solution
/*
..........................................................Stack..........................................................
TC : O(n)
SC : O(n)
*/
    static int stack(String s) {
        // potd.code.hub
        int n = s.length();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);

            if (ch == ')' && !stack.isEmpty() && stack.peek() == '(') stack.pop();
            else stack.push(ch);
        }

        return stack.size();
    }
    
/*
................................................Two-Pass Counting Method................................................
TC : O(n)
SC : O(1)
*/
    static int minParentheses(String s) {
        // potd.code.hub
        int n = s.length();
        int lCount = 0;
        int rCount = 0;

        for(int i = 0; i < n; i++) {
            char str = s.charAt(i);
            char end = s.charAt(n - 1 - i);

            if(str == '(') lCount++;
            else lCount--;

            if(end == ')') rCount++;
            else rCount--;

            lCount = Math.max(lCount, 0);
            rCount = Math.max(rCount, 0);
        }

        return lCount + rCount;
    }
}
