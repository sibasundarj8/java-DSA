package Recursion;

import java.util.Scanner;

public class Recursion_4_Fibonacci
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Size : ");
        int n = sc.nextInt();

        for (int i = 0;i < n;i++)
        {
            System.out.print(fibonacci(i) + " ");
        }
    }
    static int fibonacci(int n)
    {
        // base case
        if (n == 0 || n == 1) return n;

        // self work
        return fibonacci(n-1) + fibonacci(n-2);
    }
}