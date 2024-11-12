package Recursion;

import java.util.Scanner;

public class Recursion_35_String_Print_subSequences
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the String :");
        String s = sc.nextLine();

        recSubSequences(s,"");
    }
    static void recSubSequences(String s, String ans)
    {
        // base Case
        if (s.isEmpty())
        {
            System.out.println(ans);
            return;
        }
        // Recursive Work
        recSubSequences(s.substring(1),ans + s.charAt(0));
        recSubSequences(s.substring(1), ans);
    }
}