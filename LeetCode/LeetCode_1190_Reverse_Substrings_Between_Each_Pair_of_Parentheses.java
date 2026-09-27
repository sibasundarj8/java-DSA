package LeetCode;

import java.util.ArrayDeque;
import java.util.Scanner;

public class LeetCode_1190_Reverse_Substrings_Between_Each_Pair_of_Parentheses {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the string, segment inside the parentheses gonna reverse: ");
        String s = sc.nextLine();

        System.out.print("Res: ");
        System.out.println(reverseParentheses(s));
    }

    /// Solution
/*
-------------------------------------------------------brute-force-------------------------------------------------------
TC : O(n²)
SC : O(n)
*/
    static String bruteForce(String s1) {
        char[] s = s1.toCharArray();
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        StringBuilder res = new StringBuilder();

        for (char ch : s) {
            if (ch == '(') stack.push(res.length());

            else if (ch == ')') {
                int l = stack.pop();
                reverse(l, res.length() - 1, res);
            }

            else res.append(ch);
        }

        return res.toString();
    }

    private static void reverse(int l, int r, StringBuilder s) {
        while (l < r) {
            char ch = s.charAt(l);
            s.setCharAt(l++, s.charAt(r));
            s.setCharAt(r--, ch);
        }
    }

/*
-------------------------------------------------wormhole-teleportation-------------------------------------------------
TC : O(n)
SC : O(n)
*/
    static String reverseParentheses(String s1) {
        char[] s = s1.toCharArray();
        int n = s.length;
        ArrayDeque<Integer> stack = new ArrayDeque<>(n);
        int[] pair = new int[n];

        for (int r = 0; r < n; r++) {
            if (s[r] == '(') stack.push(r);
            else if (s[r] == ')') {
                int l = stack.pop();
                pair[l] = r;
                pair[r] = l;
            }
        }

        StringBuilder res = new StringBuilder(n);
        int dir = 1;

        for (int i = 0; i < n; i += dir) {
            char ch = s[i];
            if (ch == '(' || ch == ')') {
                i = pair[i];
                dir = -dir;
            } else {
                res.append(ch);
            }
        }

        return res.toString();
    }
}
