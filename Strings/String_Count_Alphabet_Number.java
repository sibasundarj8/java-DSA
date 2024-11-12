package Strings;

import java.util.Scanner;

public class String_Count_Alphabet_Number
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter an English Alphabet : ");
        char a = sc.next().charAt(0);

        if (Character.isLowerCase(a)) System.out.println((int)a - 96);
        else if (Character.isUpperCase(a)) System.out.println((int)a - 64);
    }
}