package Recursion;/*
 *   Q. Given the number of digits n in a number, print all n-digit numbers whose digits are
 *      strictly increasing from left to right.
 *
 *   Ex.-
 *      Input :- n = 2
 *
 *      Output:- 01 02 03 04 05 06 07 08 09 12 13 14 15 16 17 18 19 23 24 25 26 27 28
 *                  29 34 35 36 37 38 39 45 46 47 48 49 56 57 58 59 67 68 69 78 79 89
 */
import java.util.Scanner;

public class Recursion_36_String_Print_Strictly_Increasing_Number
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the Number of Digits :");
        int n = sc.nextInt();

        printNumbers(0,"",n);
    }
    static void printNumbers(int a,String s,int n)
    {
        // Base Case
        if (n == 0)
        {
            System.out.println(s);
            return;
        }
        // Recursive Work
        for (int i = a;i < 10;i++)printNumbers(i+1,s+i,n-1);
    }
}