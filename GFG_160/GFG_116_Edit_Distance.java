package GFG_160;/*
 *
 * https://www.geeksforgeeks.org/problems/edit-distance3702/1
 *
 * # Edit Distance
 *
 *   Q. Given two strings s1 and s2. Return the minimum number of operations required to convert s1
 *      to s2.
 *      The possible operations are permitted:
 *
 *      Insert a character at any position of the string.
 *      Remove any character from the string.
 *      Replace any character from the string with any other character.
 *    Ex.
 *      Input : s1 = "abcd", s2 = "bcfe"
 *      Output: 3
 *      Explanation: We can convert s1 into s2 by removing 'a', replacing 'd' with 'f' and
 *                   inserting 'e' at the end.
 */
import java.util.Scanner;

public class GFG_116_Edit_Distance {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("String 1: ");
        String s1 = sc.next();

        System.out.println("String 2: ");
        String s2 = sc.next();

        System.out.println(editDistance(s1, s2));
    }

    /// Solution
//top-down space optimized Tabulation approach
//TimeComplexity: O(n*m), SpaceComplexity: O(m);
    static int editDistance(String s1, String s2){
        int n = s1.length();
        int m = s2.length();

        int[]curr = new int[m+1];
        int[]prev = new int[m+1];
        for (int i = 0;i <= m;i++)
            prev[i] = i;

        for (int i = 1;i <= n;i++){
            curr[0] = i;
            for (int j = 1;j <= m;j++){
                if (s1.charAt(i-1) == s2.charAt(j-1)){
                    curr[j] = prev[j-1];
                }
                else {
                    int insert = curr[j - 1];
                    int remove = prev[j];
                    int replace = prev[j - 1];
                    curr[j] = 1 + Math.min(insert, Math.min(remove, replace));
                }
            }
            prev = curr.clone();
        }

        return prev[m];
    }



//top-down tabulation approach
//TimeComplexity: O(n*m), SpaceComplexity: O(n*m)
/*  static int editDistance(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();

        int[][]table = new int[n+1][m+1];
        for (int x = 0; x <= n; x++) table[x][0] = x;
        for (int x = 0; x <= m; x++) table[0][x] = x;

        for (int i = 1;i <= n;i++){
            for (int j = 1;j <= m;j++){
                if (s1.charAt(i-1) == s2.charAt(j-1)){
                    table[i][j] = table[i-1][j-1];
                }
                else {
                    int insert = table[i][j - 1];
                    int remove = table[i - 1][j];
                    int replace = table[i - 1][j - 1];
                    table[i][j] = 1 + Math.min(insert, Math.min(remove, replace));
                }
            }
        }

        return table[n][m];
    }
*/



//bottom-up recursive approach
//TimeComplexity: O(n*m), SpaceComplexity: O(n*m) + O(n*m)(recursive stack)
/*  static int editDistance(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        int[][]dp = new int[n+1][m+1];
        for (int[]i : dp)
            Arrays.fill(i, -1);

        return solve(s1.length()-1, s2.length()-1, s1, s2, dp);
    }
    private static int solve (int i, int j, String s1, String s2, int[][]dp){
        // base case
        if (i < 0) return j+1;
        if (j < 0) return i+1;

        // retrieve
        if (dp[i][j] != -1) return dp[i][j];

        // recursive work
        if (s1.charAt(i) == s2.charAt(j)) {
            dp[i][j] = solve(i - 1, j - 1, s1, s2, dp);
            return dp[i][j];
        }

        int insert = solve(i, j-1, s1, s2, dp);
        int remove = solve(i-1, j, s1, s2, dp);
        int replace = solve(i-1, j-1, s1, s2, dp);

        // self-work & memoization
        dp[i][j] = 1 + Math.min(insert, Math.min(remove, replace));
        return dp[i][j];
    }
*/
}
