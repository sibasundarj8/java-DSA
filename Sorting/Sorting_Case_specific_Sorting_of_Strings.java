package Sorting;/*
 *
 * https://www.geeksforgeeks.org/problems/case-specific-sorting-of-strings4845/1
 *
 * # Case-specific Sorting of Strings
 *
 *   Q. Given a string s consisting of only uppercase and lowercase characters. The task is to sort uppercase and
 *      lowercase letters separately such that if the ith place in the original string had an Uppercase character
 *      then it should not have a lowercase character after being sorted and vice versa.
 *   Ex.
 *      Input : s = "GEekS"
 *      Output: EGekS
 *      Explanation: Sorted form of given string with the same case of character will result in output as EGekS.
 */

import java.util.Scanner;

public class Sorting_Case_specific_Sorting_of_Strings {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Text: ");
        String s = sc.next();

        System.out.println("Case Specific Sort: " + caseSort(s));
    }

    /// Solution
    static String caseSort(String s) {
        // potd.code.hub
        int n = s.length();
        StringBuilder ans = new StringBuilder();
        int[] lower = new int[26];
        int[] upper = new int[26];

        for (int i = 0; i < n; i++) {
            int idx = s.charAt(i);
            if (idx < 'a') upper[idx-'A']++;
            else lower[idx-'a']++;
        }

        int l = 0, u = 0;

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) < 'a') { // upper
                while (upper[u] == 0) u++;
                ans.append((char) (u +'A'));
                upper[u]--;
            } else { // lower
                while (lower[l] == 0) l++;
                ans.append((char) (l +'a'));
                lower[l]--;
            }
        }

        return ans.toString();
    }
}
