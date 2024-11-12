package Recursion;/*
    Q. WAP to check a String is palindrome or not ?
     Ex.-
         Input :- level
         Output:- true
     Ex.-
         Input :- Hello
         Output:- False
*/
import java.util.Scanner;

public class Recursion_29_String_Palindrome_or_not
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a String :");
        String s = sc.nextLine();

        System.out.println(recPalindrome(s,0,s.length()-1));
    }
    static boolean recPalindrome(String s,int l,int r)
    {
        // Base Case
        if (l >= r)return true;

        // Recursive Work
        return s.charAt(r) == s.charAt(l) && recPalindrome(s,l+1,r-1);
    }
}
