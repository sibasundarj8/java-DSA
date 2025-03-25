package GFG_160;/*
 *
 * https://www.geeksforgeeks.org/problems/boolean-parenthesization5610/1
 *
 * # Boolean Parenthesization
 *
 *   Q. You are given a boolean expression s containing
 *          'T' ---> true
 *          'F' ---> false
 *      and following operators between symbols
 *         &   ---> boolean AND
 *         |   ---> boolean OR
 *         ^   ---> boolean XOR
 *      Count the number of ways we can parenthesize the expression so that the value of expression evaluates
 *      to true.
 *      Note: The answer is guaranteed to fit within a 32-bit integer.
 *   Ex.
 *      Input : s = "T|T&F^T"
 *      Output: 4
 *      Explanation: The expression evaluates to true in 4 ways:
 *                  ((T|T) & (F^T)),
 *                   (T | (T & (F^T))),
 *                 (((T|T) & F) ^ T),
 *                   (T | ((T&F) ^ T)).
 */
import java.util.Scanner;

public class GFG_131_Boolean_Parenthesization {

    /// main method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Boolean expression: ");
        String s = sc.next();

        System.out.println(countWays(s));
    }

    /// Solution
    static int countWays(String s) {
        // potd.code.hub
        int n = s.length();
        int[][][]dp = new int[n][n][2];

        for (int i = 0;i < n;i++)
            for (int j = 0;j < n;j++)
                dp[i][j][0] = dp[i][j][1] = -1;

        return solve(0, n-1, 1, s, dp);
    }
    private static int solve(int i, int j, int flag, String s, int[][][]dp){
        // base case
        if (i > j) return 0;
        if (i == j)
            if (flag == 1) return s.charAt(i)=='T' ? 1 : 0;
            else return s.charAt(i)=='F' ? 1 : 0;
        if (dp[i][j][flag] != -1) return dp[i][j][flag];

        int ans = 0;
        for (int k = i+1;k < j;k+=2){
            int lT = solve(i, k-1, 1, s, dp);
            int lF = solve(i, k-1, 0, s, dp);
            int rT = solve(k+1, j, 1, s, dp);
            int rF = solve(k+1, j, 0, s, dp);

            switch (s.charAt(k)) {
                case '&' -> ans += (flag == 1) ? lT * rT : lF * rF + lF * rT + lT * rF;
                case '|' -> ans += (flag == 1) ? lT * rT + lF * rT + lT * rF : lF * rF;
                case '^' -> ans += (flag == 1) ? lF * rT + lT * rF : lF * rF + lT * rT;
            }
        }

        return dp[i][j][flag] = ans;
    }
}
