package GFG_160.Bonus_Problems;/*
 * https://www.geeksforgeeks.org/problems/number-to-words0335/1
 *
 * # Integer to Words
 *
 *   Q. Write a function to convert a given number n into words.
 *
 *          The idea is to break down the number into International Number System, i.e., smaller
 *          groups of three digits (hundreds, tens, and ones), and convert each group into words.
 *    Ex.
 *      Input : n = 2147483647
 *      Output: "Two Billion One Hundred Forty Seven Million Four Hundred Eighty Three Thousand Six
 *               Hundred Forty Seven"
 */

import java.util.Scanner;

public class String_06_Integer_to_Words {

    /// main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Number: ");
        int n = sc.nextInt();

        System.out.println(convertToWords(n));
    }

    /// Solution
    static String convertToWords(int n) {
        // potd.code.hub
        if (n == 0) return "Zero";
        String[]ones = {"", "One ", "Two ", "Three ", "Four ", "Five ", "Six ", "Seven ", "Eight ", "Nine ", "Ten ", "Eleven ", "Twelve ", "Thirteen ", "Fourteen ", "Fifteen ", "Sixteen ", "Seventeen ", "Eighteen ", "Nineteen "};
        String[]tens = {"", "", "Twenty ", "Thirty ", "Forty ", "Fifty ", "Sixty ", "Seventy ", "Eighty ", "Ninety "};
        String ans = solve(n, ones, tens);
        return ans.substring(0, ans.length()-1);
    }
    private static String solve(int n, String[]ones, String[]tens){
        // base case
        if (n == 0) return "";

        if (n < 20) return ones[n];
        if (n < 100) return tens[n/10] + ones[n%10];
        if (n < 1000) return ones[n/100] + "Hundred " + solve(n%100, ones, tens);
        if (n < 1000000) return solve(n/1000, ones, tens) + "Thousand " + solve(n%1000, ones, tens);
        if (n < 1000000000) return solve(n/1000000, ones, tens) + "Million " + solve(n%1000000, ones, tens);

        return solve(n/1000000000, ones, tens) + "Billion " + solve(n%1000000000, ones, tens);
    }
}
