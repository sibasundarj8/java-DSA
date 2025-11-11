package DP;/*
 *
 * https://www.geeksforgeeks.org/problems/shortest-common-supersequence0322/1
 *
 * # Shortest Common Supersequence
 *
 *   Q. Given two strings s1 and s2, find the length of the smallest string which has both s1 and s2 as its sub-sequences.
 *      Note: s1 and s2 can have both uppercase and lowercase English letters.
 *    Ex.
 *      Input : s1 = "AGGTAB", s2 = "GXTXAYB"
 *      Output: 9
 *      Explanation: String "AGXGTXAYB" has both string "AGGTAB" and "GXTXAYB" as subsequences.
 *
 *  Constraints:
 *      1 ≤ s1.size(), s2.size() ≤ 500
 */

import java.util.Scanner;

public class Dynamic_Programming_Shortest_Common_Supersequence {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("s1: ");
        String s1 = sc.next();

        System.out.println("s2: ");
        String s2 = sc.next();

        System.out.println(minSuperSeq(s1, s2));
    }

    /// Solution
    static int minSuperSeq(String s1, String s2) {
        // potd.code.hub
        int n1 = s1.length();
        int n2 = s2.length();
        if (n1 > n2) return minSuperSeq(s2, s1);
        int lcs = lcs(s1, s2);

        return n2 + (n1 - lcs);
    }

    private static int lcs(String s1, String s2) {
        // potd.code.hub
        int n = s1.length(), m = s2.length();
        int[]curr = new int[m+1];
        int[]prev = new int[m+1];

        for (int i = 1;i <= n;i++){
            for (int j = 1;j <= m;j++){
                if (s1.charAt(i-1) == s2.charAt(j-1))
                    curr[j] = prev[j-1] + 1;
                else curr[j] = Math.max(prev[j], curr[j-1]);
            }
            prev = curr.clone();
        }

        return curr[m];
    }
}
