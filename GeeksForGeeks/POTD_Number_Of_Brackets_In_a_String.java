package GFG;/*
 *    Q. Given a string str, the task is to find the bracket numbers,
 *       i.e, for each bracket in str, return i if the bracket is the ith opening or
 *            closing bracket to appear in the string.
 *     Ex.
 *        Input :  str = "(aa(bdc))p(dee)"
 *       Output :  1 2 2 1 3 3
 *  Explanation : The highlighted brackets in the given string (aa(bdc))p(dee) are
 *                assigned the numbers as: 1 2 2 1 3 3.
 */
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class POTD_Number_Of_Brackets_In_a_String {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a String :");
        String s = sc.next();
        System.out.println(bracketNumbers(s));
    }
    static ArrayList<Integer> bracketNumbers(String str) {
        // code here
        ArrayList<Integer> ans = new ArrayList<>();
        Stack<Integer> s = new Stack<>();
        int count = 0;
        for (int i = 0;i < str.length();i++){
            if (str.charAt(i) == '('){
                ans.add(s.push(++count));
            }
            if (str.charAt(i) == ')'){
                ans.add(s.pop());
            }
        }
        return ans;
    }
}