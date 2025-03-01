package GFG_160;/*
 *
 * https://www.geeksforgeeks.org/problems/decode-the-string2444/1
 *
 * # Decode the string
 *
 *   Q. Given an encoded string s, the task is to decode it. The encoding rule is :
 *
 *          ⁕ k[encodedString], where the encodedString inside the square brackets is being
 *            repeated exactly k times. Note that k is guaranteed to be a positive integer.
 *
 *      Note: The test cases are generated so that the length of the output string will never
 *            exceed 105.
 *    Ex.
 *      Input: s = "3[b2[ca]]"
 *      Output: "bcacabcacabcaca"
 *      Explanation:
 *          1. Inner substring “2[ca]” breakdown into "caca".
 *          2. Now, the new string becomes "3[bcaca]"
 *          3. Similarly, "3[bcaca]" becomes "bcacabcacabcaca" which is the final result.
 */
import java.util.Scanner;
import java.util.Stack;

public class GFG_107_Decode_the_string {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("String: ");
        String s = sc.next();

        System.out.println(decodeString(s));
    }

    /// Solution
    static String decodeString(String s) {
        // potd.code.hub
        int n = s.length();
        Stack<Character> stack = new Stack<>();
        String ans;
        int i = 0;
        while (i < n){
            if (s.charAt(i) == ']'){
                StringBuilder temp = new StringBuilder();
                while (!stack.isEmpty() && stack.peek() != '[')
                    temp.insert(0, stack.pop());

                stack.pop();
                StringBuilder k = new StringBuilder();
                while (!stack.isEmpty() && Character.isDigit(stack.peek()))
                    k.insert(0, stack.pop());

                ans = String.valueOf(temp).repeat(Math.max(0, Integer.parseInt(k.toString())));

                for (int x = 0;x < ans.length();x++)
                    stack.push(ans.charAt(x));
            }
            else stack.push(s.charAt(i));
            i++;
        }
        StringBuilder temp = new StringBuilder();
        while (!stack.isEmpty())temp.insert(0, stack.pop());

        return temp.toString();
    }
}
