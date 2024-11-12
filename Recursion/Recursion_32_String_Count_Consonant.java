package Recursion;/*
    Q3. Given a string count total number of consonants in it. A consonant is an English alphabet character that is
        not vowel (a, e, i, o ani u). Examples of constants are b, c, i, f, and g.

        Ex.-
            input :- pwSkills
            output:- 7
*/
import java.util.Scanner;

public class Recursion_32_String_Count_Consonant
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a String :");
        String s = sc.nextLine();

        System.out.println(countConsonant(s,0));
    }
    static int countConsonant(String s,int i)
    {
        // Base Case
        if (s.isEmpty())return i;

        // Recursive Work
        if ((s.charAt(0) != 'a' && s.charAt(0) != 'e' && s.charAt(0) != 'i' && s.charAt(0) != 'o' && s.charAt(0) != 'u'
                && s.charAt(0) != 'A' && s.charAt(0) != 'E' && s.charAt(0) != 'I' && s.charAt(0) != 'O' && s.charAt(0) != 'U'))
            return countConsonant(s.substring(1),i+1);
        else return countConsonant(s.substring(1),i);
    }
}