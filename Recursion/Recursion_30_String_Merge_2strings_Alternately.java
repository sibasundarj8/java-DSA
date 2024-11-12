package Recursion;/*
    Q1. Write a program to merge 2 strings alternately using recursion starting
        from the first input string.
     Ex.-
        Input :- ace
                 bdf
        Output:- abcdef

*/
import java.util.Scanner;

public class Recursion_30_String_Merge_2strings_Alternately
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter String 1 :");
        String s1 = sc.nextLine();

        System.out.println("Enter String 2 :");
        String s2 = sc.nextLine();

        System.out.println(recMerge(s1,s2));
    }
    static String recMerge(String a, String b)
    {
        String ans = "";

        // Base Case
        if (a.isEmpty())return ans + b;
        if (b.isEmpty())return ans + a;

        // Self Work
        ans += a.substring(0,1);
        ans += b.substring(0,1);

        // Recursive Work
        return ans + recMerge(a.substring(1), b.substring(1));
    }
}