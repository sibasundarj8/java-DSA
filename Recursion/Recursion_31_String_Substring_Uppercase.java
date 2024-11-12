package Recursion;/*
    Q2. Given a string, find its first uppercase letter and return the remaining substring, starting from the
uppercase letter.

Explanation=
    Input:
          collegeWallah
    Expected Output:
                    Wallah
*/
import java.util.Scanner;

public class Recursion_31_String_Substring_Uppercase
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the String :");
        String s = sc.nextLine();

        System.out.println(recSubstring(s));
    }
    static String recSubstring(String s)
    {
        String ans = "";

        // Base Case
        if (s.isEmpty())return ans;

        // Self Work
        if (Character.isUpperCase(s.charAt(0)))return s;// it also can be
                                                       // s.charAt(0)>=65 && s.charAt(0)<=90
        // Recursive Work
        return recSubstring(s.substring(1));
    }
}