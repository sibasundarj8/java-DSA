package Recursion;

import java.util.Scanner;

public class Recursion_3_Factorial
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number :");
        int n = sc.nextInt();

        System.out.println(factorial(n));
    }
    static int factorial(int n)
    {
        // Base case
        if (n == 0) return 1;

        // Self work
        return n*factorial(n-1);
    }
}