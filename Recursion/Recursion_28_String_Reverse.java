package Recursion;/*
    Q. WAP to reverse a String using Recursion ?
       Ex.-
        Input :- Now Days
        Output:- syaD woN
*/
import java.util.Scanner;

public class Recursion_28_String_Reverse
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a String :");
        String s = sc.nextLine();

        System.out.println(recReverse(s));
    }
    static String recReverse(String s)
    {
        // base case
        if (s.isEmpty())return "";

        // Recursive Work
        return recReverse(s.substring(1)) + s.charAt(0);
    }
    /*
    static String recReverse(String s,int idx)
    {
        // base case
        if (idx >= s.length())return "";

        // Recursive Work
        return recReverse(s,idx+1) + s.charAt(idx);
    }*/
}