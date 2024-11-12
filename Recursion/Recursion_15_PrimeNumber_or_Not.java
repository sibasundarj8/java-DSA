package Recursion;

import java.util.Scanner;

public class Recursion_15_PrimeNumber_or_Not
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the Number, which is prime or not you want to know :");
        int x = sc.nextInt();

        System.out.println(isPrime(x,2));
    }
    static boolean isPrime(int x,int i)
    {
        // Base Case
        if (x <= 2)return x == 2;
        if (x%i == 0)return false;
        if (i*i > x)return true;

        // Recursive Work
        return isPrime(x,i+1);
    }
}
