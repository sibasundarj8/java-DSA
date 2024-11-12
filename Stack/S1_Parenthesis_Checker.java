package Stack;/*
 *   Q. Given an expression string x. Examine whether the pairs and the orders of {,},(,),[,] are correct
 *      in exp. For example, the function should return 'true' for exp = [()]{}{[()()]()} and 'false' for
 *      exp = [(]).
 *     Ex.
 *       Input : {([])}
 *       Output: true
 *       Explanation:
 *                  { ( [ ] ) }. Same colored brackets can form balanced pairs, with number 0 of
 *                  unbalanced brackets.
 */
import java.util.Scanner;
import java.util.Stack;

public class S1_Parenthesis_Checker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Parenthesis :");
        String p = sc.next();
        System.out.println(isPar(p));
    }
    static boolean isPar(String x){
        // potd.code.hub
        char f = x.charAt(0);
        if (x.length() == 1 || f == '}' || f == ']' || f == ')')return false;
        Stack<Character> pr = new Stack<>();
        int i = 0;
        while (i < x.length()){
            char c = x.charAt(i);
            if (c == '[' || c == '(' || c == '{')
                pr.push(c);
            else if (c == ']' || c == ')' || c == '}'){
                if (pr.isEmpty())return false;
                char t = pr.pop();
                System.out.println(t);
                if (c == ']' && t != '[')return false;
                if (c == '}' && t != '{')return false;
                if (c == ')' && t != '(')return false;
            }
            i++;
        }
        return pr.isEmpty();
    }
}