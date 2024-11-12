package Recursion;/*
    Q4. Given a string, return the number of lowercase characters in it using recursion.
     Ex.-
         Input :- CollegeWallah
         Output:- 11
*/
import java.util.Scanner;

public class Recursion_33_String_Count_Lowercase
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the String :");
        String s = sc.nextLine();

        System.out.println(countLowercase(s,0));
    }
    static int countLowercase(String s,int i)
    {
        // Base Case
        if (s.isEmpty())return i;

        // Recursive Work
        if (Character.isLowerCase(s.charAt(0)))
            return countLowercase(s.substring(1),i+1);
        else return countLowercase(s.substring(1),i);
    }
}
