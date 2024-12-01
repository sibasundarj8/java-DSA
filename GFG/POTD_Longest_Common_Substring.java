package GFG;/*
     Q. You are given two strings str1 and str2. Your task is to find the length of the longest
        common substring among the given strings.

       Examples:
              Input:  str1 = "ABCDGH"
                      str2 = "HIGHROAD"
              Output: 4
              Explanation: The longest common substring is "CDGH" which has length 4.
 */
import java.util.Scanner;

public class POTD_Longest_Common_Substring {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("String 1 : ");
        String s1 = sc.next();
        System.out.println("String 2 : ");
        String s2 = sc.next();
        System.out.println(longestCommonSubStr(s1,s2));
    }
    static int longestCommonSubStr(String str1, String str2) {
        // @ potd.code.hub
        int n = str1.length();
        int m = str2.length();
        int ans = 0;
        // DP
        int[][]dp = new int[n+1][m+1];

        for (int i = 1;i <= n;i++)
            for (int j = 1;j <= m;j++)
                if (str1.charAt(i-1) == str2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1]+1;
                    ans = Math.max(ans,dp[i][j]);
                }

        return ans;
    }
}