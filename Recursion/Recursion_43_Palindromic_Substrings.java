package Recursion;/*
 *   Q.  You are given a string. Your task is to divide the string into palindromic substrings.
 *       Print all such partitions.
 *     Ex.
 *        Input : banana
 *       Output : [b, a, n, a, n, a]
 *                [b, a, n, ana]
 *                [b, a, nan, a]
 *                [b, ana, n, a]
 *                [b, anana]
 */
import java.util.ArrayList;
import java.util.Scanner;

public class Recursion_43_Palindromic_Substrings {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the String :");
        String s = sc.next();
        ArrayList<String>ans = new ArrayList<>();
        printSubsequences(s,0,ans);
    }
    static boolean isPalindrome(String s){
        int i = 0;
        int j = s.length()-1;
        while (i < j)if (s.charAt(i++) != s.charAt(j--))return false;
        return true;
    }
    static void printSubsequences(String s, int start, ArrayList<String>ans){

        // Base Case
        if (start == s.length()){
            System.out.println(ans);
            return;
        }
        String curr = "";
        for (int i = start;i < s.length();i++){
            curr += s.charAt(i);
            if (isPalindrome(curr)){
                ans.add(curr);

                // Recursive Call
                printSubsequences(s,i+1,ans);
                ans.remove(ans.size()-1);
            }
        }
    }
}