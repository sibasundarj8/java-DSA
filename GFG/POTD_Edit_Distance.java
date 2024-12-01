package GFG;/*
 *   Q. Given two strings str1 and str2. Return the minimum number of operations
 *      required to convert str1 to str2. The possible operations are permitted :
 *      ● Insert a character at any position of the string.
 *      ● Remove any character from the string.
 *      ● Replace any character from the string with any other character.
 *     Ex-
 *      Input : str1 = "geek"
 *              srt2 = "gesek"
 *      Output: 1
 *      Explanation: One operation is required, inserting 's' between two 'e'.
 */
import java.util.Scanner;

public class POTD_Edit_Distance {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter String 1 :");
        String s1 = sc.next();
        System.out.println("Enter String 2 :");
        String s2 = sc.next();
        System.out.println(editDistance(s1,s2));
    }
    static int editDistance(String s1, String s2) {
        // potd.code.hub
        int n = s1.length();
        int m = s2.length();
        int[][]dp = new int[n+1][m+1];
        // Dynamic Programming
        for (int i = 0;i <= n;i++) dp[i][0] = i;
        for (int i = 0;i <= m;i++) dp[0][i] = i;

        for (int i = 1;i <= n;i++){
            for (int j = 1;j <= m;j++){
                if (s1.charAt(i-1) == s2.charAt(j-1))
                    dp[i][j] = dp[i-1][j-1];
                else dp[i][j] = 1 + Math.min(Math.min(dp[i-1][j],dp[i][j-1]),dp[i-1][j-1]);
            }
        }
        return dp[n][m];
    }
}