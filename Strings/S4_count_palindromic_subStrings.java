package Strings;

import java.util.Scanner;

public class S4_count_palindromic_subStrings {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Word :");
        String s = sc.next();
        System.out.println("count : " + countPalindromic(s));
    }
    static int countPalindromic(String s){
        int count = 0;
        for (int i = 0;i < s.length();i++){
            for (int j = i+1;j <= s.length();j++){
                if (isPalindrome(s.substring(i,j))) {
                    System.out.println(s.substring(i,j));
                    count++;
                }
            }
        }
        return count;
    }
    static boolean isPalindrome(String s){
        int i = 0;
        int j = s.length()-1;
        while (i < j)
            if (s.charAt(i++) != s.charAt(j--))
                return false;
        return true;
    }
}