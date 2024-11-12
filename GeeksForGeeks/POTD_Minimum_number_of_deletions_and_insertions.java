/*
 *   Q. Given two strings str1 and str2. The task is to remove or insert the minimum number of characters
 *      from/in str1 to transform it into str2. It could be possible that the same character needs to be
 *      removed/deleted from one point of str1 and inserted to another point.
 *   Ex.
 *      Input : str1 = "heap",
 *              str2 = "pea"
 *      Output: 3
 *      Explanation: 2 deletions and 1 insertion.
 *                   P and h deleted from heap. Then, p is inserted at the beginning.
 *                   One thing to note, though p was required, yet it was removed/deleted first from its
 *                   position, and then it is inserted to some other position. Thus, p contributes one to
 *                   the deletion_count and one to the insertion_count.
 */
package GFG;


import java.util.Scanner;

public class POTD_Minimum_number_of_deletions_and_insertions
{
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("String 1 :");
        String s1 = sc.next();
        System.out.println("String 2 :");
        String s2 = sc.next();

        System.out.println("Output :");
        System.out.println(minOperations(s1,s2));
    }
    static int minOperations(String str1, String str2) {
        // potd.code.hub
        int n = str1.length();
        int m = str2.length();

        // memoization
        int[][]dp = new int[n+1][m+1];
        for (int i = 1;i <= n;i++)
            for (int j = 1;j <= m;j++)
                dp[i][j] = -1;

        int temp = lcs(n,m,str1,str2,dp);

        return  (n-temp)+(m-temp);
    }
    static int lcs(int n,int m,String s1,String s2,int[][]dp){
        // base case
        if(n == 0 || m == 0)return 0;

        if (dp[n][m] != -1)return dp[n][m];

        // recursive work
        if (s1.charAt(n-1) == s2.charAt(m-1))
            return dp[n][m] = 1 + lcs(n-1,m-1,s1,s2,dp);
        else
            return dp[n][m] = Math.max(lcs(n-1,m,s1,s2,dp), lcs(n,m-1,s1,s2,dp));
    }
}