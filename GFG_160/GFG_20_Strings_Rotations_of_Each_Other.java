package GFG_160;/*
 * https://www.geeksforgeeks.org/problems/check-if-strings-are-rotations-of-each-other-or-not-1587115620/1
 *
 * # Strings Rotations of Each Other
 *
 *   Q. You are given two strings of equal lengths, s1 and s2. The task is to check if s2 is a rotated
 *      version of the string s1.
 *
 *      Note: The characters in the strings are in lowercase.
 *    Ex.
 *      Input : s1 = "abcd", s2 = "cdab"
 *      Output: true
 *      Explanation: After 2 right rotations, s1 will become equal to s2.
 */

import java.util.Scanner;

public class GFG_20_Strings_Rotations_of_Each_Other {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("S1: ");
        String s1 = sc.next();

        System.out.println("S2: ");
        String s2 = sc.next();

        System.out.println(areRotations(s1, s2));
    }

    /// Solution
    static boolean areRotations(String s1, String s2) {
        // potd.code.hub
        int n = s1.length();
        int[]lps = new int[n];
        lpsArray(s2, lps, n);
        s1 += s1; // s1 contains all possible rotations 

        int i = 0, j = 0;
        while (i < 2*n){
            if (s1.charAt(i) == s2.charAt(j)){
                j++;
                i++;
                if (j == n) {
                    return true;
                }
            }
            else if (j == 0){
                i++;
            }
            else {
                j = lps[j-1];
            }
        }
        return false;
    }
    static void lpsArray(String s, int[]lps, int n){
        int i = 0, j = 1;
        while (j < n){
            if (s.charAt(i) == s.charAt(j)){
                lps[j] = i+1;
                i++;
                j++;
            }
            else if (i == 0) {
                lps[j] = 0;
                j++;
            }
            else {
                i = lps[i-1];
            }
        }
    }
}
