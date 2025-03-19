package DP;/*
 *   Q. Given a string, find the minimum number of characters to be inserted to convert
 *      it to a palindrome.
 *    Ex.
 *       Input: str = "abcd"
 *       Output: 3
 *       Explanation: Inserted character marked with bold characters in dcbabcd,
 *                    here we need minimum three characters to make it palindrome.
 */
import java.util.Scanner;

public class Dynamic_Programming_Form_a_Palindrome {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter String :");
        String s = sc.next();
        System.out.println("Output : " + minInsert(s));
    }
    static String reverse(String s) {
        String ans = "";
        for (int i = s.length()-1;i >= 0;i--)
            ans += s.charAt(i);
        return ans;
    }
    static int minInsert(String s){
        String rev = reverse(s);
        return s.length()-LPS(s,rev);
    }
    static int LPS(String s,String rev){
        int n = s.length();
        int[][]dp = new int[n+1][n+1];

        for (int i = 0;i <= n;i++){
            dp[i][0] = 0;
            dp[0][i] = 0;
        }
        for (int i = 1;i <= n;i++)
            for (int j = 1;j <= n;j++)
                if (s.charAt(i-1) == rev.charAt(j-1))
                    dp[i][j] = 1+dp[i-1][j-1];
                else dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);

        return dp[n][n];
    }
}