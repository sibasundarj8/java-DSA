package Strings;

import java.util.Scanner;

public class S3_isPalindrome {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter WOrd :");
        String s = sc.next();
        System.out.println(isPalindrome(s));
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
