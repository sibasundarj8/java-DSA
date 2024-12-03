package GFG_160;/*
 *  https://www.geeksforgeeks.org/problems/minimum-characters-to-be-added-at-front-to-make-string-palindrome/0
 *
 *  # Min Chars to Add for Palindrome
 *
 *   Q. Given a string s, the task is to find the minimum characters to be added at the front to make the
 *      string palindrome.
 *
 *      Note: A palindrome string is a sequence of characters that reads the same forward and backward.
 *    Ex.
 *      Input : s = "aacecaaaa"
 *      Output: 2
 *      Explanation: Add 2 a's at front of above string to make it palindrome : "aaaacecaaaa"
 */
import java.util.Scanner;

public class GFG_19_Min_Chars_to_Add_for_Palindrome {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter String: ");
        String s = sc.next();

        System.out.println("Minimum character required to make palindrome: ");
        System.out.println(minChar(s));
    }

    /// Solution
    static int minChar(String s) {
        // potd.code.hub
        String temp = s + "$" + reverse(s);
        int n = temp.length();
        int[]lps = new int[n];

        int i = 0, j = 1;
        while (j < n){
            if (temp.charAt(i) == temp.charAt(j))
                lps[j++] = ++i;
            else if (i == 0) j++;
            else i = lps[i-1];
        }

        return s.length() - lps[n-1];
    }
    // Reverse String
    static String reverse (String s){
        StringBuilder s1 = new StringBuilder();
        int i = s.length()-1;

        while (i >= 0){
            s1.append(s.charAt(i));
            i--;
        }

        return s1.toString();
    }
}
