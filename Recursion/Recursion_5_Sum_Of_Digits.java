package Recursion;
//      Finding the sum of all the Digits using Recursion.

import java.util.Scanner;

public class Recursion_5_Sum_Of_Digits
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a Number : ");
        int n = sc.nextInt();

        System.out.println(SumOfDigits(n));
    }
    static int SumOfDigits(int n)
    {
        if (n == 0) return n;
        return n%10 + SumOfDigits(n/10);
    }
}