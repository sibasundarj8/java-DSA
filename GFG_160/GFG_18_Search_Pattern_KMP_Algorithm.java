package GFG_160;

import java.util.ArrayList;
import java.util.Scanner;

public class GFG_18_Search_Pattern_KMP_Algorithm {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Text: ");
        String txt = sc.next();

        System.out.println("Pattern: ");
        String pat = sc.next();

        System.out.println(search(pat, txt));
    }

    /// Solution
    static ArrayList<Integer> search(String pat, String txt) {
        // potd.code.hub
        int n = txt.length();
        int m = pat.length();
        ArrayList<Integer> ans = new ArrayList<>();

        int[] lps = new int[m];
        lps(pat, lps);

        int i = 0, j = 0;
        while (i < n){
            if (txt.charAt(i) == pat.charAt(j)){
                j++;
                i++;
                if (j == m){
                    ans.add(i-j);
                    j = lps[j-1];
                }
            }
            else if (j == 0) i++;
            else j = lps[j-1];
        }
        return ans;
    }
    // Longest prefix and suffix
    static void lps (String s, int[]ans){
        int n = s.length();
        int i = 0, j = 1;
        while (j < n){
            if (s.charAt(i) == s.charAt(j)) ans[j++] = ++i;
            else if (i == 0) ans[j++] = 0;
            else i = ans[i-1];
        }
    }
}
