package Recursion;/*
    Q. WAP to remove a particular char from the String using Recursion ?

    Ex.-
        Input -
                College
                l
        Output-
                Coege
*/
import org.jetbrains.annotations.NotNull;

import java.util.Scanner;

public class Recursion_27_String_Remove_Occurrences
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a String : ");
        String s = sc.nextLine();

        System.out.println("Enter The later which you want to remove :");
        String ch = sc.next();
        System.out.println(removeOccurrences(s,0,ch));
        System.out.println(removeOccurrence(s,ch));
    }
    static String removeOccurrence(String s,String x)
    {
        // Base Case
        if (s.isEmpty())return "";

        // Recursive Work
        if (s.charAt(0) != x.charAt(0)) return s + removeOccurrence(s.substring(1),x);
        return removeOccurrence(s.substring(1),x);
    }
    static @NotNull String removeOccurrences(String s, int idx, String ch)
    {
        // Base Case
        if (idx >= s.length()) return "";

        // Recursive Work
        if (s.charAt(idx) != ch.charAt(0)) return s.charAt(idx) + removeOccurrences(s,idx+1,ch);

        return removeOccurrences(s,idx+1,ch);
    }
}